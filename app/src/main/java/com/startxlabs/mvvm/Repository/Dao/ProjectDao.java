package com.startxlabs.mvvm.Repository.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.startxlabs.mvvm.Model.Project;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ProjectDao {

    @Query("Select * From Project")
    LiveData<List<Project>> getAll();

    @Query("Select * From Project WHERE id= :id")
    Project getProjectDetail(String id);

    /*@Query("Select * From ExtraFacility WHERE id IN :id")
    List<ExtraFacility> getExtras(ArrayList<String> id);*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Project> projectArrayList);
}
