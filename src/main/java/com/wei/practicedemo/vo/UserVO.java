package com.wei.practicedemo.vo;

import com.wei.practicedemo.middleentity.Address;

import java.util.List;

public class UserVO {

    private int id;
    private String userName;
    private String sex;
    private int age;
    private String email;
    private String phone;
    private String entryDate;
    private String[] personalPlans;
    private Address companyAddress;

    public UserVO() {
    }

    public UserVO(int id, String userName, String sex, int age, String email, String phone, String[] personalPlans, String entryDate, Address companyAddress) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.personalPlans = personalPlans;
        this.entryDate = entryDate;
        this.companyAddress = companyAddress;
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

    public Address getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(Address companyAddress) {
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

    public String[] getPersonalPlans() {
        return personalPlans;
    }

    public void setPersonalPlans(String personalPlans[]) {
        this.personalPlans = personalPlans;
    }
}
