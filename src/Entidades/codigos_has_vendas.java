package Entidades;


public class codigos_has_vendas
{
  private String id_venda;
  
  private int id_codigo;
  
  private int qtd_dispositivos;
  private String codigos_antigos;
  private int qtd_servidor;
  
  public codigos_has_vendas() {}
  
  public int getQtd_servidor()
  {
    return qtd_servidor;
  }
  
  public void setQtd_servidor(int qtd_servidor) {
    this.qtd_servidor = qtd_servidor;
  }
  
  public int getId_codigo() {
    return id_codigo;
  }
  
  public void setId_codigo(int id_codigo) {
    this.id_codigo = id_codigo;
  }
  
  public int getQtd() {
    return qtd_dispositivos;
  }
  
  public void setQtd(int qtd) {
    qtd_dispositivos = qtd;
  }
  
  public String getCodigos_antigos() {
    return codigos_antigos;
  }
  
  public void setCodigos_antigos(String codigos_antigos) {
    this.codigos_antigos = codigos_antigos;
  }
  
  public String getIdVenda() { return id_venda; }
  
  public void setIdVenda(String id)
  {
    id_venda = id;
  }
  
  public String toString()
  {
    return "Entidades.codigos_has_vendas[ id=" + id_venda + " ]";
  }
}
