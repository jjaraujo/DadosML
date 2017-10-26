package EmailConfig;

import Controle.VariaveisDeControle;
import javax.swing.JOptionPane;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;








public class Service
{
  public Service() {}
  
  public HtmlEmail getServiceEmail()
  {
    try
    {
      HtmlEmail email = new HtmlEmail();
      email.setSSLOnConnect(true);
      email.setHostName("smtp.gmail.com");
      email.setSslSmtpPort("465");
      email.setAuthenticator(new DefaultAuthenticator("furtadoantivirus@gmail.com", VariaveisDeControle.senha));
      email.setFrom(VariaveisDeControle.email);
      StringBuilder builder = new StringBuilder();
      return email;
    } catch (EmailException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao tentar conexão ao email: " + ex.getMessage());
    }
    return null;
  }
}
