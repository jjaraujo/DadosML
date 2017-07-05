/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Controle.VariaveisDeControle;
import Entidades.Atendentes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class AtendentesDAO {

    private static Connection con;

    public AtendentesDAO() throws ClassNotFoundException {
        con = VariaveisDeControle.CON;
    }

    public ArrayList<Atendentes> retornaAtendentes() {
        PreparedStatement stmt;
         ArrayList list = new ArrayList();
        try {
            stmt = con.prepareStatement("select * from atendentes;");

            ResultSet rs = stmt.executeQuery();
            Atendentes atendentes;
            
            while (rs.next()) {
                atendentes = new Atendentes();
                atendentes.setId(rs.getInt("id"));
                atendentes.setNome(rs.getString("nome"));
                atendentes.setPais(rs.getString("pais"));
                list.add(atendentes);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AtendentesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
