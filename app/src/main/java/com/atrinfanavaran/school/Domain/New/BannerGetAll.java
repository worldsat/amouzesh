package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;
import java.util.ArrayList;

public class BannerGetAll {


    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"id":6,"description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;","socialNetWorkLink":null,"url":"/Upload/Banner/File/3c09d85a0006c0497f0ad560271b4fb5085c.jpg","createDate":"2020-12-19T00:25:33.5943932","availableDate":"2020-12-19T00:25:33.5943987","creditDays":100,"bannerPlace":1,"bannerToPosts":null,"postsInBanner":[],"categoryId":null,"category":null,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null,"showOnMainPage":true,"bannerStatus":0,"pin":false},{"id":5,"description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;","socialNetWorkLink":null,"url":"/Upload/Banner/File/7e3edb4c0b59004d8a09af304c70fab38626.jpg","createDate":"0001-01-01T00:00:00","availableDate":"2020-12-19T00:24:43.2516779","creditDays":100,"bannerPlace":0,"bannerToPosts":null,"postsInBanner":[],"categoryId":null,"category":null,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null,"showOnMainPage":true,"bannerStatus":0,"pin":false},{"id":3,"description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;","socialNetWorkLink":null,"url":"/Upload/Banner/File/6bf1ecdb02e40049050a41909882f201f30f.jpg","createDate":"2020-12-19T00:23:24.5449465","availableDate":"2020-12-19T00:23:24.5449509","creditDays":100,"bannerPlace":0,"bannerToPosts":null,"postsInBanner":[],"categoryId":null,"category":null,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null,"showOnMainPage":true,"bannerStatus":0,"pin":false},{"id":2,"description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;","socialNetWorkLink":null,"url":"/Upload/Banner/File/164a12350f3500444e088740059eb019a7d4.jpg","createDate":"2020-12-19T00:22:47.4808947","availableDate":"2020-12-19T00:22:47.4808996","creditDays":100,"bannerPlace":0,"bannerToPosts":null,"postsInBanner":[],"categoryId":null,"category":null,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null,"showOnMainPage":true,"bannerStatus":0,"pin":false},{"id":1,"description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;سلام&lt;/p&gt;&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;","socialNetWorkLink":null,"url":"/Upload/Banner/File/b982607308c2304e64081070b39d17e2ec38.jpg","createDate":"2020-12-18T23:49:49.9972938","availableDate":"2020-12-18T23:49:49.9973651","creditDays":100,"bannerPlace":0,"bannerToPosts":null,"postsInBanner":[{"id":1,"bannerId":1,"educationPostId":21,"educationPost":null}],"categoryId":null,"category":null,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null,"showOnMainPage":true,"bannerStatus":0,"pin":false}]
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
         * id : 6
         * description : &lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;
         * socialNetWorkLink : null
         * url : /Upload/Banner/File/3c09d85a0006c0497f0ad560271b4fb5085c.jpg
         * createDate : 2020-12-19T00:25:33.5943932
         * availableDate : 2020-12-19T00:25:33.5943987
         * creditDays : 100
         * bannerPlace : 1
         * bannerToPosts : null
         * postsInBanner : []
         * categoryId : null
         * category : null
         * applicationUserId : aea11655-c2bc-49fb-a2bb-79a92c0d0fd6
         * applicationUser : null
         * showOnMainPage : true
         * bannerStatus : 0
         * pin : false
         */

        private int id;
        private String description;
        private Object socialNetWorkLink;
        private String url;
        private String createDate;
        private String availableDate;
        private int creditDays;
        private int bannerPlace;
        private Object bannerToPosts;
        private Object categoryId;
        private Object category;
        private String applicationUserId;
        private Object applicationUser;
        private boolean showOnMainPage;
        private int bannerStatus;
        private boolean pin;
        private ArrayList<?> postsInBanner;

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

        public Object getSocialNetWorkLink() {
            return socialNetWorkLink;
        }

        public void setSocialNetWorkLink(Object socialNetWorkLink) {
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

        public Object getBannerToPosts() {
            return bannerToPosts;
        }

        public void setBannerToPosts(Object bannerToPosts) {
            this.bannerToPosts = bannerToPosts;
        }

        public Object getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Object categoryId) {
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

        public int getBannerStatus() {
            return bannerStatus;
        }

        public void setBannerStatus(int bannerStatus) {
            this.bannerStatus = bannerStatus;
        }

        public boolean isPin() {
            return pin;
        }

        public void setPin(boolean pin) {
            this.pin = pin;
        }

        public ArrayList<?> getPostsInBanner() {
            return postsInBanner;
        }

        public void setPostsInBanner(ArrayList<?> postsInBanner) {
            this.postsInBanner = postsInBanner;
        }
    }
}
