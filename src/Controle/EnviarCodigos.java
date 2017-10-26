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
import EmailConfig.AssuntosEmail;
import EmailConfig.MensagensEmail;
import Entidades.Cliente;
import Entidades.Codigos;
import Entidades.Produtos;
import Entidades.Vendas;
import Entidades.VendasPendentes;
import Entidades.codigos_has_vendas;
import EmailConfig.EmailService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import org.apache.commons.mail.EmailException;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 *
 * @author Joao
 */
public class EnviarCodigos {

    HashMap<String, Produtos> mapProd = VariaveisDeControle.mapProd;

    public EnviarCodigos() {

    }

    public void enviarCodigoUmaVenda(VendasPendentes ven, boolean envioManual, ArrayList<Codigos> listCod, ArrayList<codigos_has_vendas> listaCodigosHasVendasSelecionados) {
        MensagensEmail msgEmail = new MensagensEmail();
        Vendas v = new VendaDAO().getUmaVenda(ven.getId_venda());
        Cliente c = new ClienteDAO().getCliente(ven.getApelido());
        String codigo = organizaCodigosParaEnvio(envioManual, ven, listaCodigosHasVendasSelecionados, listCod, ven.getCodigo());
        int qtdDispositivos = ven.getQtd() * mapProd.get(ven.getIdProduto()).getQtd();
        String corpo = msgEmail.verificaQualOCorpoDOEmailHTML(mapProd.get(ven.getIdProduto()).getTipo(), qtdDispositivos, codigo, v, c.getNome());
        String assunto = new AssuntosEmail().enviarEmail(corpo, ven.getId_venda());
        EmailService email = new EmailService(ven.getEmail(), assunto, corpo);
        email.sendEmail(ven.getApelido());
        new EmailService(ven.getEmail(),"Seu código acaba de ser enviado!", msgEmail.AvisarCodigoEnviado(c.getNome(), assunto,codigo)).sendEmail(c.getApelido());

    }

    public void setCodigoNaVendaNoBanco(VendasPendentes ven) {
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
        new VendaDAO().setDataEnvio(pegaDataHoje(), idVenda);
    }

