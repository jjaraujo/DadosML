package Entidades;

import Controle.VariaveisDeControle;
import java.util.HashMap;
import java.util.Objects;













public class VendasPendentes
{
  private String id_venda;
  private String observacoes;
  private String pendente;
  private String verificada;
  private String email;
  private String apelido;
  private String codigo;
  private String produto;
  private String pagamento;
  private String idProduto;
  private int idCodigo;
  private int qtd;
  private String tipoProduto;
  
  public VendasPendentes() {}
  
  public String getTipoProduto()
  {
    return tipoProduto;
  }
  
  public void setTipoProduto(String tipoProduto) {
    this.tipoProduto = tipoProduto;
  }
  
  public int getIdCodigo() {
    return idCodigo;
  }
  
  public void setIdCodigo(int idCodigo) {
    this.idCodigo = idCodigo;
  }
  
  public String getPagamento()
  {
    return pagamento;
  }
  
  public void setPagamento(String pagamento) {
    this.pagamento = pagamento;
  }
  
  public String getId_venda() {
    return id_venda;
  }
  
  public void setId_venda(String id_venda) {
    this.id_venda = id_venda;
  }
  
  public String getObservacoes() {
    return observacoes;
  }
  
  public void setObservacoes(String observacoes) {
    this.observacoes = observacoes;
  }
  
  public String getPendente() {
    return pendente;
  }
  
  public void setPendente(String pendente) {
    this.pendente = pendente;
  }
  
  public String getVerificada() {
    return verificada;
  }
  
  public void setVerificada(String verificada) {
    this.verificada = verificada;
  }
  
  public String getEmail() {
    return email;
  }
  
  public String getApelido() {
    return apelido;
  }
  
  public String getCodigo() {
    return codigo;
  }
  
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  

  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getIdProduto() {
    return idProduto;
  }
  
  public void setIdProduto(String idProduto) {
    this.idProduto = idProduto;
  }
  
  public void setApelido(String apelido) {
    this.apelido = apelido;
  }
  
  public int getQtd() {
    return qtd;
  }
  
  public void setQtd(int qtd) {
    this.qtd = qtd;
  }
  
  public String toString()
  {
    return id_venda + " - " + apelido + " - " + pagamento + " - " + ((Produtos)VariaveisDeControle.mapProd.get(idProduto)).getNomeProdutoQtdTotal(qtd);
  }
  
  public int hashCode()
  {
    return Integer.parseInt(id_venda);
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
    VendasPendentes other = (VendasPendentes)obj;
    if (!Objects.equals(id_venda, id_venda)) {
      return false;
    }
    return true;
  }
}
