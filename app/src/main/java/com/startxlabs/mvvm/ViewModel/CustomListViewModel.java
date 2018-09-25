package com.startxlabs.mvvm.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.startxlabs.mvvm.Model.Project;
import com.startxlabs.mvvm.Repository.AppDatabase;
import com.startxlabs.mvvm.Repository.AppDatabaseClient;
import com.startxlabs.mvvm.Repository.CustomRepository;

import java.util.List;

public class CustomListViewModel extends AndroidViewModel {

    private LiveData<List<Project>> mProjectListLiveData;

    public CustomListViewModel(@NonNull Application application) {
        super(application);
        final AppDatabase appDatabase = AppDatabaseClient.getInstance().getAppDatabase(getApplication());
//        mProjectListLiveData = CustomRepository.getInstance().getProjectList("Google",appDatabase);
        mProjectListLiveData = CustomRepository.getInstance().getProjectList("Google");
    }

    public LiveData<List<Project>> getProjectListObservable() {

        return mProjectListLiveData;

    }


}
