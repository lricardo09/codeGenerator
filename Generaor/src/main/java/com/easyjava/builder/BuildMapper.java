package com.easyjava.builder;

import com.easyjava.bean.Constants;
import com.easyjava.bean.FieldInfo;
import com.easyjava.bean.TableInfo;
import com.easyjava.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;
import java.util.Map;

public class BuildMapper {
    private static final Logger logger = LoggerFactory.getLogger(BuildMapper.class);

    public static void execute(TableInfo table) {
        File folder = new File(Constants.PATH_MAPPER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File poFile = new File(folder, table.getBeanName()+Constants.MAPPER_NAME_SUFFIX + ".java");
        OutputStream out = null;
        OutputStreamWriter outw = null;
        BufferedWriter bw = null;
        try {
            out = new FileOutputStream(poFile);
            outw = new OutputStreamWriter(out, "UTF-8");
            bw = new BufferedWriter(outw);
            bw.write("package " + Constants.PACKAGE_MAPPER+ ";\n");
            bw.newLine();
            bw.write("import org.apache.ibatis.annotations.Param;\n\n");
            BuildComment.createClassComment(bw, table.getComment());
            bw.write("public interface " + table.getBeanName()+Constants.MAPPER_NAME_SUFFIX +
                    "<T, P> extends BaseMapper{");
            bw.newLine();
            Map<String, List<FieldInfo>> keyIndexMap = table.getKeyIndexMap();
            StringBuffer fieldName = new StringBuffer();
            StringBuffer paramName = new StringBuffer();
            StringBuffer comment = new StringBuffer();
            int index=0;
            for (Map.Entry<String, List<FieldInfo>> entry : keyIndexMap.entrySet()){
                for (FieldInfo fieldInfo : entry.getValue()){
                    fieldName.append(StringUtils.firstLetter2Uppercase(fieldInfo.getFieldName()));
                    paramName.append("@Param(\""+fieldInfo.getPropertyName()+"\") "+fieldInfo.getJavaType()+" "+fieldInfo.getPropertyName());
                    comment.append(fieldInfo.getPropertyName());
                    index++;
                    if (index<entry.getValue().size()){
                        fieldName.append("And");
                        paramName.append(", ");
                        comment.append("和");
                    }
                }
                BuildComment.createFieldComment(bw,"根据"+comment+"查询");
                bw.write("\tT selectBy"+fieldName+"("+paramName+");\n\n");
                BuildComment.createFieldComment(bw,"根据"+comment+"更新");
                bw.write("\tInteger updateBy"+fieldName+"(@Param(\"bean\") T t, "+paramName+");\n\n");
                BuildComment.createFieldComment(bw,"根据"+comment+"删除");
                bw.write("\tInteger deleteBy"+fieldName+"("+paramName+");\n\n");
                fieldName.setLength(0);
                paramName.setLength(0);
                comment.setLength(0);
                index=0;

            }
            bw.newLine();
            bw.write("}");
            bw.flush();
        } catch (Exception e) {
            logger.error("生成{}表的Mapper类失败",table.getTableName(),e);
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
