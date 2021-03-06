package com.atrinfanavaran.school.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import com.atrinfanavaran.school.Room.Domian.BoxR;

import java.util.List;

@Dao
public interface BoxDao {
    @Query("SELECT b.id,b.fullName,b.number,b.mobile,b.code,b.assignmentDate,b.dischargeRouteId,b.address,b.lon,b.lat,r.code code2,r.id id3 ,b.id boxId FROM BoxR b Inner Join RouteR r on b.dischargeRouteId=r.id ")
    List<BoxR> getAll();

    @RawQuery(observedEntities = BoxR.class)
    List<BoxR> getfilter(SupportSQLiteQuery filter);

    @Query("SELECT * FROM BoxR where number like (:number)")
    BoxR getAllFilterNumber(String number);


    @Query("SELECT * FROM BoxR where isNew like 'true'")
    List<BoxR> getAllNew();

    @Query("delete FROM BoxR")
    void deleteAll();

    @Query("update  BoxR set fullName=:fullName,number=:number,mobile=:mobile,code=:code,assignmentDate=:assignmentDate,dischargeRouteId=:dischargeRouteId,address=:address,lon=:lng,lat=:lat" +
            " WHERE id like (:id)")
    void update(String fullName, String number, String mobile, String code, String assignmentDate, int id,String address, String lat, String lng,String dischargeRouteId);

    @Query("Delete from  BoxR  " +
            " WHERE id like (:id)")
    void delete(int id);


    @Insert
    void insertBox(BoxR boxR);

    @Delete
    void delete2(BoxR boxR);
}