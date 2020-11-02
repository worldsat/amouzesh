package com.atrinfanavaran.school.Domain.New;

import com.atrinfanavaran.school.Kernel.Controller.Domain.BaseDomain;

public class ShowPost extends BaseDomain {
    private String Title;
    private String Type;
    private String Time;
    private String Size;
    private String Link;
    private String FileName;

    public ShowPost(String title, String type, String time, String size, String link,String fileName) {
        Title = title;
        Type = type;
        Time = time;
        Size = size;
        Link = link;
        FileName = fileName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }
}
