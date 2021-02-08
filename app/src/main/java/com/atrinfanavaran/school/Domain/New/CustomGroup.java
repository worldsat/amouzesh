package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomGroup {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"id":14,"name":"MainOwnerTest1","isForTeacher":false,"date":"2021-02-07T14:52:37.8825469","applicationUserId":"02174cf0\u20139412\u20134cfe-afbf-59f706d72cf6","applicationUser":null,"usersToCustomGroups":null},{"id":15,"name":"MainOwnerTest2","isForTeacher":false,"date":"2021-02-07T14:53:56.8588091","applicationUserId":"02174cf0\u20139412\u20134cfe-afbf-59f706d72cf6","applicationUser":null,"usersToCustomGroups":null}]
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
         * id : 14
         * name : MainOwnerTest1
         * isForTeacher : false
         * date : 2021-02-07T14:52:37.8825469
         * applicationUserId : 02174cf0–9412–4cfe-afbf-59f706d72cf6
         * applicationUser : null
         * usersToCustomGroups : null
         */

        private int id;
        private String name;
        private boolean isForTeacher;
        private String date;
        private String applicationUserId;
        private Object applicationUser;
        private Object usersToCustomGroups;

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

        public boolean isIsForTeacher() {
            return isForTeacher;
        }

        public void setIsForTeacher(boolean isForTeacher) {
            this.isForTeacher = isForTeacher;
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

        public Object getApplicationUser() {
            return applicationUser;
        }

        public void setApplicationUser(Object applicationUser) {
            this.applicationUser = applicationUser;
        }

        public Object getUsersToCustomGroups() {
            return usersToCustomGroups;
        }

        public void setUsersToCustomGroups(Object usersToCustomGroups) {
            this.usersToCustomGroups = usersToCustomGroups;
        }
    }
}
