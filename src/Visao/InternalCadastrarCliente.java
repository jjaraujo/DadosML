/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.VariaveisDeControle;
import DAO.ClienteDAO;
import Entidades.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao
 */
public class InternalCadastrarCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form InternalCadastrarCliente
     */
    public InternalCadastrarCliente() {
        VariaveisDeControle.frameCadastroCliente = true;
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

        jPanelCadastraVenda_cadastroCliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCadastroNome = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextFieldCadastroEmail = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTextFieldCadastroApelido = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextFieldCadastroTelefone = new javax.swing.JTextField();
        jCheckBoxTelefoneConfirmado = new javax.swing.JCheckBox();
        jCheckBoxRevendedorAssistencia = new javax.swing.JCheckBox();
        jButton11 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanelCadastraVenda_cadastroCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar Cliente"));

        jLabel1.setText("Nome:");

        jLabel27.setText("Email:");

        jLabel28.setText("Apelido:");

        jLabel29.setText("Telefone:");

        jCheckBoxTelefoneConfirmado.setText("Telefone confirmado");

        jCheckBoxRevendedorAssistencia.setText("Revendedor Assitência");

        jButton11.setText("Cadastrar Cliente");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCadastraVenda_cadastroClienteLayout = new javax.swing.GroupLayout(jPanelCadastraVenda_cadastroCliente);
        jPanelCadastraVenda_cadastroCliente.setLayout(jPanelCadastraVenda_cadastroClienteLayout);
        jPanelCadastraVenda_cadastroClienteLayout.setHorizontalGroup(
            jPanelCadastraVenda_cadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastraVenda_cadastroClienteLayout.createSequentialGroup()
                .addGroup(jPanelCadastraVenda_cadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCadastraVenda_cadastroClienteLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCadastroApelido, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                    .addGroup(jPanelCadastraVenda_cadastroClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCadastroTelefone)))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastraVenda_cadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCadastraVenda_cadastroClienteLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCadastroNome, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCadastroEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCadastraVenda_cadastroClienteLayout.createSequentialGroup()
                        .addComponent(jCheckBoxTelefoneConfirmado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxRevendedorAssistencia)
                        .addGap(41, 41, 41)
                        .addComponent(jButton11)))
                .addContainerGap())
        );
        jPanelCadastraVenda_cadastroClienteLayout.setVerticalGroup(
            jPanelCadastraVenda_cadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastraVenda_cadastroClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastraVenda_cadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldCadastroNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jTextFieldCadastroEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jTextFieldCadastroApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastraVenda_cadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jTextFieldCadastroTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxTelefoneConfirmado)
                    .addComponent(jCheckBoxRevendedorAssistencia)
                    .addComponent(jButton11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelCadastraVenda_cadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCadastraVenda_cadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        Cliente cl = new Cliente();
        cl.setApelido(jTextFieldCadastroApelido.getText());
        cl.setNome(jTextFieldCadastroNome.getText());
        cl.setEmail(jTextFieldCadastroEmail.getText());
        cl.setTelefone(jTextFieldCadastroTelefone.getText());
        if (jCheckBoxRevendedorAssistencia.isSelected()) {
            cl.setRevendedor_assitencia("SIM");
        }
        if (jCheckBoxTelefoneConfirmado.isSelected()) {
            cl.setConfirmado("SIM");
        }
        new ClienteDAO().cadastrarCliente(cl);
        JOptionPane.showMessageDialog(null, "Cliente cadastrado");    // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton11;
    private javax.swing.JCheckBox jCheckBoxRevendedorAssistencia;
    private javax.swing.JCheckBox jCheckBoxTelefoneConfirmado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanelCadastraVenda_cadastroCliente;
    private javax.swing.JTextField jTextFieldCadastroApelido;
    private javax.swing.JTextField jTextFieldCadastroEmail;
    private javax.swing.JTextField jTextFieldCadastroNome;
    private javax.swing.JTextField jTextFieldCadastroTelefone;
    // End of variables declaration//GEN-END:variables
}
