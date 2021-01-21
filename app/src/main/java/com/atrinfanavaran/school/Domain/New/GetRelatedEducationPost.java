package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;
import java.util.ArrayList;

public class GetRelatedEducationPost {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"id":38,"title":"Test63dd","description":"desssssssss3","iconUrl":"/Upload/Post/Icon/a80064c502d7a0438d093660ecfd8ce0c2fd.png","medias":null,"number":2,"accessType":1,"pin":false,"categoryId":6,"category":null,"applicationUserId":"d4801771-5087-463f-be54-6d70d2466f39","applicationUser":null,"comments":null,"viewCount":0,"status":0}]
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
         * id : 38
         * title : Test63dd
         * description : desssssssss3
         * iconUrl : /Upload/Post/Icon/a80064c502d7a0438d093660ecfd8ce0c2fd.png
         * medias : null
         * number : 2
         * accessType : 1
         * pin : false
         * categoryId : 6
         * category : null
         * applicationUserId : d4801771-5087-463f-be54-6d70d2466f39
         * applicationUser : null
         * comments : null
         * viewCount : 0
         * status : 0
         */

        private int id;
        private String title;
        private String description;
        private String iconUrl;
        private Object medias;
        private int number;
        private int accessType;
        private boolean pin;
        private int categoryId;
        private Object category;
        private String applicationUserId;
        private Object applicationUser;
        private Object comments;
        private int viewCount;
        private int status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public Object getMedias() {
            return medias;
        }

        public void setMedias(Object medias) {
            this.medias = medias;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getAccessType() {
            return accessType;
        }

        public void setAccessType(int accessType) {
            this.accessType = accessType;
        }

        public boolean isPin() {
            return pin;
        }

        public void setPin(boolean pin) {
            this.pin = pin;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public Object getCategory() {
            return category;
        }

        public void setCategory(Object category) {
            this.category = category;
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

        public Object getComments() {
            return comments;
        }

        public void setComments(Object comments) {
            this.comments = comments;
        }

        public int getViewCount() {
            return viewCount;
        }

        public void setViewCount(int viewCount) {
            this.viewCount = viewCount;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
