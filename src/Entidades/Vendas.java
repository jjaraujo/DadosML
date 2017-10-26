package Entidades;


public class Vendas
{
  private String id;
  
  private String apelido_comprador;
  
  private int qtd;
  
  private String data;
  
  private String dataEnvio;
  
  private String valorString;
  
  private double valor;
  private double valorPorDispositivo;
  private double valorPorDispositivoDesconto;
  private double valorDesconto;
  private int cadastroVendedor;
  private String formaPagamento;
  private String formaAquisicao;
  private String cancelada;
  private String observacoes;
  private String hora;
  private String anuncio;
  private String idProduto;
  
  public Vendas() {}
  
  public String getId()
  {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getApelido_comprador() {
    return apelido_comprador;
  }
  
  public void setApelido_comprador(String apelido_comprador) {
    this.apelido_comprador = apelido_comprador;
  }
  
  public int getQtd() {
    return qtd;
  }
  
  public void setQtd(int qtd) {
    this.qtd = qtd;
  }
  
  public String getData() {
    return data;
  }
  
  public void setData(String data) {
    this.data = data;
  }
  
  public String getDataEnvio() {
    return dataEnvio;
  }
  
  public void setDataEnvio(String dataEnvio) {
    this.dataEnvio = dataEnvio;
  }
  
  public double getValor() {
    valorString = valorString.replace(".", "");
    valorString = valorString.replace(",", ".");
    return Double.parseDouble(valorString);
  }
  
  public void setValor(double valor) {
    String valorString = valor + "";
    this.valorString = valorString.replace(".", ",");
  }
  
  public double getValorPorDispositivo() {
    return valorPorDispositivo;
  }
  
  public void setValorPorDispositivo(double valorPorDispositivo) {
    this.valorPorDispositivo = valorPorDispositivo;
  }
  
  public double getValorPorDispositivoDesconto() {
    return valorPorDispositivoDesconto;
  }
  
  public void setValorPorDispositivoDesconto(double valorPorDispositivoDesconto) {
    this.valorPorDispositivoDesconto = valorPorDispositivoDesconto;
  }
  
  public double getValorDesconto() {
    return valorDesconto;
  }
  
  public void setValorDesconto(double valorDesconto) {
    this.valorDesconto = valorDesconto;
  }
  
  public int getCadastroVendedor() {
    return cadastroVendedor;
  }
  
  public void setCadastroVendedor(int cadastroVendedor) {
    this.cadastroVendedor = cadastroVendedor;
  }
  
  public String getFormaPagamento() {
    return formaPagamento;
  }
  
  public void setFormaPagamento(String formaPagamento) {
    this.formaPagamento = formaPagamento;
  }
  
  public String getFormaAquisicao() {
    return formaAquisicao;
  }
  
  public void setFormaAquisicao(String formaAquisicao) {
    this.formaAquisicao = formaAquisicao;
  }
  
  public String getCancelada() {
    return cancelada;
  }
  
  public void setCancelada(String cancelada) {
    this.cancelada = cancelada;
  }
  
  public String getObservacoes() {
    return observacoes;
  }
  
  public void setObservacoes(String observacoes) {
    this.observacoes = observacoes;
  }
  
  public String getHora() {
    return hora;
  }
  
  public void setHora(String hora) {
    this.hora = hora;
  }
  
  public String getAnuncio() { return anuncio; }
  
  public String getValorString()
  {
    return valorString;
  }
  
  public void setValorString(String valorString) {
    this.valorString = valorString;
  }
  
  public String getIdProduto() {
    return idProduto;
  }
  
  public void setIdProduto(String idProduto) {
    this.idProduto = idProduto;
  }
  
  public String toString()
  {
    return "Entidades.Vendas[ id=" + id + " ]";
  }
}
