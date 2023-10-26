package com.easyjava.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class PropertyUtils {

    private static final Logger logger = LoggerFactory.getLogger(PropertyUtils.class);
    private static Map<String,String> PROPERTY_MAP = new ConcurrentHashMap<String, String>();
    private static Properties properties = new Properties();

    static {
        InputStream is = null ;
        try {
            is = PropertyUtils.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(is);
            Iterator<Object> iterator = properties.keySet().iterator();
            while (iterator.hasNext()){
                String key = (String) iterator.next();
                PROPERTY_MAP.put(key,properties.getProperty(key));
            }
        } catch (Exception e) {
            logger.error("读取属性配置文件失败",e);
        }finally {
            try {
                if (is!=null){
                    is.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static String getProperty(String key){
        return PROPERTY_MAP.get(key);
    }
}
