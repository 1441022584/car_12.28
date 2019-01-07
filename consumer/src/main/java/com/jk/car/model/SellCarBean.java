package com.jk.car.model;

import java.io.Serializable;

public class SellCarBean implements Serializable {
    private static final long serialVersionUID = 471914947470678408L;
    private Integer id;

    private String carType;

    private String carSeries;

    private String carLicenseYear;

    private String carLicenseMonth;

    private String carRoadroller;

    private String carLicencesto;

    /**
     * 汽车状况1.车况好，无事故且外观无损伤
     * 2车况正常，无事故但有少量剐蹭钣金.
     * 3车况一般，发生过碰撞事故
     * 4.车辆有重大事故，车身骨架受损（含泡水火烧）
     */
    private String carVehiclecondition;

    /**
     * 后续需求1.买新车2.买二手车3.无购车计划
     */
    private String carDemand;

    private Integer userId;

    private Double carPrice;

    private Double carDisplacement;

    private String carLicenseplatenumber;

    private Integer carStatus;

    private String carSite;

    /**
     * 参数类型:1车龄;4变速箱;3.车型;2里程;5.座次位
     */
    private Integer carParameter;

    private String carImg;

    private String carDetails;

    /**
     * 里程，业务字段，参数表中2
     */
    private String mileage;

    private Integer carTime;

    private String phoneNumber;

    @Override
    public String toString() {
        return "SellCarBean{" +
                "id=" + id +
                ", carType='" + carType + '\'' +
                ", carSeries='" + carSeries + '\'' +
                ", carLicenseYear='" + carLicenseYear + '\'' +
                ", carLicenseMonth='" + carLicenseMonth + '\'' +
                ", carRoadroller='" + carRoadroller + '\'' +
                ", carLicencesto='" + carLicencesto + '\'' +
                ", carVehiclecondition='" + carVehiclecondition + '\'' +
                ", carDemand='" + carDemand + '\'' +
                ", userId=" + userId +
                ", carPrice=" + carPrice +
                ", carDisplacement=" + carDisplacement +
                ", carLicenseplatenumber='" + carLicenseplatenumber + '\'' +
                ", carStatus=" + carStatus +
                ", carSite='" + carSite + '\'' +
                ", carParameter=" + carParameter +
                ", carImg='" + carImg + '\'' +
                ", carDetails='" + carDetails + '\'' +
                ", mileage='" + mileage + '\'' +
                ", carTime=" + carTime +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public String getCarLicenseYear() {
        return carLicenseYear;
    }

    public void setCarLicenseYear(String carLicenseYear) {
        this.carLicenseYear = carLicenseYear;
    }

    public String getCarLicenseMonth() {
        return carLicenseMonth;
    }

    public void setCarLicenseMonth(String carLicenseMonth) {
        this.carLicenseMonth = carLicenseMonth;
    }

    public String getCarRoadroller() {
        return carRoadroller;
    }

    public void setCarRoadroller(String carRoadroller) {
        this.carRoadroller = carRoadroller;
    }

    public String getCarLicencesto() {
        return carLicencesto;
    }

    public void setCarLicencesto(String carLicencesto) {
        this.carLicencesto = carLicencesto;
    }

    public String getCarVehiclecondition() {
        return carVehiclecondition;
    }

    public void setCarVehiclecondition(String carVehiclecondition) {
        this.carVehiclecondition = carVehiclecondition;
    }

    public String getCarDemand() {
        return carDemand;
    }

    public void setCarDemand(String carDemand) {
        this.carDemand = carDemand;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    public Double getCarDisplacement() {
        return carDisplacement;
    }

    public void setCarDisplacement(Double carDisplacement) {
        this.carDisplacement = carDisplacement;
    }

    public String getCarLicenseplatenumber() {
        return carLicenseplatenumber;
    }

    public void setCarLicenseplatenumber(String carLicenseplatenumber) {
        this.carLicenseplatenumber = carLicenseplatenumber;
    }

    public Integer getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(Integer carStatus) {
        this.carStatus = carStatus;
    }

    public String getCarSite() {
        return carSite;
    }

    public void setCarSite(String carSite) {
        this.carSite = carSite;
    }

    public Integer getCarParameter() {
        return carParameter;
    }

    public void setCarParameter(Integer carParameter) {
        this.carParameter = carParameter;
    }

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = carImg;
    }

    public String getCarDetails() {
        return carDetails;
    }

    public void setCarDetails(String carDetails) {
        this.carDetails = carDetails;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public Integer getCarTime() {
        return carTime;
    }

    public void setCarTime(Integer carTime) {
        this.carTime = carTime;
    }

}