/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailConfig;

import Controle.VariaveisDeControle;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author Joao
 */
public class EmailService {

    private String email;
    private String assunto;
    private String corpoHtml;
    private JTextArea textArea = VariaveisDeControle.textArea;
    
    public EmailService(String email, String assunto, String corpo) {
        this.email = email;
        this.assunto = assunto;
        this.corpoHtml = corpo;

    }

    public void sendEmail(String apelido) {
        System.out.println("Enviando email para " + email);
         textArea.setText(textArea.getText() + "Enviando email para " + email + "\n");
        HtmlEmail email = new HtmlEmail();
        email.setSSLOnConnect(true);
        email.setHostName("smtp.gmail.com");
        email.setSslSmtpPort("465");
        email.setAuthenticator(new DefaultAuthenticator(VariaveisDeControle.email,VariaveisDeControle.senha));
        try {
            email.setFrom(VariaveisDeControle.email);
            //   email.setDebug(true); 
            email.setSubject(assunto);
            StringBuilder builder = new StringBuilder();
            builder.append(corpoHtml);
            email.setHtmlMsg(builder.toString());
            email.addTo(this.email);
            email.send();
            System.out.println("Email enviado com sucesso para " + this.email);
             textArea.setText(textArea.getText() +"Email enviado com sucesso para " + this.email + "\n");
        } catch (EmailException e) {
            JOptionPane.showMessageDialog(null, "Atenção, o email \""+assunto+"\"\n" + " não foi enviado para o email "
            + this.email);
            e.printStackTrace();
        }
    }

}
