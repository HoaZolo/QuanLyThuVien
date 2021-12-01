/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author WIN1064
 */
public class PhoneValidate {
    private Pattern pattern;
    private Matcher matcher;
    private static final String PHONE_PATTERN = 
        "^\\d{10,11}$";

    public PhoneValidate() {
        pattern = Pattern.compile(PHONE_PATTERN);
    }
    public  boolean validate(final String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }
}
