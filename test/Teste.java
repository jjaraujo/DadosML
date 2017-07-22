
import DAO.ClienteDAO;
import Visao.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Teste {
static boolean i;
    public static void main(String[] args) throws ClassNotFoundException {
        Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
            String data = formatarDate.format(date);
            System.out.println(data);
}
}
