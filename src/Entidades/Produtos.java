package Entidades;


public class Produtos
{
  private String id;
  private String tipo;
  private int qtd;
  private int anos;
  private double valor;
  private int server;
  
  public Produtos() {}
  
  public String getId()
  {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getTipo() {
    return tipo;
  }
  
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
  
  public int getQtd() {
    return qtd;
  }
  
  public void setQtd(int qtd) {
    this.qtd = qtd;
  }
  
  public int getAnos() {
    return anos;
  }
  
  public void setAnos(int anos) {
    this.anos = anos;
  }
  
  public double getValor() {
    return valor;
  }
  
  public void setValor(double valor) {
    this.valor = valor;
  }
  





  public int getServer()
  {
    return server;
  }
  
  public void setServer(int server) {
    this.server = server;
  }
  




  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Produtos other = (Produtos)obj;
    if (id != id) {
      return false;
    }
    return true;
  }
  
  public String getNomeProduto() { String server = "";
    
    if (getTipo().toLowerCase().equals("small")) {
      if (getServer() > 1) {
        server = getServer() + " servers ";
      } else {
        server = getServer() + " server ";
      }
    }
    String produto = "Kaspersky " + getTipo() + " " + getQtd() + " Dispositivo(s) " + server + " " + getAnos() + " ano(s)";
    
    if (getId().equals("KIS1D1A1A")) {
      produto = produto + " + Android";
    }
    return produto;
  }
  
  public String getNomeProdutoQtdTotal(int QtdTotal) {
    String server = "";
    
    if (getTipo().toLowerCase().equals("small")) {
      if (getServer() > 1) {
        server = getServer() + " servers ";
      } else {
        server = getServer() + " server ";
      }
    }
    String produto = "Kaspersky " + getTipo() + " " + QtdTotal * getQtd() + " Dispositivo(s) " + server + " " + getAnos() + " ano(s)";
    if (id.equals("KIS1D1A1A")) {
      produto = produto + QtdTotal + " + Android";
    }
    return produto;
  }
}
