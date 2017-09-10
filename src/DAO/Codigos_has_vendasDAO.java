/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controle.VariaveisDeControle;
import Entidades.Codigos;
import Entidades.codigos_has_vendas;
import Visao.Principal;
import com.mysql.jdbc.exceptions.MySQLNonTransientConnectionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Codigos_has_vendasDAO {

    private Connection con;

    public Codigos_has_vendasDAO() {
        con = VariaveisDeControle.CON;
    }

    public codigos_has_vendas getUmaVenda(String id, int idCod) {
        try {
            PreparedStatement stmt;
            ResultSet rs;
            codigos_has_vendas cod = new codigos_has_vendas();
            stmt = con.prepareStatement("select * from codigos_has_vendas where id_venda like '" + id + "' and id_codigo = " + idCod + ";");
            rs = stmt.executeQuery();
            while (rs.next()) {
                cod = new codigos_has_vendas();
                cod.setIdVenda(rs.getString("id_venda"));
                cod.setId_codigo(rs.getInt("id_codigo"));
                cod.setQtd(rs.getInt("qtd_dispositivos"));
                cod.setCodigos_antigos(rs.getString("codigos_antigos"));
                rs.close();
                stmt.close();
            }
            return cod;
        } catch (MySQLNonTransientConnectionException e) {
            new Principal().dialogAutenticacao();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<codigos_has_vendas> getTodasAsVendas() {
        try {
            ArrayList<codigos_has_vendas> listCod = new ArrayList<>();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = con.prepareStatement("select * from codigos_has_vendas;");
            rs = stmt.executeQuery();
            while (rs.next()) {
                codigos_has_vendas cod = new codigos_has_vendas();
                cod.setIdVenda(rs.getString("id_venda"));
                cod.setId_codigo(rs.getInt("id_codigo"));
                cod.setQtd(rs.getInt("qtd_dispositivos"));
                cod.setCodigos_antigos(rs.getString("codigos_antigos"));
                listCod.add(cod);
            }
            rs.close();
            stmt.close();
            return listCod;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<codigos_has_vendas> getCodigoHasVendas(String idVenda) {
        ArrayList<codigos_has_vendas> listCod = new ArrayList<>();
        try {
            PreparedStatement stmt;
            ResultSet rs;
            stmt = con.prepareStatement("select * from codigos_has_vendas where id_venda like ?;");
            stmt.setString(1, idVenda);
            rs = stmt.executeQuery();
            while (rs.next()) {
                codigos_has_vendas cod = new codigos_has_vendas();
                cod.setIdVenda(rs.getString("id_venda"));
                cod.setId_codigo(rs.getInt("id_codigo"));
                cod.setQtd(rs.getInt("qtd_dispositivos"));
                cod.setQtd_servidor(rs.getInt("qtd_servidor"));
                cod.setCodigos_antigos(rs.getString("codigos_antigos"));
                listCod.add(cod);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(Codigos_has_vendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listCod;
    }

    public ArrayList<Codigos> getCodigosJaEnviadosParaOCliente(String apelido) {
        ArrayList<Codigos> set = new ArrayList<>();
        Codigos c = new Codigos();
        try {
            PreparedStatement stmt;
            ResultSet rs;
            stmt = con.prepareStatement("select cd.id id, cd.codigo codigo from codigos_has_vendas chv join vendas v on"
                    + " v.id = chv.id_venda join codigos cd on chv.id_codigo = cd.id where apelido_comprador like ?");
            stmt.setString(1, apelido);
            rs = stmt.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setCodigo(rs.getString("codigo"));
                set.add(c);
            }
            return set;
        } catch (SQLException ex) {
            Logger.getLogger(Codigos_has_vendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean insertCodigoEmVenda(codigos_has_vendas chv) {
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement("insert into codigos_has_vendas (id_venda,id_codigo,qtd_dispositivos,qtd_servidor) values (?,?,?,?) ;");
            stmt.setString(1, chv.getIdVenda());
            System.out.println(chv.getIdVenda());
            stmt.setInt(2, chv.getId_codigo());
            System.out.println(chv.getId_codigo());
            stmt.setInt(3, chv.getQtd());
            stmt.setInt(4, chv.getQtd_servidor());
            stmt.executeUpdate();
            new CodigoDAO().setQtdUsadaCodigo(chv.getId_codigo(), chv.getQtd());
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Por algum erro na conexão, a venda " + chv.getIdVenda() + " não foi gravada");
            System.err.println("Por algum erro na conexão, a venda " + chv.getIdVenda() + " não foi gravada \n");
            ex.printStackTrace();
        }

        return false;
    }

    public void deteleCodigoHasVendas(String idVenda, int idCodigo) {
        try {
            PreparedStatement stmt = con.prepareCall("delete from codigos_has_vendas where id_venda = ? and id_codigo = ?;");
            stmt.setString(1, idVenda);
            stmt.setInt(2, idCodigo);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Codigos_has_vendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCodigoHasVendas(codigos_has_vendas chv) {
        try {
            PreparedStatement stmt = con.prepareCall(""
                    + "update codigos_has_vendas set qtd_dispositivos = ?,qtd_servidor = ? where id_venda like ? and id_codigo = ?;");
            stmt.setInt(1, chv.getQtd());
            stmt.setInt(2, chv.getQtd_servidor());
            stmt.setString(3, chv.getIdVenda());
            stmt.setInt(4, chv.getId_codigo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Codigos_has_vendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCodigoAntigos(codigos_has_vendas chv, String codigo) {
        try {
            PreparedStatement stmt = con.prepareCall(""
                    + "update codigos_has_vendas set codigos_antigos = concat(codigos_antigos,?) where id_venda like ?;");
            stmt.setString(1, codigo + ";");
            stmt.setString(2, chv.getIdVenda());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Codigos_has_vendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
