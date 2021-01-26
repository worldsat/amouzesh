package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;
import java.util.ArrayList;

public class GetRelatedComment  {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"id":3,"applicationUserId":null,"applicationUser":null,"studentsId":57,"students":null,"text":"Hi","date":"2021-01-26T00:00:00","commentStatus":1,"educationPostId":1032,"educationPost":{"id":1032,"title":"Test63dd","description":"desssssssss3","iconUrl":null,"medias":null,"number":2,"accessType":1,"pin":false,"categoryId":6,"category":null,"applicationUserId":"d4801771-5087-463f-be54-6d70d2466f39","applicationUser":null,"comments":[],"viewCount":0,"status":0,"groupsIds":null}}]
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
         * id : 3
         * applicationUserId : null
         * applicationUser : null
         * studentsId : 57
         * students : null
         * text : Hi
         * date : 2021-01-26T00:00:00
         * commentStatus : 1
         * educationPostId : 1032
         * educationPost : {"id":1032,"title":"Test63dd","description":"desssssssss3","iconUrl":null,"medias":null,"number":2,"accessType":1,"pin":false,"categoryId":6,"category":null,"applicationUserId":"d4801771-5087-463f-be54-6d70d2466f39","applicationUser":null,"comments":[],"viewCount":0,"status":0,"groupsIds":null}
         */

        private int id;
        private String applicationUserId;
        private String applicationUser;
        private int studentsId;
        private String students;
        private String text;
        private String date;
        private int commentStatus;
        private int educationPostId;
        private EducationPostBean educationPost;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public int getStudentsId() {
            return studentsId;
        }

        public void setStudentsId(int studentsId) {
            this.studentsId = studentsId;
        }

        public String getStudents() {
            return students;
        }

        public void setStudents(String students) {
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

        public EducationPostBean getEducationPost() {
            return educationPost;
        }

        public void setEducationPost(EducationPostBean educationPost) {
            this.educationPost = educationPost;
        }

        public static class EducationPostBean {
            /**
             * id : 1032
             * title : Test63dd
             * description : desssssssss3
             * iconUrl : null
             * medias : null
             * number : 2
             * accessType : 1
             * pin : false
             * categoryId : 6
             * category : null
             * applicationUserId : d4801771-5087-463f-be54-6d70d2466f39
             * applicationUser : null
             * comments : []
             * viewCount : 0
             * status : 0
             * groupsIds : null
             */

            private int id;
            private String title;
            private String description;
            private Object iconUrl;
            private Object medias;
            private int number;
            private int accessType;
            private boolean pin;
            private int categoryId;
            private Object category;
            private String applicationUserId;
            private Object applicationUser;
            private int viewCount;
            private int status;
            private Object groupsIds;
            private ArrayList<?> comments;

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

            public Object getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(Object iconUrl) {
                this.iconUrl = iconUrl;
            }

            public Object getMedias() {
                return medias;
            }

            public void setMedias(Object medias) {
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

            public Object getGroupsIds() {
                return groupsIds;
            }

            public void setGroupsIds(Object groupsIds) {
                this.groupsIds = groupsIds;
            }

            public ArrayList<?> getComments() {
                return comments;
            }

            public void setComments(ArrayList<?> comments) {
                this.comments = comments;
            }
        }
    }
}
