/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.ProdutosDAO;
import DAO.VendaDAO;
import Entidades.Produtos;
import Entidades.Vendas;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author Joao
 */
public class ProgramaFidelidade {

    public void verificaQtdProdutos(String apelido, String email) {
        ArrayList<Vendas> array = new VendaDAO().getVendasClienteNoPrograma(apelido, "2017-06-10");
        int ciclo = (int) Math.ceil((double) array.size() / 5);

        HashMap<String, Integer> map = new HashMap<>();
        array.forEach((v) -> {
            String idProd = v.getIdProduto();
            Produtos p = new ProdutosDAO().retornaProduto(idProd);
            int t = p.getQtd() * v.getQtd();
            if (p.getTipo().toLowerCase().equals("kis") && p.getAnos() == 1) {
               // map.put(19, t);
            } else {
                map.put(idProd, t);
            }
        });
        Set setKey = map.keySet();
        setKey.forEach((Object v) -> {
            String assunto = "Programa de fidelidade - " + apelido + ""
                    + " - Ciclo " + ciclo;
            String corpo = "Sua venda acumulou no seu ciclo. Suas vendas acumuladas são estas: "
                    + "\n"
                    + "\n"
                    + "\n"
                    ;
        });
    }
}
