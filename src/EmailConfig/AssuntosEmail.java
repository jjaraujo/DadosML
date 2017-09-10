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
     public String enviarEmail(String nomeProduto, String id){
        return "KSafe - Confirmação do Pedido (Nº do pedido " + id + ")";
     }
     
     public String reenviarEmail(String nomeProduto, String id){
        return "KSafe - Reenvio do Pedido (Nº do pedido " + id + ")";
     }
     public String emailAtualizado(){
        return "Seu email foi atualizado";
     }
     
     public String lembreteExpiracao(String pedido){
        return "Lembrete de renovação de assinatura Kaspersky - Pedido Nº" + pedido;
     }
}
