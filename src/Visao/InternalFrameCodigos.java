/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import DAO.AtendentesDAO;
import DAO.CodigoDAO;
import DAO.DesbloqueioDAO;
import Entidades.Atendentes;
import Entidades.Codigos;
import Entidades.Desbloqueios;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joao
 */
public class InternalFrameCodigos extends javax.swing.JInternalFrame {

    private String situacao;
    private String tipo;    
    DefaultTableModel modelo1;
    DefaultTableModel modelo2 = new DefaultTableModel();
    private String local;
    private int idCodigo;
    private String dataDesbloqueio;
    private String hora;
    private int qtd_usada;
    private ArrayList<Atendentes> listAtendentes = new ArrayList<>();


    /**
     * Creates new form InternalFrameCodigos
     */
    public InternalFrameCodigos() {
        modelo1 = new DefaultTableModel(null, new String[]{"Id", "Codigo", "Pedido", "Data Compra", "Data Expiração", "Qtd Usada",
            "Tipo", "Dispositivos", "Anos", "Nome", "Email", "Suspeito de revenda", "Senha MyKaspersky"}) {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
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

        buttonGroupSituacaoCodigo = new javax.swing.ButtonGroup();
        buttonGroupDiaDesbloqueio = new javax.swing.ButtonGroup();
        buttonGroupLocalDesbloquei = new javax.swing.ButtonGroup();
        jDialogsetDesbloqueio = new javax.swing.JDialog();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel15 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButton16 = new javax.swing.JRadioButton();
        jRadioButton17 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jRadioButton18 = new javax.swing.JRadioButton();
        jDialogGetDesbloqueios = new javax.swing.JDialog();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jPanelCodigos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jTextFieldEntradaCodigo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jRadioButton11 = new javax.swing.JRadioButton();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jComboBoxAnos = new javax.swing.JComboBox<>();
        jRadioButton12 = new javax.swing.JRadioButton();
        jButton6 = new javax.swing.JButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        jDialogsetDesbloqueio.setMinimumSize(new java.awt.Dimension(700, 500));
        jDialogsetDesbloqueio.setModal(true);

        jRadioButton14.setText("Hoje");
        jRadioButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton14ActionPerformed(evt);
            }
        });

        jRadioButton15.setText("Outro dia");
        jRadioButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton15ActionPerformed(evt);
            }
        });

        try{
            listAtendentes = new AtendentesDAO().retornaAtendentes();
            jList1.setModel(new javax.swing.AbstractListModel<String>() {

                public int getSize() { return listAtendentes.size();
                }
                public String getElementAt(int i) { return (listAtendentes.get(i).getNome()+ " ----- Pais: " + listAtendentes.get(i).getPais()); }
            });
        }catch(Exception e){

        }
        jScrollPane4.setViewportView(jList1);

        jLabel15.setText("Atendentes");

        jButton9.setText("SALVAR");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        jRadioButton16.setText("Por ligação");
        jRadioButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton16ActionPerformed(evt);
            }
        });

        jRadioButton17.setText("Pelo MyKaspersky");
        jRadioButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton17ActionPerformed(evt);
            }
        });

        jLabel16.setText("Motivo:");

        jLabel17.setText("Resolvido:");

        jRadioButton18.setText("Pelo Chat");
        jRadioButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogsetDesbloqueioLayout = new javax.swing.GroupLayout(jDialogsetDesbloqueio.getContentPane());
        jDialogsetDesbloqueio.getContentPane().setLayout(jDialogsetDesbloqueioLayout);
        jDialogsetDesbloqueioLayout.setHorizontalGroup(
            jDialogsetDesbloqueioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogsetDesbloqueioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogsetDesbloqueioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogsetDesbloqueioLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDialogsetDesbloqueioLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jDialogsetDesbloqueioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogsetDesbloqueioLayout.createSequentialGroup()
                                .addGroup(jDialogsetDesbloqueioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialogsetDesbloqueioLayout.createSequentialGroup()
                                        .addGroup(jDialogsetDesbloqueioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButton16)
                                            .addComponent(jRadioButton14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jDialogsetDesbloqueioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jDialogsetDesbloqueioLayout.createSequentialGroup()
                                                .addComponent(jRadioButton17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jRadioButton18))
                                            .addComponent(jRadioButton15))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialogsetDesbloqueioLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jDialogsetDesbloqueioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jDialogsetDesbloqueioLayout.createSequentialGroup()
                                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jTextField1))))
                                .addGap(26, 26, 26))
                            .addGroup(jDialogsetDesbloqueioLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jDialogsetDesbloqueioLayout.setVerticalGroup(
            jDialogsetDesbloqueioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogsetDesbloqueioLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel15)
                .addGroup(jDialogsetDesbloqueioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogsetDesbloqueioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4)
                        .addGap(45, 45, 45))
                    .addGroup(jDialogsetDesbloqueioLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jDialogsetDesbloqueioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton16)
                            .addComponent(jRadioButton17)
                            .addComponent(jRadioButton18))
                        .addGap(18, 18, 18)
                        .addGroup(jDialogsetDesbloqueioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton14)
                            .addComponent(jRadioButton15))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jDialogsetDesbloqueioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9)
                        .addGap(0, 23, Short.MAX_VALUE))))
        );

        jDialogGetDesbloqueios.setMinimumSize(new java.awt.Dimension(900, 500));
        jDialogGetDesbloqueios.setModal(true);

        jScrollPane6.setMinimumSize(new java.awt.Dimension(900, 500));

        jTable3.setModel(modelo2);
        jTable3.setMinimumSize(new java.awt.Dimension(900, 500));
        modelo2.addColumn("Atendente");
        modelo2.addColumn("Qtd_usada");
        modelo2.addColumn("Data");
        modelo2.addColumn("Hora");
        modelo2.addColumn("Local");
        modelo2.addColumn("Motivo");
        modelo2.addColumn("Pais");
        modelo2.addColumn("Resolvido");
        jTable3.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTable3.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable3.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTable3.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTable3.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTable3.getColumnModel().getColumn(5).setPreferredWidth(180);
        jTable3.getColumnModel().getColumn(6).setPreferredWidth(80);
        jTable3.getColumnModel().getColumn(7).setPreferredWidth(80);
        jScrollPane6.setViewportView(jTable3);

        javax.swing.GroupLayout jDialogGetDesbloqueiosLayout = new javax.swing.GroupLayout(jDialogGetDesbloqueios.getContentPane());
        jDialogGetDesbloqueios.getContentPane().setLayout(jDialogGetDesbloqueiosLayout);
        jDialogGetDesbloqueiosLayout.setHorizontalGroup(
            jDialogGetDesbloqueiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogGetDesbloqueiosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDialogGetDesbloqueiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        jDialogGetDesbloqueiosLayout.setVerticalGroup(
            jDialogGetDesbloqueiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogGetDesbloqueiosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jTable1.setModel(modelo1);
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(jTable1);
        jTable1.setCellSelectionEnabled(true);

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(180);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(130);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(12).setPreferredWidth(70);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa por código"));

        jButton5.setText("Pesquisar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel14.setText("Código:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldEntradaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jTextFieldEntradaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap())
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa por tipo de código"));

        buttonGroupSituacaoCodigo.add(jRadioButton11);
        jRadioButton11.setText("Utilizando");
        jRadioButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton11ActionPerformed(evt);
            }
        });

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KIS", "TOTAL", "SMALL" }));

        jComboBoxAnos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 ano", "2 anos", "3 anos" }));
        jComboBoxAnos.setSelectedItem("Ano");
        jComboBoxAnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAnosActionPerformed(evt);
            }
        });

        buttonGroupSituacaoCodigo.add(jRadioButton12);
        jRadioButton12.setText("Outra situacao");
        jRadioButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton12ActionPerformed(evt);
            }
        });

        jButton6.setText("Pesquisar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        buttonGroupSituacaoCodigo.add(jRadioButton13);
        jRadioButton13.setText("Todos");
        jRadioButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxAnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton11)
                    .addComponent(jComboBoxAnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton12)
                    .addComponent(jButton6)
                    .addComponent(jRadioButton13))
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Desbloqueio do código"));

        jButton7.setText("Registrar Desbloqueio");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Ver desbloqueios");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelCodigosLayout = new javax.swing.GroupLayout(jPanelCodigos);
        jPanelCodigos.setLayout(jPanelCodigosLayout);
        jPanelCodigosLayout.setHorizontalGroup(
            jPanelCodigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCodigosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCodigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCodigosLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(jPanelCodigosLayout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );
        jPanelCodigosLayout.setVerticalGroup(
            jPanelCodigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCodigosLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanelCodigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1259, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelCodigos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelCodigos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(12, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        pesquisarTodosCodigos(modelo1);
        // TODO add your handling code here
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jRadioButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton11ActionPerformed
        situacao = "and situacao = 'utilizando'";        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton11ActionPerformed

    private void jComboBoxAnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAnosActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxAnosActionPerformed

    private void jRadioButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton12ActionPerformed
        situacao = " and situacao != 'utilizando' ";
    }//GEN-LAST:event_jRadioButton12ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            pesquisarTodosCodigosPorTipo(modelo1);        // TODO add your handling code here:
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCodigos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jRadioButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton13ActionPerformed
        situacao = "";        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton13ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (idCodigo == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum código foi pesquisado ainda");
        } else {
            jDialogsetDesbloqueio.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            if (tipo == null) {
                JOptionPane.showMessageDialog(null, "Faça uma pesquisa de código");
            } else {
                pesquisarDesbloqueios(modelo2);
                jDialogGetDesbloqueios.setVisible(true);
            }// TODO add your handling code here:
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCodigos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaCodigos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jRadioButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton14ActionPerformed
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        dataDesbloqueio = formatarDate.format(data);
        Time time = new Time(System.currentTimeMillis());
        hora = time + "";

        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton14ActionPerformed

    private void jRadioButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton15ActionPerformed
        dataDesbloqueio = JOptionPane.showInputDialog("Qual dia? 'AAAA-MM-DD'");
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton15ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Desbloqueios des = new Desbloqueios();
        des.setId_atendente(listAtendentes.get(jList1.getSelectedIndex()).getId());
        des.setId_codigo(idCodigo);
        des.setQtd_usada(qtd_usada);
        des.setData(dataDesbloqueio);
        des.setHora(hora);
        des.setLocal(local);
        des.setPais(listAtendentes.get(jList1.getSelectedIndex()).getPais());
        des.setMotivo(jTextArea1.getText());
        des.setResolvido(jTextField1.getText().toUpperCase());
        try {
            new DesbloqueioDAO().setDesbloqueio(des);
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
            idCodigo = 0;
            jDialogsetDesbloqueio.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCodigos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jRadioButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton16ActionPerformed
        local = "CALL";        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton16ActionPerformed

    private void jRadioButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton17ActionPerformed
        local = "MYKAS";        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton17ActionPerformed

    private void jRadioButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton18ActionPerformed
        local = "Chat";        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton18ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupDiaDesbloqueio;
    private javax.swing.ButtonGroup buttonGroupLocalDesbloquei;
    private javax.swing.ButtonGroup buttonGroupSituacaoCodigo;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBoxAnos;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JDialog jDialogGetDesbloqueios;
    private javax.swing.JDialog jDialogsetDesbloqueio;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanelCodigos;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldEntradaCodigo;
    // End of variables declaration//GEN-END:variables
public void pesquisarTodosCodigos(DefaultTableModel modelo) {
        modelo.setNumRows(0);
        CodigoDAO dao = new CodigoDAO();
        String entrada = jTextFieldEntradaCodigo.getText().replaceAll("^\\s+", "");
        entrada = entrada.replaceAll("\\s+$", "");
        Codigos c = dao.getCodigosPorCodigo(entrada);
        modelo.addRow(new Object[]{c.getId(), c.getCodigo(), c.getPedido(), c.getData_compra(), c.getData_expiracao(),
            c.getQtd_usada(), c.getTipo(), c.getDispositivos(), c.getDuracao(), c.getNome(),
            c.getEmail(), c.getSuspeito(), c.getSenha_mykaspersky()});
        idCodigo = c.getId();
        qtd_usada = c.getQtd_usada();
        tipo = c.getTipo();
    }

public void pesquisarTodosCodigosPorTipo(DefaultTableModel modelo) throws ClassNotFoundException {
        modelo.setNumRows(0);
        CodigoDAO dao = new CodigoDAO();
        ArrayList list = dao.buscaTodosOsCodigos(jComboBoxTipo.getSelectedItem().toString(), situacao, jComboBoxAnos.getSelectedIndex() + 1);
        ArrayList<Codigos> list2 = list;
        for (Codigos c : list2) {
            modelo.addRow(new Object[]{c.getId(), c.getCodigo(), c.getPedido(), c.getData_compra(), c.getData_expiracao(),
                c.getQtd_usada(), c.getTipo(), c.getDispositivos(), c.getDuracao(), c.getNome(),
                c.getEmail(), c.getSuspeito(), c.getSenha_mykaspersky()});
            idCodigo = c.getId();
            qtd_usada = c.getQtd_usada();
            tipo = c.getTipo();
        }
    }

    public void pesquisarDesbloqueios(DefaultTableModel modelo) throws ClassNotFoundException, SQLException {
        modelo.setNumRows(0);
        DesbloqueioDAO dao = new DesbloqueioDAO();
        ArrayList<Desbloqueios> list = (ArrayList) dao.getDesbloqueiosPorId(idCodigo);
        list.forEach((d) -> {
            modelo.addRow(new Object[]{d.getId_atendente(),
                d.getQtd_usada(), d.getData(), d.getHora(),
                d.getLocal(), d.getMotivo(), d.getPais(), d.getResolvido()});
        });
        setMensagemPorTipo();
    }
    public void setMensagemPorTipo() {
        String qtdMaxima = null;
        if (tipo.equals("TOTAL")) {
            qtdMaxima = "2 desbloqueios";
        }
        if (tipo.equals("KIS")) {
            qtdMaxima = "2 desbloqueios";
        }
        jLabel26.setText("O código deve ter no máximo " + qtdMaxima + " em até um mês da compra, com o resolvido 'SIM'. Caso não tenha passado um mês e ele está excedido, me avisa");
    }
}
