package com.atrinfanavaran.school.Domain;

import com.atrinfanavaran.school.Kernel.Controller.Domain.BaseDomain;

public class RouteApi extends BaseDomain {
    private String code;
    private String day;
    private String address;
    private String lat;
    private String lon;
    private String id;

    public RouteApi() {
        setApiAddress("api/DischargeRoute");
    }

    public String getlat() {
        return lat;
    }

    public void setlat(String lat) {
        this.lat = lat;
    }

    public String getlon() {
        return lon;
    }

    public void setlon(String lon) {
        this.lon = lon;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getcode() {
        return code;
    }

    public void setcode(String code) {
        this.code = code;
    }

    public String getday() {
        return day;
    }

    public void setday(String day) {
        this.day = day;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }


}
