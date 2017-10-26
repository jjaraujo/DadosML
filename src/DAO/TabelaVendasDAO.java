package DAO;

import Controle.VariaveisDeControle;
import java.sql.Connection;







public class TabelaVendasDAO
{
  private static Connection con;
  
  public TabelaVendasDAO()
    throws ClassNotFoundException
  {
    con = VariaveisDeControle.CON;
  }
}
