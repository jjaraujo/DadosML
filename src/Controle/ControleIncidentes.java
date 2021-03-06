package Controle;

import DAO.ClienteDAO;
import DAO.CodigoDAO;
import DAO.IncidentesDAO;
import DAO.VendaDAO;
import EmailConfig.AssuntosEmail;
import EmailConfig.EmailService;
import EmailConfig.MensagensEmail;
import Entidades.Cliente;
import Entidades.Codigos;
import Entidades.Incidentes;
import Entidades.Vendas;
import javax.swing.JOptionPane;








public class ControleIncidentes
{
  public ControleIncidentes() {}
  
  public void encerrarIncidente(String id, String idVenda, boolean substituido)
  {
    Incidentes inc = new IncidentesDAO().getIncidente(id);
    Vendas v = new VendaDAO().getUmaVenda(inc.getId_venda());
    Cliente c = new ClienteDAO().getCliente(v.getApelido_comprador());
    String assunto = new AssuntosEmail().assuntoEncerramentoIncidente(id);
    String codigo = new CodigoDAO().buscaUmCodigo(inc.getId_codigo()).getCodigo();
    String corpo = null;
    if (substituido) {
      corpo = new MensagensEmail().mensagemIncidenteEncerrado(c.getNome(), 3, codigo);
    } else {
      corpo = new MensagensEmail().mensagemIncidenteEncerrado(c.getNome(), inc.getMotivo(), codigo);
    }
    try
    {
      new IncidentesDAO().encerrarIncidente(id);
      try {
        new EmailService(c.getEmail(), assunto, corpo).sendEmail(v.getApelido_comprador());
        if (substituido) {
          new EnviarCodigos().reenviarEmail(inc.getId_venda());
        }
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "O email não foi enviado para o cliente do incidente " + inc.getId());
        new IncidentesDAO().reabrirIncidente(id);
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Não foi possível encerrar o incidente " + inc.getId());
    }
  }
}
