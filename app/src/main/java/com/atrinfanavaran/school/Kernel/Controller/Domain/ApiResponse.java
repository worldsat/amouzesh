package com.atrinfanavaran.school.Kernel.Controller.Domain;

public class ApiResponse {


    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : {"user":{"fullName":"آترین","mobile":9136569769,"address":"Esf","nationalCode":"1272060042","apiToken":null,"url":"/Upload/Teacher/File/57313763.jpg","password":"123456","createDate":"2020-12-07T16:59:24.4402891+03:30","userType":1,"id":"708c6bf2-2d90-44f5-bfa8-9729224d598e","userName":"9136569769","normalizedUserName":null,"email":null,"normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"29ab7880-db15-4904-832f-d3bd2ff8b58f","concurrencyStamp":"4b6ef0d3-afcc-420b-a204-eff1f4cde26b","phoneNumber":null,"phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0},"school":"دریای مهر"}
     */

    private boolean success;
    private int status;
    private String message;
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * user : {"fullName":"آترین","mobile":9136569769,"address":"Esf","nationalCode":"1272060042","apiToken":null,"url":"/Upload/Teacher/File/57313763.jpg","password":"123456","createDate":"2020-12-07T16:59:24.4402891+03:30","userType":1,"id":"708c6bf2-2d90-44f5-bfa8-9729224d598e","userName":"9136569769","normalizedUserName":null,"email":null,"normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"29ab7880-db15-4904-832f-d3bd2ff8b58f","concurrencyStamp":"4b6ef0d3-afcc-420b-a204-eff1f4cde26b","phoneNumber":null,"phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0}
         * school : دریای مهر
         */

        private User user;
        private String school;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public static class User {
            /**
             * fullName : آترین
             * mobile : 9136569769
             * address : Esf
             * nationalCode : 1272060042
             * apiToken : null
             * url : /Upload/Teacher/File/57313763.jpg
             * password : 123456
             * createDate : 2020-12-07T16:59:24.4402891+03:30
             * userType : 1
             * id : 708c6bf2-2d90-44f5-bfa8-9729224d598e
             * userName : 9136569769
             * normalizedUserName : null
             * email : null
             * normalizedEmail : null
             * emailConfirmed : false
             * passwordHash : null
             * securityStamp : 29ab7880-db15-4904-832f-d3bd2ff8b58f
             * concurrencyStamp : 4b6ef0d3-afcc-420b-a204-eff1f4cde26b
             * phoneNumber : null
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
            private Object apiToken;
            private String url;
            private String password;
            private String createDate;
            private int userType;
            private String id;
            private String userName;
            private Object normalizedUserName;
            private Object email;
            private Object normalizedEmail;
            private boolean emailConfirmed;
            private Object passwordHash;
            private String securityStamp;
            private String concurrencyStamp;
            private Object phoneNumber;
            private boolean phoneNumberConfirmed;
            private boolean twoFactorEnabled;
            private Object lockoutEnd;
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

            public Object getApiToken() {
                return apiToken;
            }

            public void setApiToken(Object apiToken) {
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

            public Object getNormalizedUserName() {
                return normalizedUserName;
            }

            public void setNormalizedUserName(Object normalizedUserName) {
                this.normalizedUserName = normalizedUserName;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public Object getNormalizedEmail() {
                return normalizedEmail;
            }

            public void setNormalizedEmail(Object normalizedEmail) {
                this.normalizedEmail = normalizedEmail;
            }

            public boolean isEmailConfirmed() {
                return emailConfirmed;
            }

            public void setEmailConfirmed(boolean emailConfirmed) {
                this.emailConfirmed = emailConfirmed;
            }

            public Object getPasswordHash() {
                return passwordHash;
            }

            public void setPasswordHash(Object passwordHash) {
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

            public Object getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(Object phoneNumber) {
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

            public Object getLockoutEnd() {
                return lockoutEnd;
            }

            public void setLockoutEnd(Object lockoutEnd) {
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
