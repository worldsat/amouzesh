package com.atrinfanavaran.school.Domain.New;

import com.atrinfanavaran.school.Kernel.Controller.Domain.BaseDomain;

public class AttachFile extends BaseDomain {
    private String AttachName;
    private String AttachId;
    private String AttachDir;
    private String Size;
    private String TypeFile;

    public AttachFile(String attachName, String attachId, String size) {
        AttachName = attachName;
        AttachId = attachId;
        Size = size;
    }

    public String getTypeFile() {
        return TypeFile;
    }

    public void setTypeFile(String typeFile) {
        TypeFile = typeFile;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        this.Size = size;
    }

    public String getAttachName() {
        return AttachName;
    }

    public void setAttachName(String attachName) {
        this.AttachName = attachName;
    }

    public String getAttachId() {
        return AttachId;
    }

    public void setAttachId(String attachId) {
        this.AttachId = attachId;
    }

    public String getAttachDir() {
        return AttachDir;
    }

    public void setAttachDir(String attachDir) {
        this.AttachDir = attachDir;
    }
}
