package EmailConfig;

import Controle.VariaveisDeControle;
import Visao.Principal;
import java.awt.Color;
import java.io.PrintStream;
import javax.swing.JTextArea;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;


public class EmailService
{
  private String email;
  private String assunto;
  private String corpoHtml;
  
  public EmailService(String email, String assunto, String corpo) {
    this.email = email;
    this.assunto = assunto;
    corpoHtml = corpo;
  }
  


  public void sendEmail(String apelido)
  {
    Principal.setTextArea("Enviando email para " + email + "\n");
    try
    {
      HtmlEmail htmlEmail = new HtmlEmail();
      htmlEmail.setSSLOnConnect(true);
      htmlEmail.setHostName("smtp.gmail.com");
      htmlEmail.setSslSmtpPort("465");
      htmlEmail.setAuthenticator(new DefaultAuthenticator(VariaveisDeControle.email, VariaveisDeControle.senha));
      htmlEmail.setFrom(VariaveisDeControle.email);
      
      htmlEmail.setSubject(assunto);
      StringBuilder builder = new StringBuilder();
      builder.append(corpoHtml);
      htmlEmail.setHtmlMsg(builder.toString());
      htmlEmail.addTo(email);
      System.out.println("Enviando email para " + email);
      htmlEmail.send();
      System.out.println("Email enviado com sucesso para " + email);
      Principal.setTextArea("Email enviado com sucesso para " + email + "\n");
    }
    catch (EmailException e)
    {
      System.out.println("Atenção, o email \"" + assunto + "\"\n não foi enviado para o email " + email);
      Principal.setTextArea("Erro ============>Atenção, o email \"" + assunto + "\"\n não foi enviado para o email " + email);
      e.printStackTrace();
    }
  }
}
