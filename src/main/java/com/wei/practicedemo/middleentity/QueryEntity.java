package com.wei.practicedemo.middleentity;

public class QueryEntity {
    private String userName;
    private String personalPlans;
    private String EntryDate;
    private String province;
    private String city;
    private String origin;

    public QueryEntity() {
    }

    public QueryEntity(String userName, String personalPlans, String entryDate, String province, String city, String origin) {
        this.userName = userName;
        this.personalPlans = personalPlans;
        EntryDate = entryDate;
        this.province = province;
        this.city = city;
        this.origin = origin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPersonalPlans() {
        return personalPlans;
    }

    public void setPersonalPlans(String personalPlans) {
        this.personalPlans = personalPlans;
    }

    public String getEntryDate() {
        return EntryDate;
    }

    public void setEntryDate(String entryDate) {
        EntryDate = entryDate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
