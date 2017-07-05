/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Desbloqueios {

    private int id;
    private int id_atendente;
    private int id_codigo;
    private int qtd_usada;    
    private String data;
    private String hora;
    private String local;            
    private String motivo;
    private String pais;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    private String resolvido;


    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    public int getQtd_usada() {
        return qtd_usada;
    }

    public void setQtd_usada(int qtd_usada) {
        this.qtd_usada = qtd_usada;
    }

    public int getId_atendente() {
        return id_atendente;
    }

    public void setId_atendente(int id_atendente) {
        this.id_atendente = id_atendente;
    }

    public int getId_codigo() {
        return id_codigo;
    }

    public void setId_codigo(int id_codigo) {
        this.id_codigo = id_codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getResolvido() {
        return resolvido;
    }

    public void setResolvido(String resolvido) {
        this.resolvido = resolvido;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desbloqueios)) {
            return false;
        }
        Desbloqueios other = (Desbloqueios) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Desbloqueios[ id=" + id + " ]";
    }
    
}
