package com.wei.practicedemo.middleentity;

public class Adress {
    private String province;
    private String city;
    private String origin;

    public Adress() {
    }

    public Adress(String province, String city, String origin) {
        this.province = province;
        this.city = city;
        this.origin = origin;
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

    @Override
    public String toString() {
        return "Adress{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
