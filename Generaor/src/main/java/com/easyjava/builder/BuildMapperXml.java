package com.easyjava.builder;

import com.easyjava.bean.Constants;
import com.easyjava.bean.FieldInfo;
import com.easyjava.bean.TableInfo;
import com.easyjava.utils.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BuildMapperXml {
    private static final Logger logger = LoggerFactory.getLogger(BuildMapperXml.class);

    public static void execute(TableInfo table) {
        File directory = new File(Constants.PATH_MAPPER_XML);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String classname = table.getBeanName() + Constants.MAPPER_NAME_SUFFIX;
        File xmlFile = new File(directory, classname + ".xml");
        OutputStream out = null;
        OutputStreamWriter outw = null;
        BufferedWriter bw = null;
        try {
            out = new FileOutputStream(xmlFile);
            outw = new OutputStreamWriter(out, "UTF-8");
            bw = new BufferedWriter(outw);
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            //写入mybatis的xml配置文件模板
            bw.write("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\n" +
                    " \t\t\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n");
            bw.write("<mapper namespace=\"" + Constants.PACKAGE_MAPPER + "." + classname + "\">\n");
            String poClass = Constants.PACKAGE_PO + "." + table.getBeanName();
            //base_result_map
            bw.write("\t<resultMap id=\"base_result_map\" type=\"" + poClass + "\">");
            bw.newLine();
            FieldInfo primaryField = null;
            for (Map.Entry<String, List<FieldInfo>> entry : table.getKeyIndexMap().entrySet()) {
                if (entry.getKey().equalsIgnoreCase("PRIMARY") && entry.getValue().size() < 2) {
                    primaryField = entry.getValue().get(0);
                    break;
                }
            }
            for (FieldInfo field : table.getFieldList()) {
                bw.write("\t\t<!--" + field.getComment() + "-->");
                bw.newLine();
                if (primaryField != null && primaryField.getPropertyName().equals(field.getPropertyName())) {
                    bw.write("\t\t<id column=\"" + field.getFieldName() + "\" property=\"" + field.getPropertyName() + "\"/>");
                } else {
                    bw.write("\t\t<result column=\"" + field.getFieldName() + "\" property=\"" + field.getPropertyName() + "\"/>");
                }
                bw.newLine();
            }

            bw.write("\t</resultMap>\n");
            //base_column_list
            StringBuffer sb = new StringBuffer();
            bw.write("\t<sql id=\"base_column_list\">\n\t\t");
            for (FieldInfo field : table.getFieldList()) {
                sb.append(field.getFieldName() + ",");
            }
            String s = sb.substring(0, sb.lastIndexOf(","));
            bw.write(s);
            bw.newLine();
            bw.write("\t</sql>");
            //base_condition_list
            bw.write("\n\t<sql id=\"base_condition_list\">\n");
            Iterator<FieldInfo> iterator = table.getFieldList().iterator();
            while (iterator.hasNext()) {
                FieldInfo field = iterator.next();
                boolean hasStr = ArrayUtils.contains(Constants.SQL_STRING_TYPE, field.getSqlType());
                if (hasStr) {
                    bw.write("\t\t<if test=\"query." + field.getPropertyName() + " != null and " + field.getPropertyName() + "!=''\">" +
                            "\n\t\t\tand query." + field.getFieldName() +
                            "=#{query." + field.getPropertyName() + "}\n\t\t</if>\n");
                } else {
                    bw.write("\t\t<if test=\"query." + field.getPropertyName() + " != null\">" +
                            "\n\t\t\tand " + field.getFieldName() +
                            "=#{query." + field.getPropertyName() + "}\n\t\t</if>\n");
                }
            }
            bw.write("\t</sql>");
            //query_condition_list
            bw.write("\n\t<sql id=\"query_condition_list\">\n");
            Iterator<FieldInfo> extendFIterator = table.getExtendQueryList().iterator();
            while (extendFIterator.hasNext()) {
                FieldInfo field = extendFIterator.next();
                if (ArrayUtils.contains(Constants.SQL_STRING_TYPE, field.getSqlType())) {
                    if (field.getPropertyName().endsWith(Constants.BEAN_QUERY_NAME_PROPERTYNAME_STRQUERY_FUZZY)) {
                        bw.write("\t\t<if test=\"query." + field.getPropertyName() + " != null and query." + field.getPropertyName() + "!=''\">" +
                                "\n\t\t\tand " + field.getFieldName() + " like concat('%', #{query." + field.getPropertyName() + "}" + ", '%')" +
                                "\n\t\t</if>\n");
                    }
                }
                if (ArrayUtils.contains(Constants.SQL_DATE_TYPE, field.getSqlType())) {
                    if (field.getPropertyName().endsWith(Constants.BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_START)) {
                        bw.write("\t\t<if test=\"query." + field.getPropertyName() + " != null and query." + field.getPropertyName() + "!=''\">" +
                                "\n\t\t\t<![CDATA[ and " + field.getFieldName() + " > str_to_date(#{query." + field.getPropertyName() + "}, '%Y-%m-%d')" +
                                "]]>\n\t\t</if>\n");//<![CDATA[ ]]>
                    }
                    else if (field.getPropertyName().endsWith(Constants.BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_END)) {
                        bw.write("\t\t<if test=\"query." + field.getPropertyName() + " != null and query." + field.getPropertyName() + "!=''\">" +
                                "\n\t\t\t<![CDATA[ and " + field.getFieldName() + " < DATE_SUB( str_to_date(#{query." + field.getPropertyName() + "}, '%Y-%m-%d'), interval -1 DAY)" +
                                "]]>\n\t\t</if>\n");//<![CDATA[ ]]>
                    }
                }
                if (ArrayUtils.contains(Constants.SQL_DATE_TIME_TYPE, field.getSqlType())){
                    if (field.getPropertyName().endsWith(Constants.BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_START)) {
                        bw.write("\t\t<if test=\"query." + field.getPropertyName() + " != null and query." + field.getPropertyName() + "!=''\">" +
                                "\n\t\t\t<![CDATA[ and " + field.getFieldName() + " > str_to_date(#{query." + field.getPropertyName() + "}, '%Y-%m-%d %H:%m:%s')" +
                                "]]>\n\t\t</if>\n");//<![CDATA[ ]]>
                    }
                    else if (field.getPropertyName().endsWith(Constants.BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_END)) {
                        bw.write("\t\t<if test=\"query." + field.getPropertyName() + " != null and query." + field.getPropertyName() + "!=''\">" +
                                "\n\t\t\t<![CDATA[ and " + field.getFieldName() + " < DATE_SUB( str_to_date(#{query." + field.getPropertyName() + "}, '%Y-%m-%d %H:%m:%s'), interval -1 DAY)" +
                                "]]>\n\t\t</if>\n");//<![CDATA[ ]]>
                    }
                }
            }
            bw.write("\t</sql>\n");
            //base_condition
            bw.write("\t<sql id=\"base_condition\">\n");
            bw.write("\t\t<where>\n");
            bw.write("\t\t\t<include refid=\"base_condition_list\"/>\n");
            bw.write("\t\t</where>\n");
            bw.write("\t</sql>\n");
            //base_condition_extend
            bw.write("\t<sql id=\"base_condition_extend\">\n");
            bw.write("\t\t<where>\n");
            bw.write("\t\t\t<include refid=\"base_condition_list\"/>\n");
            bw.write("\t\t\t<include refid=\"query_condition_list\"/>\n");
            bw.write("\t\t</where>\n");
            bw.write("\t</sql>\n");
            bw.newLine();
            //selectList
            bw.write("\t<select id=\"selectList\" resultMap=\"base_result_map\">\n");
            bw.write("\t\tSELECT\n" +
                    "\t\t<include refid=\"base_column_list\"/>\n" +
                    "\t\tFROM "+table.getTableName()+"\n" +
                    "\t\t<include refid='base_condition_extend'/>\n" +
                    "\t\t<if test=\"query.orderBy!=null and query.orderBy!=''\">\n\t\t\tORDER BY ${query.orderBy}</if>\n" +
                    "\t\tlimit ${query.simplePage.start},${query.simplePage.end}\n");
            bw.write("\t</select>\n");
            //select count
            bw.write("\t<select id=\"selectCount\" resultType=\"java.lang.Integer\" >\n");
            bw.write("\t\tSELECT\n" +
                    "\t\tCOUNT(1)\n" +
                    "\t\tFROM "+table.getTableName()+"\n" +
                    "\t\t<include refid=\"base_condition_extend\"/>\n");
            bw.write("\t</select>\n");
            //insert
            bw.write("\t<insert id=\"insert\" parameterType=\""+Constants.PACKAGE_PO+"."+ table.getBeanName()+"\">\n");
            bw.write("\t\tINSERT INTO "+table.getTableName()+"\n");
            bw.write("\t\t<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n");
            for(FieldInfo field: table.getFieldList()){
                bw.write("\t\t\t<if test=\"bean."+field.getPropertyName()+"!=null\">" +
                        field.getFieldName()+",</if>\n");
            }
            bw.write("\t\t</trim>\n");
            bw.write("\t\tVALUES\n");
            bw.write("\t\t<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n");
            StringBuffer str=new StringBuffer();
            for(FieldInfo field: table.getFieldList()){
                str.append("\t\t\t<if test=\"bean."+field.getPropertyName()+"!=null\">" +
                        "#{bean."+field.getPropertyName()+"},</if>\n");
            }
            bw.write(str.toString());
            bw.write("\t\t</trim>\n");
            FieldInfo autoIncrementField = null;
            for (FieldInfo field: table.getFieldList()){
                if (field.getAutoIncrement()){
                    autoIncrementField = field;
                    break;
                }
            }
            if (autoIncrementField!=null){
                bw.write("\t\t<selectKey keyProperty=\"bean."+autoIncrementField.getPropertyName()+"\" order=\"AFTER\" resultType=\"java.lang.Integer\">\n" +
                        "\t\tSELECT LAST_INSERT_ID()\n\t\t</selectKey>\n" );
            }
            bw.write("\t</insert>\n");
            bw.write("</mapper>");
            bw.flush();

        } catch (Exception e) {
            logger.error("生成{}表的MapperXml文件失败", table.getTableName(), e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (outw != null) {
                try {
                    outw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
