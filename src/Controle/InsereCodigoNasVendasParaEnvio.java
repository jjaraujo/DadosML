package Controle;

import DAO.CodigoDAO;
import DAO.Codigos_has_vendasDAO;
import DAO.VendasPendentesDAO;
import Entidades.Codigos;
import Entidades.Produtos;
import Entidades.VendasPendentes;
import Visao.Principal;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JTextArea;











public class InsereCodigoNasVendasParaEnvio
{
  private HashMap<Integer, Codigos> total1Ano = new HashMap();
  private HashMap<Integer, Codigos> total2Anos = new HashMap();
  private HashMap<Integer, Codigos> total3Anos = new HashMap();
  private HashMap<Integer, Codigos> kis1ano = new HashMap();
  private HashMap<Integer, Codigos> android1ano = new HashMap();
  private HashMap<Integer, Codigos> small1ano = new HashMap();
  private HashMap<Integer, Codigos> small2anos = new HashMap();
  private HashMap<Integer, Codigos> antivirus1ano = new HashMap();
  
  public InsereCodigoNasVendasParaEnvio() {}
  
  public void carregaListaVendasPendentes(boolean primeiroCarregamento) {
    if ((VariaveisDeControle.listVen.isEmpty()) && (primeiroCarregamento) && (!VariaveisDeControle.listaCarregando)) {
      VariaveisDeControle.listaCarregando = true;
      System.out.println("list carregando: " + VariaveisDeControle.listaCarregando);
       Principal.setTextArea("Carregando lista de vendas\n");
      VariaveisDeControle.listVen = new VendasPendentesDAO().getVendasPendentes();
      Principal.setTextArea("Lista de vendas carregada\n");
    }
  }
  
  public void getCodigosUtilizaveis() {
    VariaveisDeControle.carregandoCodigosNasVendas = true;
    CodigoDAO codDAO = new CodigoDAO();
    System.out.println("Vai iniciar a leitura dos codigos utilizaveis");
    Principal.setTextArea(" Vai iniciar a leitura dos codigos utilizaveis \n");
    ArrayList<Codigos> listCod = codDAO.getCodigosUtilizaveis();
    


    for (Codigos cod : listCod) {
      int ano = cod.getDuracao();
      String tipoCod = cod.getTipo();
      int idCod = cod.getId();
      
      switch (ano) {
      case 1: 
        switch (tipoCod.toLowerCase()) {
        case "total": 
          total1Ano.put(Integer.valueOf(idCod), cod);
          break;
        case "kis": 
          kis1ano.put(Integer.valueOf(idCod), cod);
          break;
        case "small": 
          small1ano.put(Integer.valueOf(idCod), cod);
          break;
        case "android": 
          android1ano.put(Integer.valueOf(idCod), cod);
          break;
        case "antivirus": 
          antivirus1ano.put(Integer.valueOf(idCod), cod);
        }
        
        break;
      case 2: 
        switch (tipoCod.toLowerCase()) {
        case "total": 
          total2Anos.put(Integer.valueOf(idCod), cod);
          break;
        case "small": 
          small2anos.put(Integer.valueOf(idCod), cod);
        }
        
        break;
      case 3: 
        total3Anos.put(Integer.valueOf(idCod), cod);
        break;
      default: 
        System.err.println("Nenhum ano");
      }
    }
    setCodigoNaVendaParaEnvio();
  }
  
  private void setCodigoNaVendaParaEnvio()
  {
    HashMap<String, Produtos> mapProd = VariaveisDeControle.mapProd;
    for (VendasPendentes v : VariaveisDeControle.listVen) {
      Produtos prod = (Produtos)mapProd.get(v.getIdProduto());
      System.out.println("Carregando código na venda VendasPendentes: " + v.getId_venda() + ". Tipo: " + prod.getTipo() + " Anos " + prod.getAnos());
      Principal.setTextArea("Carregando código na venda VendasPendentes: " + v.getId_venda() + "\n");
      int ano = prod.getAnos();
      ArrayList<Codigos> setCodEnviados = new Codigos_has_vendasDAO().getCodigosJaEnviadosParaOCliente(v.getApelido());
      
      switch (ano) {
      case 1: 
        switch (prod.getTipo().toLowerCase()) {
        case "total": 
          verificaSeOCodigoPodeSerAdicionadoNaVenda(v, total1Ano, setCodEnviados);
          break;
        case "kis": 
          verificaSeOCodigoPodeSerAdicionadoNaVenda(v, kis1ano, setCodEnviados);
          break;
        case "android": 
          verificaSeOCodigoPodeSerAdicionadoNaVenda(v, android1ano, setCodEnviados);
          break;
        case "antivirus": 
          verificaSeOCodigoPodeSerAdicionadoNaVenda(v, antivirus1ano, setCodEnviados);
          break;
        case "small": 
          verificaSeOCodigoPodeSerAdicionadoNaVenda(v, small1ano, setCodEnviados);
        }
        
        break;
      case 2: 
        switch (prod.getTipo().toLowerCase()) {
        case "total": 
        case "kis": 
          verificaSeOCodigoPodeSerAdicionadoNaVenda(v, total2Anos, setCodEnviados);
          break;
        
        case "small": 
          verificaSeOCodigoPodeSerAdicionadoNaVenda(v, small2anos, setCodEnviados);
        }
        
        break;
      case 3: 
        verificaSeOCodigoPodeSerAdicionadoNaVenda(v, total3Anos, setCodEnviados);
      }
      
    }
    
    VariaveisDeControle.listaCarregando = false;
    VariaveisDeControle.codigosCarregadosListVen = true;
    VariaveisDeControle.carregandoCodigosNasVendas = false;
  }
  
  private VendasPendentes verificaSeOCodigoPodeSerAdicionadoNaVenda(VendasPendentes v, HashMap<Integer, Codigos> mapTipoEAnoCodigo, ArrayList<Codigos> array) {
    Set<Integer> codSet = mapTipoEAnoCodigo.keySet();
    ArrayList<Integer> cod = new ArrayList();
    cod.addAll(codSet);
    Collections.sort(cod);
    for (Integer i : cod) {
      Codigos c = (Codigos)mapTipoEAnoCodigo.get(i);
      int qtd_dispositivos = ((Produtos)VariaveisDeControle.mapProd.get(v.getIdProduto())).getQtd() * v.getQtd();
      if ((!array.contains(c)) || (c.getDispositivos() < qtd_dispositivos)) {
        v.setIdCodigo(c.getId());
        v.setCodigo(c.getCodigo());
        c.setQtd_usada(c.getQtd_usada() + qtd_dispositivos);
        return v;
      }
    }
    if (v.getCodigo() == null) {
      System.err.println("Não foi possível adicionar o código na venda " + v.getId_venda());
      Principal.setTextArea("Erro ============> Não foi possível adicionar o código na venda " + v.getId_venda()+"\n");
      return null;
    }
    return null;
  }
}
