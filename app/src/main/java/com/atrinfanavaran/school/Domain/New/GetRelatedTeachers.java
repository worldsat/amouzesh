package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;
import java.util.ArrayList;

public class GetRelatedTeachers {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"name":"مژگان هادیان","id":"5b56fd2e-acdc-4202-8522-c466cad1285f"},{"name":"خانم تقی زاده","id":"23dffd4e-c445-4d6b-9eca-5effe17071a6"},{"name":"مدیریت دریای مهر","id":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6"},{"name":"Atrin","id":"d4801771-5087-463f-be54-6d70d2466f39"}]
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
         * name : مژگان هادیان
         * id : 5b56fd2e-acdc-4202-8522-c466cad1285f
         */

        private String name;
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
