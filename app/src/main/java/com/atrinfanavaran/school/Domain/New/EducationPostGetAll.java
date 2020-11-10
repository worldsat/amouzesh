package com.atrinfanavaran.school.Domain.New;

import java.util.ArrayList;

public class EducationPostGetAll {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"id":8,"title":"Test6","description":"desssssssss3","iconUrl":"/Upload/Post/Icon/d3fe8a040d5af04c4c0928901ef48d492d25.png","medias":null,"number":2,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":9,"title":"Test6","description":"desssssssss3","iconUrl":"/Upload/Post/Icon/25ad3a3a09d80041db089a9075495e9b24ef.png","medias":null,"number":2,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":10,"title":"ریاضی دوم دبیرستان","description":" تست توضیحات","iconUrl":"/Upload/Post/Icon/1fca73690af1604fe20b60e056736d719021.png","medias":null,"number":1,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":11,"title":"ریاضی فصل سوم","description":"<p data-tag=\"input\" style=\"color:#000000;\"><\/p>","iconUrl":null,"medias":null,"number":1,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":12,"title":"ریاضی فصل سوم","description":"<p data-tag=\"input\" style=\"color:#000000;\"><\/p>","iconUrl":null,"medias":null,"number":1,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":13,"title":"ریاضی فصل سوم","description":"<p data-tag=\"input\" style=\"color:#000000;\"><\/p>","iconUrl":null,"medias":null,"number":1,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":14,"title":"ریاضی فصل سوم","description":"<p data-tag=\"input\" style=\"color:#000000;\"><\/p>","iconUrl":null,"medias":null,"number":1,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":15,"title":"ریاضی فصل سوم","description":"<p data-tag=\"input\" style=\"color:#000000;\"><\/p>","iconUrl":null,"medias":null,"number":1,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":16,"title":"Test6","description":"desssssssss3","iconUrl":"/Upload/Post/Icon/37e6c38f0e541047290a31a001f289913606.png","medias":null,"number":2,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":17,"title":"Test6","description":"desssssssss3","iconUrl":"/Upload/Post/Icon/a3d87612016a20492d0b39f023d28a1ca9b5.png","medias":null,"number":2,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":18,"title":"Test6","description":"desssssssss3","iconUrl":"/Upload/Post/Icon/87c504720ec7c04ca8087a90c0630f9ccb92.png","medias":null,"number":2,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":19,"title":"ریاضی فصل سوم","description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;/p&gt;","iconUrl":"/Upload/Post/Icon/68810cba0ebbb046ab09caf0bd9cce603e82.jpg","medias":null,"number":0,"accessType":1,"pin":false,"category":3,"teacherId":1,"teacher":null},{"id":20,"title":"ریاضی فصل سوم66","description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#FF0000;&quot;&gt;تست&lt;/p&gt;","iconUrl":"/Upload/Post/Icon/e6c82238070fa0430008bb1042d3126a1f94.jpg","medias":null,"number":0,"accessType":1,"pin":true,"category":3,"teacherId":1,"teacher":null}]
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
         * id : 8
         * title : Test6
         * description : desssssssss3
         * iconUrl : /Upload/Post/Icon/d3fe8a040d5af04c4c0928901ef48d492d25.png
         * medias : null
         * number : 2
         * accessType : 1
         * pin : false
         * category : 0
         * teacherId : 1
         * teacher : null
         */

        private int id;
        private String title;
        private String description;
        private String iconUrl;
        private Object medias;
        private int number;
        private int accessType;
        private boolean pin;
        private int category;
        private int teacherId;
        private Object teacher;

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

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public int getTeacherId() {
            return teacherId;
        }

        public void setTeacherId(int teacherId) {
            this.teacherId = teacherId;
        }

        public Object getTeacher() {
            return teacher;
        }

        public void setTeacher(Object teacher) {
            this.teacher = teacher;
        }
    }
}
