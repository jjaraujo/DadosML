package Visao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.SequentialGroup;

public class InternalCadastrarCliente extends javax.swing.JInternalFrame
{
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
  
  public InternalCadastrarCliente()
  {
    initComponents();
  }


  private void initComponents()
  {
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
    setTitle("Cadastrar Cliente");
    addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
      public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {}
      
      public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {}
      
      public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
        InternalCadastrarCliente.this.formInternalFrameClosing(evt);
      }
      

      public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {}
      
      public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {}
      
      public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {}
      
      public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {}
    });
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
        InternalCadastrarCliente.this.jButton11ActionPerformed(evt);
      }
      
    });
    GroupLayout jPanelCadastraVenda_cadastroClienteLayout = new GroupLayout(jPanelCadastraVenda_cadastroCliente);
    jPanelCadastraVenda_cadastroCliente.setLayout(jPanelCadastraVenda_cadastroClienteLayout);
    jPanelCadastraVenda_cadastroClienteLayout.setHorizontalGroup(jPanelCadastraVenda_cadastroClienteLayout
      .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelCadastraVenda_cadastroClienteLayout.createSequentialGroup()
      .addGroup(jPanelCadastraVenda_cadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelCadastraVenda_cadastroClienteLayout.createSequentialGroup()
      .addGap(17, 17, 17)
      .addComponent(jLabel28)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jTextFieldCadastroApelido, -1, 158, 32767))
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
      .addComponent(jTextFieldCadastroNome, -2, 160, -2)
      .addGap(10, 10, 10)
      .addComponent(jLabel27)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
      .addComponent(jTextFieldCadastroEmail, -2, 200, -2))
      .addGroup(jPanelCadastraVenda_cadastroClienteLayout.createSequentialGroup()
      .addComponent(jCheckBoxTelefoneConfirmado)
      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
      .addComponent(jCheckBoxRevendedorAssistencia)
      .addGap(41, 41, 41)
      .addComponent(jButton11)))
      .addContainerGap()));
    
    jPanelCadastraVenda_cadastroClienteLayout.setVerticalGroup(jPanelCadastraVenda_cadastroClienteLayout
      .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelCadastraVenda_cadastroClienteLayout.createSequentialGroup()
      .addContainerGap()
      .addGroup(jPanelCadastraVenda_cadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
      .addComponent(jLabel1)
      .addComponent(jTextFieldCadastroNome, -2, -1, -2)
      .addComponent(jLabel27)
      .addComponent(jTextFieldCadastroEmail, -2, -1, -2)
      .addComponent(jLabel28)
      .addComponent(jTextFieldCadastroApelido, -2, -1, -2))
      .addGap(18, 18, 18)
      .addGroup(jPanelCadastraVenda_cadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
      .addComponent(jLabel29)
      .addComponent(jTextFieldCadastroTelefone, -2, -1, -2)
      .addComponent(jCheckBoxTelefoneConfirmado)
      .addComponent(jCheckBoxRevendedorAssistencia)
      .addComponent(jButton11))
      .addContainerGap(-1, 32767)));
    

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
      .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
      .addContainerGap(-1, 32767)
      .addComponent(jPanelCadastraVenda_cadastroCliente, -2, -1, -2)
      .addContainerGap()));
    
    layout.setVerticalGroup(layout
      .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
      .addContainerGap()
      .addComponent(jPanelCadastraVenda_cadastroCliente, -2, -1, -2)
      .addContainerGap(-1, 32767)));
    

    pack();
  }
  
  private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
    Entidades.Cliente cl = new Entidades.Cliente();
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
    new DAO.ClienteDAO().insertCliente(cl);
  }
  
  private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
    Controle.VariaveisDeControle.frameCadastroClienteAberto = false;
  }
}
