/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSON;

import Entidades.Cliente;
import Entidades.Vendas;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import javax.swing.JOptionPane;


/**
 *
 * @author HP
 */
public class LeituraJson {
    
    public ArrayList<Vendas> lerJsonVendas(String s){
        Gson gson = new Gson();
        try{
        Type collectionType = new TypeToken<ArrayList<Vendas>>(){}.getType();
        ArrayList<Vendas> vendasSet = gson.fromJson(s, collectionType);
        return  vendasSet;
        } catch(JsonSyntaxException e){
            JOptionPane.showMessageDialog(null, "Erro em ler JSON.LeituraJson().lerJsonVendas"+ "\n Erro:" + e.getMessage());
            return null;
        }
    }    
    public HashSet<Cliente> lerJsonClientes(String s){
        Gson gson = new Gson();
        try{
        Type collectionType = new TypeToken<HashSet<Cliente>>(){}.getType();
        HashSet<Cliente> clientesSet = gson.fromJson(s, collectionType);
        return clientesSet;
        } catch(JsonSyntaxException e){
            JOptionPane.showMessageDialog(null, "Erro em JSON.LeituraJson().lerJsonClientes" + "\n Erro:" + e.getMessage());
            return null;
        }
    }
}
