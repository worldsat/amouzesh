package com.atrinfanavaran.kheiriyeh.Room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.atrinfanavaran.kheiriyeh.Room.Domian.BoxIncomeR;

import java.util.List;

@Dao
public interface BoxIncomeDao {
    @Query("SELECT * FROM BoxIncomeR")
    List<BoxIncomeR> getAll();

    @Query("delete FROM BoxIncomeR")
    void deleteByTitle();

    @Query("update  BoxIncomeR set factorNumber=:factorNumber,lat=:lat,lon=:lon,number=:number,price=:price," +
            "registerDate=(:registerDate),status=:status WHERE id like (:id)")
    void update(String factorNumber, String lat, String lon, String number, String price, String registerDate, String status, int id);

    @Query("Delete from  BoxIncomeR  " +
            " WHERE id like (:id)")
    void delete(int id);

    @Insert
    void insertBoxIncome(BoxIncomeR boxIncome);

    @Delete
    void delete(BoxIncomeR boxIncome);
}