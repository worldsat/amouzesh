package com.atrinfanavaran.school.Domain.New;

import java.util.ArrayList;

public class CommentsGetAll {


    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"id":16,"applicationUserId":null,"applicationUser":null,"studentsId":57,"students":{"id":57,"fullName":"امید جوانمردی","mobile":9214361566,"address":"خیابان رسالت رسالت سوم پلاک ۵۹","nationalCode":"1111111111","apiToken":null,"url":null,"userName":"9214361566","password":"39488","majorId":1,"major":null,"gradeId":1,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},"text":"تست کامنت","date":"2021-02-02T15:43:06.7375895","commentStatus":0,"educationPostId":1058,"educationPost":null}]
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

    public static class Data {
        /**
         * id : 16
         * applicationUserId : null
         * applicationUser : null
         * studentsId : 57
         * students : {"id":57,"fullName":"امید جوانمردی","mobile":9214361566,"address":"خیابان رسالت رسالت سوم پلاک ۵۹","nationalCode":"1111111111","apiToken":null,"url":null,"userName":"9214361566","password":"39488","majorId":1,"major":null,"gradeId":1,"grade":null,"userType":2,"classRoomId":3,"classRoom":null}
         * text : تست کامنت
         * date : 2021-02-02T15:43:06.7375895
         * commentStatus : 0
         * educationPostId : 1058
         * educationPost : null
         */

        private int id;
        private Object applicationUserId;
        private Object applicationUser;
        private int studentsId;
        private Students students;
        private String text;
        private String date;
        private int commentStatus;
        private int educationPostId;
        private Object educationPost;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getApplicationUserId() {
            return applicationUserId;
        }

        public void setApplicationUserId(Object applicationUserId) {
            this.applicationUserId = applicationUserId;
        }

        public Object getApplicationUser() {
            return applicationUser;
        }

        public void setApplicationUser(Object applicationUser) {
            this.applicationUser = applicationUser;
        }

        public int getStudentsId() {
            return studentsId;
        }

        public void setStudentsId(int studentsId) {
            this.studentsId = studentsId;
        }

        public Students getStudents() {
            return students;
        }

        public void setStudents(Students students) {
            this.students = students;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getCommentStatus() {
            return commentStatus;
        }

        public void setCommentStatus(int commentStatus) {
            this.commentStatus = commentStatus;
        }

        public int getEducationPostId() {
            return educationPostId;
        }

        public void setEducationPostId(int educationPostId) {
            this.educationPostId = educationPostId;
        }

        public Object getEducationPost() {
            return educationPost;
        }

        public void setEducationPost(Object educationPost) {
            this.educationPost = educationPost;
        }

        public static class Students {
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
             * major : null
             * gradeId : 1
             * grade : null
             * userType : 2
             * classRoomId : 3
             * classRoom : null
             */

            private int id;
            private String fullName;
            private long mobile;
            private String address;
            private String nationalCode;
            private Object apiToken;
            private Object url;
            private String userName;
            private String password;
            private int majorId;
            private Object major;
            private int gradeId;
            private Object grade;
            private int userType;
            private int classRoomId;
            private Object classRoom;

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

            public Object getApiToken() {
                return apiToken;
            }

            public void setApiToken(Object apiToken) {
                this.apiToken = apiToken;
            }

            public Object getUrl() {
                return url;
            }

            public void setUrl(Object url) {
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

            public Object getMajor() {
                return major;
            }

            public void setMajor(Object major) {
                this.major = major;
            }

            public int getGradeId() {
                return gradeId;
            }

            public void setGradeId(int gradeId) {
                this.gradeId = gradeId;
            }

            public Object getGrade() {
                return grade;
            }

            public void setGrade(Object grade) {
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

            public Object getClassRoom() {
                return classRoom;
            }

            public void setClassRoom(Object classRoom) {
                this.classRoom = classRoom;
            }
        }
    }
}
