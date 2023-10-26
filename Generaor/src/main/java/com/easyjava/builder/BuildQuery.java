package com.easyjava.builder;

import com.easyjava.bean.Constants;
import com.easyjava.bean.FieldInfo;
import com.easyjava.bean.TableInfo;
import com.easyjava.utils.DateUtils;
import com.easyjava.utils.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;


public class BuildQuery {
    private static final Logger logger = LoggerFactory.getLogger(BuildQuery.class);

    /**
     * 生成query类
     *
     * @param table
     */
    public static void execute(TableInfo table) {
        File folder = new File(Constants.PATH_QUERY);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File poFile = new File(folder, table.getBeanParamName() + ".java");
        OutputStream out = null;
        OutputStreamWriter outw = null;
        BufferedWriter bw = null;
        try {
            out = new FileOutputStream(poFile);
            outw = new OutputStreamWriter(out, "UTF-8");
            bw = new BufferedWriter(outw);
            bw.write("package " + Constants.PACKAGE_QUERY + ";");
            bw.newLine();
            bw.newLine();
            if (table.haveDate() || table.haveDateTime()){
                bw.newLine();
                bw.write("import java.util.Date;");
            }
            if (table.haveBigDecimal()){
                bw.newLine();
                bw.write("import java.math.BigDecimal;");
            }
            bw.newLine();
            BuildComment.createClassComment(bw, table.getComment());
            bw.write("public class " + table.getBeanParamName() +" extends BaseQuery {");
            bw.newLine();
            ArrayList<FieldInfo> dateTypePropertyList = new ArrayList<>();
            ArrayList<FieldInfo> strTypePropertyList = new ArrayList<>();
            for (FieldInfo fieldInfo : table.getFieldList()) {
                BuildComment.createFieldComment(bw, fieldInfo.getComment());
                bw.write("\tprivate "+fieldInfo.getJavaType()+" "+fieldInfo.getPropertyName()+";");
                bw.newLine();
                if (ArrayUtils.contains(Constants.SQL_DATE_TYPE,fieldInfo.getSqlType())
                        ||ArrayUtils.contains(Constants.SQL_DATE_TIME_TYPE,fieldInfo.getSqlType())){
                    bw.write("\tprivate "+"String"+" "+fieldInfo.getPropertyName()+Constants.BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_START+";");
                    bw.newLine();
                    bw.write("\tprivate "+"String"+" "+fieldInfo.getPropertyName()+Constants.BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_END+";");
                    dateTypePropertyList.add(fieldInfo);
                } else if (ArrayUtils.contains(Constants.SQL_STRING_TYPE, fieldInfo.getSqlType())) {
                    bw.write("\tprivate "+"String"+" "+fieldInfo.getPropertyName()+Constants.BEAN_QUERY_NAME_PROPERTYNAME_STRQUERY_FUZZY+";");
                    strTypePropertyList.add(fieldInfo);
                }
                bw.newLine();
            }
            //普通属性 set get 方法
            for (FieldInfo field: table.getFieldList()){
                bw.write("\tpublic void set"+ StringUtils.firstLetter2Uppercase(field.getPropertyName())
                        +"("+field.getJavaType()+" "+field.getPropertyName()+") {");
                bw.newLine();
                bw.write("\t\tthis."+field.getPropertyName()+" = "+field.getPropertyName()+";");
                bw.newLine();
                bw.write("\t}");
                bw.newLine();
                bw.newLine();
                bw.write("\tpublic "+field.getJavaType()+" get"+ StringUtils.firstLetter2Uppercase(field.getPropertyName())
                        +"() {");
                bw.newLine();
                bw.write("\t\treturn this."+field.getPropertyName()+';');
                bw.newLine();
                bw.write("\t}");
                bw.newLine();
                bw.newLine();
            }
            //日期查询属性set get
            for (FieldInfo field:dateTypePropertyList){
                //start
                String strXXXStart=field.getPropertyName()+Constants.BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_START;
                String strXXXEnd=field.getPropertyName()+Constants.BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_END;
                bw.write("\tpublic void set"+ StringUtils.firstLetter2Uppercase(strXXXStart)
                        +"("+"String"+" "+strXXXStart+") {");
                bw.newLine();
                bw.write("\t\tthis."+strXXXStart+" = "+strXXXStart+";");
                bw.newLine();
                bw.write("\t}");
                bw.newLine();
                bw.newLine();
                bw.write("\tpublic "+"String"+" get"+ StringUtils.firstLetter2Uppercase(strXXXStart)
                        +"() {");
                bw.newLine();
                bw.write("\t\treturn this."+strXXXStart+';');
                bw.newLine();
                bw.write("\t}");
                bw.newLine();
                //end
                bw.write("\tpublic void set"+ StringUtils.firstLetter2Uppercase(strXXXEnd)
                        +"("+"String"+" "+strXXXEnd+") {");
                bw.newLine();
                bw.write("\t\tthis."+strXXXEnd+" = "+strXXXEnd+";");
                bw.newLine();
                bw.write("\t}");
                bw.newLine();
                bw.newLine();
                bw.write("\tpublic "+"String"+" get"+ StringUtils.firstLetter2Uppercase(strXXXEnd)
                        +"() {");
                bw.newLine();
                bw.write("\t\treturn this."+strXXXEnd+';');
                bw.newLine();
                bw.write("\t}");
                bw.newLine();
                bw.newLine();
            }
            //query属性 set get方法
            for (FieldInfo field:strTypePropertyList){
                String strXXXFuzzy=field.getPropertyName()+Constants.BEAN_QUERY_NAME_PROPERTYNAME_STRQUERY_FUZZY;
                bw.write("\tpublic void set"+ StringUtils.firstLetter2Uppercase(strXXXFuzzy)
                        +"("+"String"+" "+strXXXFuzzy+") {");
                bw.newLine();
                bw.write("\t\tthis."+strXXXFuzzy+" = "+strXXXFuzzy+";");
                bw.newLine();
                bw.write("\t}");
                bw.newLine();
                bw.newLine();
                bw.write("\tpublic "+"String"+" get"+ StringUtils.firstLetter2Uppercase(strXXXFuzzy)
                        +"() {");
                bw.newLine();
                bw.write("\t\treturn this."+strXXXFuzzy+';');
                bw.newLine();
                bw.write("\t}");
                bw.newLine();
            }
            bw.write("}");
            bw.flush();
        } catch (Exception e) {
            logger.error("生成{}表的query类失败" ,table.getTableName(),e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
//            if (outw != null) {
//                try {
//                    outw.close();
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }


    }
}
