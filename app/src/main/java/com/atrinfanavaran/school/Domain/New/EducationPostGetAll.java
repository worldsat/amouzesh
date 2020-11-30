package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;
import java.util.ArrayList;

public class EducationPostGetAll implements Serializable {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"id":41,"title":"test","description":"&lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;b&gt;test2&lt;/b&gt;&lt;/p&gt;","iconUrl":"/Upload/Post/Icon/a8062ed60272104b550aa1b022ad80128eca.jpg","medias":[{"id":51,"title":"-46-11.jpg","url":"/Upload/Post/Media/140f68f60531004b860a0c6043625976dc79.jpg","educationPostId":41,"durationTime":"0","lenght":"1.6 KB","mediaType":5},{"id":52,"title":"-00-40.jpg","url":"/Upload/Post/Media/d36eafb007282048c80b42e0c2ed17d66c9e.jpg","educationPostId":41,"durationTime":"0","lenght":"1.6 KB","mediaType":5}],"number":0,"accessType":1,"pin":true,"category":1,"teacherId":1,"teacher":null},{"id":17,"title":"Alireza44","description":"Razmjoooooooo","iconUrl":"/Upload/Post/Icon/a3d87612016a20492d0b39f023d28a1ca9b5.png","medias":[],"number":2020,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":16,"title":"Test6","description":"desssssssss3","iconUrl":"/Upload/Post/Icon/37e6c38f0e541047290a31a001f289913606.png","medias":[],"number":2,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":15,"title":"ریاضی فصل سوم","description":"<p data-tag=\"input\" style=\"color:#000000;\"><\/p>","iconUrl":null,"medias":[],"number":1,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":14,"title":"ریاضی فصل سوم","description":"<p data-tag=\"input\" style=\"color:#000000;\"><\/p>","iconUrl":null,"medias":[{"id":35,"title":"symbol_54.png","url":"/Upload/Post/Media/a7cc579008a3e04d0009ca701f944cc370c4.png","educationPostId":14,"durationTime":null,"lenght":null,"mediaType":5}],"number":1,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":13,"title":"ریاضی فصل سوم","description":"<p data-tag=\"input\" style=\"color:#000000;\"><\/p>","iconUrl":null,"medias":[{"id":33,"title":"symbol_55.png","url":"/Upload/Post/Media/3b4f75d900015048430befc05ee65f5c7e51.png","educationPostId":13,"durationTime":null,"lenght":null,"mediaType":5},{"id":34,"title":"symbol_54.png","url":"/Upload/Post/Media/145f46cd0ff930415909082088cd4178ed0d.png","educationPostId":13,"durationTime":null,"lenght":null,"mediaType":5}],"number":1,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":12,"title":"ریاضی فصل سوم","description":"<p data-tag=\"input\" style=\"color:#000000;\"><\/p>","iconUrl":null,"medias":[],"number":1,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":11,"title":"ریاضی فصل سوم","description":"<p data-tag=\"input\" style=\"color:#000000;\"><\/p>","iconUrl":null,"medias":[],"number":1,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null},{"id":10,"title":"ریاضی دوم دبیرستان","description":" تست توضیحات","iconUrl":"/Upload/Post/Icon/1fca73690af1604fe20b60e056736d719021.png","medias":[{"id":30,"title":"جلسه.pdf","url":"/Upload/Post/Media/b51957ec07942048b70bbcb000c8882ea3f0.pdf","educationPostId":10,"durationTime":null,"lenght":null,"mediaType":0},{"id":31,"title":"فیلم 1.mp4","url":"/Upload/Post/Media/550c40a808670049e0081cb0594b1f597471.mp4","educationPostId":10,"durationTime":null,"lenght":null,"mediaType":3},{"id":32,"title":"صدای جلسه.mp3","url":"/Upload/Post/Media/a610babd04861049b7081fc05ebfdfd3cdbe.mp3","educationPostId":10,"durationTime":null,"lenght":null,"mediaType":4}],"number":1,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null}]
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

    public static class Data  implements Serializable{
        /**
         * id : 41
         * title : test
         * description : &lt;p data-tag=&quot;input&quot; style=&quot;color:#000000;&quot;&gt;&lt;b&gt;test2&lt;/b&gt;&lt;/p&gt;
         * iconUrl : /Upload/Post/Icon/a8062ed60272104b550aa1b022ad80128eca.jpg
         * medias : [{"id":51,"title":"-46-11.jpg","url":"/Upload/Post/Media/140f68f60531004b860a0c6043625976dc79.jpg","educationPostId":41,"durationTime":"0","lenght":"1.6 KB","mediaType":5},{"id":52,"title":"-00-40.jpg","url":"/Upload/Post/Media/d36eafb007282048c80b42e0c2ed17d66c9e.jpg","educationPostId":41,"durationTime":"0","lenght":"1.6 KB","mediaType":5}]
         * number : 0
         * accessType : 1
         * pin : true
         * category : 1
         * teacherId : 1
         * teacher : null
         */

        private int id;
        private String title;
        private String description;
        private String iconUrl;
        private int number;
        private int accessType;
        private boolean pin;
        private int category;
        private int teacherId;
        private Object teacher;
        private ArrayList<Medias> medias;

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

        public ArrayList<Medias> getMedias() {
            return medias;
        }

        public void setMedias(ArrayList<Medias> medias) {
            this.medias = medias;
        }

        public static class Medias implements Serializable {
            /**
             * id : 51
             * title : -46-11.jpg
             * url : /Upload/Post/Media/140f68f60531004b860a0c6043625976dc79.jpg
             * educationPostId : 41
             * durationTime : 0
             * lenght : 1.6 KB
             * mediaType : 5
             */

            private int id;
            private String title;
            private String url;
            private int educationPostId;
            private String durationTime;
            private String lenght;
            private int mediaType;

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

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getEducationPostId() {
                return educationPostId;
            }

            public void setEducationPostId(int educationPostId) {
                this.educationPostId = educationPostId;
            }

            public String getDurationTime() {
                return durationTime;
            }

            public void setDurationTime(String durationTime) {
                this.durationTime = durationTime;
            }

            public String getLenght() {
                return lenght;
            }

            public void setLenght(String lenght) {
                this.lenght = lenght;
            }

            public int getMediaType() {
                return mediaType;
            }

            public void setMediaType(int mediaType) {
                this.mediaType = mediaType;
            }
        }
    }
}
