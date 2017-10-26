/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.EnviarCodigos;
import Controle.VariaveisDeControle;
import DAO.CodigoDAO;
import DAO.Codigos_has_vendasDAO;
import DAO.ProdutosDAO;
import DAO.VendasPendentesDAO;
import Entidades.Codigos;
import Entidades.Produtos;
import Entidades.VendasPendentes;
import Entidades.codigos_has_vendas;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao
 */
public class InternalEnviosManuais extends javax.swing.JInternalFrame {

    /**
     * Creates new form InternalEnviosManuais
     */
    private int QtdSelecionadaDaVenda;
    private VendasPendentes ven = new VendasPendentes();
    ArrayList<codigos_has_vendas> listaCodigosHasVendasSelecionados = new ArrayList<>();
    private ArrayList<Codigos> codAdicionadoManualmente = new ArrayList<>();
    private HashMap<String, Produtos> map = VariaveisDeControle.mapProd;

    public InternalEnviosManuais() {
        initComponents();
        if (!VariaveisDeControle.listVen.isEmpty()) {
            ven = VariaveisDeControle.listVen.get(VariaveisDeControle.indexItemSelecionado);
            preencheCampos();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane7 = new javax.swing.JScrollPane();
        jTextAreaCodigosSelecionados = new javax.swing.JTextArea();
        jSpinnerQTD = new javax.swing.JSpinner();
        jLabel36 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextFieldObservacaoEnvioManual = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextFieldProdutoEnvioManual = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextFieldIdCodigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextFieldApelidoEnvioManual = new javax.swing.JTextField();
        jSpinnerQTDServer = new javax.swing.JSpinner();
        jLabel34 = new javax.swing.JLabel();
        jScrollvendasPendentes = new javax.swing.JScrollPane();
        jListVendasPendentes = new javax.swing.JList<>();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Envio de Código");
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

        jTextAreaCodigosSelecionados.setColumns(20);
        jTextAreaCodigosSelecionados.setRows(5);
        jScrollPane7.setViewportView(jTextAreaCodigosSelecionados);

        jLabel36.setText("Apelido:");

        jLabel33.setText("Dispositivos:");

        jTextFieldObservacaoEnvioManual.setEditable(false);

        jLabel35.setText("Observação:");

        jLabel32.setText("ID código:");

        jTextFieldProdutoEnvioManual.setEditable(false);

        jLabel37.setText("Produto:");

        jTextFieldIdCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdCodigoActionPerformed(evt);
            }
        });

        jButton1.setText("Salvar e Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Adicionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Limpar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Salvar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextFieldApelidoEnvioManual.setEditable(false);

        jSpinnerQTDServer.setValue(ven.getQtd());

        jLabel34.setText("Server:");

        jListVendasPendentes.setModel(VariaveisDeControle.jModelList);
        jListVendasPendentes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListVendasPendentesValueChanged(evt);
            }
        });
        jScrollvendasPendentes.setViewportView(jListVendasPendentes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldProdutoEnvioManual, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldObservacaoEnvioManual, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldApelidoEnvioManual, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(74, 74, 74)
                            .addComponent(jButton4)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1)
                            .addGap(18, 18, 18)
                            .addComponent(jButton3)
                            .addGap(44, 44, 44))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldIdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerQTD, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerQTDServer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)))))
                .addContainerGap(53, Short.MAX_VALUE))
            .addComponent(jScrollvendasPendentes, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollvendasPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldProdutoEnvioManual, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldObservacaoEnvioManual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35)
                        .addComponent(jLabel36)
                        .addComponent(jTextFieldApelidoEnvioManual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(jTextFieldIdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(jSpinnerQTD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jLabel34)
                        .addComponent(jSpinnerQTDServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed

    }//GEN-LAST:event_formInternalFrameClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jListVendasPendentes.setEnabled(true);
        new Thread(() -> {
            if (listaCodigosHasVendasSelecionados.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Adicione um código");
            } else {
                ArrayList<codigos_has_vendas> listaCodigosHasVendasSelecionados2 = new ArrayList<>();
                listaCodigosHasVendasSelecionados2.addAll(listaCodigosHasVendasSelecionados);
                ArrayList<Codigos> codAdicionadoManualmente2 = new ArrayList<>();
                codAdicionadoManualmente2.addAll(codAdicionadoManualmente);
                ven = VariaveisDeControle.listVen.get(VariaveisDeControle.indexItemSelecionado);
                ven.setCodigo(null);
                for (Codigos c : codAdicionadoManualmente2) {
                    System.out.println(c.getCodigo() + " na list adicionadoManualmente");
                }
                VendasPendentes v = ven;
                limparCampos();
                excluirDaLista(v);
                new EnviarCodigos().enviarCodigoUmaVenda(v, true, codAdicionadoManualmente2, listaCodigosHasVendasSelecionados2);
                new VendasPendentesDAO().remove(v.getId_venda());
            }
        }).start();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        QtdSelecionadaDaVenda = QtdSelecionadaDaVenda + (int) jSpinnerQTD.getValue();
        jTextAreaCodigosSelecionados.setText(jTextAreaCodigosSelecionados.getText() + jTextFieldIdCodigo.getText() + " - " + jSpinnerQTD.getValue() + " - " + jSpinnerQTDServer.getValue() + " server\n");
        inserirEAlterarCodigoVendaManualmente(Integer.parseInt(jTextFieldIdCodigo.getText()), (int) jSpinnerQTD.getValue(), (int) jSpinnerQTDServer.getValue());
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        limparCampos();       // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (listaCodigosHasVendasSelecionados.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Adicione um código");
                } else {
                    ArrayList<codigos_has_vendas> listaCodigosHasVendasSelecionados2 = new ArrayList<>();
                    listaCodigosHasVendasSelecionados2.addAll(listaCodigosHasVendasSelecionados);
                    for (codigos_has_vendas chv : listaCodigosHasVendasSelecionados2) {
                        new Codigos_has_vendasDAO().insertCodigoEmVenda(chv);
                        new VendasPendentesDAO().remove(ven.getId_venda());
                    }
                }
            }
        }).start();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        VariaveisDeControle.frameEnvioManualAberto = false;        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing

    private void jListVendasPendentesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListVendasPendentesValueChanged
        if (VariaveisDeControle.jModelList.getSize() != 0 && jListVendasPendentes.getSelectedIndex() > -1) {
            VariaveisDeControle.indexItemSelecionado = jListVendasPendentes.getSelectedIndex();
            ven = VariaveisDeControle.listVen.get(VariaveisDeControle.indexItemSelecionado);
            preencheCampos();
        }
    }//GEN-LAST:event_jListVendasPendentesValueChanged

    private void jTextFieldIdCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdCodigoActionPerformed
        jListVendasPendentes.setEnabled(false);
    }//GEN-LAST:event_jTextFieldIdCodigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private static javax.swing.JList<String> jListVendasPendentes;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollvendasPendentes;
    private javax.swing.JSpinner jSpinnerQTD;
    private javax.swing.JSpinner jSpinnerQTDServer;
    private javax.swing.JTextArea jTextAreaCodigosSelecionados;
    private javax.swing.JTextField jTextFieldApelidoEnvioManual;
    private javax.swing.JTextField jTextFieldIdCodigo;
    private javax.swing.JTextField jTextFieldObservacaoEnvioManual;
    private javax.swing.JTextField jTextFieldProdutoEnvioManual;
    // End of variables declaration//GEN-END:variables

    private void inserirEAlterarCodigoVendaManualmente(int id, int qtd, int qtdServer) {
        try {
            codigos_has_vendas chv = new codigos_has_vendas();
            chv.setIdVenda(ven.getId_venda());
            chv.setId_codigo(id);
            chv.setQtd(qtd);
            chv.setQtd_servidor(qtdServer);
            listaCodigosHasVendasSelecionados.add(chv);
            Codigos c = new CodigoDAO().buscaUmCodigo(id);
            codAdicionadoManualmente.add(c);
        } catch (Exception e) {

        }
    }

    private void limparCampos() {
        listaCodigosHasVendasSelecionados.clear();
        QtdSelecionadaDaVenda = 0;
        jTextAreaCodigosSelecionados.setText("");
        jTextFieldIdCodigo.setText("");
        jTextFieldApelidoEnvioManual.setText("");
        jTextFieldProdutoEnvioManual.setText("");
        jSpinnerQTD.setValue(0);
        jSpinnerQTDServer.setValue(0);
        codAdicionadoManualmente.clear();
    }


    private void preencheCampos() {
        if (ven != null) {
            VendasPendentes ven = this.ven;
            jSpinnerQTD.setValue(ven.getQtd() * map.get(ven.getIdProduto()).getQtd());
            jSpinnerQTDServer.setValue(VariaveisDeControle.mapProd.get(ven.getIdProduto()).getServer());
            jTextFieldApelidoEnvioManual.setText(ven.getApelido());
            jTextFieldObservacaoEnvioManual.setText(ven.getObservacoes());
            jTextFieldProdutoEnvioManual.setText(VariaveisDeControle.mapProd.get(ven.getIdProduto()).getNomeProdutoQtdTotal(ven.getQtd()));
            if (InternalFrameAnaliseVendaPendentes.getJList() != null) {
                InternalFrameAnaliseVendaPendentes.getJList().setSelectedIndex(VariaveisDeControle.indexItemSelecionado);
            }
           
        }
    }

    public static JList getJList() {
        return jListVendasPendentes;
    }
    
        private void excluirDaLista(VendasPendentes v) {
        VendasPendentes ven = new VendasPendentes();
        VariaveisDeControle.listVen.remove(VariaveisDeControle.indexItemSelecionado);
        VariaveisDeControle.jModelList.removeElementAt(VariaveisDeControle.indexItemSelecionado);
    }
}
