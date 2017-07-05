/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Controle.VariaveisDeControle;
import Entidades.QtdUsoCodigos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QtdUsoCodigosDAO {

   private Connection con;

    public QtdUsoCodigosDAO() {
            con = VariaveisDeControle.CON;
    }

    public QtdUsoCodigos getQtdUsada() {
        PreparedStatement stmt;
        QtdUsoCodigos qtd = new QtdUsoCodigos();
        try {
            stmt = con.prepareStatement("select * from qtd_uso_cods;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                qtd.setQtdMaxKis(rs.getInt("KIS1_disp"));
                qtd.setDiasMaxKis1A(rs.getInt("KIS1_dias"));
                qtd.setDiasMaxTotal1A(rs.getInt("TOTAL1_dias"));
                qtd.setDiasMaxTotal2A(rs.getInt("TOTAL2_dias"));
                qtd.setDiasMaxTotal3A(rs.getInt("TOTAL3_dias"));
                qtd.setDiasMaxSmall1A(rs.getInt("SMALL1_dias"));
                qtd.setQtdMaxTotal(rs.getInt("TOTAL1_disp"));
                qtd.setDiasMaxSmall2A(rs.getInt("SMALL2_dias"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QtdUsoCodigosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qtd;
    }
}
