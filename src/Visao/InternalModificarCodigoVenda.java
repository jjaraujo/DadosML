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
import DAO.VendaDAO;
import Entidades.Codigos;
import Entidades.Vendas;
import Entidades.VendasPendentes;
import Entidades.codigos_has_vendas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao
 */
public class InternalModificarCodigoVenda extends javax.swing.JInternalFrame {

    private int QtdSelecionadaDaVenda;
    private Vendas venda;
    private ArrayList<codigos_has_vendas> listChv;
    private ArrayList<codigos_has_vendas> listaCodigosHasVendasSelecionados = new ArrayList<>();
    private int qtdDispositivosVenda;
    private ArrayList<codigos_has_vendas> codigosExcluidos = new ArrayList<>();
    private ArrayList<codigos_has_vendas> codigosSubstituidos = new ArrayList<>();
    private ArrayList<codigos_has_vendas> codigosAtualizados = new ArrayList<>();
    private ArrayList<codigos_has_vendas> codigosInseridos = new ArrayList<>();
    private String tipoAlteracao = "";

    /**
     * Creates new form InternalModificarCodigoVenda
     */
    public InternalModificarCodigoVenda() {
        initComponents();
        jButtonAtualizar.setEnabled(false);
        jButtonAdicionar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonSubstituir.setEnabled(false);
        jPanel1.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonAdicionar = new javax.swing.JButton();
        jSpinnerQTDAtualizarVenda = new javax.swing.JSpinner();
        jTextFieldIdVenda = new javax.swing.JTextField();
        jTextFieldIdCodigo = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jButtonSubstituir = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jButtonAtualizar = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListCodigosAtuais = new javax.swing.JList<>();
        jButton23 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextAreaCodigosAtualizarVendas = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        jSpinnerQTDServer = new javax.swing.JSpinner();
        jLabel42 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modificar Venda");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar código"));

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jTextFieldIdVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdVendaActionPerformed(evt);
            }
        });

        jTextFieldIdCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdCodigoActionPerformed(evt);
            }
        });

        jLabel40.setText("        ID Codigo:");

        jButtonSubstituir.setText("Substituir");
        jButtonSubstituir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubstituirActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jLabel41.setText("Quantidade:");

        jButtonAtualizar.setText("Atualizar Quantidade");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jLabel38.setText("ID Venda:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jListCodigosAtuais.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { ""};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListCodigosAtuais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListCodigosAtuaisMouseClicked(evt);
            }
        });
        jListCodigosAtuais.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListCodigosAtuaisValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListCodigosAtuais);

        jButton23.setText("Salvar");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton21.setText("Limpar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jTextAreaCodigosAtualizarVendas.setEditable(false);
        jTextAreaCodigosAtualizarVendas.setColumns(20);
        jTextAreaCodigosAtualizarVendas.setRows(5);
        jScrollPane9.setViewportView(jTextAreaCodigosAtualizarVendas);

        jLabel42.setText("Servidores:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerQTDAtualizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerQTDServer, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAdicionar)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(81, 81, 81)
                            .addComponent(jLabel38)
                            .addGap(2, 2, 2)
                            .addComponent(jTextFieldIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonSubstituir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jTextFieldIdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jSpinnerQTDAtualizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(jSpinnerQTDServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton21)
                        .addGap(18, 18, 18)
                        .addComponent(jButton23)
                        .addGap(23, 23, 23))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel38)
                                .addComponent(jTextFieldIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(jButtonExcluir)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonSubstituir)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonAtualizar)))
                    .addContainerGap(182, Short.MAX_VALUE)))
        );

        jMenu1.setText("Opções");

        jMenuItem1.setText("Cancelar Venda");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Modificar Produto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Modificar Quantidade");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIdCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdCodigoActionPerformed

    private void jTextFieldIdVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdVendaActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        if (jTextFieldIdCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione ou insira um código");
        } else {
            int qtdJSpinner = (int) jSpinnerQTDAtualizarVenda.getValue();
            if (QtdSelecionadaDaVenda <= qtdDispositivosVenda || qtdJSpinner > qtdDispositivosVenda) {
                QtdSelecionadaDaVenda = QtdSelecionadaDaVenda + qtdJSpinner;
                jTextAreaCodigosAtualizarVendas.setText(jTextAreaCodigosAtualizarVendas.getText() + jTextFieldIdCodigo.getText() + " - " + jSpinnerQTDAtualizarVenda.getValue() + " - " + tipoAlteracao + " \n");
                int id = Integer.parseInt(jTextFieldIdCodigo.getText());
                int qtd = (int) jSpinnerQTDAtualizarVenda.getValue();
                int qtdServer = (int) jSpinnerQTDServer.getValue();
                codigos_has_vendas chv = new codigos_has_vendas();
                chv.setIdVenda(jTextFieldIdVenda.getText());
                chv.setId_codigo(id);
                chv.setQtd(qtd);
                chv.setQtd_servidor(qtdServer);
                switch (tipoAlteracao) {
                    case "excluir":
                        codigosExcluidos.add(chv);
                        break;
                    case "atualizar":
                        codigosAtualizados.add(chv);
                        break;
                    case "substituir":
                        codigosSubstituidos.add(chv);
                        break;
                    case "":
                        codigosInseridos.add(chv);
                        break;
                }
                tipoAlteracao = "";
                jTextFieldIdCodigo.setText("");
                jSpinnerQTDAtualizarVenda.setValue(qtdDispositivosVenda - QtdSelecionadaDaVenda);
            } else {
                JOptionPane.showMessageDialog(null, "Quantidade de dispositivos maior que a da venda");
            }
        }
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        tipoAlteracao = "excluir";
        jTextFieldIdCodigo.setText(listChv.get(jListCodigosAtuais.getSelectedIndex()).getId_codigo() + "");
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            listChv = new Codigos_has_vendasDAO().getCodigoHasVendas(jTextFieldIdVenda.getText());
            buscaInformacoesVenda();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        tipoAlteracao = "atualizar";
        if (jListCodigosAtuais.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um código da lista");
        } else {
            codigos_has_vendas chv = listChv.get(jListCodigosAtuais.getSelectedIndex());
            jTextFieldIdCodigo.setText(chv.getId_codigo() + "");
            jSpinnerQTDAtualizarVenda.setValue(chv.getQtd());
        }

    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jListCodigosAtuaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListCodigosAtuaisMouseClicked

    }//GEN-LAST:event_jListCodigosAtuaisMouseClicked

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        salvarCodigos();
        limparDados();
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButtonSubstituirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubstituirActionPerformed
        tipoAlteracao = "substituir";
    }//GEN-LAST:event_jButtonSubstituirActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        limparDados();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (venda == null) {
            JOptionPane.showMessageDialog(null, "Pesquise uma venda!");
        } else {
            new VendaDAO().cancelaVenda(venda.getId());
            listChv.forEach((c) -> {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new CodigoDAO().updateQtdUsadaCodigo(c.getId_codigo());
                    }
                }).start();
            });
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        VariaveisDeControle.frameModificarVendaAberto = false;        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (venda == null) {
            JOptionPane.showMessageDialog(null, "Pesquise uma venda!");
        } else {
            String s = JOptionPane.showInputDialog("Informe o id do produto");
            if (s == null) {

            } else {
                new VendaDAO().updateIdProdutoVenda(venda.getId(), Integer.parseInt(s));

            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (venda == null) {
            JOptionPane.showMessageDialog(null, "Pesquise uma venda!");
        } else {
            String s = JOptionPane.showInputDialog("Informe a nova quantidade");
            if (s == null) {

            } else {
                new VendaDAO().updateQtdVenda(venda.getId(), Integer.parseInt(s));

            }
        }           // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jListCodigosAtuaisValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListCodigosAtuaisValueChanged
        if (listChv != null) {
            int qtdDispositivos = listChv.get(jListCodigosAtuais.getSelectedIndex()).getQtd();
            int qtdServidor = listChv.get(jListCodigosAtuais.getSelectedIndex()).getQtd_servidor();
            jSpinnerQTDAtualizarVenda.setValue(qtdDispositivos);
            jSpinnerQTDServer.setValue(qtdServidor);
        }
    }//GEN-LAST:event_jListCodigosAtuaisValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonSubstituir;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JList<String> jListCodigosAtuais;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSpinner jSpinnerQTDAtualizarVenda;
    private javax.swing.JSpinner jSpinnerQTDServer;
    private javax.swing.JTextArea jTextAreaCodigosAtualizarVendas;
    private javax.swing.JTextField jTextFieldIdCodigo;
    private javax.swing.JTextField jTextFieldIdVenda;
    // End of variables declaration//GEN-END:variables

    private void buscaInformacoesVenda() {
        if (listChv == null) {
            JOptionPane.showMessageDialog(null, "Não foram encontrados nenhum código nessa venda");
        } else {
            venda = new VendaDAO().getUmaVenda(jTextFieldIdVenda.getText());
            int dispositivosProduto = new ProdutosDAO().retornaProduto(venda.getIdProduto()).getQtd();
            qtdDispositivosVenda = dispositivosProduto * venda.getQtd();
            System.out.println(venda.getIdProduto() + ", " + dispositivosProduto + ", " + venda.getQtd() + " ," + qtdDispositivosVenda);
            jListCodigosAtuais.setModel(new javax.swing.AbstractListModel<String>() {
                public int getSize() {
                    return listChv.size();
                }

                public String getElementAt(int i) {
                    return ("Codigo: " + listChv.get(i).getId_codigo() + " - QTD: " + listChv.get(i).getQtd());
                }
            });
            jButtonAtualizar.setEnabled(true);
            jButtonAdicionar.setEnabled(true);
            jButtonExcluir.setEnabled(true);
            jButtonSubstituir.setEnabled(true);
        }
    }

    private void salvarCodigos() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<codigos_has_vendas> codigosInseridos2 = new ArrayList<>();
                codigosInseridos2.addAll(codigosInseridos);
                if (!codigosInseridos2.isEmpty()) {
                    codigosInseridos2.forEach((c) -> {
                        new Codigos_has_vendasDAO().insertCodigoEmVenda(c);
                        new CodigoDAO().updateQtdUsadaCodigo(c.getId_codigo());
                    });
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<codigos_has_vendas> codigosAtualizados2 = new ArrayList<>();
                codigosAtualizados2.addAll(codigosAtualizados);
                if (!codigosAtualizados2.isEmpty()) {
                    codigosAtualizados2.forEach((c) -> {
                        new Codigos_has_vendasDAO().updateCodigoHasVendas(c);
                        new CodigoDAO().updateQtdUsadaCodigo(c.getId_codigo());
                    });
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<codigos_has_vendas> codigosExcluidos2 = new ArrayList<>();
                codigosExcluidos2.addAll(codigosExcluidos);
                if (!codigosExcluidos2.isEmpty()) {
                    codigosExcluidos2.forEach((c) -> {
                        new Codigos_has_vendasDAO().deteleCodigoHasVendas(c.getIdVenda(), c.getId_codigo());
                        new Codigos_has_vendasDAO().updateCodigoAntigos(c, new CodigoDAO().buscaUmCodigo(c.getId_codigo()).getCodigo());
                        new CodigoDAO().updateQtdUsadaCodigo(c.getId_codigo());
                    });
                }
            }
        }).start();
    }

    private void limparDados() {
        jTextAreaCodigosAtualizarVendas.setText("");
        jTextFieldIdVenda.setText("");
        jTextFieldIdCodigo.setText("");
        jListCodigosAtuais.removeAll();
        QtdSelecionadaDaVenda = 0;
        venda = new Vendas();
        listChv.clear();
        listaCodigosHasVendasSelecionados.clear();
        qtdDispositivosVenda = 0;
        codigosExcluidos.clear();
        codigosSubstituidos.clear();
        codigosAtualizados.clear();
        codigosInseridos.clear();
        tipoAlteracao = "";
    }
}
