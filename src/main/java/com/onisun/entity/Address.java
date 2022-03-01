package com.onisun.entity;

/**
 * @author Neo
 * @version 1.0
 */
public class Address {
    private String province;
    private String city;
    private String town;

    public Address() {
        System.out.println("Address被创建了");
    }
    public void init(){
        System.out.println("Address对象被初始化");
    }
    public void destroy(){
        System.out.println("Address对象被销毁");
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                '}';
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

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
