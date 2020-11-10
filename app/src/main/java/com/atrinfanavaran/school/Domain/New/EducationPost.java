package com.atrinfanavaran.school.Domain.New;

import java.util.ArrayList;

public class EducationPost {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : {"id":8,"title":"Test6","description":"desssssssss3","iconUrl":"../Upload/Post/Icon/d3fe8a040d5af04c4c0928901ef48d492d25.png","medias":[{"id":21,"title":"Documents_files_pictogram_symbol_icon_folder.png","url":"../Upload/Post/Media/44ed56c30221a046e20ad8002b8211f64b79.png","educationPostId":8,"mediaType":2},{"id":22,"title":"28887-1B1DDD95-055C-416E-8190-A354BB1CA7FA.pdf","url":"../Upload/Post/Media/878a6e98098ec048030ae4c0ef4b179f3e5a.pdf","educationPostId":8,"mediaType":0},{"id":23,"title":"part1DjTaba.docx","url":"../Upload/Post/Media/6e8a79ae0456804a340b16301750dc45b47d.docx","educationPostId":8,"mediaType":1},{"id":24,"title":"بدلیجات-35.jpg","url":"../Upload/Post/Media/d02f67760fa61049160b93a06203025286e2.jpg","educationPostId":8,"mediaType":2}],"number":2,"accessType":1,"pin":false,"category":0,"teacherId":1,"teacher":null}
     */

    private boolean success;
    private int status;
    private String message;
    private Data data;

    public EducationPost(boolean success, int status, String message, Data data) {
        this.success = success;
        this.status = status;
        this.message = message;
        this.data = data;
    }

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
         * id : 8
         * title : Test6
         * description : desssssssss3
         * iconUrl : ../Upload/Post/Icon/d3fe8a040d5af04c4c0928901ef48d492d25.png
         * medias : [{"id":21,"title":"Documents_files_pictogram_symbol_icon_folder.png","url":"../Upload/Post/Media/44ed56c30221a046e20ad8002b8211f64b79.png","educationPostId":8,"mediaType":2},{"id":22,"title":"28887-1B1DDD95-055C-416E-8190-A354BB1CA7FA.pdf","url":"../Upload/Post/Media/878a6e98098ec048030ae4c0ef4b179f3e5a.pdf","educationPostId":8,"mediaType":0},{"id":23,"title":"part1DjTaba.docx","url":"../Upload/Post/Media/6e8a79ae0456804a340b16301750dc45b47d.docx","educationPostId":8,"mediaType":1},{"id":24,"title":"بدلیجات-35.jpg","url":"../Upload/Post/Media/d02f67760fa61049160b93a06203025286e2.jpg","educationPostId":8,"mediaType":2}]
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

        public static class Medias {
            /**
             * id : 21
             * title : Documents_files_pictogram_symbol_icon_folder.png
             * url : ../Upload/Post/Media/44ed56c30221a046e20ad8002b8211f64b79.png
             * educationPostId : 8
             * mediaType : 2
             */

            private int id;
            private String title;
            private String url;
            private int educationPostId;
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

            public int getMediaType() {
                return mediaType;
            }

            public void setMediaType(int mediaType) {
                this.mediaType = mediaType;
            }
        }
    }
}
