package com.startxlabs.mvvm.ViewModel;

import com.startxlabs.mvvm.Repository.Retrofit.ApiClient;
import com.startxlabs.mvvm.Repository.Room.AppDatabase;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class CustomListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private AppDatabase mAppDatabase;
    private ApiClient mApiClient;
    private String mRepoName;

    public CustomListViewModelFactory(AppDatabase appDatabase, ApiClient apiClient, String repoName) {
        mAppDatabase = appDatabase;
        mApiClient = apiClient;
        mRepoName = repoName;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CustomListViewModel(mApiClient, mAppDatabase, mRepoName);
    }
}
