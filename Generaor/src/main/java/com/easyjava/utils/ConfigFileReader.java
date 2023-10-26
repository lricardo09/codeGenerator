package com.easyjava.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ConfigFileReader {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\PROJECT\\workspace-mybatisCodeGeneraor\\Generaor\\src\\main\\resources\\application.properties"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 忽略注释
                if (line.startsWith("#")) {
                    continue;
                }
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    String propertyName = parts[0].trim();
                    String propertyValue = parts[1].trim();

                    // 改写属性名为Java静态常量的命名规则
                    String constantName = toConstantName(propertyName);

                    System.out.println("Original Property Name: " + propertyName);
                    System.out.println("Constant Name: " + constantName);
                    System.out.println("Property Value: " + propertyValue);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 将属性名改写为Java静态常量的命名规则
    private static String toConstantName(String propertyName) {
        // 移除非法字符
        propertyName = propertyName.replaceAll("[^a-zA-Z0-9_]", "_");
        // 转为大写
        propertyName = propertyName.toUpperCase();
        // 如果以数字开头，在前面加上下划线
        if (Character.isDigit(propertyName.charAt(0))) {
            propertyName = "_" + propertyName;
        }
        return propertyName;
    }
}
