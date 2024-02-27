package com.example.testsidemenu.db.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "any_info")
public class AnyInfo {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String info;

    public AnyInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "AnyInfo{" +
                "id=" + id +
                ", info='" + info + '\'' +
                '}';
    }
}
