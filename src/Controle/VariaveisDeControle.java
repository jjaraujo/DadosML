/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Entidades.Produtos;
import Entidades.VendasPendentes;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Joao
 */
public class VariaveisDeControle {

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
    public static Connection CON ;
    public static HashMap<String,Produtos> mapProd;
    public static ArrayList<VendasPendentes> listVen = new ArrayList<>();
    
    public static DefaultComboBoxModel jComboBoxModelDialogVendasPendentes = new DefaultComboBoxModel<VendasPendentes>();
    
    public static void carregarVendasPendentesECodigos() {
        if (!listVen.isEmpty()) {
            codigosCarregadosListVen = false;
            listVen.clear();
            jComboBoxModelDialogVendasPendentes.removeAllElements();
        }
        new InsereCodigoNasVendasParaEnvio().carregaListaVendasPendentes(true);
        new InsereCodigoNasVendasParaEnvio().getCodigosUtilizaveis();
    }
}
