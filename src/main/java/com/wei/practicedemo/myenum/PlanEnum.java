package com.wei.practicedemo.myenum;

public enum PlanEnum {
    TECHNIQUE(1,"技术型"),

    MARKETING(2,"业务型"),
    BUSINESS(3,"营销型"),
    MANAGE(4,"管理型");

    private int code;
    private String name;

    PlanEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
