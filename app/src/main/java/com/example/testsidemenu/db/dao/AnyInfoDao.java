package com.example.testsidemenu.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.testsidemenu.db.model.AnyInfo;

import java.util.List;

@Dao
public interface AnyInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(AnyInfo anyInfo);

    @Query("SELECT * FROM any_info")
    List<AnyInfo> getAllAnyInfo();
}
