package com.suzei.timescheduler.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Schedule.class}, version = 1)
public abstract class ScheduleDatabase extends RoomDatabase {

    private static ScheduleDatabase sInstance;

    private static final String DATABASE_NAME = "time-scheduler.db";

    public abstract ScheduleDao getScheduleDao();

    public static synchronized ScheduleDatabase getInstance(Context context) {

        if (sInstance == null) {
            sInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ScheduleDatabase.class,
                    DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();

        }

        return sInstance;

    }

}
