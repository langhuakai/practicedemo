package com.wei.practicedemo.entity;

import java.util.List;

public class UserEntity {

    private int id;
    private String userName;
    private String sex;
    private int age;
    private String email;
    private String phone;
    private String personalPlan;
    private String personalDesign;
    private String entryDate;
    private String companyAddress;

    public UserEntity() {
    }

    public UserEntity(int id, String userName, String sex, int age, String email, String phone, String personalPlan, String personalDesign, String entryDate, String companyAddress) {
        this.userName = userName;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.personalPlan = personalPlan;
        this.entryDate = entryDate;
        this.companyAddress = companyAddress;
        this.personalDesign = personalDesign;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersonalPlan() {
        return personalPlan;
    }

    public void setPersonalPlan(String personalPlan) {
        this.personalPlan = personalPlan;
    }

    public String getPersonalDesign() {
        return personalDesign;
    }

    public void setPersonalDesign(String personalDesign) {
        this.personalDesign = personalDesign;
    }
}
