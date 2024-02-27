package com.example.testsidemenu.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.testsidemenu.db.dao.AnyInfoDao;
import com.example.testsidemenu.db.model.AnyInfo;

@Database(entities = {AnyInfo.class}, version = 1)
public abstract class LocalDatabase extends RoomDatabase {
    public abstract AnyInfoDao achivementImageDao();
}