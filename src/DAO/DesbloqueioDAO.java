package DAO;

import Controle.VariaveisDeControle;
import Entidades.Codigos;
import Entidades.Desbloqueios;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;












public class DesbloqueioDAO
{
  private Connection con;
  
  public DesbloqueioDAO()
  {
    con = VariaveisDeControle.CON;
  }
  
  public void setDesbloqueio(Desbloqueios des) throws SQLException {
    PreparedStatement stmt = con.prepareStatement("insert into desbloqueios(id_atendente,id_codigo,qtd_momento_vendida,data,hora,chip_local,pais,motivo,resolvido) values(?,?,?,?,?,?,?,?,?)");
    stmt.setInt(1, des.getId_atendente());
    stmt.setInt(2, des.getId_codigo());
    stmt.setInt(3, des.getQtd_usada());
    stmt.setString(4, des.getData());
    stmt.setString(5, des.getHora());
    stmt.setString(6, des.getLocal());
    stmt.setString(7, des.getPais());
    stmt.setString(8, des.getMotivo());
    stmt.setString(9, des.getResolvido());
    System.out.println(stmt.toString());
    stmt.executeUpdate();
    stmt.close();
  }
  
  public ArrayList<Desbloqueios> getDesbloqueiosPorId(int id) {
    try {
      PreparedStatement stmt = con.prepareStatement("select * from desbloqueios where id_codigo = ?");
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
      ArrayList<Desbloqueios> list = new ArrayList();
      
      while (rs.next()) {
        Desbloqueios desbloqueios = new Desbloqueios();
        desbloqueios.setId_atendente(rs.getInt("id_atendente"));
        desbloqueios.setId_codigo(rs.getInt("id_codigo"));
        desbloqueios.setQtd_usada(rs.getInt("qtd_momento_vendida"));
        desbloqueios.setData(rs.getString("data"));
        desbloqueios.setHora(rs.getString("hora"));
        desbloqueios.setPais(rs.getString("pais"));
        desbloqueios.setLocal(rs.getString("chip_local"));
        desbloqueios.setMotivo(rs.getString("motivo"));
        desbloqueios.setResolvido(rs.getString("resolvido"));
        list.add(desbloqueios);
      }
      rs.close();
      stmt.close();
      return list;
    } catch (SQLException ex) {
      Logger.getLogger(DesbloqueioDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
  public HashMap<Integer, Integer> getDesbloqueiosPorVariosID(ArrayList<Codigos> listCod) {
    try {
      HashMap<Integer, Integer> map = new HashMap();
      String s = "id_codigo = ";
      for (int i = 0; i <= listCod.size() - 1; i++) {
        s = s + ((Codigos)listCod.get(i)).getId();
        if (i < listCod.size() - 1) {
          s = s + " or id_codigo = ";
        }
      }
      PreparedStatement stmt = con.prepareStatement("select id_codigo from desbloqueios where (" + s + ") and resolvido = 'SIM';");
      System.err.println(stmt.toString());
      ResultSet rs = stmt.executeQuery();
      
      while (rs.next()) {
        int id = rs.getInt("id_codigo");
        if (map.containsKey(Integer.valueOf(id))) {
          int qtd = ((Integer)map.get(Integer.valueOf(id))).intValue();
          map.put(Integer.valueOf(id), Integer.valueOf(qtd++));
        } else {
          map.put(Integer.valueOf(id), Integer.valueOf(1));
        }
      }
      rs.close();
      stmt.close();
      return map;
    } catch (SQLException ex) {
      Logger.getLogger(DesbloqueioDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
}
