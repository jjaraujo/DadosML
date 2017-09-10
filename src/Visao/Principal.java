/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Connection.ConnectionFactory;
import Controle.EnviarCodigos;
import Controle.InsereCodigoNasVendasParaEnvio;
import Controle.VariaveisDeControle;
import DAO.CodigoDAO;
import DAO.Codigos_has_vendasDAO;
;import DAO.IncidentesDAO;
import DAO.ProdutosDAO;
import DAO.VendaDAO;
import EmailConfig.MensagensEmail;
import Entidades.EmailNomeTipoproduto;
import  EmailConfig.EmailService;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao
 */


public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension scrnsize = toolkit.getScreenSize();
        dialogAutenticacao();
        VariaveisDeControle.atualizaMapProdutos();
        VariaveisDeControle.textArea = jTextAreaSaida;
        this.setSize(scrnsize);
        int i = new IncidentesDAO().getCountIncidentesAbertos();
        if (i > 0) {
            
            jLabel3.setText("Há " + i + " incidente(s) abertos");
            jDialog2.setVisible(true);
        }
           if(!new CodigoDAO().getCodigosProximosExpirar().isEmpty()){
              jLabel3.setText("Há códigos próximos de expirar. Verifique a lista de códigos para enviar emails");
           jDialog2.setVisible(true);
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

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jDialog2 = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaSaida = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();

        jDialog1.setAlwaysOnTop(true);
        jDialog1.setMinimumSize(new java.awt.Dimension(256, 183));
        jDialog1.setModal(true);
        jDialog1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jDialog1WindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialog1WindowClosing(evt);
            }
        });
        jDialog1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Usuário:");
        jDialog1.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 40, -1, -1));

        jLabel2.setText("Senha:");
        jDialog1.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 78, -1, -1));
        jDialog1.getContentPane().add(jTextFieldUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 37, 146, -1));

        jButton2.setText("Logar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jDialog1.getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));
        jDialog1.getContentPane().add(jPasswordFieldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 75, 146, -1));

        jDialog2.setAlwaysOnTop(true);
        jDialog2.setMinimumSize(new java.awt.Dimension(221, 108));
        jDialog2.setModal(true);

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(82, 144, 180));

        jTextAreaSaida.setColumns(20);
        jTextAreaSaida.setRows(5);
        jScrollPane1.setViewportView(jTextAreaSaida);

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jMenu1.setText("Vendas");

        jMenuItem1.setText("Buscar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem15.setText("Incidentes");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem15);

        jMenuItem3.setText("Analise Vendas Pendentes");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem6.setText("Enviar Códigos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem2.setText("Cadastro Manual");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setText("Adicionar Código Manualmente");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Modificar Venda");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Clientes");

        jMenuItem8.setText("Cadastrar Manualmente");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem17.setText("Enviar Email Sobre Atualização");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem17);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Codigos");

        jMenuItem7.setText("Pesquisar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenu8.setText("Quantidade Usada Códigos");

        jMenuItem10.setText("Todos");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem10);

        jMenuItem11.setText("Por ID");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem11);

        jMenu2.add(jMenu8);

        jMenuItem9.setText("Quantidade de Uso Codigos");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Cadastrar");

        jMenuItem13.setText("JSon");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem13);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Produtos");

        jMenuItem12.setText("Visualizar Produtos");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuItem16.setText("Atualizar Lista Produtos");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem16);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        verificaFrameAberto(new InternalFrameVendas(), VariaveisDeControle.frameVendasAberto);
        VariaveisDeControle.frameVendasAberto = true;
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VariaveisDeControle.user = jTextFieldUser.getText().toUpperCase();
        VariaveisDeControle.senha = jPasswordFieldSenha.getText();
        VariaveisDeControle.CON = new ConnectionFactory().getConnection();// TODO add your handling code here:
        jDialog1.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                new CodigoDAO().updateQtdUsadaCodigo();
            }
        }).start();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new CodigoDAO().updateQtdUsadaCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do código:")));        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
