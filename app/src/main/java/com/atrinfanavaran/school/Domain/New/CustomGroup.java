package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomGroup {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"id":2,"name":"Test1","date":"2021-01-18T13:09:11.9879505","applicationUserId":"d4801771-5087-463f-be54-6d70d2466f39","applicationUser":null,"usersToCustomGroups":null}]
     */

    private boolean success;
    private int status;
    private String message;
    private ArrayList<data> data;

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

    public ArrayList<data> getData() {
        return data;
    }

    public void setData(ArrayList<data> data) {
        this.data = data;
    }

    public static class data implements Serializable {
        /**
         * id : 2
         * name : Test1
         * date : 2021-01-18T13:09:11.9879505
         * applicationUserId : d4801771-5087-463f-be54-6d70d2466f39
         * applicationUser : null
         * usersToCustomGroups : null
         */

        private int id;
        private String name;
        private String date;
        private String applicationUserId;
        private String applicationUser;
        private String usersToCustomGroups;

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

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
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

        public String getUsersToCustomGroups() {
            return usersToCustomGroups;
        }

        public void setUsersToCustomGroups(String usersToCustomGroups) {
            this.usersToCustomGroups = usersToCustomGroups;
        }
    }
}
