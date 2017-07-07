/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author HP
 */
public class Cliente {

    private String apelido;
    private String nome;
    private String email;
    private String cpf;
    private String estado;
    private String telefone;
    private String confirmado;
    private String revendedor_assitencia;
    private String conta_semelhante;
    private String aceita_publicidade;
    private String observacoes;
    private String inativo;
    private String suspeito;

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
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
    
    public String getCpf() {        
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getEstado() {
        int dd = Integer.parseInt(getTelefone().substring(0, 2));
        if (dd == 68) {
            return "AC";
        } else if (dd == 82) {
            return "AL";
        } else if (dd == 96) {
            return "AP";
        } else if (dd == 97 || dd == 92) {
            return "AM";
        } else if (dd == 71 || (dd > 72 && dd < 76) || dd == 77) {
            return "BA";
        } else if (dd == 61) {
            return "DF";
        } else if (dd == 85 || dd == 88) {
            return "CE";
        } else if (dd > 26 && dd < 29) {
            return "ES";
        } else if (dd == 64 || (dd > 60 && dd < 63)) {
            return "GO";
        } else if (dd > 97 && dd < 100) {
            return "MA";
        } else if ((dd > 30 && dd < 36) || (dd > 36 && dd < 39)) {
            return "MG";
        } else if (dd == 67) {
            return "MS";
        } else if (dd > 64 && dd < 67) {
            return "MT";
        } else if (dd == 91 || (dd > 92 && dd < 95)) {
            return "PA";
        } else if (dd == 83) {
            return "PB";
        } else if (dd == 81 || dd == 87) {
            return "PE";
        } else if (dd == 86 || dd == 89) {
            return "PI";
        } else if (dd > 40 && dd < 47) {
            return "PR";
        } else if ((dd > 20 && dd < 23) || dd == 24) {
            return "RJ";
        } else if (dd == 84) {
            return "RN";
        } else if (dd == 69) {
            return "RO";
        } else if (dd == 95) {
            return "RR";
        } else if (dd == 51 || (dd > 52 && dd < 56)) {
            return "RS";
        } else if (dd > 46 && dd < 50) {
            return "SC";
        } else if (dd == 79) {
            return "SE";
        } else if (dd > 10 && dd < 20) {
            return "SP";
        } else if (dd == 63) {
            return "TO";
        } else {
            return "";
        }
    }

    public String getTelefone() {
     try{   String index0 = telefone.substring(0, 1);
        telefone = telefone.replace("(", "");
        telefone = telefone.replace(")", "");
        telefone = telefone.replace("*", "");
        telefone = telefone.replace("-", "");
        telefone = telefone.replace(".", "");
        telefone = telefone.replace(" ", "");
        if (index0.equals("0")) {
            telefone = telefone.substring(1, (telefone.length() - 1));
            return telefone;
        } else {
            return telefone;
        }
     }catch(Exception e){
         System.err.println("Erro ao adicionar telefone do cliente " + apelido);
         return null;
     }
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(String confirmado) {
        this.confirmado = confirmado;
    }

    public String getRevendedor_assitencia() {
        return revendedor_assitencia;
    }

    public void setRevendedor_assitencia(String revendedor_assitencia) {
        this.revendedor_assitencia = revendedor_assitencia;
    }

    public String getConta_semelhante() {
        return conta_semelhante;
    }

    public void setConta_semelhante(String conta_semelhante) {
        this.conta_semelhante = conta_semelhante;
    }

    public String getAceita_publicidade() {
        return aceita_publicidade;
    }

    public void setAceita_publicidade(String aceita_publicidade) {
        this.aceita_publicidade = aceita_publicidade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getInativo() {
        return inativo + "";
    }

    public void setInativo(String inativo) {
        this.inativo = inativo;
    }

    public String getSuspeito() {
        return suspeito;
    }

    public void setSuspeito(String suspeito) {
        this.suspeito = suspeito;
    }

    @Override
    public String toString() {
        return "Entidades.Cliente[ apelido=" + apelido + " ]";
    }

}
