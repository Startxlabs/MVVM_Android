package com.startxlabs.mvvm.ViewModel;

import com.startxlabs.mvvm.Model.Project;
import com.startxlabs.mvvm.Repository.ApiClient;
import com.startxlabs.mvvm.Repository.AppDatabase;
import com.startxlabs.mvvm.Repository.CustomRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class CustomListViewModel extends ViewModel {

    private LiveData<List<Project>> mProjectListLiveData;
    private AppDatabase mAppDatabase;
    private ApiClient mApiClient;
    private String mRepoName;

    public CustomListViewModel(ApiClient apiClient, AppDatabase appDatabase, String repoName) {
        mApiClient = apiClient;
        mAppDatabase = appDatabase;
        mRepoName = repoName;

        mProjectListLiveData = CustomRepository.getInstance().getProjectList(mApiClient, mAppDatabase, mRepoName);
    }


    public LiveData<List<Project>> getProjectListObservable() {

        return mProjectListLiveData;

    }


}
