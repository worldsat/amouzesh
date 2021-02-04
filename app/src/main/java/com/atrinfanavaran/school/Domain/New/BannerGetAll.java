package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;
import java.util.ArrayList;

public class BannerGetAll {


    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"id":1006,"description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;تست3&lt;/p&gt;","socialNetWorkLink":null,"url":null,"createDate":"2021-02-03T09:19:20.952004","availableDate":"2021-02-03T09:19:20.9520112","creditDays":12,"bannerPlace":0,"postsInBanner":[],"categoryId":20,"category":{"id":20,"name":"دفتر تمرین ریاضی","url":"/Upload/Category/File/4fba789d0e31d047560a4bb09089d2451bfc.jpg","applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null},"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null,"showOnMainPage":false,"bannerStatus":0,"pin":false,"isOnlyForTeacher":false},{"id":1005,"description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;تست&lt;/p&gt;","socialNetWorkLink":null,"url":null,"createDate":"2021-02-03T09:10:56.5498169","availableDate":"2021-02-03T09:10:56.5498269","creditDays":12,"bannerPlace":0,"postsInBanner":[10],"categoryId":null,"category":null,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null,"showOnMainPage":false,"bannerStatus":0,"pin":false,"isOnlyForTeacher":false},{"id":6,"description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;","socialNetWorkLink":null,"url":"/Upload/Banner/File/3c09d85a0006c0497f0ad560271b4fb5085c.jpg","createDate":"2020-12-19T00:25:33.5943932","availableDate":"2020-12-19T00:25:33.5943987","creditDays":100,"bannerPlace":1,"postsInBanner":[],"categoryId":null,"category":null,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null,"showOnMainPage":true,"bannerStatus":0,"pin":false,"isOnlyForTeacher":false},{"id":5,"description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;","socialNetWorkLink":null,"url":"/Upload/Banner/File/7e3edb4c0b59004d8a09af304c70fab38626.jpg","createDate":"0001-01-01T00:00:00","availableDate":"2020-12-19T00:24:43.2516779","creditDays":100,"bannerPlace":0,"postsInBanner":[],"categoryId":null,"category":null,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null,"showOnMainPage":true,"bannerStatus":0,"pin":false,"isOnlyForTeacher":false},{"id":3,"description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;","socialNetWorkLink":null,"url":"/Upload/Banner/File/6bf1ecdb02e40049050a41909882f201f30f.jpg","createDate":"2020-12-19T00:23:24.5449465","availableDate":"2020-12-19T00:23:24.5449509","creditDays":100,"bannerPlace":0,"postsInBanner":[],"categoryId":null,"category":null,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null,"showOnMainPage":true,"bannerStatus":0,"pin":false,"isOnlyForTeacher":false},{"id":2,"description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;","socialNetWorkLink":null,"url":"/Upload/Banner/File/164a12350f3500444e088740059eb019a7d4.jpg","createDate":"2020-12-19T00:22:47.4808947","availableDate":"2020-12-19T00:22:47.4808996","creditDays":100,"bannerPlace":0,"postsInBanner":[],"categoryId":null,"category":null,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null,"showOnMainPage":true,"bannerStatus":0,"pin":false,"isOnlyForTeacher":false},{"id":1,"description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;سلام&lt;/p&gt;&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;","socialNetWorkLink":null,"url":"/Upload/Banner/File/b982607308c2304e64081070b39d17e2ec38.jpg","createDate":"2020-12-18T23:49:49.9972938","availableDate":"2020-12-18T23:49:49.9973651","creditDays":100,"bannerPlace":0,"postsInBanner":[1],"categoryId":null,"category":null,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null,"showOnMainPage":true,"bannerStatus":0,"pin":false,"isOnlyForTeacher":false}]
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
         * id : 1006
         * description : &lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;تست3&lt;/p&gt;
         * socialNetWorkLink : null
         * url : null
         * createDate : 2021-02-03T09:19:20.952004
         * availableDate : 2021-02-03T09:19:20.9520112
         * creditDays : 12
         * bannerPlace : 0
         * postsInBanner : []
         * categoryId : 20
         * category : {"id":20,"name":"دفتر تمرین ریاضی","url":"/Upload/Category/File/4fba789d0e31d047560a4bb09089d2451bfc.jpg","applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null}
         * applicationUserId : aea11655-c2bc-49fb-a2bb-79a92c0d0fd6
         * applicationUser : null
         * showOnMainPage : false
         * bannerStatus : 0
         * pin : false
         * isOnlyForTeacher : false
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
        private Category category;
        private String applicationUserId;
        private String applicationUser;
        private boolean showOnMainPage;
        private int bannerStatus;
        private boolean pin;
        private boolean isOnlyForTeacher;
        private ArrayList<Integer> postsInBanner;

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

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
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

        public boolean isIsOnlyForTeacher() {
            return isOnlyForTeacher;
        }

        public void setIsOnlyForTeacher(boolean isOnlyForTeacher) {
            this.isOnlyForTeacher = isOnlyForTeacher;
        }

        public ArrayList<Integer> getPostsInBanner() {
            return postsInBanner;
        }

        public void setPostsInBanner(ArrayList<Integer> postsInBanner) {
            this.postsInBanner = postsInBanner;
        }

        public static class Category implements Serializable{
            /**
             * id : 20
             * name : دفتر تمرین ریاضی
             * url : /Upload/Category/File/4fba789d0e31d047560a4bb09089d2451bfc.jpg
             * applicationUserId : aea11655-c2bc-49fb-a2bb-79a92c0d0fd6
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
}
