package DAO;

import Controle.VariaveisDeControle;
import Entidades.Atendentes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;














public class AtendentesDAO
{
  private static Connection con;
  
  public AtendentesDAO()
    throws ClassNotFoundException
  {
    con = VariaveisDeControle.CON;
  }
  
  public ArrayList<Atendentes> retornaAtendentes()
  {
    ArrayList list = new ArrayList();
    try {
      PreparedStatement stmt = con.prepareStatement("select * from atendentes;");
      
      ResultSet rs = stmt.executeQuery();
      

      while (rs.next()) {
        Atendentes atendentes = new Atendentes();
        atendentes.setId(rs.getInt("id"));
        atendentes.setNome(rs.getString("nome"));
        atendentes.setPais(rs.getString("pais"));
        list.add(atendentes);
      }
      rs.close();
      stmt.close();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage() + "\n Abra o programa novamente!", "Erro", 2);
      ex.printStackTrace();
      System.exit(0);
    }
    
    return list;
  }
}
