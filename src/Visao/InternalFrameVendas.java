/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Connection.ConnectionFactory;
import Controle.EnviarCodigos;
import Controle.EnviosManuaisControle;
import Controle.VariaveisDeControle;
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
import EmailConfig.EmailService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 *
 * @author Joao
 */
public class InternalFrameVendas extends javax.swing.JInternalFrame {

    private String tipoDePesquisa;
    private final DefaultTableModel modelo;
    private String apelidoClientePesquisado;
    public static int motivo;

    /**
     * Creates new form InternalFrameVendas
     */
    public InternalFrameVendas() {
        if (VariaveisDeControle.user.equals("JOAO")) {
            modelo = new DefaultTableModel(null, new String[]{"ID Venda", "Apelido", "Nome",
                "Email", "Codigo", "Codigos Antigos", "Tipo", "Dispositivos", "Servidores",
                "Anos", "Valor", "Data", "Data envio", "Dias restantes", "Pagamento", "Cancelada", "Suspeito", "Inativo"}) {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;//To change body of generated methods, choose Tools | Templates.
                }
            };
        } else {
            modelo = new DefaultTableModel(null, new String[]{"ID Venda", "Apelido", "Nome",
                "Email", "Codigo", "Codigos Antigos", "Tipo", "Dispositivos", "Servidores",
                "Anos", "Data", "Data envio", "Dias restantes", "Pagamento", "Cancelada", "Suspeito", "Inativo"}) {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;//To change body of generated methods, choose Tools | Templates.
                }
            };
        }
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

        buttonGroupPesquisarVendaPor = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldInformacaoAdicional = new javax.swing.JTextField();
        buttonGroupMotivo = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVendas = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jTextFieldInformacaoVenda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jDialog1.setMinimumSize(new java.awt.Dimension(605, 354));
        jDialog1.setModal(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        buttonGroupMotivo.add(jRadioButton5);
        jRadioButton5.setText("Tentou ativar pela primeira vez e o código excedeu");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        buttonGroupMotivo.add(jRadioButton6);
        jRadioButton6.setText("Formatou o computador e o código excedeu");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        buttonGroupMotivo.add(jRadioButton7);
        jRadioButton7.setText("Código bloqueado");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        buttonGroupMotivo.add(jRadioButton8);
        jRadioButton8.setText("Programa Incompatível");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Informação adicional:");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton6)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton7)
                            .addComponent(jRadioButton8)))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldInformacaoAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jButton2)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton8)
                .addGap(33, 33, 33)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldInformacaoAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Buscar Vendas");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jTableVendas.setModel(modelo);
        jTableVendas.setCellSelectionEnabled(true);
        jTableVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVendas);
        jTableVendas.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTableVendas.getColumnModel().getColumn(1).setPreferredWidth(140);
        jTableVendas.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableVendas.getColumnModel().getColumn(3).setPreferredWidth(230);
        jTableVendas.getColumnModel().getColumn(4).setPreferredWidth(260);
        jTableVendas.getColumnModel().getColumn(5).setPreferredWidth(50);
        jTableVendas.getColumnModel().getColumn(6).setPreferredWidth(50);
        jTableVendas.getColumnModel().getColumn(7).setPreferredWidth(80);
        jTableVendas.getColumnModel().getColumn(8).setPreferredWidth(80);
        jTableVendas.getColumnModel().getColumn(9).setPreferredWidth(60);
        jTableVendas.getColumnModel().getColumn(10).setPreferredWidth(100);
        jTableVendas.getColumnModel().getColumn(11).setPreferredWidth(80);
        jTableVendas.getColumnModel().getColumn(12).setPreferredWidth(80);
        jTableVendas.getColumnModel().getColumn(13).setPreferredWidth(80);
        jTableVendas.getColumnModel().getColumn(14).setPreferredWidth(80);
        jTableVendas.getColumnModel().getColumn(15).setPreferredWidth(80);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar por:"));

        buttonGroupPesquisarVendaPor.add(jRadioButton3);
        jRadioButton3.setText("Numero da Compra");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroupPesquisarVendaPor.add(jRadioButton2);
        jRadioButton2.setText("Email");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroupPesquisarVendaPor.add(jRadioButton1);
        jRadioButton1.setText("Nome");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroupPesquisarVendaPor.add(jRadioButton4);
        jRadioButton4.setText("Apelido");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton4))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldInformacaoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(652, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldInformacaoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        tipoDePesquisa = "v.id";        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        tipoDePesquisa = "cl.email";        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        tipoDePesquisa = "cl.nome";        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        tipoDePesquisa = "cl.apelido";        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pesquisarVendasPorVariavel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed

    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        VariaveisDeControle.frameVendasAberto = false;        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing

    private void jTableVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVendasMouseClicked
        //Verificando se o botão direito foi pressionado
        if ((evt.getModifiers() & MouseEvent.BUTTON3_MASK) != 0 && (jTableVendas.getSelectedRowCount() == 1)) {
            int i = jTableVendas.getSelectedRow();
            JPopupMenu menu = new JPopupMenu();
            JMenuItem adicionarIncidente = new JMenuItem("Adicionar Incidente");
            JMenuItem reenviar = new JMenuItem("Reenviar");
            JMenuItem atualizarEmail = new JMenuItem("Atualizar email");
            adicionarIncidente.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    String idvenda = (String) jTableVendas.getValueAt(i, 0);
                    jLabel1.setText("MOTIVO DE CRIAR INCIDENTE NA VENDA " + idvenda + ":");
                    jDialog1.setVisible(true);
                }
            });

            reenviar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    String idVenda = (String) jTableVendas.getValueAt(i, 0);
                        new EnviarCodigos().reenviarEmail(idVenda);
                    }
            });
            atualizarEmail.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    String apelido = (String) jTableVendas.getValueAt(i, 1);
                    String email = JOptionPane.showInputDialog("Informe o novo email");
                    int i = JOptionPane.showConfirmDialog(null, "Confirmar email " + email + " para o cliente " + apelido + "?", "Confirmar email", JOptionPane.OK_CANCEL_OPTION);
                    if (i == 0) {
                        new ClienteDAO().updateEmail(apelido, email);
                        String nome = new ClienteDAO().getCliente(apelido).getNome();
                        String assunto = new AssuntosEmail().emailAtualizado();
                        String corpo = new MensagensEmail().atualizarEmail(nome);
                        new EmailConfig.EmailService(email, assunto, corpo).sendEmail(apelido);
                        JOptionPane.showMessageDialog(null, "Email atualizado");
                    }

                }
            });
            menu.add(adicionarIncidente);
            menu.add(reenviar);
            menu.add(atualizarEmail);
            menu.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jTableVendasMouseClicked

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        motivo = 2;        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        motivo = 3;        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        motivo = 4;        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        motivo = 1;        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Thread(() -> {
            int i = jTableVendas.getSelectedRow();
            String idvenda = (String) jTableVendas.getValueAt(i, 0);
            new EnviosManuaisControle().gerarIncidente(jTableVendas, idvenda, jTextFieldInformacaoAdicional);
        }).start();
        if (buttonGroupMotivo.getSelection() != null) {
            jDialog1.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Escolha um motivo");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupMotivo;
    private javax.swing.ButtonGroup buttonGroupPesquisarVendaPor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVendas;
    private javax.swing.JTextField jTextFieldInformacaoAdicional;
    private javax.swing.JTextField jTextFieldInformacaoVenda;
    // End of variables declaration//GEN-END:variables

    public void pesquisarVendasPorVariavel() {
        try {

            modelo.setNumRows(0);
            String entrada = jTextFieldInformacaoVenda.getText().replaceAll("^\\s+", "");
            entrada = entrada.replaceAll("\\s+$", "");
            PreparedStatement stmt;
            ResultSet rs;
            String script = "select chv.id_venda id_venda, cl.apelido apelido,cl.nome nome,cl.email email,"
                    + " cd.codigo codigo,chv.codigos_antigos codigos_antigos,"
                    + "cd.tipo tipo, chv.qtd_dispositivos qtd_dispositivos,"
                    + "chv.qtd_servidor qtd_servidor, v.valor, "
                    + "cd.duracao duracao,v.data data,v.data_envio data_envio, v.forma_pagamento pagamento,"
                    + "p.duracao duracao_produto,v.cancelada cancelada,cl.suspeito suspeito,cl.inativo inativo "
                    + "from codigos_has_vendas chv "
                    + "join vendas v on v.id like chv.id_venda "
                    + "join clientes_ml cl on v.apelido_comprador like cl.apelido "
                    + "join codigos cd on cd.id = chv.id_codigo "
                    + "join produtos p on p.id = v.id_produto"
                    + " where "
                    + tipoDePesquisa + " like ? order by v.data;";
            stmt = VariaveisDeControle.CON.prepareStatement(script);
            stmt.setString(1, "%" + entrada + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id_venda = rs.getString("id_venda");
                apelidoClientePesquisado = rs.getString("apelido");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String codigo = rs.getString("codigo");
                String codigosAntigos = rs.getString("codigos_antigos");
                String tipo = rs.getString("tipo");
                int qtd_dispositivos = rs.getInt("qtd_dispositivos");
                int qtd_server = rs.getInt("qtd_servidor");
                int duracao = rs.getInt("duracao");
                Double valor = rs.getDouble("valor");
                String data = rs.getString("data");
                String dataEnvio = rs.getString("data_envio");
                int duracao_produto = rs.getInt("duracao_produto");
                String pagamento = rs.getString("pagamento");
                String cancelada = rs.getString("cancelada");
                String suspeito = rs.getString("suspeito");
                String inativo = rs.getString("inativo");
                int diasRestantes = getDiasRestantes(data, duracao_produto);
                if (VariaveisDeControle.user.equals("JOAO")) {
                    modelo.addRow(new Object[]{id_venda, apelidoClientePesquisado, nome, email, codigo, codigosAntigos, tipo, qtd_dispositivos, qtd_server, duracao, valor, data, dataEnvio, diasRestantes, pagamento, cancelada, suspeito, inativo});
                } else {
                    modelo.addRow(new Object[]{id_venda, apelidoClientePesquisado, nome, email, codigo, codigosAntigos, tipo, qtd_dispositivos, qtd_server, duracao, data, dataEnvio, diasRestantes, pagamento, cancelada, suspeito, inativo});
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "\n Abra o programa novamente!", "Erro", JOptionPane.WARNING_MESSAGE);
            ex.printStackTrace();
            System.exit(0);
        }
    }

    private int getDiasRestantes(String data_compra, int ano) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dataCompra = format.parse(data_compra);
            Date dateHoje = new Date(System.currentTimeMillis());
            Calendar c = Calendar.getInstance();
            c.setTime(dataCompra);
            c.set(Calendar.YEAR, c.get(Calendar.YEAR) + ano);
            LocalDate hoje = LocalDate.parse(format.format(dateHoje));
            LocalDate dataFim = LocalDate.parse(format.format(c.getTime()));
            return Days.daysBetween(hoje, dataFim).getDays();
        } catch (ParseException ex) {
            Logger.getLogger(InternalFrameVendas.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

}
