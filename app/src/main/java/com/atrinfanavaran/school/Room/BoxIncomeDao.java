package com.atrinfanavaran.school.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import com.atrinfanavaran.school.Room.Domian.BoxIncomeR;

import java.util.List;

@Dao
public interface BoxIncomeDao {
    @Query("SELECT * FROM BoxIncomeR")
    List<BoxIncomeR> getAll();

    @RawQuery(observedEntities = BoxIncomeR.class)
    List<BoxIncomeR> getfilter(SupportSQLiteQuery filter);

    @Query("delete FROM BoxIncomeR")
    void deleteAll();

    @Query("update  BoxIncomeR set lat=:lat,lon=:lon,number=:number,price=:price," +
            "assignmentDate=(:assignmentDate),status=:status WHERE id like (:id)")
    void update(String lat, String lon, String number, String price, String assignmentDate, String status, int id);

    @Query("Delete from  BoxIncomeR  " +
            " WHERE id like (:id)")
    void delete(int id);

    @Insert
    void insertBoxIncome(BoxIncomeR boxIncome);

    @Delete
    void delete(BoxIncomeR boxIncome);
}