/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.LocalDate;

/**
 *
 * @author HP  META-INF.maven.org.mortbay.jetty.servlet-api-2.5
 */
public class Janela {
    
        public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate hoje = LocalDate.parse(formatarDate.format(date));
            System.out.println(hoje.plusDays(15).toString());
                }}
