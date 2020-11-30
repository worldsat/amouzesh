package com.atrinfanavaran.school.Kernel.Controller.Domain;

import java.util.ArrayList;

public class ApiResponse {


    /**
     * success : true
     * status : 200
     * message : موفقیت آمیز
     * data : [{"id":1,"fullName":"Atrin","mobile":9136531539,"address":"esff","nationalCode":"1278945569","apiToken":"rewrwerewrrsggeetsdgffdgfdgfdgf","url":"/Upload/Teacher/File/54432180-black-city-icon-on-white-background - Copy.jpg","userName":"Atrin2020","password":"123456"}]
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

    public static class Data {
        /**
         * id : 1
         * fullName : Atrin
         * mobile : 9136531539
         * address : esff
         * nationalCode : 1278945569
         * apiToken : rewrwerewrrsggeetsdgffdgfdgfdgf
         * url : /Upload/Teacher/File/54432180-black-city-icon-on-white-background - Copy.jpg
         * userName : Atrin2020
         * password : 123456
         */

        private int id;
        private String fullName;
        private long mobile;
        private String address;
        private String nationalCode;
        private String apiToken;
        private String url;
        private String userName;
        private String password;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public long getMobile() {
            return mobile;
        }

        public void setMobile(long mobile) {
            this.mobile = mobile;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getNationalCode() {
            return nationalCode;
        }

        public void setNationalCode(String nationalCode) {
            this.nationalCode = nationalCode;
        }

        public String getApiToken() {
            return apiToken;
        }

        public void setApiToken(String apiToken) {
            this.apiToken = apiToken;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
