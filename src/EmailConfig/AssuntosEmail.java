/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailConfig;

/**
 *
 * @author Joao
 */
public class AssuntosEmail {
    public String assuntoAberturaIncidente(String id){
        return "Novo incidente " + id + " aberto em nosso sistema";
    }
     public String assuntoEncerramentoIncidente(String id){
        return "Incidente " + id + " encerrado";
    }
}
