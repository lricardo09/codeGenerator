package com.easyjava;

import com.easyjava.bean.TableInfo;
import com.easyjava.builder.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<TableInfo> tables = BuildTable.getTables();
        BuildBase.execute();
        for (TableInfo table : tables){
            BuildPo.execute(table);
            BuildQuery.execute(table);
            BuildMapper.execute(table);
            BuildMapperXml.execute(table);
        }
    }
}
