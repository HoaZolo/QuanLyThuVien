/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.regex.Pattern;

/**
 *
 * @author WIN1064
 */
public class IntegerValidate {
    private static Pattern pattern = Pattern.compile("^\\d+$");

public static boolean isInteger(String strNum) {
    if (strNum == null) {
        return false; 
    }
    return pattern.matcher(strNum).matches();
}
}
