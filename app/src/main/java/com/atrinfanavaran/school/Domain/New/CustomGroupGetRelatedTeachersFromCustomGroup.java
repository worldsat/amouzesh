package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;
import java.util.List;

public class CustomGroupGetRelatedTeachersFromCustomGroup {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"idHelper":786987,"fullName":"الهه کاظمی","mobile":0,"address":null,"nationalCode":"1111111935","apiToken":null,"url":null,"password":"66048","createDate":"2021-01-04T23:08:42.222046","userType":1,"id":"49550408-8bdb-41f8-b8bc-fd2d7037bb45","userName":"9139739358","normalizedUserName":null,"email":"9139739358yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"141e9830-f66e-4182-8fb3-f54dcb17f9bf","concurrencyStamp":"2c691996-4f29-4701-93ef-6accb6225424","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0},{"idHelper":543221,"fullName":"مژگان هادیان","mobile":0,"address":null,"nationalCode":null,"apiToken":null,"url":null,"password":"45277","createDate":"2020-12-21T23:38:52.2662246","userType":1,"id":"5b56fd2e-acdc-4202-8522-c466cad1285f","userName":"9915822906","normalizedUserName":null,"email":"9915822906yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"5dce504e-7f25-404e-817c-40cfa071a5f4","concurrencyStamp":"5970e3b4-e136-4727-9674-c1a1cfc05222","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0},{"idHelper":478584,"fullName":"مدیریت دریای مهر","mobile":0,"address":null,"nationalCode":null,"apiToken":null,"url":null,"password":"85259","createDate":"2020-12-18T23:40:01.9748032","userType":1,"id":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","userName":"9134041021","normalizedUserName":null,"email":"9134041021yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"0693dccf-a00a-4dfd-b5df-77826bf52adc","concurrencyStamp":"35cf9179-7f85-40e3-b044-21576586ee42","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0},{"idHelper":142356,"fullName":"Atrin","mobile":0,"address":null,"nationalCode":"1272070042","apiToken":null,"url":null,"password":"73763","createDate":"2020-12-18T12:48:55.3761151","userType":1,"id":"d4801771-5087-463f-be54-6d70d2466f39","userName":"9136531539","normalizedUserName":null,"email":"9136531539yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"decfbea8-9cf7-4fae-b533-1a8249df483f","concurrencyStamp":"393d007d-47ca-4e5c-bdf7-2cc6f5b72138","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0}]
     */

    private boolean success;
    private int status;
    private String message;
    private List<Data> data;

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

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public static class Data implements Serializable {
        /**
         * idHelper : 786987
         * fullName : الهه کاظمی
         * mobile : 0
         * address : null
         * nationalCode : 1111111935
         * apiToken : null
         * url : null
         * password : 66048
         * createDate : 2021-01-04T23:08:42.222046
         * userType : 1
         * id : 49550408-8bdb-41f8-b8bc-fd2d7037bb45
         * userName : 9139739358
         * normalizedUserName : null
         * email : 9139739358yahoo.com
         * normalizedEmail : null
         * emailConfirmed : false
         * passwordHash : null
         * securityStamp : 141e9830-f66e-4182-8fb3-f54dcb17f9bf
         * concurrencyStamp : 2c691996-4f29-4701-93ef-6accb6225424
         * phoneNumber : 0
         * phoneNumberConfirmed : false
         * twoFactorEnabled : false
         * lockoutEnd : null
         * lockoutEnabled : false
         * accessFailedCount : 0
         */

        private int idHelper;
        private String fullName;
        private int mobile;
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

        public int getIdHelper() {
            return idHelper;
        }

        public void setIdHelper(int idHelper) {
            this.idHelper = idHelper;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public int getMobile() {
            return mobile;
        }

        public void setMobile(int mobile) {
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
