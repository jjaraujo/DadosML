




package Connection;

import Controle.VariaveisDeControle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConnectionFactory {


    public ConnectionFactory(){
    }
    
    public java.sql.Connection getConnection() {
        try {
            Connection con;
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String senha = VariaveisDeControle.senha;
            String usuario = VariaveisDeControle.user;
            con = DriverManager.getConnection(
                    "jdbc:mysql://35.188.13.37/dados_ml", usuario, senha);
            
            return con;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage() + "\nAbra o programa novamente");
            System.exit(0);
        }
        return null;
    }


}
