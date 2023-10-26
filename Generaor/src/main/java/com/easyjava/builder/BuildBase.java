package com.easyjava.builder;

import com.easyjava.bean.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BuildBase {
    private static final Logger logger = LoggerFactory.getLogger(BuildBase.class);
    public static void execute(){
        //生成enum
        ArrayList<String> heads = new ArrayList<>();
        heads.add(("package "+Constants.PACKAGE_ENUM+";"));
        build(heads,"DateTimePatternEnum",Constants.PATH_ENUM);
        heads.clear();
        //生成日期工具类
        heads.add("package "+Constants.PACKAGE_UTIL+";");
        build(heads,"DateUtils", Constants.PATH_UTIL);
        heads.clear();
        //生成base_mapper
        heads.add("package "+Constants.PACKAGE_MAPPER+";");
        build(heads,"BaseMapper",Constants.PATH_MAPPER);
        heads.clear();
        //PageSize枚举
        heads.add("package "+Constants.PACKAGE_ENUM+";");
        build(heads,"PageSize",Constants.PATH_ENUM);
        heads.clear();
        //BaseQuery类
        heads.add("package "+Constants.PACKAGE_QUERY+";");
        build(heads,"BaseQuery",Constants.PATH_QUERY);
        heads.clear();
        //SimplePage类
        heads.add("package "+Constants.PACKAGE_QUERY+";");
        build(heads,"SimplePage",Constants.PATH_QUERY);
        heads.clear();

    }
    private static void build(List<String> headList,String fileName, String path){
        File folder = new File(path);
        if (!folder.exists()){
            folder.mkdirs();
        }
        File file = new File(folder, fileName + ".java");
        InputStream is=null;
        OutputStream os=null;
        InputStreamReader reader=null;
        OutputStreamWriter writer=null;
        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;
        try {
            is=ClassLoader.getSystemClassLoader().getResourceAsStream("template/"+fileName+".txt");
            reader=new InputStreamReader(is);
            bufferedReader=new BufferedReader(reader);
            os=new FileOutputStream(file);
            writer=new OutputStreamWriter(os);
            bufferedWriter=new BufferedWriter(writer);
            for (String head:headList){
                bufferedWriter.write(head);
                bufferedWriter.newLine();
                if (head.contains("package")){
                    bufferedWriter.newLine();
                }
            }
            String str;
            while ((str=bufferedReader.readLine())!=null){
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        }catch (Exception e){
            logger.error("创建基础类失败",e);
        }
        finally {
            if (is!=null){
                try {
                    is.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (os!=null){
                try {
                    os.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (writer!=null){
                try {
                    writer.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (reader!=null){
                try {
                    reader.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (bufferedWriter!=null){
                try {
                    bufferedWriter.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (bufferedReader!=null){
                try {
                    bufferedReader.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
