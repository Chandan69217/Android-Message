package com.chandan.message.database;
import android.os.Message;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MessageDAO {
    @Query("SELECT * FROM messages")
    List<Messages> getAllMessages();

    @Insert
    void insertMessage(Messages messages);

    @Update
    void updateMessage(Messages messages);

//    @Delete
//    void deleteMessage(Message message);
}
