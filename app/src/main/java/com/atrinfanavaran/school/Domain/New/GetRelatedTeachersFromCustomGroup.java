package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;
import java.util.ArrayList;

public class GetRelatedTeachersFromCustomGroup {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"idHelper":785478,"fullName":null,"mobile":0,"address":null,"nationalCode":null,"apiToken":null,"url":null,"password":"123456","createDate":"2021-02-07T15:18:04.783633","userType":0,"id":"02174cf0\u20139412\u20134cfe-afbf-59f706d72cf6","userName":"09130961021","normalizedUserName":"09130961021","email":"mainowner@email.com","normalizedEmail":"mainowner@email.com","emailConfirmed":true,"passwordHash":"AQAAAAEAACcQAAAAEMntdqyUgyauC8Zcf/DLSDFpUAJ4TqwjEsr+wUEIHBRUmJFuwgAi1VVB089TmqQOMg==","securityStamp":"9bb93642-4a8a-4b49-8ad0-2658b8340b3a","concurrencyStamp":"8ac6e418-8607-46ca-82b8-e3a56d668de7","phoneNumber":null,"phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0},{"idHelper":636667,"fullName":"خانم تقی زاده","mobile":9931262824,"address":null,"nationalCode":null,"apiToken":null,"url":null,"password":"36514","createDate":"2020-12-19T00:18:04.8846794","userType":1,"id":"23dffd4e-c445-4d6b-9eca-5effe17071a6","userName":"9931262824","normalizedUserName":null,"email":"9931262824yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"308d923f-89b1-470c-8a44-508f4bd2baaa","concurrencyStamp":"f6290ac4-c390-4f41-967e-68ee642e0e7e","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0},{"idHelper":786987,"fullName":"الهه کاظمی","mobile":9139739358,"address":null,"nationalCode":"1111111935","apiToken":null,"url":null,"password":"66048","createDate":"2021-01-04T23:08:42.222046","userType":1,"id":"49550408-8bdb-41f8-b8bc-fd2d7037bb45","userName":"9139739358","normalizedUserName":null,"email":"9139739358yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"141e9830-f66e-4182-8fb3-f54dcb17f9bf","concurrencyStamp":"2c691996-4f29-4701-93ef-6accb6225424","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0},{"idHelper":543221,"fullName":"مژگان هادیان","mobile":9915822906,"address":null,"nationalCode":null,"apiToken":null,"url":null,"password":"45277","createDate":"2020-12-21T23:38:52.2662246","userType":1,"id":"5b56fd2e-acdc-4202-8522-c466cad1285f","userName":"9915822906","normalizedUserName":null,"email":"9915822906yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"5dce504e-7f25-404e-817c-40cfa071a5f4","concurrencyStamp":"5970e3b4-e136-4727-9674-c1a1cfc05222","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0}]
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
         * idHelper : 785478
         * fullName : null
         * mobile : 0
         * address : null
         * nationalCode : null
         * apiToken : null
         * url : null
         * password : 123456
         * createDate : 2021-02-07T15:18:04.783633
         * userType : 0
         * id : 02174cf0–9412–4cfe-afbf-59f706d72cf6
         * userName : 09130961021
         * normalizedUserName : 09130961021
         * email : mainowner@email.com
         * normalizedEmail : mainowner@email.com
         * emailConfirmed : true
         * passwordHash : AQAAAAEAACcQAAAAEMntdqyUgyauC8Zcf/DLSDFpUAJ4TqwjEsr+wUEIHBRUmJFuwgAi1VVB089TmqQOMg==
         * securityStamp : 9bb93642-4a8a-4b49-8ad0-2658b8340b3a
         * concurrencyStamp : 8ac6e418-8607-46ca-82b8-e3a56d668de7
         * phoneNumber : null
         * phoneNumberConfirmed : false
         * twoFactorEnabled : false
         * lockoutEnd : null
         * lockoutEnabled : false
         * accessFailedCount : 0
         */

        private int idHelper;
        private String fullName;

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
