package com.easyjava.bean;

import com.easyjava.utils.PropertyUtils;

public class ConstantsCopyMirror {
public static final String DB_DRIVER_NAME;
public static final String DB_URL;
public static final String DB_USERNAME;
public static final String DB_PASSWORD;
public static final String IGNORE_BEAN_TOJSON_FIELD;
public static final String IGNORE_BEAN_TOJSON_EXPRESSION;
public static final String IGNORE_BEAN_TOJSON_CLASS;
public static final String BEAN_DATE_SERIALIZE_DESERIALIZE_EXPRESSION;
public static final String BEAN_TOJSON_SERIALIZE_DESERIALIZE_CLASS;
public static final String URL_PARSE_DATEPARAM_EXPRESSION;
public static final String URL_PARSE_DATEPARAM_CLASS;
public static final boolean IGNORE_TABLE_SUFFIX;
public static final String MAPPER_NAME_SUFFIX;
public static final String BEAN_QUERY_NAME_CLASSNAME_SUFFIX;
public static final String BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_START;
public static final String BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_END;
public static final String BEAN_QUERY_NAME_PROPERTYNAME_STRQUERY_FUZZY;
public static final String PATH_BASE;
public static final String PACKAGE_BASE;
public static final String PACKAGE_PO;
public static final String PACKAGE_PARAM;
public static final String PACKAGE_UTIL;
public static final String PACKAGE_ENUMS;
public static final String PACKAGE_MAPPER;
public static final String AUTHOR;
static{
DB_DRIVER_NAME=PropertyUtils.getProperty("db.driver.name");
DB_URL=PropertyUtils.getProperty("db.url");
DB_USERNAME=PropertyUtils.getProperty("db.username");
DB_PASSWORD=PropertyUtils.getProperty("db.password");
IGNORE_BEAN_TOJSON_FIELD=PropertyUtils.getProperty("ignore.bean.toJson.field");
IGNORE_BEAN_TOJSON_EXPRESSION=PropertyUtils.getProperty("ignore.bean.toJson.expression");
IGNORE_BEAN_TOJSON_CLASS=PropertyUtils.getProperty("ignore.bean.toJson.class");
BEAN_DATE_SERIALIZE_DESERIALIZE_EXPRESSION=PropertyUtils.getProperty("bean.date.serialize.deserialize.expression");
BEAN_TOJSON_SERIALIZE_DESERIALIZE_CLASS=PropertyUtils.getProperty("bean.toJson.serialize.deserialize.class");
URL_PARSE_DATEPARAM_EXPRESSION=PropertyUtils.getProperty("url.parse.dateParam.expression");
URL_PARSE_DATEPARAM_CLASS=PropertyUtils.getProperty("url.parse.dateParam.class");
MAPPER_NAME_SUFFIX=PropertyUtils.getProperty("mapper.name.suffix");
BEAN_QUERY_NAME_CLASSNAME_SUFFIX=PropertyUtils.getProperty("bean.query.name.classname.suffix");
BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_START=PropertyUtils.getProperty("bean.query.name.propertyName.dateQuery.start");
BEAN_QUERY_NAME_PROPERTYNAME_DATEQUERY_END=PropertyUtils.getProperty("bean.query.name.propertyName.dateQuery.end");
BEAN_QUERY_NAME_PROPERTYNAME_STRQUERY_FUZZY=PropertyUtils.getProperty("bean.query.name.propertyName.strQuery.fuzzy");
PATH_BASE=PropertyUtils.getProperty("path.base");
PACKAGE_BASE=PropertyUtils.getProperty("package.base");
PACKAGE_PO=PropertyUtils.getProperty("package.po");
PACKAGE_PARAM=PropertyUtils.getProperty("package.param");
PACKAGE_UTIL=PropertyUtils.getProperty("package.util");
PACKAGE_ENUMS=PropertyUtils.getProperty("package.enums");
PACKAGE_MAPPER=PropertyUtils.getProperty("package.mapper");
AUTHOR=PropertyUtils.getProperty("author");
IGNORE_TABLE_SUFFIX=Boolean.parseBoolean(PropertyUtils.getProperty("ignore.table.suffix"));
}
}