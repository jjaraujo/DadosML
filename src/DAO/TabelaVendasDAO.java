/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Controle.VariaveisDeControle;
import java.sql.Connection;

/**
 *
 * @author HP
 */
public class TabelaVendasDAO {
        private static Connection con;
        public TabelaVendasDAO() throws ClassNotFoundException{
                    con = VariaveisDeControle.CON;
        }        
}
