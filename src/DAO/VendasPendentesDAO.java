/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controle.VariaveisDeControle;
import Entidades.Vendas;
import Entidades.VendasPendentes;
import Entidades.codigos_has_vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author HP
 */
public class VendasPendentesDAO {
    
    private Connection con;
    private JTextArea textArea = VariaveisDeControle.textArea;
    
    public VendasPendentesDAO() {
        con = VariaveisDeControle.CON;
    }
    
    public void insereVendas(VendasPendentes ven) {
        
        try {
            PreparedStatement stmt = con.prepareStatement("insert into vendas_pendentes(id_venda,apelido_comprador,qtd,"
                    + "id_produto,email,forma_pagamento) values(?,?,?,?,?,?);");
            stmt.setString(1, ven.getId_venda());
            stmt.setString(2, ven.getApelido());
            stmt.setInt(3, ven.getQtd());
            stmt.setString(4, ven.getIdProduto());
            stmt.setString(5, ven.getEmail());
            stmt.setString(6, ven.getPagamento());
            stmt.executeUpdate();
            System.out.println("Venda: " + ven.getId_venda() + " adicionada como pendente");
            textArea.setText(textArea.getText() + "Venda: " + ven.getId_venda() + " adicionada como pendente\n" );
        } catch (SQLException e1) {
            
            System.err.println(ven.getId_venda() + ": Erro na transação de DAO.VendasPendentesDAO().insereVendas: " + e1);
        }
    }
    
    public boolean marcaComoPendente(String id, String observacoes) {
        try {
            PreparedStatement stmt = con.prepareStatement("update vendas_pendentes set pendente = 'sim',observacao = ? where id_venda like ?;");
            stmt.setString(1, observacoes);
            stmt.setString(2, "%" + id + "%");
            stmt.executeUpdate();
            return true;
        } catch (SQLException e1) {
            System.err.println("Erro na transação de DAO.VendasPendentesDAO().marcaComoPendente: " + e1);
            return false;
        }
    }
    
    public void marcaComoVerificada(String id) {
        try {
            PreparedStatement stmt = con.prepareStatement("update vendas_pendentes set pendente = null,verificada = 'sim' where id_venda like ?;");
            stmt.setString(1, "%" + id + "%");
            stmt.executeUpdate();
        } catch (SQLException e1) {
            System.err.println("Erro na transação de DAO.VendasPendentesDAO().marcaComoVerificada: " + e1);
        }
    }
    
    public ArrayList<VendasPendentes> retornaVendasPendentes() {
        VendasPendentes vendasPen;
        ArrayList<VendasPendentes> list = new ArrayList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("select * from vendas_pendentes order by id_venda ASC;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                vendasPen = new VendasPendentes();
                vendasPen.setId_venda(rs.getString("id_venda"));
                vendasPen.setApelido(rs.getString("apelido_comprador"));
                vendasPen.setQtd(rs.getInt("qtd"));
                vendasPen.setIdProduto(rs.getString("id_produto"));
                vendasPen.setEmail(rs.getString("email"));
                vendasPen.setPagamento(rs.getString("forma_pagamento"));
                vendasPen.setPendente(rs.getString("pendente"));
                vendasPen.setVerificada(rs.getString("verificada"));
                vendasPen.setObservacoes(rs.getString("observacao"));
                VariaveisDeControle.mapProd.get(vendasPen.getIdProduto()).getNomeProdutoQtdTotal(vendasPen.getQtd());//colocando aqui, o nome do produto é coletado após o incremento d0 idProduto
                list.add(vendasPen);
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro em DAO.VendasPendesntesDAO().retornaVendasPendentes: " + ex.getMessage());
            
            return null;
        }
    }
    
    public void remove(String id) {
        try {
            PreparedStatement stmt = con.prepareStatement("delete from vendas_pendentes where id_venda = ?;");
            stmt.setString(1, id);
            System.out.println("Id venda no remove: " + stmt.toString());
            stmt.executeUpdate();
        } catch (SQLException e1) {
            System.err.println("Erro na transação de DAO.VendasPendentesDAO().remove: " + e1);
        }
    }
    
    public boolean verificaSeAVendaPodeSerAdicionada(String id) {
        boolean contem = false;
        try {
            ArrayList<codigos_has_vendas> chv = new Codigos_has_vendasDAO().getCodigoHasVendas(id);
            Vendas v = new VendaDAO().getUmaVenda(id);
            if (chv.isEmpty() && (v.getCancelada() == null || v.getCancelada().equals(""))) {
                PreparedStatement stmt2 = con.prepareStatement("select id_venda from vendas_pendentes where id_venda like ?");
                stmt2.setString(1, id);
                ResultSet rs2 = stmt2.executeQuery();
                if (!rs2.next()) {
                    contem = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasPendentesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contem;
    }
}
