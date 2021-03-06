package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;
import java.util.ArrayList;

public class AnnouncementGetAll {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"id":2,"text":"This is Text2","createDate":"2021-02-01T14:08:52.5924157","applicationUserId":"d4801771-5087-463f-be54-6d70d2466f39","applicationUser":null}]
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
         * id : 2
         * text : This is Text2
         * createDate : 2021-02-01T14:08:52.5924157
         * applicationUserId : d4801771-5087-463f-be54-6d70d2466f39
         * applicationUser : null
         */

        private int id;
        private String text;
        private String createDate;
        private String applicationUserId;
        private String applicationUser;
        private int AvailableDays;
        private boolean isOnlyForTeacher;

        public boolean isIsOnlyForTeacher() {
            return isOnlyForTeacher;
        }

        public void setIsOnlyForTeacher(boolean isOnlyForTeacher) {
            this.isOnlyForTeacher = isOnlyForTeacher;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public int getAvailableDays() {
            return AvailableDays;
        }

        public void setAvailableDays(int availableDays) {
            AvailableDays = availableDays;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
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
