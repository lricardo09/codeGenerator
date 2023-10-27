package com.easyjava.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtils {
    private static final Object lockObj = new Object();
    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<>();

    private static SimpleDateFormat getSdf(String pattern) {
        ThreadLocal<SimpleDateFormat> t = sdfMap.get(pattern);
        if (t == null) {
            synchronized (lockObj) {
                t = ThreadLocal.withInitial(() -> new SimpleDateFormat(pattern));
                sdfMap.put(pattern, t);
            }
        }
        return t.get();
    }

    public static String format(Date date, String pattern) {
        return getSdf(pattern).format(date);
    }

    public static Date parse(String date, String pattern) {
        try {
            return getSdf(pattern).parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
