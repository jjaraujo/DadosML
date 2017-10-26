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
import Visao.InternalFrameVendas;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;















public class EnviosManuaisControle
{
  public EnviosManuaisControle() {}
  
  public void gerarIncidente(JTable jTableVendas, String idvenda, JTextField jTextFieldInformacaoAdicional)
  {
    Incidentes inc = new Incidentes();
    int i = jTableVendas.getSelectedRow();
    inc.setId_venda(idvenda);
    int motivo = InternalFrameVendas.motivo;
    if (motivo > 0) {
      Date date = new Date(System.currentTimeMillis());
      SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
      String codigo = (String)jTableVendas.getValueAt(i, 4);
      int countIncidentes = new IncidentesDAO().getCountIncidentes();
      inc.setDataIncidente(formatarDate.format(date));
      inc.setId("INC" + inc.getId_venda() + "00" + countIncidentes);
      inc.setMotivo(motivo);
      inc.setAnotacoes(jTextFieldInformacaoAdicional.getText());
      inc.setId_codigo(new CodigoDAO().getCodigosPorCodigo(codigo).getId());
      if (new IncidentesDAO().addIncidente(inc, idvenda)) {
        try {
          Vendas v = new VendaDAO().getUmaVenda(inc.getId_venda());
          Cliente c = new ClienteDAO().getCliente(v.getApelido_comprador());
          String assunto = new AssuntosEmail().assuntoAberturaIncidente(inc.getId());
          String corpo = new MensagensEmail().mensagemIncidenteAdicionado(c.getNome(), inc.getId());
          new EmailService(c.getEmail(), assunto, corpo).sendEmail(v.getApelido_comprador());
          JOptionPane.showMessageDialog(null, "Incidente adicionado!");
        } catch (Exception e) {
          new IncidentesDAO().deleteIncidente(inc.getId());
          JOptionPane.showMessageDialog(null, "O email não foi enviado para o cliente do incidente " + inc.getId());
          e.printStackTrace();
        }
      }
    } else {
      JOptionPane.showMessageDialog(null, "Motivo inválido");
    }
  }
}
