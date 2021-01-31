package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;

public class UserGetStudentById {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : {"id":57,"fullName":"امید جوانمردی","mobile":9214361566,"address":"خیابان رسالت رسالت سوم پلاک ۵۹","nationalCode":"1111111111","apiToken":null,"url":null,"userName":"9214361566","password":"39488","majorId":1,"major":{"id":1,"code":"777777","name":"دریای مهر"},"gradeId":1,"grade":{"id":1,"code":"112","name":"اول"},"userType":2,"classRoomId":3,"classRoom":null}
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

    public static class Data implements Serializable {
        /**
         * id : 57
         * fullName : امید جوانمردی
         * mobile : 9214361566
         * address : خیابان رسالت رسالت سوم پلاک ۵۹
         * nationalCode : 1111111111
         * apiToken : null
         * url : null
         * userName : 9214361566
         * password : 39488
         * majorId : 1
         * major : {"id":1,"code":"777777","name":"دریای مهر"}
         * gradeId : 1
         * grade : {"id":1,"code":"112","name":"اول"}
         * userType : 2
         * classRoomId : 3
         * classRoom : null
         */

        private int id;
        private String fullName;
        private long mobile;
        private String address;
        private String nationalCode;
        private String apiToken;
        private String url;
        private String userName;
        private String password;
        private int majorId;
        private Major major;
        private int gradeId;
        private Grade grade;
        private int userType;
        private int classRoomId;
        private String classRoom;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getMajorId() {
            return majorId;
        }

        public void setMajorId(int majorId) {
            this.majorId = majorId;
        }

        public Major getMajor() {
            return major;
        }

        public void setMajor(Major major) {
            this.major = major;
        }

        public int getGradeId() {
            return gradeId;
        }

        public void setGradeId(int gradeId) {
            this.gradeId = gradeId;
        }

        public Grade getGrade() {
            return grade;
        }

        public void setGrade(Grade grade) {
            this.grade = grade;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getClassRoomId() {
            return classRoomId;
        }

        public void setClassRoomId(int classRoomId) {
            this.classRoomId = classRoomId;
        }

        public String getClassRoom() {
            return classRoom;
        }

        public void setClassRoom(String classRoom) {
            this.classRoom = classRoom;
        }

        public static class Major {
            /**
             * id : 1
             * code : 777777
             * name : دریای مهر
             */

            private int id;
            private String code;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class Grade {
            /**
             * id : 1
             * code : 112
             * name : اول
             */

            private int id;
            private String code;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
