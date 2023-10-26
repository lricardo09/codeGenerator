package com.easyjava.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static final String YYYY_MM_DD="yy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS="yy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat formatter=new SimpleDateFormat(YYYY_MM_DD);
    public static String formatDate(Date date){
        return formatter.format(date);
    }
    public static Date parseDate(String date,String pattern){
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(formatDate(new Date()));
    }
}
