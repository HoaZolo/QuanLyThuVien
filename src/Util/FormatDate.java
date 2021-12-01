/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WIN1064
 */
public class FormatDate {
    public static String format(String s){
        String str = "";
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(s);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            str = sdf.format(date);
        } catch (ParseException ex) {
            Logger.getLogger(FormatDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }
}
