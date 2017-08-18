/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.CodigoDAO;
import DAO.Codigos_has_vendasDAO;
import DAO.ProdutosDAO;
import DAO.VendasPendentesDAO;
import Entidades.Codigos;
import Entidades.Produtos;
import Entidades.VendasPendentes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

/**
 *
 * @author Joao
 */
public class InsereCodigoNasVendasParaEnvio {
    private HashMap<Integer, Codigos> total1Ano = new HashMap<>();
    private HashMap<Integer, Codigos> total2Anos = new HashMap<>();
    private HashMap<Integer, Codigos> total3Anos = new HashMap<>();
    private HashMap<Integer, Codigos> kis1ano = new HashMap<>();
    private HashMap<Integer, Codigos> small1ano = new HashMap<>();
    private HashMap<Integer, Codigos> small2anos = new HashMap<>();


    public void carregaListaVendasPendentes(boolean primeiroCarregamento) {
        //condições para que a listVen seja carregada do dados do banco
        if (VariaveisDeControle.listVen.isEmpty() && primeiroCarregamento && !VariaveisDeControle.listaCarregando) {
            VariaveisDeControle.listaCarregando = true;
            System.out.println("list carregando: " + VariaveisDeControle.listaCarregando);
            VariaveisDeControle.listVen = new VendasPendentesDAO().retornaVendasPendentes();
        }
    }

    public void getCodigosUtilizaveis() {
        VariaveisDeControle.carregandoCodigosNasVendas = true;
        CodigoDAO codDAO = new CodigoDAO();
        System.out.println("Vai iniciar a leitura dos codigos utilizaveis");
        ArrayList<Codigos> listCod = codDAO.getCodigosUtilizaveis();
        int ano;
        int idCod;
        String tipoCod;
        for (Codigos cod : listCod) {
            ano = cod.getDuracao();
            tipoCod = cod.getTipo();
            idCod = cod.getId();
            // condicionais que separa o código em cada map de acordo com o tipo 
            switch (ano) {
                case 1:
                    switch (tipoCod.toLowerCase()) {
                        case "total":
                            total1Ano.put(idCod, cod);
                            break;
                        case "kis":
                        case "android":
                            kis1ano.put(idCod, cod);
                            break;
                        case "small":
                            small1ano.put(idCod, cod);
                            break;
                    }
                    break;
                case 2:
                    switch (tipoCod.toLowerCase()) {
                        case "total":
                            total2Anos.put(idCod, cod);
                            break;
                        case "small":
                            small2anos.put(idCod, cod);
                            break;
                    }
                    break;
                case 3:
                    total3Anos.put(idCod, cod);
                    break;
                default:
                    System.err.println("Nenhum ano");
            }
        }
        setCodigoNaVendaParaEnvio();

    }

    private void setCodigoNaVendaParaEnvio() {
        HashMap<String, Produtos> mapProd = VariaveisDeControle.mapProd;
        for (VendasPendentes v : VariaveisDeControle.listVen) {
            Produtos prod = mapProd.get(v.getIdProduto());
            System.out.println("Carregando código na venda VendasPendentes: " + v.getId_venda() + ". Tipo: " + prod.getTipo() + " Anos " + prod.getAnos());
            int ano = prod.getAnos();
            ArrayList<Codigos> setCodEnviados = new Codigos_has_vendasDAO().getCodigosJaEnviadosParaOCliente(v.getApelido());
            //condicionais que adicionam o codigo na venda de acordo com o tipo de ID
            switch (ano) {
                case 1:
                    switch (prod.getTipo().toLowerCase()) {
                        case "total":                            
                            verificaSeOCodigoPodeSerAdicionadoNaVenda(v, total1Ano, setCodEnviados);
                            break;
                        case "kis":
                        case "android":
                            verificaSeOCodigoPodeSerAdicionadoNaVenda(v, kis1ano, setCodEnviados);
                            break;
                        case "small":
                            verificaSeOCodigoPodeSerAdicionadoNaVenda(v, small1ano, setCodEnviados);
                            break;
                    }
                    break;
                case 2:
                    switch (prod.getTipo().toLowerCase()) {
                        case "total":
                            verificaSeOCodigoPodeSerAdicionadoNaVenda(v, total2Anos, setCodEnviados);
                            break;
                        case "small":
                            verificaSeOCodigoPodeSerAdicionadoNaVenda(v, small2anos, setCodEnviados);
                            break;
                    }
                    break;
                case 3:
                    verificaSeOCodigoPodeSerAdicionadoNaVenda(v, total3Anos, setCodEnviados);
                    break;
                default:
            }
        }
        VariaveisDeControle.listaCarregando = false;
        VariaveisDeControle.codigosCarregadosListVen = true;
        VariaveisDeControle.carregandoCodigosNasVendas = false;
    }

    private VendasPendentes verificaSeOCodigoPodeSerAdicionadoNaVenda(VendasPendentes v, HashMap<Integer, Codigos> mapTipoEAnoCodigo, ArrayList<Codigos> array) {
        Set<Integer> codSet = mapTipoEAnoCodigo.keySet();
        ArrayList<Integer> cod = new ArrayList<>();
        cod.addAll(codSet);
        Collections.sort(cod);
        for (Integer i : cod) {
            Codigos c = (Codigos) mapTipoEAnoCodigo.get(i);
            int qtd_dispositivos = VariaveisDeControle.mapProd.get(v.getIdProduto()).getQtd()*v.getQtd();
            if (!array.contains(c)||c.getDispositivos()<qtd_dispositivos) {
                v.setIdCodigo(c.getId());
                v.setCodigo(c.getCodigo());
                c.setQtd_usada(c.getQtd_usada() + qtd_dispositivos);
                return v;
            }
        }
        if (v.getCodigo() == null) {
            System.err.println("Não foi possível adicionar o código na venda " + v.getId_venda());
            return null;
        }
        return null;
    }
}
