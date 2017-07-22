/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controle.VariaveisDeControle;
import Entidades.Incidentes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Joao
 */
public class IncidentesDAO {

    public void addIncidente(Incidentes inc) {
        try {
            PreparedStatement stmt = VariaveisDeControle.CON.prepareStatement("insert into incidentes values (?,?,?,?,?,?,?,?); ");
            stmt.setString(1, inc.getId());
            stmt.setString(2, inc.getId_venda());
            stmt.setInt(3, inc.getId_codigo());
            stmt.setString(4, inc.getDataIncidente());
            stmt.setInt(5, inc.getMotivo());
            stmt.setString(6, "ABERTO");
            stmt.setString(7, inc.getAnotacoes());
            stmt.setString(8, null);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Não foi possível adiicionar o incidente");
            ex.printStackTrace();
        }
    }

    public ArrayList<Incidentes> getIncidentes() {
        try {
            ArrayList<Incidentes> list = new ArrayList<>();
            PreparedStatement stmt = VariaveisDeControle.CON.prepareStatement("select i.id id, i.id_venda id_venda, i.id_codigo id_codigo,"
                    + "v.apelido_comprador apelido,c.codigo codigo,v.data data_compra,"
                    + " i.data_criacao data_criacao, mi.motivo_texto motivo_texto, i.situacao situacao, i.anotacoes anotacoes"
                    + " from incidentes i join motivo_incidentes mi on i.motivo = mi.id "
                    + " join vendas v on i.id_venda = v.id join codigos c on i.id_codigo = c.id"
                    + " where i.situacao = 'ABERTO'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Incidentes inc = new Incidentes();
                inc.setId(rs.getString("id"));
                inc.setApelido(rs.getString("apelido"));
                inc.setCodigo(rs.getString("codigo"));
                inc.setId_venda(rs.getString("id_venda"));
                inc.setId_codigo(rs.getInt("id_codigo"));
                inc.setDataIncidente(rs.getString("data_criacao"));
                inc.setData_compra(rs.getString("data_compra"));
                inc.setMotivoTexto(rs.getString("motivo_texto"));
                inc.setSituacao(rs.getString("situacao"));
                inc.setAnotacoes(rs.getString("anotacoes"));
                list.add(inc);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(IncidentesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<Incidentes> getIncidentesPorIdCodigo(int idCodigo) {
        try {
            ArrayList<Incidentes> list = new ArrayList<>();
            PreparedStatement stmt = VariaveisDeControle.CON.prepareStatement("select * from incidentes i join motivo_incidentes mi on i.motivo = mi.id where situacao = 'ABERTO' and id_codigo = ?");
            stmt.setInt(1, idCodigo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Incidentes inc = new Incidentes();
                inc.setId(rs.getString("id"));
                inc.setId_venda(rs.getString("id_venda"));
                inc.setId_codigo(rs.getInt("id_codigo"));
                inc.setDataIncidente(rs.getString("data_criacao"));
                inc.setMotivoTexto(rs.getString("motivo_texto"));
                inc.setSituacao(rs.getString("situacao"));
                inc.setAnotacoes(rs.getString("anotacoes"));
                list.add(inc);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(IncidentesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Incidentes getIncidente(String id) {
        try {
            PreparedStatement stmt = VariaveisDeControle.CON.prepareStatement("select * from incidentes where id = ?;");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            Incidentes inc = new Incidentes();
            while (rs.next()) {
                inc.setId(rs.getString("id"));
                inc.setId_venda(rs.getString("id_venda"));
                inc.setId_codigo(rs.getInt("id_codigo"));
                inc.setDataIncidente(rs.getString("data_criacao"));
                inc.setMotivo(rs.getInt("motivo"));
                inc.setSituacao(rs.getString("situacao"));
                inc.setAnotacoes(rs.getString("anotacoes"));
            }
            return inc;
        } catch (SQLException ex) {
            Logger.getLogger(IncidentesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int getCountIncidentes() {
        try {
            PreparedStatement stmt = VariaveisDeControle.CON.prepareStatement("select count(id) count from incidentes");
            ResultSet rs = stmt.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt("count");
            }
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(IncidentesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int getCountIncidentesAbertos() {
        try {
            PreparedStatement stmt = VariaveisDeControle.CON.prepareStatement("select count(id) count from incidentes where situacao ='ABERTO' ");
            ResultSet rs = stmt.executeQuery();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt("count");
            }
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(IncidentesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public void encerrarIncidente(String id) {
        try {

            PreparedStatement stmt = VariaveisDeControle.CON.prepareStatement("update incidentes set situacao = 'FECHADO', data_encerramento = ? where id = ?; ");
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
            stmt.setString(2, id);
            stmt.setString(1, formatarDate.format(date));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Não foi possível encerrar o incidente");
            ex.printStackTrace();
        }
    }

    public void encerrarIncidentePorIdCodigo(int idCodigo) {
        try{
                PreparedStatement stmt = VariaveisDeControle.CON.prepareStatement("update incidentes set situacao = 'FECHADO', data_encerramento = ? where id_codigo = ? and situacao = 'ABERTO'; ");
                Date date = new Date(System.currentTimeMillis());
                SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
                stmt.setInt(2, idCodigo);
                stmt.setString(1, formatarDate.format(date));
                stmt.executeUpdate();
            } catch (SQLException ex) {
                System.err.println("Não foi possível encerrar os incidentes do codigo " + idCodigo);
                ex.printStackTrace();
            }
    }

    public void setAnotacao(String id, String anotacao, String data) {
        try {

            PreparedStatement stmt = VariaveisDeControle.CON.prepareStatement("update incidentes set anotacoes = concat(anotacoes,?) where id = ?; ");

            stmt.setString(1, data + ": " + anotacao + ";");
            stmt.setString(2, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Não foi possível encerrar o incidente");
            ex.printStackTrace();
        }
    }
}
