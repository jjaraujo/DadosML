/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import DAO.ClienteDAO;
import DAO.CodigoDAO;
import DAO.IncidentesDAO;
import DAO.VendaDAO;
import EmailConfig.AssuntosEmail;
import EmailConfig.MensagensEmail;
import Entidades.Cliente;
import Entidades.Codigos;
import Entidades.Incidentes;
import Entidades.Vendas;
import com.email.EmailService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.table.DefaultTableModel;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 *
 * @author Joao
 */
public class InternalIncidentes extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;

    public InternalIncidentes() {
        modelo = new DefaultTableModel(null, new String[]{"Número Incidente", "Apelido", "Código", "Data Criação", "Data Compra", "Dias Aberto", "Motivo", "Anotações"}) {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;//To change body of generated methods, choose Tools | Templates.
            }
        };
        incidentesAbertos();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableIncidentes = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setMinimumSize(new java.awt.Dimension(1100, 274));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1100, 274));

        jTableIncidentes.setModel(modelo);
        jTableIncidentes.setCellSelectionEnabled(true);
        jTableIncidentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableIncidentesMouseClicked(evt);
            }
        });
        jTableIncidentes.getColumnModel().getColumn(0).setPreferredWidth(150);
        jTableIncidentes.getColumnModel().getColumn(1).setPreferredWidth(180);
        jTableIncidentes.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableIncidentes.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTableIncidentes.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTableIncidentes.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTableIncidentes.getColumnModel().getColumn(6).setPreferredWidth(300);
        jTableIncidentes.getColumnModel().getColumn(7).setPreferredWidth(300);
        jScrollPane1.setViewportView(jTableIncidentes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1628, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableIncidentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableIncidentesMouseClicked
        if ((evt.getModifiers() & MouseEvent.BUTTON3_MASK) != 0 && jTableIncidentes.getSelectedRow() >= 0) {
            JPopupMenu menu = new JPopupMenu();
            JMenuItem encerrarIncidente = new JMenuItem("Fechar Incidente");
            encerrarIncidente.addActionListener((ActionEvent ae) -> {
                new Thread(() -> {
                    int i = jTableIncidentes.getSelectedRow();
                    String id = (String) jTableIncidentes.getValueAt(i, 0);
                    int opcao = JOptionPane.showConfirmDialog(null, "Deseja encerrar o incidente " + id + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
                    if (opcao == 0) {
                        encerrarIncidente(id);
                    }
                    JOptionPane.showMessageDialog(null, "Incidente encerrado com sucesso!");
                    modelo.removeRow(i);
                }).start();
            });
            JMenuItem adicionarAnotacao = new JMenuItem("Adicionar Anotação");
            adicionarAnotacao.addActionListener((ActionEvent ae) -> {
                new Thread(() -> {
                    adicionarAnotacao();
                }).start();
            });
            menu.add(encerrarIncidente);
            menu.add(adicionarAnotacao);
            menu.show(this, evt.getX(), evt.getY());
        }// TODO add your handling code here:
    }//GEN-LAST:event_jTableIncidentesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableIncidentes;
    // End of variables declaration//GEN-END:variables
    private void incidentesAbertos() {
        ArrayList<Incidentes> list = new IncidentesDAO().getIncidentes();
        modelo.setNumRows(0);
        list.forEach(inc -> {
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
            LocalDate hoje = LocalDate.parse(formatarDate.format(date));
            LocalDate dataInc = LocalDate.parse(inc.getDataIncidente());
            int dias = getDiasRestantes(dataInc, hoje);
            modelo.addRow(new Object[]{inc.getId(), inc.getApelido(), inc.getCodigo(), inc.getDataIncidente(), inc.getDataCompra(), dias, inc.getMotivoTexto(), inc.getAnotacoes()});
        });
    }

    private int getDiasRestantes(LocalDate criacao, LocalDate hoje) {
        return Days.daysBetween(criacao, hoje).getDays();
    }

    public void encerrarIncidente(String id) {
        try {
            new IncidentesDAO().encerrarIncidente(id);
            Incidentes inc = new IncidentesDAO().getIncidente(id);
            try {
                Vendas v = new VendaDAO().getUmaVenda(inc.getId_venda());
                Cliente c = new ClienteDAO().buscaCliente(v.getApelido_comprador());
                String assunto = new AssuntosEmail().assuntoEncerramentoIncidente(id);
                String codigo = new CodigoDAO().buscaUmCodigo(inc.getId_codigo()).getCodigo();
                String corpo = new MensagensEmail().mensagemIncidenteEncerrado(c.getNome(), inc.getMotivo(), codigo);
                new EmailService(c.getEmail(), assunto, corpo).sendEmail();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "O email não foi enviado para o cliente do incidente " + inc.getId());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encerrar o incidente " + id);
            e.printStackTrace();
        }

    }

    private void adicionarAnotacao() {
        int i = jTableIncidentes.getSelectedRow();
        String id = (String) jTableIncidentes.getValueAt(i, 0);
        String anotacaoAnterior = (String) jTableIncidentes.getValueAt(i, 7);
        String anotacao = JOptionPane.showInputDialog("Adicionar anotação: ");
        if (anotacao != null) {
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
            String data = formatarDate.format(date);
            new IncidentesDAO().setAnotacao(id, anotacao, data);
            modelo.setValueAt(anotacaoAnterior + data + ": " + anotacao + ";", i, 7);
        }
    }
}
