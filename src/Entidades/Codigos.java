/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author HP
 */
public class Codigos {

    private int id;
    private String codigo;
    private String pedido; 
    private String senha;
    private int qtd_usada;
    private String data_compra;
    private String data_expiracao;
    private String pais;
    private double vlr_dolar;
    private String tipo;
    private int duracao;
    private int dispositivos;
    private double valor;
    private String suspeito;       
    private String nome;
    private String email;
    private String senha_mykaspersky;
    
    public String getSuspeito() {
        return suspeito;
    }

    public void setSuspeito(String suspeito) {
        this.suspeito = suspeito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha_mykaspersky() {
        return senha_mykaspersky;
    }

    public void setSenha_mykaspersky(String senha_mykaspersky) {
        this.senha_mykaspersky = senha_mykaspersky;
    }

    public int getQtd_usada() {
        return qtd_usada;
    }

    public void setQtd_usada(int qtd_usada) {
        this.qtd_usada = qtd_usada;
    }
    private String situacao;
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getData_compra() {
        return data_compra;
    }

    public void setData_compra(String data_compra) {
        this.data_compra = data_compra;
    }

    public String getData_expiracao() {
        return data_expiracao;
    }

    public void setData_expiracao(String data_expiracao) {
        this.data_expiracao = data_expiracao;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getVlr_dolar() {
        return vlr_dolar;
    }

    public void setVlr_dolar(double vlr_dolar) {
        this.vlr_dolar = vlr_dolar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(int dispositivos) {
        this.dispositivos = dispositivos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
    
    @Override
    public String toString() {
        return "Entidades.Codigos[ id=" + id + " ]";
    }   

    @Override
    public int hashCode() {
        return id; //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Codigos other = (Codigos) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
