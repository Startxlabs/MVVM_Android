package com.startxlabs.mvvm.Repository;

import com.startxlabs.mvvm.Model.Project;
import com.startxlabs.mvvm.Repository.Dao.ProjectDao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Project.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProjectDao projectDao();

}
