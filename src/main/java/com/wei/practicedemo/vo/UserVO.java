package com.wei.practicedemo.vo;

import com.wei.practicedemo.middleentity.Adress;

import java.util.List;

public class UserVO {

    private int id;
    private String userName;
    private String sex;
    private int age;
    private String email;
    private String phone;
    private String entryDate;
    private List<String> personalPlans;
    private Adress companyAdress;

    public UserVO() {
    }

    public UserVO(int id, String userName, String sex, int age, String email, String phone, List<String> personalPlans, String entryDate, Adress companyAdress) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.personalPlans = personalPlans;
        this.entryDate = entryDate;
        this.companyAdress = companyAdress;
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

    public Adress getCompanyAdress() {
        return companyAdress;
    }

    public void setCompanyAdress(Adress companyAdress) {
        this.companyAdress = companyAdress;
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

    public List<String> getPersonalPlans() {
        return personalPlans;
    }

    public void setPersonalPlans(List<String> personalPlans) {
        this.personalPlans = personalPlans;
    }
}
