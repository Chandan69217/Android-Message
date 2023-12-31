package com.chandan.message.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoticesDAO {
    @Query("SELECT * FROM notices ORDER BY MessageId DESC")
    List<Notices> getAllNotices();

    @Insert
    void insertNotices(Notices notices);

    @Update
    void updateNotices(Notices notices);
}
