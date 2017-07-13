
import DAO.ClienteDAO;
import Visao.Principal;
import javax.swing.JOptionPane;

public class Teste {
static boolean i;
    public static void main(String[] args) throws ClassNotFoundException {
        new Principal().dialogAutenticacao();
            String s = JOptionPane.showInputDialog(null, "Numero :" + new ClienteDAO().buscaCliente("SFVFLA").getTelefone()+ "\nDeseja adicionar outro?(Deixe em branco caso não)","Confirmar numero de telefone");
            System.out.println(s);
    }
}
