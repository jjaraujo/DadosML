package DAO;

import Controle.VariaveisDeControle;
import Entidades.Produtos;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;












public class ProdutosDAO
{
  public ProdutosDAO() {}
  
  public Produtos retornaProduto(String id)
  {
    Produtos p = new Produtos();
    try {
      PreparedStatement stmt = VariaveisDeControle.CON.prepareStatement("select * from produtos p where p.id = ?;");
      stmt.setString(1, id);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        p.setId(rs.getString("id"));
        p.setTipo(rs.getString("tipo"));
        p.setAnos(rs.getInt("duracao"));
        p.setQtd(rs.getInt("qtd"));
      }
      return p;
    } catch (SQLException ex) {
      System.out.println("Erro ao buscar tipo do produto em ProdutoDAO.retornaProduto: " + ex.getMessage()); }
    return null;
  }
  

  public HashMap<String, Produtos> getProdutosMap()
  {
    HashMap<String, Produtos> mapProd = new HashMap();
    try {
      if (VariaveisDeControle.CON == null) {
        return null;
      }
      PreparedStatement stmt = VariaveisDeControle.CON.prepareStatement("select * from produtos");
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Produtos p = new Produtos();
        p.setId(rs.getString("id"));
        p.setTipo(rs.getString("tipo"));
        p.setAnos(rs.getInt("duracao"));
        p.setQtd(rs.getInt("qtd"));
        p.setServer(rs.getInt("servidor"));
        mapProd.put(p.getId(), p);
      }
      return mapProd;
    }
    catch (SQLException ex) {
      System.out.println("Erro ao buscar tipo do produto em ProdutoDAO.retornaProduto: " + ex.getMessage()); }
    return null;
  }
  

  public ArrayList<Produtos> getProdutosList()
  {
    ArrayList<Produtos> listProd = new ArrayList();
    try {
      PreparedStatement stmt = VariaveisDeControle.CON.prepareStatement("select * from produtos order by tipo, qtd,duracao;");
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Produtos p = new Produtos();
        p.setId(rs.getString("id"));
        p.setTipo(rs.getString("tipo"));
        p.setAnos(rs.getInt("duracao"));
        p.setQtd(rs.getInt("qtd"));
        p.setValor(rs.getDouble("valor"));
        listProd.add(p);
      }
      return listProd;
    }
    catch (SQLException ex) {
      System.out.println("Erro ao buscar tipo do produto em ProdutoDAO.retornaProduto: " + ex.getMessage()); }
    return null;
  }
}
