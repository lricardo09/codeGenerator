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
import java.nio.channels.FileChannel;

/**
 * 这三个类的关系是层次性的，用于将数据从程序写入输出流中，实现数据输出的不同层次或方式：
 * <p>
 * OutputStream（输出流）： OutputStream 是 Java 中用于字节级别的输出流的基类。它负责将字节数据写入底层输出设备或流中。OutputStream 本身是一个抽象类，不能直接实例化，需要通过其子类来实现具体的字节输出功能。
 * <p>
 * OutputStreamWriter（输出流写入器）： OutputStreamWriter 是 OutputStream 的包装类，它将字节数据转换为字符数据，并提供了字符级别的输出功能。它充当了字节流和字符流之间的桥梁。通常，您可以在构造 OutputStreamWriter 时指定字符编码，以便正确地将字节数据转换为字符数据。
 * <p>
 * BufferedWriter（缓冲字符输出流）： BufferedWriter 是 OutputStreamWriter 的包装类，用于提供带有缓冲功能的字符输出。它会缓冲字符数据，以减少频繁的写操作，从而提高输出性能。通常，您可以通过 BufferedWriter 来写入文本文件或字符流，以获得更好的性能。
 * <p>
 * 通常的使用方式是：您创建一个 OutputStream，然后将其传递给 OutputStreamWriter，最后将 OutputStreamWriter 传递给 BufferedWriter，从而实现以字符为单位的文本数据输出，并且具有缓冲功能。
 */

public class BuildPo {
    private static final Logger logger = LoggerFactory.getLogger(BuildPo.class);

    /**
     * 生成po类
     *
     * @param table
     */
    public static void execute(TableInfo table) {
        File folder = new File(Constants.PATH_PO);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File poFile = new File(folder, table.getBeanName() + ".java");
        OutputStream out = null;
        OutputStreamWriter outw = null;
        BufferedWriter bw = null;
        try {
            out = new FileOutputStream(poFile);
            outw = new OutputStreamWriter(out, "UTF-8");
            bw = new BufferedWriter(outw);
            bw.write("package " + Constants.PACKAGE_PO + ";");
            bw.newLine();
            bw.newLine();
            bw.write("import " + "java.io.Serializable;");
            if (table.haveDate() || table.haveDateTime()){
                bw.newLine();
                bw.write("import java.util.Date;");
                bw.newLine();
                bw.write("import "+Constants.BEAN_SERIALIZE_DESERIALIZE_CLASS+";");
                bw.newLine();
                bw.write("import "+Constants.URL_PARSE_DATEPARAM_CLASS+";");
            }
            if (table.haveBigDecimal()){
                bw.newLine();
                bw.write("import java.math.BigDecimal;");
            }
            boolean hasIgnoreF=false;
            for (FieldInfo fieldInfo : table.getFieldList()) {
                String[] ignoredFields = Constants.IGNORE_BEAN_TOJSON_FIELD.split(",");
                if (ArrayUtils.contains(ignoredFields,fieldInfo.getPropertyName())){
                    hasIgnoreF=true;
                }
            }
            if (hasIgnoreF){
                bw.newLine();
                bw.write("import "+Constants.IGNORE_BEAN_TOJSON_CLASS+';');
            }
            bw.newLine();
            BuildComment.createClassComment(bw, table.getComment());
            bw.write("public class " + table.getBeanName() + " implements Serializable {");
            bw.newLine();
            for (FieldInfo fieldInfo : table.getFieldList()) {
                BuildComment.createFieldComment(bw, fieldInfo.getComment());
                String[] ignoredFields = Constants.IGNORE_BEAN_TOJSON_FIELD.split(",");
                if (ArrayUtils.contains(ignoredFields,fieldInfo.getPropertyName())){
                    bw.write("\t"+Constants.IGNORE_BEAN_TOJSON_EXPRESSION);//文件写到这块,我又想把光标跳回import的最后一行的下一行开头,因为要加一个import语句,该怎么控制光标
                    bw.newLine();
                }
                if (ArrayUtils.contains(Constants.SQL_DATE_TIME_TYPE,fieldInfo.getSqlType())){
                    bw.write("\t"+String.format(Constants.BEAN_SERIALIZE_DESERIALIZE_EXPRESSION, DateUtils.YYYY_MM_DD_HH_MM_SS));
                    bw.newLine();
                    bw.write("\t"+String.format(Constants.URL_PARSE_DATEPARAM_EXPRESSION,DateUtils.YYYY_MM_DD_HH_MM_SS));
                    bw.newLine();
                }
                if (ArrayUtils.contains(Constants.SQL_DATE_TYPE,fieldInfo.getSqlType())){
                    bw.write("\t"+String.format(Constants.BEAN_SERIALIZE_DESERIALIZE_EXPRESSION, DateUtils.YYYY_MM_DD));
                    bw.newLine();
                    bw.write("\t"+String.format(Constants.URL_PARSE_DATEPARAM_EXPRESSION,DateUtils.YYYY_MM_DD));
                    bw.newLine();
                }
                bw.write("\tprivate "+fieldInfo.getJavaType()+" "+fieldInfo.getPropertyName()+";");
                bw.newLine();
                bw.newLine();
            }
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
            bw.write("}//哈哈哈开心");
            bw.flush();
        } catch (Exception e) {
            logger.error("生成po类失败,可能的错误:配置文件中的文件路径错误" + e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
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
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }


    }
}
