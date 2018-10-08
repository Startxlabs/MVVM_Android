package com.startxlabs.mvvm.ViewModel;

import com.startxlabs.mvvm.Model.Project;
import com.startxlabs.mvvm.Model.ProjectRes;
import com.startxlabs.mvvm.Repository.CustomRepository;
import com.startxlabs.mvvm.Repository.Retrofit.ApiClient;
import com.startxlabs.mvvm.Repository.Room.AppDatabase;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CustomListViewModel extends ViewModel {

    private LiveData<List<Project>> mProjectListLiveData;
    private MutableLiveData<ProjectRes> mProjectResMutableLiveData;
    private AppDatabase mAppDatabase;
    private ApiClient mApiClient;
    private String mRepoName;

    public CustomListViewModel(ApiClient apiClient, AppDatabase appDatabase, String repoName) {
        mApiClient = apiClient;
        mAppDatabase = appDatabase;
        mRepoName = repoName;

        mProjectListLiveData = CustomRepository.getInstance().getProjectListSSOT(mApiClient, mAppDatabase, mRepoName);
        mProjectResMutableLiveData = CustomRepository.getInstance().getProjectListServerWithErrorHandling(mApiClient, mAppDatabase, mRepoName);
    }


    public LiveData<List<Project>> getProjectListObservable() {

        return mProjectListLiveData;

    }

    public MutableLiveData<ProjectRes> getProjectList2Observable() {
        return mProjectResMutableLiveData;
    }


}
