package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;
import java.util.List;

public class GetRelatedUsers implements Serializable {


    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : {"students":[{"id":57,"fullName":"امید جوانمردی","mobile":9214361566,"address":"خیابان رسالت رسالت سوم پلاک ۵۹","nationalCode":"1111111111","apiToken":null,"url":null,"userName":"9214361566","password":"39488","majorId":1,"major":null,"gradeId":1,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":58,"fullName":"ماهان جوانمردی","mobile":9388743917,"address":null,"nationalCode":"9388743917","apiToken":null,"url":null,"userName":"9388743917","password":"44626","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":59,"fullName":"محمد هادیان","mobile":9103919135,"address":null,"nationalCode":"9103919135","apiToken":null,"url":null,"userName":"9103919135","password":"14493","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":60,"fullName":"مالک رمضانی","mobile":9909487527,"address":null,"nationalCode":"9909487527","apiToken":null,"url":null,"userName":"9909487527","password":"53910","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":61,"fullName":"امیرعباس اکبری","mobile":9137545197,"address":null,"nationalCode":"9137545197","apiToken":null,"url":null,"userName":"9137545197","password":"17340","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":62,"fullName":"حسنا سادات میرافضلی","mobile":9172306233,"address":null,"nationalCode":"9172306233","apiToken":null,"url":null,"userName":"9172306233","password":"46022","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":63,"fullName":"دانیال جعفرزاده","mobile":9136867784,"address":null,"nationalCode":"1111111177","apiToken":null,"url":null,"userName":"9136867784","password":"80817","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":64,"fullName":"ایلیا فانی","mobile":9130825250,"address":null,"nationalCode":"9130825250","apiToken":null,"url":null,"userName":"9130825250","password":"41702","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":65,"fullName":"بهراد طاهری","mobile":9137828262,"address":null,"nationalCode":"9137828262","apiToken":null,"url":null,"userName":"9137828262","password":"98570","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":66,"fullName":"رضا جعفرزاده","mobile":9913466215,"address":null,"nationalCode":"9913466215","apiToken":null,"url":null,"userName":"9913466215","password":"56232","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":67,"fullName":"امین طاهری","mobile":9135433911,"address":null,"nationalCode":"9135433911","apiToken":null,"url":null,"userName":"9135433911","password":"73149","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":68,"fullName":"ثمین فانی","mobile":9136015025,"address":null,"nationalCode":"9136015025","apiToken":null,"url":null,"userName":"9136015025","password":"84758","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":69,"fullName":"رها و رادمهر رمضانی","mobile":9140266220,"address":null,"nationalCode":"9140266220","apiToken":null,"url":null,"userName":"9140266220","password":"67769","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":70,"fullName":"شایان جوانمردی","mobile":9394226561,"address":null,"nationalCode":"9394226561","apiToken":null,"url":null,"userName":"9394226561","password":"36247","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":71,"fullName":"ماهان جوانمردی","mobile":9133384460,"address":"مکئمئکمئمکئکمئکمئکمئکم","nationalCode":"1111111460","apiToken":null,"url":null,"userName":"9133384460","password":"91835","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":72,"fullName":"محمد متین جمالی","mobile":9918739561,"address":null,"nationalCode":"0991873956","apiToken":null,"url":null,"userName":"9918739561","password":"16580","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":73,"fullName":"شهریار جوانمردی","mobile":9138029065,"address":null,"nationalCode":"0913802906","apiToken":null,"url":null,"userName":"9138029065","password":"69617","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":74,"fullName":"میلاد جوانمردی","mobile":9138194139,"address":null,"nationalCode":"0913819413","apiToken":null,"url":null,"userName":"9138194139","password":"90977","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":75,"fullName":"پوریا کریمی","mobile":9130185803,"address":null,"nationalCode":"0913018580","apiToken":null,"url":null,"userName":"9130185803","password":"79830","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":76,"fullName":"فاطمه صفرزاده","mobile":9913409880,"address":null,"nationalCode":"0991340988","apiToken":null,"url":null,"userName":"9913409880","password":"26700","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":77,"fullName":"ملیکا صفرزاده","mobile":9136902105,"address":null,"nationalCode":"0913690210","apiToken":null,"url":null,"userName":"9136902105","password":"60325","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":78,"fullName":"محمد طاها محمدی","mobile":9130774089,"address":null,"nationalCode":"0913077408","apiToken":null,"url":null,"userName":"9130774089","password":"33475","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":79,"fullName":"زهرا هادیان","mobile":9130193087,"address":null,"nationalCode":"0913019308","apiToken":null,"url":null,"userName":"9130193087","password":"64758","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":80,"fullName":"داریوش رفیع زاده","mobile":9138091597,"address":null,"nationalCode":"0913809159","apiToken":null,"url":null,"userName":"9138091597","password":"90798","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":81,"fullName":"فاطمه رمضانی","mobile":9138281512,"address":null,"nationalCode":"0913828151","apiToken":null,"url":null,"userName":"9138281512","password":"94581","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":82,"fullName":"زهرا سجادی","mobile":9137251814,"address":null,"nationalCode":"0913725181","apiToken":null,"url":null,"userName":"9137251814","password":"39272","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":83,"fullName":"پریا مرادی","mobile":9137982199,"address":null,"nationalCode":"0913798219","apiToken":null,"url":null,"userName":"9137982199","password":"57805","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":84,"fullName":"نازنین سجادی","mobile":9399577948,"address":null,"nationalCode":"0939957794","apiToken":null,"url":null,"userName":"9399577948","password":"87341","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":85,"fullName":"زهرا محمدی","mobile":9130330177,"address":null,"nationalCode":"0913033017","apiToken":null,"url":null,"userName":"9130330177","password":"91217","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":86,"fullName":"آوا محمدی","mobile":9908069701,"address":null,"nationalCode":"0990806970","apiToken":null,"url":null,"userName":"9908069701","password":"17586","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":87,"fullName":"ایمان مهدیزاده","mobile":9130825226,"address":null,"nationalCode":"0913082522","apiToken":null,"url":null,"userName":"9130825226","password":"96607","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":88,"fullName":"مایده سادات احمدی","mobile":9133947258,"address":null,"nationalCode":"0913394725","apiToken":null,"url":null,"userName":"9133947258","password":"39176","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":89,"fullName":"پریا رحمانی","mobile":9902911396,"address":null,"nationalCode":"0990291139","apiToken":null,"url":null,"userName":"9902911396","password":"42606","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":90,"fullName":"پوریا فانی","mobile":9137827634,"address":null,"nationalCode":"0913782763","apiToken":null,"url":null,"userName":"9137827634","password":"98353","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":91,"fullName":"مهسا فانی","mobile":9136020510,"address":null,"nationalCode":"0913602051","apiToken":null,"url":null,"userName":"9136020510","password":"98305","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":92,"fullName":"ثمین کاظمی","mobile":9134213213,"address":null,"nationalCode":"0913421321","apiToken":null,"url":null,"userName":"9134213213","password":"73386","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":93,"fullName":"نازنین زهرا مشهدی","mobile":9137821728,"address":null,"nationalCode":"0913782172","apiToken":null,"url":null,"userName":"9137821728","password":"54769","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":94,"fullName":"ریحانه سادات نجفی","mobile":9136853133,"address":null,"nationalCode":"0913685313","apiToken":null,"url":null,"userName":"9136853133","password":"56492","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":95,"fullName":"یونس رفیع زاده ","mobile":9139763439,"address":null,"nationalCode":"0913976343","apiToken":null,"url":null,"userName":"9139763439","password":"38896","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":96,"fullName":"پریسا مرادی","mobile":9335404694,"address":null,"nationalCode":"0913354046","apiToken":null,"url":null,"userName":"9335404694","password":"81535","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":97,"fullName":"مهسا مهدیزاده ","mobile":9922077680,"address":null,"nationalCode":"0992207768","apiToken":null,"url":null,"userName":"9922077680","password":"58962","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":98,"fullName":"امیرحسام نقی زاده","mobile":9137875208,"address":null,"nationalCode":"0913787520","apiToken":null,"url":null,"userName":"9137875208","password":"63041","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":99,"fullName":"سید سهراب هاشمی","mobile":9137128458,"address":null,"nationalCode":"0913712845","apiToken":null,"url":null,"userName":"9137128458","password":"50269","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":100,"fullName":"حدیث نقی زاده","mobile":9130801142,"address":null,"nationalCode":"0913080114","apiToken":null,"url":null,"userName":"9130801142","password":"54049","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":101,"fullName":"امیرحسین نقی زاده","mobile":9901808534,"address":null,"nationalCode":"0990180853","apiToken":null,"url":null,"userName":"9901808534","password":"65412","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":102,"fullName":"کسرا رحیمی","mobile":9136011513,"address":null,"nationalCode":"0913601151","apiToken":null,"url":null,"userName":"9136011513","password":"83943","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":103,"fullName":"علی یادگاری","mobile":9138651318,"address":null,"nationalCode":"0913865131","apiToken":null,"url":"/Upload/Student/File/2.jpg","userName":"9138651318","password":"95797","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null}],"teachers":[{"fullName":"خانم تقی زاده","mobile":9931262824,"address":null,"nationalCode":null,"apiToken":null,"url":null,"password":"36514","createDate":"2020-12-19T00:18:04.8846794","userType":1,"id":"23dffd4e-c445-4d6b-9eca-5effe17071a6","userName":"9931262824","normalizedUserName":null,"email":"9931262824yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"308d923f-89b1-470c-8a44-508f4bd2baaa","concurrencyStamp":"f6290ac4-c390-4f41-967e-68ee642e0e7e","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0},{"fullName":"الهه کاظمی","mobile":9139739358,"address":null,"nationalCode":"1111111935","apiToken":null,"url":null,"password":"66048","createDate":"2021-01-04T23:08:42.222046","userType":1,"id":"49550408-8bdb-41f8-b8bc-fd2d7037bb45","userName":"9139739358","normalizedUserName":null,"email":"9139739358yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"141e9830-f66e-4182-8fb3-f54dcb17f9bf","concurrencyStamp":"2c691996-4f29-4701-93ef-6accb6225424","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0},{"fullName":"مژگان هادیان","mobile":9915822906,"address":null,"nationalCode":null,"apiToken":null,"url":null,"password":"45277","createDate":"2020-12-21T23:38:52.2662246","userType":1,"id":"5b56fd2e-acdc-4202-8522-c466cad1285f","userName":"9915822906","normalizedUserName":null,"email":"9915822906yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"5dce504e-7f25-404e-817c-40cfa071a5f4","concurrencyStamp":"5970e3b4-e136-4727-9674-c1a1cfc05222","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0},{"fullName":"مدیریت دریای مهر","mobile":9134041021,"address":null,"nationalCode":null,"apiToken":null,"url":null,"password":"85259","createDate":"2020-12-18T23:40:01.9748032","userType":1,"id":"aea11655-c2bc-49fb-a2bb-79a92c0d0fd6","userName":"9134041021","normalizedUserName":null,"email":"9134041021yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"0693dccf-a00a-4dfd-b5df-77826bf52adc","concurrencyStamp":"35cf9179-7f85-40e3-b044-21576586ee42","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0},{"fullName":"Atrin","mobile":9136531539,"address":null,"nationalCode":"1272070042","apiToken":null,"url":null,"password":"73763","createDate":"2020-12-18T12:48:55.3761151","userType":1,"id":"d4801771-5087-463f-be54-6d70d2466f39","userName":"9136531539","normalizedUserName":null,"email":"9136531539yahoo.com","normalizedEmail":null,"emailConfirmed":false,"passwordHash":null,"securityStamp":"decfbea8-9cf7-4fae-b533-1a8249df483f","concurrencyStamp":"393d007d-47ca-4e5c-bdf7-2cc6f5b72138","phoneNumber":"0","phoneNumberConfirmed":false,"twoFactorEnabled":false,"lockoutEnd":null,"lockoutEnabled":false,"accessFailedCount":0}]}
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
        private List<Students> students;
        private List<Teachers> teachers;

