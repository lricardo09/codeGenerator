package com.easyjava.bean;

import java.util.*;

public class TableInfo {
    private String tableName;
    private String beanName;
    private String comment;
    private String beanParamName;
    private List<FieldInfo> fieldList;
    //唯一索引的map, 不是唯一索引的属性不算, key是key_name, value是所有共享key_name的属性对象(联合索引)
    private Map<String,List<FieldInfo>> keyIndexMap=new LinkedHashMap<String, List<FieldInfo>>();//有序map对应有序索引
    private Boolean haveDate=false;
    private Boolean haveDateTime=false;
    private Boolean haveBigDecimal=false;
    private List<FieldInfo> extendQueryList=new ArrayList<>();

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBeanParamName() {
        return beanParamName;
    }

    public void setBeanParamName(String beanParamName) {
        this.beanParamName = beanParamName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public List<FieldInfo> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<FieldInfo> fieldList) {
        this.fieldList = fieldList;
    }

    public Map<String, List<FieldInfo>> getKeyIndexMap() {
        return keyIndexMap;
    }

    public void setKeyIndexMap(Map<String, List<FieldInfo>> keyIndexMap) {
        this.keyIndexMap = keyIndexMap;
    }

    public Boolean haveDate() {
        return haveDate;
    }

    public void setHaveDate(Boolean haveDate) {
        this.haveDate = haveDate;
    }

    public Boolean haveDateTime() {
        return haveDateTime;
    }

    public void setHaveDateTime(Boolean haveDateTime) {
        this.haveDateTime = haveDateTime;
    }

    public Boolean haveBigDecimal() {
        return haveBigDecimal;
    }

    public void setHaveBigDecimal(Boolean haveBigDecimal) {
        this.haveBigDecimal = haveBigDecimal;
    }


    public List<FieldInfo> getExtendQueryList() {
        return extendQueryList;
    }

    public void setExtendQueryList(List<FieldInfo> extendQueryList) {
        this.extendQueryList = extendQueryList;
    }
}
