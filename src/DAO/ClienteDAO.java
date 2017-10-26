package DAO;

import Controle.VariaveisDeControle;
import Entidades.Cliente;
import Entidades.Vendas;
import Visao.Principal;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;







public class ClienteDAO
{
  private PreparedStatement stmt;
  private Connection con;
  private ResultSet rs;
  private Cliente cc;
  
  public ClienteDAO()
  {
    con = VariaveisDeControle.CON;
  }
  
  public Cliente getCliente(String apelido)
  {
    try {
      stmt = con.prepareStatement("select nome, email,telefone,inativo,confirmado,revendedor_assistencia from clientes_ml where apelido like '" + apelido + "';");
      rs = stmt.executeQuery();
      Cliente cliente = new Cliente();
      while (rs.next()) {
        cliente.setNome(rs.getString("nome"));
        cliente.setEmail(rs.getString("email"));
        cliente.setInativo(rs.getString("inativo"));
        cliente.setConfirmado(rs.getString("confirmado"));
        cliente.setRevendedor_assitencia(rs.getString("revendedor_assistencia"));
        cliente.setTelefone(rs.getString("telefone"));
      }
      rs.close();
      stmt.close();
      return cliente;
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage() + "\n Abra o programa novamente!", "Erro", 2);
      ex.printStackTrace();
      System.exit(0); }
    return null;
  }
  
  public ArrayList<Object[]> getClientePorCodigo(int id) {
    ArrayList<Object[]> list = new ArrayList();
    try
    {
      stmt = con.prepareStatement("select c.nome,c.email,v.data,v.id,v.id_produto,v.qtd,v.valor,v.valorpordispositivo from clientes_ml c join vendas v on c.apelido = v.apelido_comprador join codigos_has_vendas cv on v.id = cv.id_venda where id_codigo = ? and v.cancelada is null;");
      

      stmt.setString(1, id + "");
      rs = stmt.executeQuery();
      while (rs.next()) {
        Cliente cliente = new Cliente();
        Vendas v = new Vendas();
        cliente.setNome(rs.getString("c.nome"));
        cliente.setEmail(rs.getString("c.email"));
        v.setData(rs.getString("v.data"));
        v.setId(rs.getString("id"));
        v.setIdProduto(rs.getString("v.id_produto"));
        v.setValorPorDispositivo(rs.getDouble("v.valorpordispositivo"));
        v.setValor(rs.getDouble("v.valor"));
        v.setQtd(rs.getInt("v.qtd"));
        Object[] obj = { cliente, v };
        list.add(obj);
      }
      rs.close();
      stmt.close();
      return list;
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage() + "\n Abra o programa novamente!", "Erro", 2);
      ex.printStackTrace();
      System.exit(0); }
    return null;
  }
  
  private boolean verificaClienteCadastrado(String apelido)
  {
    try {
      stmt = con.prepareStatement("select * from clientes_ml where apelido like ?");
      stmt.setString(1, "%" + apelido + "%");
      rs = stmt.executeQuery();
      return rs.first();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "\"Erro ao verificar se cliente já está cadastrado \n\"" + ex.getMessage() + "\n Abra o programa novamente!", "Erro", 2);
      ex.printStackTrace();
      System.exit(0); }
    return true;
  }
  
  public boolean verificaClienteRevendedor(String apelido)
  {
    try {
      stmt = con.prepareStatement("select revendedor_assistencia from clientes_ml where apelido like ?");
      stmt.setString(1, "" + apelido + "");
      rs = stmt.executeQuery();
      String i = null;
      while (rs.next()) {
        i = rs.getString("revendedor_assistencia");
      }
      
      if (i != null) {
        return true;
      }
      return false;
    }
    catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao verificar se cliente já está cadastrado", "Erro", 64);
      System.exit(0); }
    return true;
  }
  
  public void insertCliente(Cliente c)
  {
    HashSet<Cliente> hs = new HashSet();
    hs.add(c);
    insertCliente(hs);
  }
  




























  public void insertCliente(final HashSet<Cliente> c)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          for (Cliente clt : c) {
            cc = clt;
            if (!ClienteDAO.this.verificaClienteCadastrado(clt.getApelido())) {
              stmt = con.prepareStatement("insert into clientes_ml(apelido,nome,email,cpf,estado,telefone) values(?,?,?,?,?,?);");
              stmt.setString(1, clt.getApelido());
              stmt.setString(2, clt.getNome());
              stmt.setString(3, clt.getEmail());
              stmt.setString(4, clt.getCpf());
              stmt.setString(5, clt.getEstado());
              stmt.setString(6, clt.getTelefone());
              stmt.executeUpdate();
              Principal.setTextArea("Ciente cadastradoo: " + clt.getApelido() + "\n");
            }
          }
          JOptionPane.showMessageDialog(null, "Clientes cadastrados com sucesso");
        }
        catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro na transação! DAO.ClienteDAO().cadastrarCliente: " + ex.getMessage());
          System.exit(0);
        } catch (NumberFormatException exN) {
          System.out.println("Erro na transação! DAO.ClienteDAO().cadastrarCliente: " + exN.getMessage());
          Principal.setTextArea("Erro na transação! DAO.ClienteDAO().cadastrarCliente: " + cc.getApelido() + " - " + exN.getMessage() + "\n");
          exN.printStackTrace();
        }
      }
    })
    



























      .start();
  }
  
  public ArrayList<Cliente> getClientesRevendedores() {
    ArrayList<Cliente> set = new ArrayList();
    try {
      PreparedStatement stmt = con.prepareStatement("select * from clientes_ml where revendedor_assistencia is not null and inativo is null;");
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Cliente c1 = new Cliente();
        c1.setEmail(rs.getString("email"));
        c1.setApelido(rs.getString("apelido"));
        c1.setNome(rs.getString("nome"));
        
        set.add(c1);
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro na transação! DAO.ClienteDAO().getClientesRevendedores: " + ex.getMessage());
      System.exit(0);
    }
    
    return set;
  }
  
  public void setNumeroConfimado(String apelido, String telefone) {
    try {
      PreparedStatement stmt = con.prepareStatement("UPDATE clientes_ml SET telefone = concat(telefone,?)  WHERE apelido like ?;");
      stmt.setString(1, telefone);
      stmt.setString(2, apelido);
      stmt.executeUpdate();
    } catch (SQLException ex) {
      System.err.println("Erro ao adicionar numero confirmado no cliente " + apelido + "\n" + ex.getMessage());
      System.exit(0);
    }
  }
  
  public void updateEmail(String apelido, String email) {
    try {
      PreparedStatement stmt = con.prepareStatement("UPDATE clientes_ml SET email = ?  WHERE apelido like ?;");
      stmt.setString(1, email);
      stmt.setString(2, apelido);
      stmt.executeUpdate();
    } catch (SQLException ex) {
      System.err.println("Erro ao modificar email do cliente " + apelido + "\n" + ex.getMessage());
      System.exit(0);
    }
  }
}
