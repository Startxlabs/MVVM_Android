package com.startxlabs.mvvm.Repository;

import com.startxlabs.mvvm.Model.Project;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomRepository {

    private static CustomRepository mCustomProjectRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<Project>> data = new MutableLiveData<>();

    public synchronized static CustomRepository getInstance() {

        if (mCustomProjectRepository == null)
            mCustomProjectRepository = new CustomRepository();

        return mCustomProjectRepository;

    }


    public LiveData<List<Project>> getProjectList(ApiClient apiClient, final AppDatabase appDatabase, String repoName) {

        LiveData<List<Project>> temp = appDatabase.projectDao().getAll();

        ApiClient.getInstance()
                .getApiService()
                .getProjectList(repoName).enqueue(new Callback<List<Project>>() {

            @Override
            public void onResponse(Call<List<Project>> call, final Response<List<Project>> response) {
                data.setValue(response.body());
                Completable.fromRunnable(new Runnable() {
                    @Override
                    public void run() {
                        appDatabase.projectDao().insertAll(response.body());
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe();
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {

            }

        });
        return temp;
    }

    public LiveData<List<Project>> getProjectList(ApiClient apiClient, String repoName) {


        ApiClient.getInstance()
                .getApiService()
                .getProjectList(repoName).enqueue(new Callback<List<Project>>() {

            @Override
            public void onResponse(Call<List<Project>> call, final Response<List<Project>> response) {
                data.setValue(response.body());
                Completable.fromRunnable(new Runnable() {
                    @Override
                    public void run() {
                        if (data.getValue() != null)
                            data.getValue().addAll(response.body());
                        else
                            data.setValue(response.body());
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe();
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {

            }

        });
        return data;
    }

}
