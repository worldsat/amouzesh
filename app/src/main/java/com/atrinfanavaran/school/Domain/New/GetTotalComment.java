package com.atrinfanavaran.school.Domain.New;

public class GetTotalComment {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : 2
     */

    private boolean success;
    private int status;
    private String message;
    private int data;

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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
