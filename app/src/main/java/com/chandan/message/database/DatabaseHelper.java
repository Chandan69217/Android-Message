package com.chandan.message.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Messages.class},version = 1)
public abstract class DatabaseHelper extends RoomDatabase {
    private static final String DATABASE_NAME = "MessageDB";
    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context, DatabaseHelper.class,DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract MessageDAO messageDAO();
}
