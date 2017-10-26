package Controle;

import DAO.ProdutosDAO;
import Entidades.Produtos;
import Entidades.VendasPendentes;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;
import org.apache.commons.mail.HtmlEmail;

public abstract class VariaveisDeControle {

    public static boolean codigosCarregadosListVen;
    public static boolean carregandoCodigosNasVendas;
    public static boolean listaCarregando;
    public static boolean carregamentoCodigoManual;
    public static boolean frameVendasAberto;
    public static boolean frameAnaliseVendasAberto;
    public static boolean frameCadastroClienteAberto;
    public static boolean frameJsonAberto;
    public static boolean frameEnvioManualAberto;
    public static boolean frameCodigosAberto;
    public static boolean frameModificarVendaAberto;
    public static boolean frameCadVenOutroMeioAberto;
    public static String user = "";
    public static String senha = "";
    public static Connection CON;
    public static HashMap<String, Produtos> mapProd;
    public static ArrayList<VendasPendentes> listVen = new ArrayList();
    public static String email = "vendas@ksafe.com.br";
    public static DefaultComboBoxModel jComboBoxModelDialogVendasPendentes = new DefaultComboBoxModel();
    public static DefaultListModel jModelList = new DefaultListModel();
    public static int indexItemSelecionado;
    public static VendasPendentes vendaSelecionado;
    
    public VariaveisDeControle() {
    }

    public static void carregarVendasPendentesECodigos() {
        if (!listVen.isEmpty()) {
            codigosCarregadosListVen = false;
            listVen.clear();
            jComboBoxModelDialogVendasPendentes.removeAllElements();
        }
        new InsereCodigoNasVendasParaEnvio().carregaListaVendasPendentes(true);
        new InsereCodigoNasVendasParaEnvio().getCodigosUtilizaveis();
    }

    public static HtmlEmail htmlEmail;

    public static void atualizaMapProdutos() {
        mapProd = new ProdutosDAO().getProdutosMap();
    }
    
}
