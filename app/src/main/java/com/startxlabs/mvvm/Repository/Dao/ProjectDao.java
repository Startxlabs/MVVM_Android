package com.startxlabs.mvvm.Repository.Dao;

import com.startxlabs.mvvm.Model.Project;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

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
