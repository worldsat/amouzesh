package com.atrinfanavaran.school.Domain.New;

import java.util.ArrayList;

public class CommentsGetAll {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"id":3,"applicationUserId":null,"applicationUser":null,"studentsId":57,"students":null,"text":"Hi","date":"2021-01-26T00:00:00","commentStatus":1,"educationPostId":1032,"educationPost":null}]
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
         * id : 3
         * applicationUserId : null
         * applicationUser : null
         * studentsId : 57
         * students : null
         * text : Hi
         * date : 2021-01-26T00:00:00
         * commentStatus : 1
         * educationPostId : 1032
         * educationPost : null
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
        private String educationPost;

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

        public String getEducationPost() {
            return educationPost;
        }

        public void setEducationPost(String educationPost) {
            this.educationPost = educationPost;
        }
    }
}
