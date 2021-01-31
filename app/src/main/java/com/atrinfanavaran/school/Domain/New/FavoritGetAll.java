package com.atrinfanavaran.school.Domain.New;

import java.util.ArrayList;

public class FavoritGetAll {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"id":6,"educationPostId":1058,"educationPost":{"id":1058,"title":"تست","description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;تست&lt;/p&gt;&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;","iconUrl":null,"medias":null,"number":0,"accessType":0,"pin":false,"categoryId":20,"category":null,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null,"comments":null,"viewCount":0,"status":0,"groupsIds":null,"studentArrayListToPost":null,"teacherArrayListToPost":null,"usersToEducationPosts":null},"bannerId":null,"banner":null,"studentsId":57,"students":{"id":57,"fullName":"امید جوانمردی","mobile":9214361566,"address":"خیابان رسالت رسالت سوم پلاک ۵۹","nationalCode":"1111111111","apiToken":null,"url":null,"userName":"9214361566","password":"39488","majorId":1,"major":null,"gradeId":1,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},"applicationUserId":null,"applicationUser":null}]
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
         * id : 6
         * educationPostId : 1058
         * educationPost : {"id":1058,"title":"تست","description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;تست&lt;/p&gt;&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;","iconUrl":null,"medias":null,"number":0,"accessType":0,"pin":false,"categoryId":20,"category":null,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null,"comments":null,"viewCount":0,"status":0,"groupsIds":null,"studentArrayListToPost":null,"teacherArrayListToPost":null,"usersToEducationPosts":null}
         * bannerId : null
         * banner : null
         * studentsId : 57
         * students : {"id":57,"fullName":"امید جوانمردی","mobile":9214361566,"address":"خیابان رسالت رسالت سوم پلاک ۵۹","nationalCode":"1111111111","apiToken":null,"url":null,"userName":"9214361566","password":"39488","majorId":1,"major":null,"gradeId":1,"grade":null,"userType":2,"classRoomId":3,"classRoom":null}
         * applicationUserId : null
         * applicationUser : null
         */

        private int id;
        private int educationPostId;
        private EducationPost educationPost;
        private String bannerId;
        private String banner;
        private int studentsId;
        private Students students;
        private String applicationUserId;
        private String applicationUser;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getEducationPostId() {
            return educationPostId;
        }

        public void setEducationPostId(int educationPostId) {
            this.educationPostId = educationPostId;
        }

        public EducationPost getEducationPost() {
            return educationPost;
        }

        public void setEducationPost(EducationPost educationPost) {
            this.educationPost = educationPost;
        }

        public String getBannerId() {
            return bannerId;
        }

        public void setBannerId(String bannerId) {
            this.bannerId = bannerId;
        }

        public String getBanner() {
            return banner;
        }

        public void setBanner(String banner) {
            this.banner = banner;
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

        public static class EducationPost {
            /**
             * id : 1058
             * title : تست
             * description : &lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;تست&lt;/p&gt;&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;
             * iconUrl : null
             * medias : null
             * number : 0
             * accessType : 0
             * pin : false
             * categoryId : 20
             * category : null
             * applicationUserId : aea11655-c2bc-49fb-a2bb-79a92c0d0fd6
             * applicationUser : null
             * comments : null
             * viewCount : 0
             * status : 0
             * groupsIds : null
             * studentArrayListToPost : null
             * teacherArrayListToPost : null
             * usersToEducationPosts : null
             */

            private int id;
            private String title;
            private String description;
            private String iconUrl;
            private String medias;
            private int number;
            private int accessType;
            private boolean pin;
            private int categoryId;
            private String category;
            private String applicationUserId;
            private String applicationUser;
            private String comments;
            private int viewCount;
            private int status;
            private String groupsIds;
            private String studentArrayListToPost;
            private String teacherArrayListToPost;
            private String usersToEducationPosts;

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

            public String getMedias() {
                return medias;
            }

            public void setMedias(String medias) {
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

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
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

            public String getComments() {
                return comments;
            }

            public void setComments(String comments) {
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

            public String getGroupsIds() {
                return groupsIds;
            }

            public void setGroupsIds(String groupsIds) {
                this.groupsIds = groupsIds;
            }

            public String getStudentArrayListToPost() {
                return studentArrayListToPost;
            }

            public void setStudentArrayListToPost(String studentArrayListToPost) {
                this.studentArrayListToPost = studentArrayListToPost;
            }

            public String getTeacherArrayListToPost() {
                return teacherArrayListToPost;
            }

            public void setTeacherArrayListToPost(String teacherArrayListToPost) {
                this.teacherArrayListToPost = teacherArrayListToPost;
            }

            public String getUsersToEducationPosts() {
                return usersToEducationPosts;
            }

            public void setUsersToEducationPosts(String usersToEducationPosts) {
                this.usersToEducationPosts = usersToEducationPosts;
            }
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
            private String apiToken;
            private String url;
            private String userName;
            private String password;
            private int majorId;
            private String major;
            private int gradeId;
            private String grade;
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

            public String getMajor() {
                return major;
            }

            public void setMajor(String major) {
                this.major = major;
            }

            public int getGradeId() {
                return gradeId;
            }

            public void setGradeId(int gradeId) {
                this.gradeId = gradeId;
            }

            public String getGrade() {
                return grade;
            }

            public void setGrade(String grade) {
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
        }
    }
}
