package com.atrinfanavaran.school.Domain.New;

public class ManageDomain {

    /**
     * success : false
     * status : 500
     * message : عملیات با شکست مواجه شد.
     * data : Object reference not set to an instance of an object.
     */

    private boolean success;
    private int status;
    private String message;
    private String data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
