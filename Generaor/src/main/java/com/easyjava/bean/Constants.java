package com.easyjava.bean;

import com.easyjava.utils.PropertyUtils;

public class Constants {
    public static final boolean IGNORE_TABLE_SUFFIX;
    public static final String BEAN_QUERY_NAME_CLASSNAME_SUFFIX;
    public static final String BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_START;
    public static final String BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_END;
    public static final String BEAN_QUERY_NAME_PROPERTYNAME_STRQUERY_FUZZY;
    public static final String MAPPER_NAME_SUFFIX;
    public static final String PATH_BASE;
    public static final String PATH_PO;
    public static final String PATH_QUERY;
    public static final String PATH_UTIL ;
    public static final String PACKAGE_BASE;
    public static final String PACKAGE_PO;
    public static final String PACKAGE_QUERY;
    public static final String PACKAGE_UTIL;
    public static final String PATH_ENUM;
    public static final String PACKAGE_ENUM;

    public static final String AUTHOR;
    public static final String IGNORE_BEAN_TOJSON_FIELD;
    public static final String IGNORE_BEAN_TOJSON_EXPRESSION;
    public static final String IGNORE_BEAN_TOJSON_CLASS;
    public static final String BEAN_SERIALIZE_DESERIALIZE_EXPRESSION;
    public static final String BEAN_SERIALIZE_DESERIALIZE_CLASS;
    public static final String URL_PARSE_DATEPARAM_EXPRESSION;
    public static final String URL_PARSE_DATEPARAM_CLASS;
    public static final String PACKAGE_MAPPER;
    public static final String PATH_MAPPER;
    public static final String PATH_RESOURCE;
    public static final String PATH_MAPPER_XML;

    static {
        IGNORE_TABLE_SUFFIX = Boolean.parseBoolean(PropertyUtils.getProperty("ignore.table.suffix"));
        BEAN_QUERY_NAME_CLASSNAME_SUFFIX = PropertyUtils.getProperty("bean.query.name.classname.suffix");
        BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_START=PropertyUtils.getProperty("bean.query.name.propertyName.dateQuery.start");
        BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_END=PropertyUtils.getProperty("bean.query.name.propertyName.dateQuery.end");
        BEAN_QUERY_NAME_PROPERTYNAME_STRQUERY_FUZZY=PropertyUtils.getProperty("bean.query.name.propertyName.strQuery.fuzzy");
        PATH_BASE = PropertyUtils.getProperty("path.base");
        PACKAGE_BASE = PropertyUtils.getProperty("package.base");
        PACKAGE_PO = PACKAGE_BASE + "." + PropertyUtils.getProperty("package.po");
        PACKAGE_QUERY = PACKAGE_BASE + "." + PropertyUtils.getProperty("package.param");
        PATH_PO = PATH_BASE + "/src/main/java/" + PACKAGE_PO.replace(".", "/");
        PATH_QUERY = PATH_BASE + "/src/main/java/" + PACKAGE_QUERY.replace(".", "/");
        PACKAGE_UTIL=PACKAGE_BASE+"."+PropertyUtils.getProperty("package.util");
        PATH_UTIL=PATH_BASE+"/src/main/java/" + PACKAGE_UTIL.replace(".", "/");
        PACKAGE_ENUM=PACKAGE_BASE+"."+PropertyUtils.getProperty("package.enums");
        PATH_ENUM=PATH_BASE+"/src/main/java/"+PACKAGE_ENUM.replace(".","/");
        AUTHOR = PropertyUtils.getProperty("author");
        IGNORE_BEAN_TOJSON_FIELD = PropertyUtils.getProperty("ignore.bean.toJson.field");
        IGNORE_BEAN_TOJSON_EXPRESSION = PropertyUtils.getProperty("ignore.bean.toJson.expression");
        IGNORE_BEAN_TOJSON_CLASS = PropertyUtils.getProperty("ignore.bean.toJson.class");
        BEAN_SERIALIZE_DESERIALIZE_EXPRESSION = PropertyUtils.getProperty("bean.date.serialize.deserialize.expression");
        BEAN_SERIALIZE_DESERIALIZE_CLASS = PropertyUtils.getProperty("bean.toJson.serialize.deserialize.class");
        URL_PARSE_DATEPARAM_EXPRESSION = PropertyUtils.getProperty("url.parse.dateParam.expression");
        URL_PARSE_DATEPARAM_CLASS = PropertyUtils.getProperty("url.parse.dateParam.class");
        MAPPER_NAME_SUFFIX=PropertyUtils.getProperty("mapper.name.suffix");
        PACKAGE_MAPPER=PACKAGE_BASE+"."+PropertyUtils.getProperty("package.mapper");
        PATH_MAPPER=PATH_BASE + "/src/main/java/" + PACKAGE_MAPPER.replace(".", "/");
        PATH_RESOURCE=PATH_BASE+"/src/main/resources/";
        PATH_MAPPER_XML=PATH_RESOURCE+PACKAGE_MAPPER.replace(".", "/");

    }

    public static void main(String[] args) {
        System.out.println(IGNORE_BEAN_TOJSON_FIELD);
        System.out.println(IGNORE_BEAN_TOJSON_EXPRESSION);
        System.out.println(IGNORE_BEAN_TOJSON_CLASS);
        System.out.println(BEAN_SERIALIZE_DESERIALIZE_EXPRESSION);
        System.out.println(BEAN_SERIALIZE_DESERIALIZE_CLASS);
        System.out.println(URL_PARSE_DATEPARAM_EXPRESSION);
        System.out.println(URL_PARSE_DATEPARAM_CLASS);
        System.out.println(PACKAGE_UTIL);
        System.out.println(PATH_UTIL);
        System.out.println(PATH_ENUM);
        System.out.println(PACKAGE_ENUM);
    }

    public static final String[] SQL_DATE_TIME_TYPE = {"datetime", "timestamp"};
    public static final String[] SQL_DATE_TYPE = {"date"};
    public static final String[] SQL_DECIMAL_TYPE = {"decimal", "double", "float"};
    public static final String[] SQL_STRING_TYPE = {"char", "varchar", "text", "mediumtext", "longtext"};
    public static final String[] SQL_INTEGER_TYPE = {"int", "tinyint"};
    public static final String[] SQL_LONG_TYPE = {"bigint"};


}
