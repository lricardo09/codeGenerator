package com.easyjava.builder;

import com.easyjava.bean.Constants;
import com.easyjava.bean.FieldInfo;
import com.easyjava.bean.TableInfo;
import com.easyjava.utils.PropertyUtils;
import com.easyjava.utils.StringUtils;
import com.google.gson.Gson;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 连接数据库读取信息
 */
public class BuildTable {
    private static final Gson gson = new Gson();

    private static final Logger logger = LoggerFactory.getLogger(BuildTable.class);
    private static Connection connection;
    private static final String SQL_SHOW_TABLE_STATUS = "show table status";
    private static final String SQL_SHOW_TABLE_FIELD = "show full fields from %s";

    private static final String SQL_SHOW_INDEX = "SHOW INDEX FROM %s";
    static {
        try {
            String driverName = PropertyUtils.getProperty("db.driver.name");
            String url = PropertyUtils.getProperty("db.url");
            String username = PropertyUtils.getProperty("db.username");
            String password = PropertyUtils.getProperty("db.password");
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            logger.error("连接数据库失败",e);
        }
    }
    public static List<TableInfo> getTables(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<TableInfo> tableInfos = new ArrayList<>();
        try {
            ps=connection.prepareStatement(SQL_SHOW_TABLE_STATUS);
            rs=ps.executeQuery();
            while (rs.next()){
                String tableName = rs.getString("name");
                String comment = rs.getString("comment");
                String beanName = tableNameAndFieldName2JavaFormat(Constants.IGNORE_TABLE_SUFFIX ?
                        tableName.substring(tableName.indexOf("_")+1):tableName,true);
                String beanParamName = beanName + Constants.BEAN_QUERY_NAME_CLASSNAME_SUFFIX;
                logger.info("\ntableName: {}\ncomment: {}\nbeanName: {}\nbeanParamName: {}\n",tableName,comment,beanName,beanParamName);
                TableInfo tableInfo = new TableInfo();
                tableInfo.setTableName(tableName);
                tableInfo.setBeanName(beanName);
                tableInfo.setComment(comment);
                tableInfo.setBeanParamName(beanParamName);
                readFields(tableInfo);
                readIndexes(tableInfo);
//               logger.info("fieldList对象是:\n\n"+gson.toJson(fieldInfos));
                logger.info("table对象是:\n\n"+gson.toJson(tableInfo));
                tableInfos.add(tableInfo);
            }
        } catch (SQLException e) {
            logger.info("读取表失败",e);
        }finally {
            if (ps!=null){
                try {
                    ps.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (rs!=null){
                try {
                    rs.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return tableInfos;
    }
    public static void readFields(TableInfo tableInfo){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<FieldInfo> fieldInfoList = new ArrayList<FieldInfo>();
        boolean haveDate=false;
        boolean haveDateTime=false;
        try {
            ps=connection.prepareStatement(String.format(SQL_SHOW_TABLE_FIELD,tableInfo.getTableName()));
            rs=ps.executeQuery();
                while (rs.next()){
                    String fieldName = rs.getString("Field");
                    String propertyName = tableNameAndFieldName2JavaFormat(fieldName,false);
                    String sqlType = rs.getString("type");
                    if (sqlType.indexOf("(")!=-1){
                        sqlType=sqlType.substring(0,sqlType.indexOf("("));//类似varchar(255)
                    }
                    String javaType=sqlType2JavaType(sqlType);
                    String comment=rs.getString("comment");
                    String extra=rs.getString("extra");//auto increment
                    FieldInfo fieldInfo = new FieldInfo();
                    fieldInfo.setFieldName(fieldName);
                    fieldInfo.setPropertyName(propertyName);
                    fieldInfo.setComment(comment);
                    fieldInfo.setSqlType(sqlType);
                    fieldInfo.setJavaType(javaType);
                    fieldInfo.setAutoIncrement("auto_increment".equalsIgnoreCase(extra));

                    //顺便设置table的属性
                    if (ArrayUtils.contains(Constants.SQL_DATE_TIME_TYPE,sqlType)){
                        haveDateTime=true;
                    }
                    if (ArrayUtils.contains(Constants.SQL_DATE_TYPE,sqlType)){
                        haveDate=true;
                    }
                    if (ArrayUtils.contains(Constants.SQL_DECIMAL_TYPE,sqlType)){
                        tableInfo.setHaveBigDecimal(true);
                    }
                    if (ArrayUtils.contains(Constants.SQL_DATE_TYPE,sqlType)||ArrayUtils.contains(Constants.SQL_DATE_TIME_TYPE,sqlType)){
                        FieldInfo extendField1 = new FieldInfo();
                        extendField1.setPropertyName(propertyName+Constants.BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_START);
                        extendField1.setJavaType("String");
                        extendField1.setFieldName(fieldName);
                        extendField1.setSqlType(sqlType);
                        FieldInfo extendField2 = new FieldInfo();
                        extendField2.setPropertyName(propertyName+Constants.BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_END);
                        extendField2.setJavaType("String");
                        extendField2.setFieldName(fieldName);
                        extendField2.setSqlType(sqlType);
                        tableInfo.getExtendQueryList().add(extendField1);
                        tableInfo.getExtendQueryList().add(extendField2);
                    }
                    if (ArrayUtils.contains(Constants.SQL_STRING_TYPE,sqlType)){
                        FieldInfo extendField = new FieldInfo();
                        extendField.setPropertyName(propertyName+ Constants.BEAN_QUERY_NAME_PROPERTYNAME_STRQUERY_FUZZY);
                        extendField.setJavaType("String");
                        extendField.setFieldName(fieldName);
                        extendField.setSqlType(sqlType);
                        tableInfo.getExtendQueryList().add(extendField);
                    }
                    tableInfo.setHaveDateTime(haveDateTime);
                    tableInfo.setHaveDate(haveDate);
                    fieldInfoList.add(fieldInfo);
                }
                tableInfo.setFieldList(fieldInfoList);
        } catch (SQLException e) {
            logger.info("读取表失败",e);
        }finally {
            if (ps!=null){
                try {
                    ps.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (rs!=null){
                try {
                    rs.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void readIndexes(TableInfo tableInfo){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps=connection.prepareStatement(String.format(SQL_SHOW_INDEX,tableInfo.getTableName()));
            rs=ps.executeQuery();
            while (rs.next()){
                String keyName = rs.getString("key_name");
                String columnName = rs.getString("column_name");
                String nonUnique = rs.getString("non_unique");//不是唯一索引
                if (nonUnique.equals("1")){
                    continue;
                }
                List<FieldInfo> keyFieldList = tableInfo.getKeyIndexMap().get(keyName);
                if (keyFieldList==null){
                    keyFieldList= new ArrayList<>();
                    tableInfo.getKeyIndexMap().put(keyName,keyFieldList);
                }
                for (FieldInfo fieldInfo : tableInfo.getFieldList()){
                    if (fieldInfo.getFieldName().equals(columnName)){
                        keyFieldList.add(fieldInfo);
                    }
                }
            }
        } catch (SQLException e) {
            logger.info("读取表失败",e);
        }finally {
            if (ps!=null){
                try {
                    ps.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (rs!=null){
                try {
                    rs.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    private static String sqlType2JavaType(String sqlType) {
        if (ArrayUtils.contains(Constants.SQL_DATE_TYPE,sqlType) || ArrayUtils.contains(Constants.SQL_DATE_TIME_TYPE,sqlType)){
            return "Date";
        }else if (ArrayUtils.contains(Constants.SQL_INTEGER_TYPE,sqlType)){
            return "Integer";
        }else if (ArrayUtils.contains(Constants.SQL_LONG_TYPE,sqlType)){
            return "Long";
        }else if (ArrayUtils.contains(Constants.SQL_DECIMAL_TYPE,sqlType)){
            return "BigDecimal";
        }else if (ArrayUtils.contains(Constants.SQL_STRING_TYPE,sqlType)){
            return "String";
        }else {
            throw new RuntimeException("无法识别的类型: "+sqlType);
        }
    }

    private static String tableNameAndFieldName2JavaFormat(String name,boolean firstLetterUppercase){
        String[] namePortions = name.split("_");
        StringBuffer buffer = new StringBuffer();
        buffer.append(firstLetterUppercase?
                StringUtils.firstLetter2Uppercase(namePortions[0]):namePortions[0]);
        for (int i=1,len=namePortions.length;i<len;i++){
            buffer.append(StringUtils.firstLetter2Uppercase(namePortions[i]));
        }
        return buffer.toString() ;
    }


}
