/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.ClienteDAO;
import DAO.CodigoDAO;
import DAO.Codigos_has_vendasDAO;
import DAO.ProdutosDAO;
import DAO.VendaDAO;
import DAO.VendasPendentesDAO;
import EmailConfig.MensagensEmail;
import Entidades.Cliente;
import Entidades.Codigos;
import Entidades.Produtos;
import Entidades.Vendas;
import Entidades.VendasPendentes;
import Entidades.codigos_has_vendas;
import com.email.EmailService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao
 */
public class EnviarCodigos {

    HashMap<String, Produtos> mapProd = VariaveisDeControle.mapProd;

    public EnviarCodigos() {

    }

    public void enviarCodigoUmaVenda(VendasPendentes ven, boolean envioManual, ArrayList<Codigos> listCod, ArrayList<codigos_has_vendas> listaCodigosHasVendasSelecionados) {
        try {
            MensagensEmail msgEmail = new MensagensEmail();
            String codigo = organizaCodigosParaEnvio(envioManual, ven, listaCodigosHasVendasSelecionados, listCod, ven.getCodigo());
            int qtdDispositivos = ven.getQtd() * mapProd.get(ven.getIdProduto()).getQtd();
            String corpo = msgEmail.verificaQualOCorpoDOEmail(mapProd.get(ven.getIdProduto()).getTipo(), qtdDispositivos, codigo, ven.getQtd());
            EmailService email = new EmailService(ven.getEmail(),
                    "Código de ativação - " + ven.getProduto() + " - " + ven.getApelido() + " - " + ven.getId_venda(), corpo);
            email.sendEmail();
            
        } catch (MessagingException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao enviar o código da venda " + ven.getId_venda() + "\n" + ex.getMessage());
            System.err.println( "Erro ao enviar o código da venda " + ven.getId_venda() + "\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void setCodigoNaVenda(VendasPendentes ven) {
        String idVenda = ven.getId_venda(); // Colocando só o getIdVenda nao dava certo, a Thread mudava e a venda também
        int idCod = ven.getIdCodigo();
        int qtd = ven.getQtd() * mapProd.get(ven.getIdProduto()).getQtd(); // estava dando como nulo
        codigos_has_vendas chv = new codigos_has_vendas();
        chv.setIdVenda(idVenda);
        chv.setId_codigo(idCod);
        chv.setQtd(qtd);
        chv.setQtd_servidor(mapProd.get(ven.getIdProduto()).getServer());
        new Codigos_has_vendasDAO().insertCodigoEmVenda(chv);
        new VendasPendentesDAO().remove(idVenda);
    }

    public void enviarCodigosDaLista() {
        for (VendasPendentes v : VariaveisDeControle.listVen) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Cliente c = new ClienteDAO().buscaCliente(v.getApelido());
                        if ((v.getPagamento().toLowerCase().contains("boleto")
                                || v.getPagamento().toLowerCase().contains("saldo")) && c.getConfirmado() == null) {
                            new VendasPendentesDAO().marcaComoPendente(v.getId_venda(), "Análise Pendente");
                        } else if (v.getProduto().contains("promocional")) {
                            new VendasPendentesDAO().marcaComoPendente(v.getId_venda(), "Venda promocional");
                        } else if (v.getPendente() == null && v.getCodigo() != null) {
                            int qtdDispositivos = v.getQtd() * mapProd.get(v.getIdProduto()).getQtd();
                            String codigo = organizaCodigosParaEnvio(false, v, null, null, v.getCodigo());
                            MensagensEmail msgEmail = new MensagensEmail();
                            String corpo = msgEmail.verificaQualOCorpoDOEmail(mapProd.get(v.getIdProduto()).getTipo(), qtdDispositivos, codigo, v.getQtd());
                            EmailService email = new EmailService(v.getEmail(),
                                    "Código de ativação - " + v.getProduto() + " - " + v.getApelido() + " - " + v.getId_venda(), corpo);
                            email.sendEmail();
                            setCodigoNaVenda(v);
                            VariaveisDeControle.listVen.remove(v);
                            VariaveisDeControle.jComboBoxModelDialogVendasPendentes.removeElement(v);
                            if (c.getRevendedor_assitencia() != null) {
                                if (c.getRevendedor_assitencia().equals("sim")) {
                                    // new ProgramaFidelidade().verificaQtdProdutos(v.getApelido(), corpo);
                                }
                            }
                        } else {
                            System.out.println("venda com cod nulo ou com pendencia: " + v.getId_venda());
                        }
                    } catch (IOException ex) {
                        System.err.println("Erro na venda " + v.getId_venda());
                        ex.printStackTrace();
                    } catch (MessagingException ex) {
                        System.err.println("Erro na venda " + v.getId_venda());
                        ex.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void reenviarEmail(Vendas v, ArrayList<codigos_has_vendas> list) {
        MensagensEmail msgEmail = new MensagensEmail();
        Produtos p = new ProdutosDAO().retornaProduto(v.getIdProduto());
        Cliente c = new ClienteDAO().buscaCliente(v.getApelido_comprador());
        int qtd = p.getQtd() * v.getQtd();
        ArrayList<Codigos> listCod = new ArrayList<>();
        list.forEach(cod -> {
            listCod.add(new CodigoDAO().buscaUmCodigo(cod.getId_codigo()));
        });
        String codigo = organizaCodigosParaEnvio(true, null, list, listCod, null);
        String corpo = msgEmail.verificaQualOCorpoDOEmail(p.getTipo(), qtd, codigo, v.getQtd());
        String assunto = "Código de ativação - " + p.getTipo() + " " + qtd + " Dispositivo(s)" + p.getAnos() + " Ano(s) - " + v.getApelido_comprador() + " - " + v.getId();
        try {
            System.out.println(codigo == null);
            System.out.println(corpo == null);
            System.out.println(assunto == null);
            EmailService email = new EmailService(c.getEmail(), assunto, corpo);
            email.sendEmail();
        } catch (IOException ex) {
            Logger.getLogger(EnviarCodigos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarCodigos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String organizaCodigosParaEnvio(boolean envioManual, VendasPendentes ven, ArrayList<codigos_has_vendas> listaCodigosHasVendasSelecionados, ArrayList<Codigos> listCod, String codigo) {
        HashMap<Integer, codigos_has_vendas> map = new HashMap<>();
        if (envioManual) {
            for (codigos_has_vendas chv : listaCodigosHasVendasSelecionados) {
                map.put(chv.getId_codigo(), chv);
            }
            codigo = "";
            for (int i = 0; i < listCod.size(); i++) {
                Codigos c = listCod.get(i);
                if (c.getTipo().toLowerCase().equals("small")) {
                    codigo = "\n" + codigo + c.getCodigo() + " - " + map.get(c.getId()).getQtd() + " dispositivo(s) - " + map.get(c.getId()).getQtd_servidor() + "  server(s)" + "\n";
                } else {
                    codigo = "\n" + codigo + c.getCodigo() + " - " + map.get(c.getId()).getQtd() + " dispositivo(s)" + "\n";
                }
            }
        }
        if (envioManual) {
            if (ven != null) {
                for (codigos_has_vendas chv : listaCodigosHasVendasSelecionados) {
                    new Codigos_has_vendasDAO().insertCodigoEmVenda(chv);
                    new VendasPendentesDAO().remove(ven.getId_venda());
                }
            }
        } else {
            Produtos p = mapProd.get(ven.getIdProduto());
            if (p.getTipo().toLowerCase().equals("small")) {
                codigo = "\n" + codigo + " - " + p.getQtd() * ven.getQtd() + " dispositivo(s) - " + mapProd.get(ven.getIdProduto()).getServer()+ "server(s) \n";
            } else {
                codigo = "\n" + codigo + " - " + p.getQtd() * ven.getQtd() + " dispositivo(s)" + "\n";
            }
        }
        return codigo;
    }
}
