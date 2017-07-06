/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.VariaveisDeControle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joao
 */
public class InternalFrameClientes extends javax.swing.JInternalFrame {

    private String tipoDePesquisa;
    private final DefaultTableModel modelo;
    private String apelidoClientePesquisado;

    /**
     * Creates new form InternalFrameVendas
     */
    public InternalFrameClientes() {
        if (VariaveisDeControle.user.equals("JOAO")) {
            modelo = new DefaultTableModel(null, new String[]{"ID Venda", "Apelido", "Nome",
                "Email", "Codigo", "Codigos Antigos", "Tipo", "Dispositivos",
                "Anos", "Valor", "Data", "Pagamento", "Cancelada", "Suspeito", "Inativo"}) {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;//To change body of generated methods, choose Tools | Templates.
                }
            };
        } else {
            modelo = new DefaultTableModel(null, new String[]{"ID Venda", "Apelido", "Nome",
                "Email", "Codigo", "Codigos Antigos", "Tipo", "Dispositivos",
                "Anos", "Data", "Pagamento", "Cancelada", "Suspeito", "Inativo"}) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVendas = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jTextFieldInformacaoVenda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupPesquisarVendaPor;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVendas;
    private javax.swing.JTextField jTextFieldInformacaoVenda;
    // End of variables declaration//GEN-END:variables

    public void pesquisarVendasPorVariavel() {
        try {

            modelo.setNumRows(0);
            String entrada = jTextFieldInformacaoVenda.getText().replaceAll("^\\s+", "");
            entrada = entrada.replaceAll("\\s+$", "");
            PreparedStatement stmt;
            ResultSet rs;
            String script = "select apelido,nome,email,"
                    + " where "
                    + tipoDePesquisa + " like ? order by v.data;";
            String id_venda = null;
            String email = null;
            String codigo = null;
            String tipo = null;
            String nome = null;
            int qtd_dispositivos = 0;
            int duracao = 0;
            String data = null;
            String pagamento = null;
            String cancelada = "";
            String suspeito = "";
            String inativo = "";
            String codigosAntigos = "";
            Double valor = 0.0;
            stmt = VariaveisDeControle.CON.prepareStatement(script);
            stmt.setString(1, "%" + entrada + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                id_venda = rs.getString("id_venda");
                apelidoClientePesquisado = rs.getString("apelido");
                nome = rs.getString("nome");
                email = rs.getString("email");
                codigo = rs.getString("codigo");
                codigosAntigos = rs.getString("codigos_antigos");
                tipo = rs.getString("tipo");
                qtd_dispositivos = rs.getInt("qtd_dispositivos");
                duracao = rs.getInt("duracao");
                valor = rs.getDouble("valor");
                data = rs.getString("data");
                pagamento = rs.getString("pagamento");
                cancelada = rs.getString("cancelada");
                suspeito = rs.getString("suspeito");
                inativo = rs.getString("inativo");
                if (VariaveisDeControle.user.equals("JOAO")) {
                    modelo.addRow(new Object[]{id_venda, apelidoClientePesquisado, nome, email, codigo, codigosAntigos, tipo, qtd_dispositivos, duracao, valor, data, pagamento, cancelada, suspeito, inativo});
                } else {
                    modelo.addRow(new Object[]{id_venda, apelidoClientePesquisado, nome, email, codigo, codigosAntigos, tipo, qtd_dispositivos, duracao, data, pagamento, cancelada, suspeito, inativo});
                }
            }
        } catch (SQLException ex) {

        }
    }

}