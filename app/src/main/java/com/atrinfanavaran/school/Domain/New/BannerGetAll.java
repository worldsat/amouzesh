package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;
import java.util.ArrayList;

public class BannerGetAll {


    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"id":1006,"description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;تست3&lt;/p&gt;","socialNetWorkLink":null,"url":null,"createDate":"2021-02-03T09:19:20.952004","availableDate":"2021-02-03T09:19:20.9520112","creditDays":12,"bannerPlace":0,"postsInBanner":[],"categoryId":20,"category":{"id":20,"name":"دفتر تمرین ریاضی","url":"/Upload/Category/File/4fba789d0e31d047560a4bb09089d2451bfc.jpg","isOnlyForTeacher":false,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":{"fullName":"مدیریت دریای مهر","mobile":9134041021,"address":null,"nationalCode":null,"apiToken":null,"url":null,"password":"85259","createDate":"2020-12-18T23:40:01.9748032","userType":1,"id":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","userName":"9134041021","normalizedUserName":null,"email":"9134041021yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"0693dccf-a00a-4dfd-b5df-77826bf52adc","concurrencyStamp":"35cf9179-7f85-40e3-b044-21576586ee42","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0}},"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":{"fullName":"مدیریت دریای مهر","mobile":9134041021,"address":null,"nationalCode":null,"apiToken":null,"url":null,"password":"85259","createDate":"2020-12-18T23:40:01.9748032","userType":1,"id":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","userName":"9134041021","normalizedUserName":null,"email":"9134041021yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"0693dccf-a00a-4dfd-b5df-77826bf52adc","concurrencyStamp":"35cf9179-7f85-40e3-b044-21576586ee42","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0},"showOnMainPage":false,"bannerStatus":0,"pin":false,"isOnlyForTeacher":false},{"id":6,"description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;","socialNetWorkLink":null,"url":"/Upload/Banner/File/3c09d85a0006c0497f0ad560271b4fb5085c.jpg","createDate":"2020-12-19T00:25:33.5943932","availableDate":"2020-12-19T00:25:33.5943987","creditDays":100,"bannerPlace":1,"postsInBanner":[],"categoryId":null,"category":null,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":{"fullName":"مدیریت دریای مهر","mobile":9134041021,"address":null,"nationalCode":null,"apiToken":null,"url":null,"password":"85259","createDate":"2020-12-18T23:40:01.9748032","userType":1,"id":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","userName":"9134041021","normalizedUserName":null,"email":"9134041021yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"0693dccf-a00a-4dfd-b5df-77826bf52adc","concurrencyStamp":"35cf9179-7f85-40e3-b044-21576586ee42","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0},"showOnMainPage":true,"bannerStatus":0,"pin":false,"isOnlyForTeacher":false},{"id":1005,"description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;تست&lt;/p&gt;&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;","socialNetWorkLink":null,"url":null,"createDate":"0001-01-01T00:00:00","availableDate":"2021-02-03T09:10:56.5498269","creditDays":12,"bannerPlace":0,"postsInBanner":[26],"categoryId":null,"category":null,"applicationUserId":"d4801771-5087-463f-be54-6d70d2466f39","applicationUser":{"fullName":"Atrin","mobile":9136531539,"address":null,"nationalCode":"1272070042","apiToken":null,"url":null,"password":"73763","createDate":"2020-12-18T12:48:55.3761151","userType":1,"id":"d4801771-5087-463f-be54-6d70d2466f39","userName":"9136531539","normalizedUserName":null,"email":"9136531539yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"decfbea8-9cf7-4fae-b533-1a8249df483f","concurrencyStamp":"393d007d-47ca-4e5c-bdf7-2cc6f5b72138","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0},"showOnMainPage":false,"bannerStatus":0,"pin":false,"isOnlyForTeacher":false}]
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
         * category : {"id":20,"name":"دفتر تمرین ریاضی","url":"/Upload/Category/File/4fba789d0e31d047560a4bb09089d2451bfc.jpg","isOnlyForTeacher":false,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":{"fullName":"مدیریت دریای مهر","mobile":9134041021,"address":null,"nationalCode":null,"apiToken":null,"url":null,"password":"85259","createDate":"2020-12-18T23:40:01.9748032","userType":1,"id":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","userName":"9134041021","normalizedUserName":null,"email":"9134041021yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"0693dccf-a00a-4dfd-b5df-77826bf52adc","concurrencyStamp":"35cf9179-7f85-40e3-b044-21576586ee42","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0}}
         * applicationUserId : aea11655-c2bc-49fb-a2bb-79a92c0d0fd6
         * applicationUser : {"fullName":"مدیریت دریای مهر","mobile":9134041021,"address":null,"nationalCode":null,"apiToken":null,"url":null,"password":"85259","createDate":"2020-12-18T23:40:01.9748032","userType":1,"id":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","userName":"9134041021","normalizedUserName":null,"email":"9134041021yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"0693dccf-a00a-4dfd-b5df-77826bf52adc","concurrencyStamp":"35cf9179-7f85-40e3-b044-21576586ee42","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0}
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
        private ApplicationUserX applicationUser;
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

        public ApplicationUserX getApplicationUser() {
            return applicationUser;
        }

        public void setApplicationUser(ApplicationUserX applicationUser) {
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

        public static class Category {
            /**
             * id : 20
             * name : دفتر تمرین ریاضی
             * url : /Upload/Category/File/4fba789d0e31d047560a4bb09089d2451bfc.jpg
             * isOnlyForTeacher : false
             * applicationUserId : aea11655-c2bc-49fb-a2bb-79a92c0d0fd6
             * applicationUser : {"fullName":"مدیریت دریای مهر","mobile":9134041021,"address":null,"nationalCode":null,"apiToken":null,"url":null,"password":"85259","createDate":"2020-12-18T23:40:01.9748032","userType":1,"id":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","userName":"9134041021","normalizedUserName":null,"email":"9134041021yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"0693dccf-a00a-4dfd-b5df-77826bf52adc","concurrencyStamp":"35cf9179-7f85-40e3-b044-21576586ee42","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0}
             */

            private int id;
            private String name;
            private String url;
            private boolean isOnlyForTeacher;
            private String applicationUserId;
            private ApplicationUser applicationUser;

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

            public boolean isIsOnlyForTeacher() {
                return isOnlyForTeacher;
            }

            public void setIsOnlyForTeacher(boolean isOnlyForTeacher) {
                this.isOnlyForTeacher = isOnlyForTeacher;
            }

            public String getApplicationUserId() {
                return applicationUserId;
            }

            public void setApplicationUserId(String applicationUserId) {
                this.applicationUserId = applicationUserId;
            }

            public ApplicationUser getApplicationUser() {
                return applicationUser;
            }

            public void setApplicationUser(ApplicationUser applicationUser) {
                this.applicationUser = applicationUser;
            }

            public static class ApplicationUser {
                /**
                 * fullName : مدیریت دریای مهر
                 * mobile : 9134041021
                 * address : null
                 * nationalCode : null
                 * apiToken : null
                 * url : null
                 * password : 85259
                 * createDate : 2020-12-18T23:40:01.9748032
                 * userType : 1
                 * id : aea11655-c2bc-49fb-a2bb-79a92c0d0fd6
                 * userName : 9134041021
                 * normalizedUserName : null
                 * email : 9134041021yahoo.com
                 * normalizedEmail : null
                 * emailConfirmed : false
                 * passwordHash : null
                 * securityStamp : 0693dccf-a00a-4dfd-b5df-77826bf52adc
                 * concurrencyStamp : 35cf9179-7f85-40e3-b044-21576586ee42
                 * phoneNumber : 0
                 * phoneNumberConfirmed : false
                 * twoFactorEnabled : false
                 * lockoutEnd : null
                 * lockoutEnabled : false
                 * accessFailedCount : 0
                 */

                private String fullName;
                private long mobile;
                private String address;
                private String nationalCode;
                private String apiToken;
                private String url;
                private String password;
                private String createDate;
                private int userType;
                private String id;
                private String userName;
                private String normalizedUserName;
                private String email;
                private String normalizedEmail;
                private boolean emailConfirmed;
                private String passwordHash;
                private String securityStamp;
                private String concurrencyStamp;
                private String phoneNumber;
                private boolean phoneNumberConfirmed;
                private boolean twoFactorEnabled;
                private String lockoutEnd;
                private boolean lockoutEnabled;
                private int accessFailedCount;

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

                public String getPassword() {
                    return password;
                }

                public void setPassword(String password) {
                    this.password = password;
                }

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
                }

                public int getUserType() {
                    return userType;
                }

                public void setUserType(int userType) {
                    this.userType = userType;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public String getNormalizedUserName() {
                    return normalizedUserName;
                }

                public void setNormalizedUserName(String normalizedUserName) {
                    this.normalizedUserName = normalizedUserName;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public String getNormalizedEmail() {
                    return normalizedEmail;
                }

                public void setNormalizedEmail(String normalizedEmail) {
                    this.normalizedEmail = normalizedEmail;
                }

                public boolean isEmailConfirmed() {
                    return emailConfirmed;
                }

                public void setEmailConfirmed(boolean emailConfirmed) {
                    this.emailConfirmed = emailConfirmed;
                }

                public String getPasswordHash() {
                    return passwordHash;
                }

                public void setPasswordHash(String passwordHash) {
                    this.passwordHash = passwordHash;
                }

                public String getSecurityStamp() {
                    return securityStamp;
                }

                public void setSecurityStamp(String securityStamp) {
                    this.securityStamp = securityStamp;
                }

                public String getConcurrencyStamp() {
                    return concurrencyStamp;
                }

                public void setConcurrencyStamp(String concurrencyStamp) {
                    this.concurrencyStamp = concurrencyStamp;
                }

                public String getPhoneNumber() {
                    return phoneNumber;
                }

                public void setPhoneNumber(String phoneNumber) {
                    this.phoneNumber = phoneNumber;
                }

                public boolean isPhoneNumberConfirmed() {
                    return phoneNumberConfirmed;
                }

                public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
                    this.phoneNumberConfirmed = phoneNumberConfirmed;
                }

                public boolean isTwoFactorEnabled() {
                    return twoFactorEnabled;
                }

                public void setTwoFactorEnabled(boolean twoFactorEnabled) {
                    this.twoFactorEnabled = twoFactorEnabled;
                }

                public String getLockoutEnd() {
                    return lockoutEnd;
                }

                public void setLockoutEnd(String lockoutEnd) {
                    this.lockoutEnd = lockoutEnd;
                }

                public boolean isLockoutEnabled() {
                    return lockoutEnabled;
                }

                public void setLockoutEnabled(boolean lockoutEnabled) {
                    this.lockoutEnabled = lockoutEnabled;
                }

                public int getAccessFailedCount() {
                    return accessFailedCount;
                }

                public void setAccessFailedCount(int accessFailedCount) {
                    this.accessFailedCount = accessFailedCount;
                }
            }
        }

        public static class ApplicationUserX {
            /**
             * fullName : مدیریت دریای مهر
             * mobile : 9134041021
             * address : null
             * nationalCode : null
             * apiToken : null
             * url : null
             * password : 85259
             * createDate : 2020-12-18T23:40:01.9748032
             * userType : 1
             * id : aea11655-c2bc-49fb-a2bb-79a92c0d0fd6
             * userName : 9134041021
             * normalizedUserName : null
             * email : 9134041021yahoo.com
             * normalizedEmail : null
             * emailConfirmed : false
             * passwordHash : null
             * securityStamp : 0693dccf-a00a-4dfd-b5df-77826bf52adc
             * concurrencyStamp : 35cf9179-7f85-40e3-b044-21576586ee42
             * phoneNumber : 0
             * phoneNumberConfirmed : false
             * twoFactorEnabled : false
             * lockoutEnd : null
             * lockoutEnabled : false
             * accessFailedCount : 0
             */

            private String fullName;
            private long mobile;
            private String address;
            private String nationalCode;
            private String apiToken;
            private String url;
            private String password;
            private String createDate;
            private int userType;
            private String id;
            private String userName;
            private String normalizedUserName;
            private String email;
            private String normalizedEmail;
            private boolean emailConfirmed;
            private String passwordHash;
            private String securityStamp;
            private String concurrencyStamp;
            private String phoneNumber;
            private boolean phoneNumberConfirmed;
            private boolean twoFactorEnabled;
            private String lockoutEnd;
            private boolean lockoutEnabled;
            private int accessFailedCount;

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

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getNormalizedUserName() {
                return normalizedUserName;
            }

            public void setNormalizedUserName(String normalizedUserName) {
                this.normalizedUserName = normalizedUserName;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getNormalizedEmail() {
                return normalizedEmail;
            }

            public void setNormalizedEmail(String normalizedEmail) {
                this.normalizedEmail = normalizedEmail;
            }

            public boolean isEmailConfirmed() {
                return emailConfirmed;
            }

            public void setEmailConfirmed(boolean emailConfirmed) {
                this.emailConfirmed = emailConfirmed;
            }

            public String getPasswordHash() {
                return passwordHash;
            }

            public void setPasswordHash(String passwordHash) {
                this.passwordHash = passwordHash;
            }

            public String getSecurityStamp() {
                return securityStamp;
            }

            public void setSecurityStamp(String securityStamp) {
                this.securityStamp = securityStamp;
            }

            public String getConcurrencyStamp() {
                return concurrencyStamp;
            }

            public void setConcurrencyStamp(String concurrencyStamp) {
                this.concurrencyStamp = concurrencyStamp;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public boolean isPhoneNumberConfirmed() {
                return phoneNumberConfirmed;
            }

            public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
                this.phoneNumberConfirmed = phoneNumberConfirmed;
            }

            public boolean isTwoFactorEnabled() {
                return twoFactorEnabled;
            }

            public void setTwoFactorEnabled(boolean twoFactorEnabled) {
                this.twoFactorEnabled = twoFactorEnabled;
            }

            public String getLockoutEnd() {
                return lockoutEnd;
            }

            public void setLockoutEnd(String lockoutEnd) {
                this.lockoutEnd = lockoutEnd;
            }

            public boolean isLockoutEnabled() {
                return lockoutEnabled;
            }

            public void setLockoutEnabled(boolean lockoutEnabled) {
                this.lockoutEnabled = lockoutEnabled;
            }

            public int getAccessFailedCount() {
                return accessFailedCount;
            }

            public void setAccessFailedCount(int accessFailedCount) {
                this.accessFailedCount = accessFailedCount;
            }
        }
    }
}
