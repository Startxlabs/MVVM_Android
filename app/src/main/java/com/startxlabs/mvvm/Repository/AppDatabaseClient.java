package com.startxlabs.mvvm.Repository;

import android.arch.persistence.room.Room;
import android.content.Context;

public class AppDatabaseClient {

    private static final AppDatabaseClient ourInstance = new AppDatabaseClient();
    private static AppDatabase appDatabase = null;

    private AppDatabaseClient() {

    }

    public static AppDatabaseClient getInstance() {
        return ourInstance;
    }

    public AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context,
                    AppDatabase.class, "app-database")
                    .build();
        }

        return appDatabase;
    }
}