//        QtdUsoCodigos dao = new QtdUsoCodigosDAO().getQtdUsada();
//        jTextFieldDiasKis1Ano.setText(dao.getDiasMaxKis1A() + "");
//        jTextFieldDiasSmall1Ano.setText(dao.getDiasMaxSmall1A() + "");
//        jTextFieldDiasSmall2Anos.setText(dao.getDiasMaxSmall2A() + "");;
//        jTextFieldDiasTotal1Ano.setText(dao.getDiasMaxTotal1A() + "");;
//        jTextFieldDiasTotal2Anos.setText(dao.getDiasMaxTotal2A() + "");;
//        jTextFieldDiasTotal3Anos.setText(dao.getDiasMaxTotal3A() + "");;
//        jTextFieldDispKis.setText(dao.getQtdMaxKis() + "");;
//        jTextFieldDispTotal.setText(dao.getQtdMaxTotal() + "");
//        jDialogGetQtdUsoCodigos.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        verificaFrameAberto(new InternalFrameAnaliseVendaPendentes(), VariaveisDeControle.frameAnaliseVendasAberto);
        VariaveisDeControle.frameAnaliseVendasAberto = true;
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (!VariaveisDeControle.codigosCarregadosListVen && !VariaveisDeControle.listaCarregando && VariaveisDeControle.listVen.isEmpty()) {
                    new InsereCodigoNasVendasParaEnvio().carregaListaVendasPendentes(true);
                    new InsereCodigoNasVendasParaEnvio().getCodigosUtilizaveis();
                    new EnviarCodigos().enviarCodigosDaLista();
                } else if (VariaveisDeControle.codigosCarregadosListVen) {
                    int i = JOptionPane.showConfirmDialog(null, "Deseja carregar novamente a lista?", "Confirmar", JOptionPane.YES_NO_OPTION);
                    if (i == 0) {
                        VariaveisDeControle.codigosCarregadosListVen = false;
                        VariaveisDeControle.listVen.clear();
                        VariaveisDeControle.jComboBoxModelDialogVendasPendentes.removeAllElements();
                        new InsereCodigoNasVendasParaEnvio().carregaListaVendasPendentes(true);
                        new InsereCodigoNasVendasParaEnvio().getCodigosUtilizaveis();
                        new EnviarCodigos().enviarCodigosDaLista();
                    } else {
                        new EnviarCodigos().enviarCodigosDaLista();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "As vendas estão sendo carregadas. Abra a analise de vendas para obter detahes.");
                }

            }
        }).start();


    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        verificaFrameAberto(new InternalCadastroVendaOutrosMeios(), VariaveisDeControle.frameCadVenOutroMeioAberto);
        VariaveisDeControle.frameCadVenOutroMeioAberto = true;
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        verificaFrameAberto(new InternalEnviosManuais(), VariaveisDeControle.frameEnvioManualAberto);
        VariaveisDeControle.frameEnvioManualAberto = true;
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        verificaFrameAberto(new InternalModificarVenda(), VariaveisDeControle.frameModificarVendaAberto);
        VariaveisDeControle.frameModificarVendaAberto = true;
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        verificaFrameAberto(new InternalFrameCodigos(), VariaveisDeControle.frameCodigosAberto);
        VariaveisDeControle.frameCodigosAberto = true;
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        verificaFrameAberto(new InternalJSon(), VariaveisDeControle.frameJsonAberto);
        VariaveisDeControle.frameJsonAberto = true;
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jDialog1WindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog1WindowClosed

    }//GEN-LAST:event_jDialog1WindowClosed

    private void jDialog1WindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog1WindowClosing
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jDialog1WindowClosing

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        verificaFrameAberto(new InternalCadastrarCliente(), VariaveisDeControle.frameCadastroClienteAberto);
        VariaveisDeControle.frameCadastroClienteAberto = true;
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        InternalProdutos i = new InternalProdutos();
        jDesktopPane1.add(i);
        i.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        InternalIncidentes inc = new InternalIncidentes();
        jDesktopPane1.add(inc);
        inc.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        VariaveisDeControle.atualizaMapProdutos();
        JOptionPane.showMessageDialog(null, "Produtos atualizados");// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
//        ArrayList<EmailNomeTipoproduto> set = new VendaDAO().getEmailVendasKisTotal();
//        System.out.println("Vai começar a enviar");
//        int count = 0;
//        for (EmailNomeTipoproduto t : set) {
//            try {
//                count ++;
//                String corpo = new MensagensEmail().atualizacaoPrograma(t.nome, t.tipo);
//                new EmailService(t.email, "Atualização do Kaspersky 2018", corpo).sendEmail(t.apelido);
//                System.err.println("================ ============= ========== " + count + "============================================");
//            } catch (IOException ex) {
//                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (MessagingException ex) {
//                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaSaida;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables

    public void dialogAutenticacao() {
        jDialog1.setVisible(true);
    }

    private void verificaFrameAberto(JInternalFrame ifr, boolean aberto) {
        if (!aberto) {
            jDesktopPane1.add(ifr);
            ifr.setVisible(true);// TODO add your handling code here:            
        }
    }
}
