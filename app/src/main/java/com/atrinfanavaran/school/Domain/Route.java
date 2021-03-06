package com.atrinfanavaran.school.Domain;

import com.atrinfanavaran.school.Kernel.Controller.Domain.BaseDomain;
import com.atrinfanavaran.school.Kernel.Controller.Domain.DomainInfo;
import com.atrinfanavaran.school.Kernel.Controller.Domain.ViewMode;
import com.atrinfanavaran.school.Kernel.Controller.Domain.ViewType;

import java.util.ArrayList;

public class Route extends BaseDomain {
 private String  code;
 private String  day;
 private String  address;
 private String  lat;
 private String  lon;
 private int  id;

    public Route() {
        ArrayList<DomainInfo> domainInfoList = new ArrayList<>();

        domainInfoList.add(new DomainInfo(
                ViewMode.FILTER.name(),
                "address",
                "آدرس مسیر",
                "",
                ViewType.EDIT_TEXT.name())
        );
        domainInfoList.add(new DomainInfo(
                ViewMode.FILTER.name(),
                "code",
                "کد مسیر",
                "",
                ViewType.EDIT_TEXT.name())
        );
        domainInfoList.add(new DomainInfo(
                ViewMode.FILTER.name(),
                "day",
                "تاریخ در ماه",
                "",
                ViewType.EDIT_TEXT.name())
        );
        setDomainInfo(domainInfoList);
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

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
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
}
