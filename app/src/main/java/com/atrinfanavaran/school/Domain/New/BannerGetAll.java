package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BannerGetAll {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"id":2,"description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;test&lt;/p&gt;","socialNetWorkLink":null,"url":"/Upload/Banner/File/c7a74fb40120b04c980822a0ea5e081d4869.jpg","createDate":"2020-12-05T15:07:31.7173214","availableDate":"2020-12-05T15:07:31.7173628","creditDays":3,"bannerPlace":0,"bannerToPosts":[],"categoryId":null,"category":null,"applicationUserId":"708c6bf2-2d90-44f5-bfa8-9729224d598e","applicationUser":null,"showOnMainPage":true}]
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
         * description : &lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;test&lt;/p&gt;
         * socialNetWorkLink : null
         * url : /Upload/Banner/File/c7a74fb40120b04c980822a0ea5e081d4869.jpg
         * createDate : 2020-12-05T15:07:31.7173214
         * availableDate : 2020-12-05T15:07:31.7173628
         * creditDays : 3
         * bannerPlace : 0
         * bannerToPosts : []
         * categoryId : null
         * category : null
         * applicationUserId : 708c6bf2-2d90-44f5-bfa8-9729224d598e
         * applicationUser : null
         * showOnMainPage : true
         */

        private int id;
        private String description;
        private String socialNetWorkLink;
        private String url;
        private String createDate;
        private String availableDate;
        private int creditDays;
        private int bannerPlace;
        private int categoryId;
        private Object category;
        private String applicationUserId;
        private Object applicationUser;
        private boolean showOnMainPage;
        private List<?> bannerToPosts;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSocialNetWorkLink() {
            return socialNetWorkLink;
        }

        public void setSocialNetWorkLink(String socialNetWorkLink) {
            this.socialNetWorkLink = socialNetWorkLink;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getAvailableDate() {
            return availableDate;
        }

        public void setAvailableDate(String availableDate) {
            this.availableDate = availableDate;
        }

        public int getCreditDays() {
            return creditDays;
        }

        public void setCreditDays(int creditDays) {
            this.creditDays = creditDays;
        }

        public int getBannerPlace() {
            return bannerPlace;
        }

        public void setBannerPlace(int bannerPlace) {
            this.bannerPlace = bannerPlace;
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

        public boolean isShowOnMainPage() {
            return showOnMainPage;
        }

        public void setShowOnMainPage(boolean showOnMainPage) {
            this.showOnMainPage = showOnMainPage;
        }

        public List<?> getBannerToPosts() {
            return bannerToPosts;
        }

        public void setBannerToPosts(List<?> bannerToPosts) {
            this.bannerToPosts = bannerToPosts;
        }
    }
}
