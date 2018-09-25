package com.startxlabs.mvvm.Repository;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.startxlabs.mvvm.Model.Project;
import com.startxlabs.mvvm.Repository.Dao.ProjectDao;

@Database(entities = {Project.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProjectDao projectDao();

}
