package com.atrinfanavaran.school.Domain;

import com.atrinfanavaran.school.Kernel.Controller.Domain.BaseDomain;

public class Sliders extends BaseDomain {
    private String id;
    private String image;
    private String imageUrl;
    private String link;

    public Sliders() {
        setApiAddress("api/Sliders");
    }

    public String getId() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getimage() {
        return image;
    }

    public void setimage(String image) {
        this.image = image;
    }

    public String getimageUrl() {
        return imageUrl;
    }

    public void setimageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getlink() {
        return link;
    }

    public void setlink(String link) {
        this.link = link;
    }
}
