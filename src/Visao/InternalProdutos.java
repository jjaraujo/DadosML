/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import DAO.ProdutosDAO;
import Entidades.Produtos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joao
 */
public class InternalProdutos extends javax.swing.JInternalFrame {

    private final DefaultTableModel modelo;

    /**
     * Creates new form InternalProdutos
     */
    public InternalProdutos() {
    modelo = new DefaultTableModel(null, new String[]{"ID", "Tipo", "Quantidade",
                "Duracao", "Preço"}) {
                @Override
                public boolean isCellEditable(int i, int i1) {
                    return false;//To change body of generated methods, choose Tools | Templates.
                }
            };
        ArrayList<Produtos> list = new ProdutosDAO().getProdutosList();
        list.forEach(p ->{
            modelo.addRow(new Object[]{p.getId(),p.getTipo(),p.getQtd(),p.getAnos(),p.getValor()});
        });
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
        jTableVendas = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);

        jTableVendas.setModel(modelo);
        jTableVendas.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTableVendas);
        jTableVendas.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTableVendas.getColumnModel().getColumn(1).setPreferredWidth(140);
        jTableVendas.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableVendas.getColumnModel().getColumn(3).setPreferredWidth(230);
        jTableVendas.getColumnModel().getColumn(4).setPreferredWidth(260);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVendas;
    // End of variables declaration//GEN-END:variables
}
