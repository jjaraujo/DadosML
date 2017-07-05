/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

/**
 *
 * @author Joao
 */
public class Comparator implements java.util.Comparator<Integer>{
    // outros metodos e atributos

    @Override
    public int compare(Integer i, Integer i1) {
     return i.compareTo(i1);
    }
 
    
}