    public void enviarCodigosDaLista() {
        for (VendasPendentes v : VariaveisDeControle.listVen) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Cliente c = new ClienteDAO().getCliente(v.getApelido());
                    Vendas vd = new VendaDAO().getUmaVenda(v.getId_venda());
                    Produtos p = mapProd.get(v.getIdProduto());
                    String nomeProduto = p.getNomeProdutoQtdTotal(v.getQtd());
                    if ((v.getPagamento().toLowerCase().contains("boleto")
                            || v.getPagamento().toLowerCase().contains("saldo")) && c.getConfirmado() == null || p.getId().equals("KIS1D1A1A")) {
                        new VendasPendentesDAO().marcaComoPendente(v.getId_venda(), "Análise Pendente");
                    } else if (nomeProduto.contains("promocional")) {
                        new VendasPendentesDAO().marcaComoPendente(v.getId_venda(), "Venda promocional");
                    } else if (v.getPendente() == null && v.getCodigo() != null) {
                        int qtdDispositivos = v.getQtd() * mapProd.get(v.getIdProduto()).getQtd();
                        String codigo = organizaCodigosParaEnvio(false, v, null, null, v.getCodigo());
                        MensagensEmail msgEmail = new MensagensEmail();
                        String corpo = msgEmail.verificaQualOCorpoDOEmailHTML(mapProd.get(v.getIdProduto()).getTipo(), qtdDispositivos, codigo, vd, c.getNome());
                        String assunto =  new AssuntosEmail().enviarEmail(nomeProduto, v.getId_venda());
                        EmailService email = new EmailService(v.getEmail(),assunto, corpo);
                        email.sendEmail(v.getApelido());
                        new EmailService(v.getEmail(),"Seu código acaba de ser enviado!", msgEmail.AvisarCodigoEnviado(c.getNome(), assunto,codigo)).sendEmail(c.getApelido());
                        setCodigoNaVendaNoBanco(v);
                        VariaveisDeControle.listVen.remove(v);
                        VariaveisDeControle.jComboBoxModelDialogVendasPendentes.removeElement(v.toString());
                        if (c.getRevendedor_assitencia() != null) {
                            if (c.getRevendedor_assitencia().equals("sim")) {
                                // new ProgramaFidelidade().verificaQtdProdutos(v.getApelido(), corpo);
                            }
                        }
                    } else {
                        System.out.println("venda com cod nulo ou com pendencia: " + v.getId_venda());

                    }
                }
            }).start();
        }
    }

    public void reenviarEmail(String idVenda) {
        Vendas v = new VendaDAO().getUmaVenda(idVenda);
        Cliente c = new ClienteDAO().getCliente(v.getApelido_comprador());
        ArrayList<codigos_has_vendas> list = new Codigos_has_vendasDAO().getCodigoHasVendas(v.getId());
        int opcao = JOptionPane.showConfirmDialog(null, "Reenviar códigos da venda " + v.getId() + "?", "Confirmar reenvio", JOptionPane.YES_NO_OPTION);
        if (opcao == 0) {
            int opcao2 = JOptionPane.showConfirmDialog(null, "Informar outro email?", "Confirmar email", JOptionPane.YES_NO_OPTION);
            if (opcao2 == 0) {
                String email = JOptionPane.showInputDialog("Informe o email:");
                c.setEmail(email);
            }
        }
        MensagensEmail msgEmail = new MensagensEmail();
        Produtos p = new ProdutosDAO().retornaProduto(v.getIdProduto());
        int qtd = p.getQtd() * v.getQtd();
        ArrayList<Codigos> listCod = new ArrayList<>();
        list.forEach(cod -> {
            listCod.add(new CodigoDAO().buscaUmCodigo(cod.getId_codigo()));
        });
        String codigo = organizaCodigosParaEnvio(true, null, list, listCod, null);
        String corpo = msgEmail.verificaQualOCorpoDOEmailHTML(p.getTipo(), qtd, codigo, v, c.getNome());
        String assunto = new AssuntosEmail().reenviarEmail(p.getNomeProduto(), v.getId());
        EmailService email = new EmailService(c.getEmail(), assunto, corpo);
        email.sendEmail(c.getNome());

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
                    codigo = "<br>" + codigo + c.getCodigo() + " - " + map.get(c.getId()).getQtd() + " dispositivo(s) - " + map.get(c.getId()).getQtd_servidor() + "  server(s)" + "<br>";
                } else if (!c.getTipo().toLowerCase().equals("android")) {
                    codigo = "<br>" + codigo + c.getCodigo() + " - " + map.get(c.getId()).getQtd() + " dispositivo(s)" + "<br>";
                } else if (c.getTipo().toLowerCase().equals("android")) {
                    codigo = "<br>" + codigo + c.getCodigo() + " - " + map.get(c.getId()).getQtd() + " Android(s)" + "<br>";
                }
            }
            if (ven != null) {
                for (codigos_has_vendas chv : listaCodigosHasVendasSelecionados) {
                    new Codigos_has_vendasDAO().insertCodigoEmVenda(chv);
                    new VendasPendentesDAO().remove(ven.getId_venda());
                }
            }
        } else {
            Produtos p = mapProd.get(ven.getIdProduto());
            if (p.getTipo().toLowerCase().equals("small")) {
                codigo = "\n" + codigo + " - " + p.getQtd() * ven.getQtd() + " dispositivo(s) - " + mapProd.get(ven.getIdProduto()).getServer() + " server(s) \n";
            } else {
                codigo = "\n" + codigo + " - " + p.getQtd() * ven.getQtd() + " dispositivo(s)" + "\n";
            }
        }
        return codigo;
    }

    private String pegaDataHoje() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate hoje = LocalDate.parse(formatarDate.format(date));
        return hoje.toString();
    }
}
