package com.atrinfanavaran.school.Domain.New;

import java.io.Serializable;
import java.util.ArrayList;

public class GetRelatedStudentsFromCustomGroup {

    /**
     * success : true
     * status : 200
     * message : عملیات انجام شد
     * data : [{"id":57,"fullName":"امید جوانمردی","mobile":9214361566,"address":"خیابان رسالت رسالت سوم پلاک ۵۹","nationalCode":"1111111111","apiToken":null,"url":null,"userName":"9214361566","password":"39488","majorId":1,"major":null,"gradeId":1,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":60,"fullName":"مالک رمضانی","mobile":9909487527,"address":null,"nationalCode":"9909487527","apiToken":null,"url":null,"userName":"9909487527","password":"53910","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":61,"fullName":"امیرعباس اکبری","mobile":9137545197,"address":null,"nationalCode":"9137545197","apiToken":null,"url":null,"userName":"9137545197","password":"17340","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":62,"fullName":"حسنا سادات میرافضلی","mobile":9172306233,"address":null,"nationalCode":"9172306233","apiToken":null,"url":null,"userName":"9172306233","password":"46022","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":63,"fullName":"دانیال جعفرزاده","mobile":9136867784,"address":null,"nationalCode":"1111111177","apiToken":null,"url":null,"userName":"9136867784","password":"80817","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":64,"fullName":"ایلیا فانی","mobile":9130825250,"address":null,"nationalCode":"9130825250","apiToken":null,"url":null,"userName":"9130825250","password":"41702","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":65,"fullName":"بهراد طاهری","mobile":9137828262,"address":null,"nationalCode":"9137828262","apiToken":null,"url":null,"userName":"9137828262","password":"98570","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":66,"fullName":"رضا جعفرزاده","mobile":9913466215,"address":null,"nationalCode":"9913466215","apiToken":null,"url":null,"userName":"9913466215","password":"56232","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":67,"fullName":"امین طاهری","mobile":9135433911,"address":null,"nationalCode":"9135433911","apiToken":null,"url":null,"userName":"9135433911","password":"73149","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":68,"fullName":"ثمین فانی","mobile":9136015025,"address":null,"nationalCode":"9136015025","apiToken":null,"url":null,"userName":"9136015025","password":"84758","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":69,"fullName":"رها و رادمهر رمضانی","mobile":9140266220,"address":null,"nationalCode":"9140266220","apiToken":null,"url":null,"userName":"9140266220","password":"67769","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":70,"fullName":"شایان جوانمردی","mobile":9394226561,"address":null,"nationalCode":"9394226561","apiToken":null,"url":null,"userName":"9394226561","password":"36247","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":71,"fullName":"ماهان جوانمردی","mobile":9133384460,"address":"مکئمئکمئمکئکمئکمئکمئکم","nationalCode":"1111111460","apiToken":null,"url":null,"userName":"9133384460","password":"91835","majorId":2,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":72,"fullName":"محمد متین جمالی","mobile":9918739561,"address":null,"nationalCode":"0991873956","apiToken":null,"url":null,"userName":"9918739561","password":"16580","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":73,"fullName":"شهریار جوانمردی","mobile":9138029065,"address":null,"nationalCode":"0913802906","apiToken":null,"url":null,"userName":"9138029065","password":"69617","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":74,"fullName":"میلاد جوانمردی","mobile":9138194139,"address":null,"nationalCode":"0913819413","apiToken":null,"url":null,"userName":"9138194139","password":"90977","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":75,"fullName":"پوریا کریمی","mobile":9130185803,"address":null,"nationalCode":"0913018580","apiToken":null,"url":null,"userName":"9130185803","password":"79830","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":76,"fullName":"فاطمه صفرزاده","mobile":9913409880,"address":null,"nationalCode":"0991340988","apiToken":null,"url":null,"userName":"9913409880","password":"26700","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":77,"fullName":"ملیکا صفرزاده","mobile":9136902105,"address":null,"nationalCode":"0913690210","apiToken":null,"url":null,"userName":"9136902105","password":"60325","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":78,"fullName":"محمد طاها محمدی","mobile":9130774089,"address":null,"nationalCode":"0913077408","apiToken":null,"url":null,"userName":"9130774089","password":"33475","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":79,"fullName":"زهرا هادیان","mobile":9130193087,"address":null,"nationalCode":"0913019308","apiToken":null,"url":null,"userName":"9130193087","password":"64758","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":80,"fullName":"داریوش رفیع زاده","mobile":9138091597,"address":null,"nationalCode":"0913809159","apiToken":null,"url":null,"userName":"9138091597","password":"90798","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":81,"fullName":"فاطمه رمضانی","mobile":9138281512,"address":null,"nationalCode":"0913828151","apiToken":null,"url":null,"userName":"9138281512","password":"94581","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":82,"fullName":"زهرا سجادی","mobile":9137251814,"address":null,"nationalCode":"0913725181","apiToken":null,"url":null,"userName":"9137251814","password":"39272","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":83,"fullName":"پریا مرادی","mobile":9137982199,"address":null,"nationalCode":"0913798219","apiToken":null,"url":null,"userName":"9137982199","password":"57805","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":84,"fullName":"نازنین سجادی","mobile":9399577948,"address":null,"nationalCode":"0939957794","apiToken":null,"url":null,"userName":"9399577948","password":"87341","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":85,"fullName":"زهرا محمدی","mobile":9130330177,"address":null,"nationalCode":"0913033017","apiToken":null,"url":null,"userName":"9130330177","password":"91217","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":86,"fullName":"آوا محمدی","mobile":9908069701,"address":null,"nationalCode":"0990806970","apiToken":null,"url":null,"userName":"9908069701","password":"17586","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":87,"fullName":"ایمان مهدیزاده","mobile":9130825226,"address":null,"nationalCode":"0913082522","apiToken":null,"url":null,"userName":"9130825226","password":"96607","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":88,"fullName":"مایده سادات احمدی","mobile":9133947258,"address":null,"nationalCode":"0913394725","apiToken":null,"url":null,"userName":"9133947258","password":"39176","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":89,"fullName":"پریا رحمانی","mobile":9902911396,"address":null,"nationalCode":"0990291139","apiToken":null,"url":null,"userName":"9902911396","password":"42606","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":90,"fullName":"پوریا فانی","mobile":9137827634,"address":null,"nationalCode":"0913782763","apiToken":null,"url":null,"userName":"9137827634","password":"98353","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":91,"fullName":"مهسا فانی","mobile":9136020510,"address":null,"nationalCode":"0913602051","apiToken":null,"url":null,"userName":"9136020510","password":"98305","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":92,"fullName":"ثمین کاظمی","mobile":9134213213,"address":null,"nationalCode":"0913421321","apiToken":null,"url":null,"userName":"9134213213","password":"73386","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":93,"fullName":"نازنین زهرا مشهدی","mobile":9137821728,"address":null,"nationalCode":"0913782172","apiToken":null,"url":null,"userName":"9137821728","password":"54769","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":94,"fullName":"ریحانه سادات نجفی","mobile":9136853133,"address":null,"nationalCode":"0913685313","apiToken":null,"url":null,"userName":"9136853133","password":"56492","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":95,"fullName":"یونس رفیع زاده ","mobile":9139763439,"address":null,"nationalCode":"0913976343","apiToken":null,"url":null,"userName":"9139763439","password":"38896","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":96,"fullName":"پریسا مرادی","mobile":9335404694,"address":null,"nationalCode":"0913354046","apiToken":null,"url":null,"userName":"9335404694","password":"81535","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":97,"fullName":"مهسا مهدیزاده ","mobile":9922077680,"address":null,"nationalCode":"0992207768","apiToken":null,"url":null,"userName":"9922077680","password":"58962","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":98,"fullName":"امیرحسام نقی زاده","mobile":9137875208,"address":null,"nationalCode":"0913787520","apiToken":null,"url":null,"userName":"9137875208","password":"63041","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":99,"fullName":"سید سهراب هاشمی","mobile":9137128458,"address":null,"nationalCode":"0913712845","apiToken":null,"url":null,"userName":"9137128458","password":"50269","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":100,"fullName":"حدیث نقی زاده","mobile":9130801142,"address":null,"nationalCode":"0913080114","apiToken":null,"url":null,"userName":"9130801142","password":"54049","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":101,"fullName":"امیرحسین نقی زاده","mobile":9901808534,"address":null,"nationalCode":"0990180853","apiToken":null,"url":null,"userName":"9901808534","password":"65412","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":102,"fullName":"کسرا رحیمی","mobile":9136011513,"address":null,"nationalCode":"0913601151","apiToken":null,"url":null,"userName":"9136011513","password":"83943","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null},{"id":103,"fullName":"علی یادگاری","mobile":9138651318,"address":null,"nationalCode":"0913865131","apiToken":null,"url":null,"userName":"9138651318","password":"95797","majorId":3,"major":null,"gradeId":2,"grade":null,"userType":2,"classRoomId":3,"classRoom":null}]
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

        public Object getMajor() {
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