        public List<Students> getStudents() {
            return students;
        }

        public void setStudents(List<Students> students) {
            this.students = students;
        }

        public List<Teachers> getTeachers() {
            return teachers;
        }

        public void setTeachers(List<Teachers> teachers) {
            this.teachers = teachers;
        }

        public static class Students implements Serializable {
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

        public static class Teachers  implements Serializable{
            /**
             * fullName : خانم تقی زاده
             * mobile : 9931262824
             * address : null
             * nationalCode : null
             * apiToken : null
             * url : null
             * password : 36514
             * createDate : 2020-12-19T00:18:04.8846794
             * userType : 1
             * id : 23dffd4e-c445-4d6b-9eca-5effe17071a6
             * userName : 9931262824
             * normalizedUserName : null
             * email : 9931262824yahoo.com
             * normalizedEmail : null
             * emailConfirmed : false
             * passwordHash : null
             * securityStamp : 308d923f-89b1-470c-8a44-508f4bd2baaa
             * concurrencyStamp : f6290ac4-c390-4f41-967e-68ee642e0e7e
             * phoneNumber : 0
             * phoneNumberConfirmed : false
             * twoFactorEnabled : false
             * lockoutEnd : null
             * lockoutEnabled : false
             * accessFailedCount : 0
             */

            private String fullName;
            private long mobile;
            private Object address;
            private Object nationalCode;
            private Object apiToken;
            private Object url;
            private String password;
            private String createDate;
            private int userType;
            private String id;
            private String userName;
            private Object normalizedUserName;
            private String email;
            private Object normalizedEmail;
            private boolean emailConfirmed;
            private Object passwordHash;
            private String securityStamp;
            private String concurrencyStamp;
            private String phoneNumber;
            private boolean phoneNumberConfirmed;
            private boolean twoFactorEnabled;
            private Object lockoutEnd;
            private boolean lockoutEnabled;
            private int accessFailedCount;
            private int idHelper;

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

            public long getMobile() {
                return mobile;
            }

            public void setMobile(long mobile) {
                this.mobile = mobile;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public Object getNationalCode() {
                return nationalCode;
            }

            public void setNationalCode(Object nationalCode) {
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

            public Object getNormalizedUserName() {
                return normalizedUserName;
            }

            public void setNormalizedUserName(Object normalizedUserName) {
                this.normalizedUserName = normalizedUserName;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public Object getNormalizedEmail() {
                return normalizedEmail;
            }

            public void setNormalizedEmail(Object normalizedEmail) {
                this.normalizedEmail = normalizedEmail;
            }

            public boolean isEmailConfirmed() {
                return emailConfirmed;
            }

            public void setEmailConfirmed(boolean emailConfirmed) {
                this.emailConfirmed = emailConfirmed;
            }

            public Object getPasswordHash() {
                return passwordHash;
            }

            public void setPasswordHash(Object passwordHash) {
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

            public Object getLockoutEnd() {
                return lockoutEnd;
            }

            public void setLockoutEnd(Object lockoutEnd) {
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
}
