package com.atrinfanavaran.school.Domain;

import com.atrinfanavaran.school.Kernel.Controller.Domain.BaseDomain;

public class DischargeRoute extends BaseDomain {
    private String id;
    private String code;
    private String day;
    private String address;

    public DischargeRoute() {
        setApiAddress("api/DischargeRoute");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
