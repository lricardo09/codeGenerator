package com.easyjava.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ConstantsClassGenerator {
    public static void main(String[] args) {
        generate();
    }
    static void generate() {
        String propertyFilePath = "D:\\PROJECT\\workspace-mybatisCodeGeneraor\\Generaor\\src\\main\\resources\\application.properties";
        String outputPath="D:\\PROJECT\\workspace-mybatisCodeGeneraor\\Generaor\\src\\main\\java\\com\\easyjava\\bean\\ConstantsCopyMirror.java";
        try {
            File file = new File(outputPath);
            if (!file.exists()){
                file.createNewFile();
            }
            Charset charset = Charset.forName("UTF-8");
            InputStream is =new FileInputStream(propertyFilePath);
            OutputStream os = new FileOutputStream(file);
            BufferedReader bufferedReader;
            BufferedWriter bufferedWriter;
            bufferedReader = new BufferedReader(new InputStreamReader(is,charset));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,charset));
            String str;
            List<String> variableNameList = new ArrayList<String>();
            List<String> propertyNameList = new ArrayList<String>();
            List<String> booleanTypePropertyNameList = new ArrayList<String>();
            List<String> booleanTypeVariableNameList = new ArrayList<String>();
            bufferedWriter.write("package com.easyjava.bean;\n" +
                    "\n" +
                    "import com.easyjava.utils.PropertyUtils;\n" +
                    "\n" +
                    "public class ConstantsCopyMirror {\n");
            while ((str = bufferedReader.readLine()) != null) {
                if (str.startsWith("#")|| StringUtils.isEmpty(str)) {
                    continue;
                }
                str = str.trim();
                String[] ls = str.split("=");
                if (ls[1].trim().equalsIgnoreCase("true")||ls[1].trim().equalsIgnoreCase("false")){
                    bufferedWriter.write("public static final boolean " + toConstantName(ls[0]) + ";");
                }else {
                    bufferedWriter.write("public static final String " + toConstantName(ls[0]) + ";");
                    variableNameList.add(toConstantName(ls[0]));
                }

                if (ls[1].trim().equalsIgnoreCase("true")||ls[1].trim().equalsIgnoreCase("false")){
                    booleanTypePropertyNameList.add(ls[0].trim());
                }else {
                    propertyNameList.add(ls[0].trim());
                }

                bufferedWriter.newLine();
            }
            bufferedWriter.write("static{\n");
            for (int i = 0; i < variableNameList.size(); i++) {
                String variableName = variableNameList.get(i);
                String propertyName = propertyNameList.get(i);
                bufferedWriter.write(variableName + "=PropertyUtils.getProperty(\"" + propertyName + "\");\n");
            }
            for (String variableName:booleanTypePropertyNameList){
                bufferedWriter.write(toConstantName(variableName) + "=Boolean.parseBoolean(PropertyUtils.getProperty(\""+ variableName + "\"));\n");
            }
            bufferedWriter.write("}\n");
            bufferedWriter.write("}");
            bufferedWriter.flush();
        } catch (Exception e) {
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
        try {
            if (Character.isDigit(propertyName.charAt(0))) {
                propertyName = "_" + propertyName;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return propertyName;
    }
}