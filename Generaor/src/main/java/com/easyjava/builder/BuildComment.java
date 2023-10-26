package com.easyjava.builder;

import com.easyjava.bean.Constants;
import com.easyjava.utils.DateUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;

public class BuildComment {
    public static void createClassComment(BufferedWriter bw,String comment) throws IOException {
        bw.write("/**\n");
        bw.write(" * @description: "+comment+"\n");
        bw.write(" * @author: "+ ((Constants.AUTHOR==null)?"":Constants.AUTHOR)+"\n");
        bw.write(" * @date: "+ DateUtils.formatDate(new Date())+"\n");
        bw.write(" */\n");
    }
    public static void createFieldComment(BufferedWriter bw,String comment)throws IOException{
        bw.write("\t/**\n");
        bw.write(" \t * "+comment+"\n");
        bw.write(" \t */\n");
    }
    public static void createMethodComment(BufferedWriter bw,String comment){

    }
}
