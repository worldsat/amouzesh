package com.atrinfanavaran.school.Domain.New;

import java.util.ArrayList;

public class CustomGroupGetById {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : {"id":2,"name":"Test23","date":"2021-01-19T12:45:06.5626193","applicationUserId":"d4801771-5087-463f-be54-6d70d2466f39","applicationUser":null,"usersToCustomGroups":[{"id":1003,"applicationUserId":null,"applicationUser":null,"studentsId":58,"students":null,"customGroupId":2},{"id":1004,"applicationUserId":null,"applicationUser":null,"studentsId":59,"students":null,"customGroupId":2},{"id":1006,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null,"studentsId":null,"students":null,"customGroupId":2}]}
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

    public static class Data {
        /**
         * id : 2
         * name : Test23
         * date : 2021-01-19T12:45:06.5626193
         * applicationUserId : d4801771-5087-463f-be54-6d70d2466f39
         * applicationUser : null
         * usersToCustomGroups : [{"id":1003,"applicationUserId":null,"applicationUser":null,"studentsId":58,"students":null,"customGroupId":2},{"id":1004,"applicationUserId":null,"applicationUser":null,"studentsId":59,"students":null,"customGroupId":2},{"id":1006,"applicationUserId":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","applicationUser":null,"studentsId":null,"students":null,"customGroupId":2}]
         */

        private int id;
        private String name;
        private String date;
        private String applicationUserId;
        private String applicationUser;
        private ArrayList<UsersToCustomGroups> usersToCustomGroups;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
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

        public ArrayList<UsersToCustomGroups> getUsersToCustomGroups() {
            return usersToCustomGroups;
        }

        public void setUsersToCustomGroups(ArrayList<UsersToCustomGroups> usersToCustomGroups) {
            this.usersToCustomGroups = usersToCustomGroups;
        }

        public static class UsersToCustomGroups {
            /**
             * id : 1003
             * applicationUserId : null
             * applicationUser : null
             * studentsId : 58
             * students : null
             * customGroupId : 2
             */

            private int id;
            private String applicationUserId;
            private String applicationUser;
            private int studentsId;
            private String students;
            private String studentName;
            private int customGroupId;

            public String getStudentName() {
                return studentName;
            }

            public void setStudentName(String studentName) {
                this.studentName = studentName;
            }

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

            public int getCustomGroupId() {
                return customGroupId;
            }

            public void setCustomGroupId(int customGroupId) {
                this.customGroupId = customGroupId;
            }
        }
    }
}
