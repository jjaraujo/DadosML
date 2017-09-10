/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 *
 * @author Joao
 */
public class Datas {
    public int getDiasRestantesPartirHoje(String expiracao) {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate hoje = LocalDate.parse(formatarDate.format(date));
        LocalDate dataFim = LocalDate.parse(expiracao);
        return Days.daysBetween(hoje, dataFim).getDays();
    }
}
