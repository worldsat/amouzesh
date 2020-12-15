package com.atrinfanavaran.school.Domain.New;

public class RememberPassword {

    /**
     * success : false
     * status : 403
     * message : کاریری با چنین مشخصاتی یافت نشد.
     * data : null
     */

    private boolean success;
    private int status;
    private String message;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
