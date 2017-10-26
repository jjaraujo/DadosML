package DAO;

import Controle.VariaveisDeControle;
import Entidades.Cliente;
import Entidades.EmailNomeTipoproduto;
import Entidades.Produtos;
import Entidades.Vendas;
import Entidades.VendasPendentes;
import Visao.Principal;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class VendaDAO
{
  private static Connection con;
  
  public VendaDAO() {
    con = VariaveisDeControle.CON;
  }
  
  public Vendas getUmaVenda(String id)
  {
    try {
      PreparedStatement stmt = con.prepareCall("select * from vendas where id like '" + id + "';");
      ResultSet rs = stmt.executeQuery();
      Vendas ven = new Vendas();
      while (rs.next()) {
        ven.setId(rs.getString("id"));
        ven.setApelido_comprador(rs.getString("apelido_comprador"));
        ven.setQtd(rs.getInt("qtd"));
        ven.setIdProduto(rs.getString("id_produto"));
        ven.setData(rs.getString("data"));
        ven.setFormaPagamento(rs.getString("forma_pagamento"));
        ven.setValor(rs.getDouble("valor"));
        ven.setCancelada(rs.getString("cancelada"));
        ven.setValorPorDispositivo(rs.getDouble("valorpordispositivo"));
      }
      return ven;
    } catch (SQLException e) {
      e.printStackTrace(); }
    return null;
  }
  
  public ArrayList<Vendas> getVendas()
  {
    ArrayList<Vendas> set = new ArrayList();
    try {
      PreparedStatement stmt = VariaveisDeControle.CON.prepareStatement("select * from vendas;");
      ResultSet rs = stmt.executeQuery();
      
      while (rs.next()) {
        Vendas ven = new Vendas();
        ven.setId(rs.getString("id"));
        ven.setApelido_comprador(rs.getString("apelido_comprador"));
        ven.setQtd(rs.getInt("qtd"));
        ven.setIdProduto(rs.getString("id_produto"));
        ven.setData(rs.getString("data"));
        ven.setFormaPagamento(rs.getString("forma_pagamento"));
        ven.setValor(rs.getDouble("valor"));
        ven.setCancelada(rs.getString("cancelada"));
        ven.setValorPorDispositivo(rs.getDouble("valorpordispositivo"));
        set.add(ven);
      }
      return set;
    } catch (SQLException e) {
      e.printStackTrace(); }
    return null;
  }
  
  public void insertVenda(ArrayList<Vendas> set)
  {
    for (final Vendas v : set) {
      Runnable r = new Runnable()
      {
        public void run() {
          try {
            VendasPendentes vp = new VendasPendentes();
            Cliente cliente = new ClienteDAO().getCliente(v.getApelido_comprador());
            double valor = v.getValor() * v.getQtd();
            double valordesconto;
            if (valor < 20.0D) {
              valordesconto = valor - valor * 11.0D / 100.0D;
            } else {
              valordesconto = valor - valor * 16.0D / 100.0D;
            }
            Produtos produto = (Produtos)VariaveisDeControle.mapProd.get(v.getIdProduto());
            int qtddispproduto = produto.getQtd();
            int qtdProdutosVenda = v.getQtd();
            if (produto.getQtd() == 0) {
              qtddispproduto = 1;
            }
            int qtdTotalDispositivos = qtdProdutosVenda * qtddispproduto;
            double valorpordispositivodescont = valordesconto / qtdTotalDispositivos;
            double valorpordispositivo = valor / qtdTotalDispositivos;
            String hora = v.getHora().substring(11, v.getHora().length() - 1);
            
            if (getUmaVenda(v.getId()).getApelido_comprador() == null) {
              try
              {
                PreparedStatement stmt = VendaDAO.con.prepareStatement("insert into vendas(id, apelido_comprador,id_produto, qtd, valor,valorpordispositivo, valorpordispositivo_descont,valor_desconto, cadastro_vendedor,forma_aquisicao, forma_pagamento, data, hora) values (?,?,?,?,?,?,?,?,?,?,?,?,?);");
                stmt.setString(1, v.getId());
                stmt.setString(2, v.getApelido_comprador());
                stmt.setString(3, v.getIdProduto());
                stmt.setInt(4, qtdProdutosVenda);
                stmt.setDouble(5, valor);
                stmt.setDouble(6, valorpordispositivo);
                stmt.setDouble(7, valorpordispositivodescont);
                stmt.setDouble(8, valordesconto);
                stmt.setInt(9, v.getCadastroVendedor());
                stmt.setString(10, v.getFormaAquisicao());
                stmt.setString(11, v.getFormaPagamento());
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date data = new java.sql.Date(format.parse(v.getData()).getTime());
                stmt.setDate(12, data);
                stmt.setString(13, hora);
                System.out.println("Venda cadastrada: " + v.getId());
                Principal.setTextArea("Venda cadastrada: " + v.getId() + "\n");
                stmt.executeUpdate();
                stmt.close();
              }
              catch (SQLException ex) {
                System.err.println("Erro ao adicionar a venda " + v.getId() + ": " + ex.getMessage());
                Principal.setTextArea("Erro ============> Erro ao adicionar a venda " + v.getId() + ": " + ex.getMessage());
                ex.printStackTrace();
              } catch (NullPointerException ex) {
                 Principal.setTextArea("Erro ============> Erro ao adicionar a venda " + v.getId() + ": " + ex.getMessage());
               System.err.println("Erro ============> Erro ao adicionar a venda " + v.getId() + ": " + ex.getMessage());
                ex.printStackTrace();
              } catch (ParseException ex) {
                Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
              }
            }
            if (new VendasPendentesDAO().verificaSeAVendaPodeSerAdicionada(v.getId())) {
              vp.setApelido(v.getApelido_comprador());
              vp.setEmail(cliente.getEmail());
              vp.setIdProduto(v.getIdProduto());
              vp.setPagamento(v.getFormaPagamento());
              vp.setQtd(qtdProdutosVenda);
              vp.setId_venda(v.getId());
              
              if (cliente.getInativo().equals("null")) {
                new VendasPendentesDAO().insereVendas(vp);
              } else {
                JOptionPane.showMessageDialog(null, "Cliente inativo: " + v.getApelido_comprador());
              }
            }
          }
          catch (Exception e)
          {
            System.err.println("Erro ao adicionar a venda " + v.getId() + " " + v.getApelido_comprador() + ": " + e.getMessage());
            Principal.setTextArea("Erro ============>Erro ao adicionar a venda " + v.getId() + " " + v.getApelido_comprador() + ": " + e.getMessage() + "\n");
            e.printStackTrace();
          }
        }
      };
      Thread t = new Thread(r);
      t.start();
    }
  }
   
  public void insertVendas(Vendas v)
  {
    ProdutosDAO prodDAO = new ProdutosDAO();
    VendasPendentes vp = new VendasPendentes();
    Cliente cliente = new ClienteDAO().getCliente(v.getApelido_comprador());
    double valor = v.getValor();
    if (v.getFormaAquisicao().equals("MP")) {
      valor -= valor * 4.99D / 100.0D;
    }
    double valordesconto = valor;
    Produtos produto = prodDAO.retornaProduto(v.getIdProduto());
    int qtddispproduto = produto.getQtd();
    int qtdProdutosVenda = v.getQtd();
    int qtdTotalDispositivos;
 
    if (qtddispproduto == 0) {
      qtdTotalDispositivos = qtdProdutosVenda * 1;
    } else {
      qtdTotalDispositivos = qtdProdutosVenda * qtddispproduto;
    }
    double valorpordispositivodescont = valordesconto / qtdTotalDispositivos;
    
    double valorpordispositivo = valor / qtdTotalDispositivos;
    
    System.out.println("valorpordispositivo: " + valorpordispositivo);
    System.out.println("valor: " + valor);
    System.out.println("qtdTotalDispositivos: " + qtdTotalDispositivos);
    try
    {
      PreparedStatement stmt = con.prepareStatement("insert into vendas(id,apelido_comprador,id_produto,qtd,valor,valorpordispositivo,valorpordispositivo_descont,valor_desconto,cadastro_vendedor,forma_aquisicao,forma_pagamento,data,hora) values (?,?,?,?,?,?,?,?,?,?,?,?,?);");
      stmt.setString(1, v.getId());
      stmt.setString(2, v.getApelido_comprador());
      stmt.setString(3, v.getIdProduto());
      stmt.setInt(4, qtdProdutosVenda);
      stmt.setDouble(5, valor);
      stmt.setDouble(6, valorpordispositivo);
      stmt.setDouble(7, valorpordispositivodescont);
      stmt.setDouble(8, valordesconto);
      stmt.setInt(9, v.getCadastroVendedor());
      stmt.setString(10, v.getFormaAquisicao());
      stmt.setString(11, v.getFormaPagamento());
      stmt.setDate(12, java.sql.Date.valueOf(v.getData()));
      stmt.setTime(13, Time.valueOf(v.getHora()));
      System.out.println(stmt.toString());
      stmt.executeUpdate();
      vp.setApelido(v.getApelido_comprador());
      vp.setEmail(cliente.getEmail());
      vp.setIdProduto(v.getIdProduto());
      vp.setPagamento(v.getFormaPagamento());
      vp.setQtd(qtdProdutosVenda);
      vp.setId_venda(v.getId());
      new VendasPendentesDAO().insereVendas(vp);
      stmt.close();
      JOptionPane.showMessageDialog(null, "Venda " + v.getId() + " cadastrada");
      Principal.setTextArea( "Venda cadastrada: " + v.getId() + "\n");
    } catch (SQLException ex) {
      System.err.println("Erro ============>Erro ao adicionar a venda " + v.getId() + ": " + ex.getMessage());
      Principal.setTextArea("Erro ============>Erro ao adicionar a venda " + v.getId() + ": " + ex.getMessage() + "\n");
      ex.printStackTrace();
    }
    catch (NullPointerException ex) {
      Principal.setTextArea("Erro ============> "+ v.getId() + "  tem erro de nulo: " + ex.getMessage() + "\n");
      System.err.println("Erro ============> "+v.getId() + " tem erro de nulo: " + ex.getMessage());
      ex.printStackTrace();
    }
  }
  
  public String getCountVendasWhatsappDoDia() {
    java.sql.Date data = new java.sql.Date(System.currentTimeMillis());
    SimpleDateFormat formatarDate = new SimpleDateFormat("ddMMyyyy");
    String dataId = formatarDate.format(data);
    int count = 0;
    try {
      PreparedStatement stmt = con.prepareStatement("select count(id) count from vendas where id like  ?;");
      stmt.setString(1, "%" + dataId + "%");
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        count = rs.getInt("count");
      }
      return dataId + "" + (count + 1);
    } catch (SQLException ex) {
      System.err.println("Erro ============> Erro ao retornar idVendaWhatsapp: " + ex.getMessage()); }
    return null;
  }
  
  public ArrayList<Vendas> getVendasClienteNoPrograma(String apelido, String dataInicio)
  {
    try {
      ArrayList<Vendas> array = new ArrayList();
      
      PreparedStatement stmt = con.prepareCall("select * from vendas where apelido_comprador like ? where data > ?; ");
      stmt.setString(1, apelido);
      stmt.setString(2, dataInicio);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Vendas v = new Vendas();
        v.setApelido_comprador(rs.getString("apelido_cliente"));
        v.setQtd(rs.getInt("qtd"));
        v.setIdProduto(rs.getString("id_produto"));
        array.add(v);
      }
      return array;
    } catch (SQLException ex) {
      Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex); }
    return null;
  }
  
  public void cancelaVenda(String id)
  {
    try {
      PreparedStatement stmt = con.prepareCall("update vendas set cancelada = 'SIM' where id like ?; ");
      stmt.setString(1, id);
      stmt.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void updateIdProdutoVenda(String id, String idProd) {
    try {
      PreparedStatement stmt = con.prepareCall("update vendas set id_produto = ? where id like ?; ");
      stmt.setString(1, idProd);
      stmt.setString(2, id);
      stmt.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void updateQtdVenda(String id, int qtd) {
    try {
      PreparedStatement stmt = con.prepareCall("update vendas set qtd = ?,valor = valorpordispositivo * ?,valor_desconto = valorprodispositivo_descont * ? where id like ?; ");
      stmt.setInt(1, qtd);
      stmt.setInt(2, qtd);
      stmt.setInt(3, qtd);
      stmt.setInt(4, qtd);
      stmt.setString(5, id);
      stmt.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void updateValorDispositivo(String id, double valorpordispositivo) {
    try { PreparedStatement stmt = con.prepareCall("update vendas set valorpordispositivo = ? where id like ?; ");
      stmt.setDouble(1, valorpordispositivo);
      stmt.setString(2, id);
      stmt.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void setDataEnvio(String data, String id) {
    try {
      PreparedStatement stmt = con.prepareCall("update vendas set data_envio = ? where id like ?; ");
      stmt.setString(1, data);
      stmt.setString(2, id);
      stmt.executeUpdate();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Não foi possivel adicionar a data de envio do código para a venda " + id + "\n" + ex.getMessage());
      System.err.println("Não foi possivel adicionar a data de envio do código para a venda " + id + "\n" + ex.getMessage());
      Principal.setTextArea("Erro ============> Não foi possivel adicionar a data de envio do código para a venda " + id + "\n" + ex.getMessage());
      ex.printStackTrace();
    }
  }
  
  public ArrayList<EmailNomeTipoproduto> getEmailVendasKisTotal() {
    ArrayList<EmailNomeTipoproduto> list = new ArrayList();
    System.out.println("Vai buscar os dados dos clientes");
    try {
      PreparedStatement stmt = con.prepareStatement("select distinct c.email,c.nome,cd.tipo,c.apelido from clientes_ml c join vendas v on v.apelido_comprador = c.apelido\njoin codigos_has_vendas chv on v.id = chv.id_venda join codigos cd on chv.id_codigo = cd.id \nwhere c.inativo is null and (cd.tipo = 'TOTAL' or cd.tipo = 'KIS') order by c.email limit 99, 5136;");
      

      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        EmailNomeTipoproduto ent = new EmailNomeTipoproduto();
        ent.email = rs.getString("c.email");
        ent.nome = rs.getString("c.nome");
        ent.tipo = rs.getString("cd.tipo");
        ent.apelido = rs.getString("c.apelido");
        list.add(ent);
      }
    } catch (SQLException ex) {
      Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println("Terminou de buscar os dados dos clientes");
    return list;
  }
}
