package com.co.hsg.innventa.backing.util;

/**
 *
 * @author hectsaga
 */
public class Utils {
    public static String capitalizes(String value){
       return value.substring(0, 1).toUpperCase()
                    + value.substring(1).toLowerCase();
    }
}