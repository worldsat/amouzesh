package com.atrinfanavaran.school.Domain;

import com.atrinfanavaran.school.Kernel.Controller.Domain.BaseDomain;

public class AndroidVersion extends BaseDomain {
    private String id;
    private String appAndroidUrl;
    private String currVersion;

    public AndroidVersion() {
        setApiAddress("api/AndroidVersion");
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getappAndroidUrl() {
        return appAndroidUrl;
    }

    public void seappAndroidUrl(String appAndroidUrl) {
        this.appAndroidUrl = appAndroidUrl;
    }

    public String getcurrVersion() {
        return currVersion;
    }

    public void setcurrVersion(String currVersion) {
        this.currVersion = currVersion;
    }
}
