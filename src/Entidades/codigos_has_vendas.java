/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;


public class codigos_has_vendas {

    private String id_venda;

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
        this.qtd_dispositivos = qtd;
    }

    public String getCodigos_antigos() {
        return codigos_antigos;
    }

    public void setCodigos_antigos(String codigos_antigos) {
        this.codigos_antigos = codigos_antigos;
    }
    private int id_codigo;
    private int qtd_dispositivos;
    private String codigos_antigos;
    public String getIdVenda() {
        return id_venda;
    }

    public void setIdVenda(String id) {
        this.id_venda = id;
    }

    @Override
    public String toString() {
        return "Entidades.codigos_has_vendas[ id=" + id_venda + " ]";
    }
    
}
