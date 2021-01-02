package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoryGetAll implements Serializable {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"id":4,"name":"تست1","url":"/Upload/Category/File/a1cb035e0d326044100a33c0795147d423f7.jpg","applicationUserId":"23dffd4e-c445-4d6b-9eca-5effe17071a6","applicationUser":null}]
     */

    private boolean success;
    private int status;
    private String message;
    private ArrayList<Data> data;

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

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public static class Data implements Serializable {
        /**
         * id : 4
         * name : تست1
         * url : /Upload/Category/File/a1cb035e0d326044100a33c0795147d423f7.jpg
         * applicationUserId : 23dffd4e-c445-4d6b-9eca-5effe17071a6
         * applicationUser : null
         */

        private int id;
        private String name;
        private String url;
        private String applicationUserId;
        private String applicationUser;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getApplicationUserId() {
            return applicationUserId;
        }

        public void setApplicationUserId(String applicationUserId) {
            this.applicationUserId = applicationUserId;
        }

        public String getApplicationUser() {
            return applicationUser;
        }

        public void setApplicationUser(String applicationUser) {
            this.applicationUser = applicationUser;
        }
    }
}
