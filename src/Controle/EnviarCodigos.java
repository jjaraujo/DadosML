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
import DAO.VendasPendentesDAO;
import EmailConfig.MensagensEmail;
import Entidades.Cliente;
import Entidades.Codigos;
import Entidades.Produtos;
import Entidades.Vendas;
import Entidades.VendasPendentes;
import Entidades.codigos_has_vendas;
import Visao.TelaVendas;
import com.email.EmailService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author Joao
 */
public class EnviarCodigos {

    HashMap<Integer, Produtos> mapProd = new ProdutosDAO().getProdutos();

    public EnviarCodigos() {

    }

    public void enviarCodigoUmaVenda(VendasPendentes ven, boolean envioManual, ArrayList<Codigos> listCod, ArrayList<codigos_has_vendas> listaCodigosHasVendasSelecionados) {
        try {
            MensagensEmail msgEmail = new MensagensEmail();
            String codigo = ven.getCodigo();
            HashMap<Integer, Integer> map = new HashMap<>();

            if (envioManual) {
                for (codigos_has_vendas chv : listaCodigosHasVendasSelecionados) {
                    map.put(chv.getId_codigo(), chv.getQtd());
                    System.out.println(chv.getId_codigo() + " for. " + map.get(chv.getId_codigo()));
                }
                codigo = "";
                for (int i = 0; i <= listCod.size() - 1; i++) {
                    Codigos c = listCod.get(i);
                    codigo = "\n" + codigo + c.getCodigo() + " - " + map.get(c.getId()) + " dispositivo(s)" + "\n";
                    if (c.getTipo().toLowerCase().equals("small") && i == 0) {
                        codigo = "\n" + c.getCodigo() + " - " + map.get(c.getId()) + " dispositivo(s) - 1 server" + "\n";
                    }
                    System.out.println("for enviarCodigoUmaVenda:" + codigo);
                }
            }
            String corpo = msgEmail.verificaQualOCorpoDOEmail(mapProd.get(ven.getIdProduto()).getTipo(), ven.getQtd(), codigo);
            EmailService email = new EmailService(ven.getEmail(),
                    "Código de ativação - " + ven.getProduto() + " - " + ven.getApelido() + " - " + ven.getId_venda(), corpo);
            email.sendEmail();
            if (envioManual) {
                for (codigos_has_vendas chv : listaCodigosHasVendasSelecionados) {
                    new Codigos_has_vendasDAO().insertCodigoEmVenda(chv);
                    new VendasPendentesDAO().remove(ven.getId_venda());
                }
            } else {
                setCodigoNaVenda(ven);
            }
        } catch (MessagingException ex) {
            Logger.getLogger(TelaVendas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TelaVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setCodigoNaVenda(VendasPendentes ven) {
        String idVenda = ven.getId_venda(); // Colocando só o getIdVenda nao dava certo, a Thread mudava e a venda também
        int idCod = ven.getIdCodigo();
        int qtd = ven.getQtd(); // estava dando como nulo
        codigos_has_vendas chv = new codigos_has_vendas();
        chv.setIdVenda(idVenda);
        chv.setId_codigo(idCod);
        chv.setQtd(qtd);
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
                        } else if (v.getPendente() == null && v.getCodigo() != null) {
                            MensagensEmail msgEmail = new MensagensEmail();
                            String corpo = msgEmail.verificaQualOCorpoDOEmail(mapProd.get(v.getIdProduto()).getTipo(), v.getQtd(), v.getCodigo());
                            EmailService email = new EmailService(v.getEmail(),
                                    "Código de ativação - " + v.getProduto() + " - " + v.getApelido() + " - " + v.getId_venda(), corpo);
                            email.sendEmail();
                            setCodigoNaVenda(v);
                            VariaveisDeControle.listVen.remove(v);
                            VariaveisDeControle.jComboBoxModelDialogVendasPendentes.removeElement(v);
                            if (c.getRevendedor_assitencia().equals("sim")) {
                                // new ProgramaFidelidade().verificaQtdProdutos(v.getApelido(), corpo);
                            }
                        } else {
                            System.out.println("venda com cod nulo ou com pendencia: " + v.getId_venda());
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(TelaVendas.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (MessagingException ex) {
                        Logger.getLogger(TelaVendas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }).start();
        }
    }

    public void reenviarEmail(Vendas v,ArrayList<codigos_has_vendas> list) {
        MensagensEmail msgEmail = new MensagensEmail();
        Produtos p = new ProdutosDAO().retornaProduto(v.getIdProduto());
        Cliente c = new ClienteDAO().buscaCliente(v.getApelido_comprador());
        int qtd = p.getQtd() * v.getQtd();
        String codigo = "";
        for(codigos_has_vendas chv : list){
            codigo = codigo + new CodigoDAO().buscaUmCodigo(chv.getId_codigo()).getCodigo() + "\n";
        }
        String corpo = msgEmail.verificaQualOCorpoDOEmail(p.getTipo(), qtd, codigo);
        String assunto = "Código de ativação - " + p.getTipo() + " " + qtd + " Dispositivo(s)" + p.getAnos()  +" Ano(s) - " + v.getApelido_comprador()+ " - " + v.getId();
        try {
          EmailService email =   new EmailService(c.getEmail(),assunto , corpo);
          email.sendEmail();
        } catch (IOException ex) {
            Logger.getLogger(EnviarCodigos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarCodigos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
