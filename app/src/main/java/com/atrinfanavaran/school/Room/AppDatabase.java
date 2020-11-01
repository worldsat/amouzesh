package com.atrinfanavaran.school.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.atrinfanavaran.school.Kernel.Room.User;
import com.atrinfanavaran.school.Kernel.Room.User2;
import com.atrinfanavaran.school.Kernel.Room.UserDao;
import com.atrinfanavaran.school.Room.Domian.BoxIncomeR;
import com.atrinfanavaran.school.Room.Domian.BoxR;
import com.atrinfanavaran.school.Room.Domian.RouteR;

@Database(entities = {BoxIncomeR.class, BoxR.class, RouteR.class, User.class, User2.class}, version = 11)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract BoxIncomeDao BoxIncomeDao();

    public abstract BoxDao BoxDao();

    public abstract RouteDao RouteDao();

}