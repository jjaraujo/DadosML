package Controle;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.Days;
import org.joda.time.LocalDate;






public class Datas
{
  public Datas() {}
  
  public int getDiasRestantesPartirHoje(String expiracao)
  {
    Date date = new Date(System.currentTimeMillis());
    SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
    LocalDate hoje = LocalDate.parse(formatarDate.format(date));
    LocalDate dataFim = LocalDate.parse(expiracao);
    return Days.daysBetween(hoje, dataFim).getDays();
  }
}
