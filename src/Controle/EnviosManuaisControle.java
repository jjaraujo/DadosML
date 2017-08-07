/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.ClienteDAO;
import DAO.CodigoDAO;
import DAO.Codigos_has_vendasDAO;
import DAO.IncidentesDAO;
import DAO.VendaDAO;
import EmailConfig.AssuntosEmail;
import EmailConfig.MensagensEmail;
import Entidades.Cliente;
import Entidades.Incidentes;
import Entidades.Vendas;
import Visao.InternalFrameVendas;
import com.email.EmailService;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Joao
 */
public class EnviosManuaisControle {
    
    public void gerarIncidente(JTable jTableVendas, String idvenda, JTextField jTextFieldInformacaoAdicional ) {
        Incidentes inc = new Incidentes();
        int i = jTableVendas.getSelectedRow();
        inc.setId_venda(idvenda);
        
        int motivo = InternalFrameVendas.motivo;
        if (motivo > 0) {
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
            String codigo = (String) jTableVendas.getValueAt(i, 4);
            int countIncidentes = new IncidentesDAO().getCountIncidentes();
            inc.setDataIncidente(formatarDate.format(date));
            inc.setId("INC" + inc.getId_venda() + "00" + countIncidentes);
            inc.setMotivo(motivo);
            inc.setAnotacoes(jTextFieldInformacaoAdicional.getText());
            inc.setId_codigo(new CodigoDAO().getCodigosPorCodigo(codigo).getId());
            try {
                new IncidentesDAO().addIncidente(inc);
                JOptionPane.showMessageDialog(null, "Incidente adicionado!");
                try {
                    Vendas v = new VendaDAO().getUmaVenda(inc.getId_venda());
                    Cliente c = new ClienteDAO().buscaCliente(v.getApelido_comprador());
                    String assunto = new AssuntosEmail().assuntoAberturaIncidente(inc.getId());
                    String corpo = new MensagensEmail().mensagemIncidenteAdicionado(c.getNome(),inc.getId());
                    new EmailService(c.getEmail(), assunto, corpo).sendEmail();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "O email não foi enviado para o cliente do incidente " + inc.getId());
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível adicionar o incidente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Motivo inválido");
        }
    }

    public void reenviarCodigo(JTable jTableVendas) {
        int i = jTableVendas.getSelectedRow();
        String idVenda = (String) jTableVendas.getValueAt(i, 0);
        int opcao = JOptionPane.showConfirmDialog(null, "Reenviar códigos da venda " + idVenda + "?", "Confirmar reenvio", JOptionPane.YES_NO_OPTION);
        if (opcao == 0) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("reenviando email venda " + idVenda);
                    ArrayList listChv = new Codigos_has_vendasDAO().getCodigoHasVendas(idVenda);
                    new EnviarCodigos().reenviarEmail(new VendaDAO().getUmaVenda(idVenda), listChv);
                }
            }).start();
        }
    }
}
