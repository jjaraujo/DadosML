package Entidades;

public class Incidentes
{
  private String id;
  private String id_venda;
  private String data_incidente;
  private String motivo_texto;
  private int motivo;
  
  public Incidentes() {}
  
  public String getCodigo()
  {
    return codigo;
  }
  
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  
  public String getApelido() {
    return apelido;
  }
  
  public void setApelido(String apelido) {
    this.apelido = apelido;
  }
  
  public String getDataCompra() {
    return data_compra;
  }
  
  public void setData_compra(String data_compra) {
    this.data_compra = data_compra;
  }
  
  private int id_codigo;
  private String situacao;
  private String anotacoes;
  
  public String getId() { return id; }
  
  private String codigo;
  
  public void setId(String id) { this.id = id; }
  
  private String apelido;
  private String data_compra;
  public String getId_venda() { return id_venda; }
  
  public void setId_venda(String id_venda)
  {
    this.id_venda = id_venda;
  }
  
  public int getId_codigo() {
    return id_codigo;
  }
  
  public void setId_codigo(int id_codigo) {
    this.id_codigo = id_codigo;
  }
  
  public String getDataIncidente() {
    return data_incidente;
  }
  
  public void setDataIncidente(String data) {
    data_incidente = data;
  }
  
  public String getMotivoTexto() {
    return motivo_texto;
  }
  
  public void setMotivoTexto(String motivo_texto) {
    this.motivo_texto = motivo_texto;
  }
  
  public int getMotivo() {
    return motivo;
  }
  
  public void setMotivo(int motivo) {
    this.motivo = motivo;
  }
  
  public String getSituacao() {
    return situacao;
  }
  
  public void setSituacao(String situacao) {
    this.situacao = situacao;
  }
  
  public String getAnotacoes() {
    return anotacoes;
  }
  
  public void setAnotacoes(String anotacoes) {
    this.anotacoes = anotacoes;
  }
}
