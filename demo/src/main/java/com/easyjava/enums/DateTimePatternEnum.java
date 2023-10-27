package com.easyjava.enums;

public enum DateTimePatternEnum {

    YY_MM_DD_HH_MM_SS("yy-MM-dd HH:mm:ss"),
    YY_MM_DD("yy-MM-dd");
    private String pattern;

    DateTimePatternEnum(String pattern) {
       this.pattern=pattern;
    }


    public String getPattern(){return pattern;}
}
