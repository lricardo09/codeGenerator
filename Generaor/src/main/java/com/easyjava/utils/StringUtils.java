package com.easyjava.utils;

import com.easyjava.bean.Constants;

public class StringUtils {
    public static String firstLetter2Uppercase(String str){
        StringBuffer buffer = new StringBuffer();
        buffer.append(Character.toUpperCase(str.charAt(0)));
        buffer.append(str.substring(1));
        return buffer.toString();
    }
}
