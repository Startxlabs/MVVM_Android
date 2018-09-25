package com.startxlabs.mvvm.Repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.startxlabs.mvvm.Model.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomRepository {

    private static CustomRepository mCustomProjectRepository;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public synchronized static CustomRepository getInstance() {

        if (mCustomProjectRepository == null)
            mCustomProjectRepository = new CustomRepository();

        return mCustomProjectRepository;

    }


    public LiveData<List<Project>> getProjectList(String userId) {

        final MutableLiveData<List<Project>> data = new MutableLiveData<>();


        ApiClient.getInstance()
                .getApiService()
                .getProjectList(userId).enqueue(new Callback<List<Project>>() {

            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {

            }

        });

        return data;

    }
/*
    public List<Project> requestProjectList(String userId, final AppDatabase appDatabase) {


        ApiService apiService = ApiClient.getInstance().getApiService();

        final List<Project> data = new ArrayList<>();

        apiService.getProjectList(userId).enqueue(new Callback<List<Project>>() {

            @Override
            public void onResponse(Call<List<Project>> call, final Response<List<Project>> response) {
                Completable.fromRunnable(new Runnable() {
                    @Override
                    public void run() {
                        data.addAll(response.body());
                        appDatabase.projectDao().insertAll(response.body());
                    }
                }).subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                compositeDisposable.add(d);
                            }

                            @Override
                            public void onComplete() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });


            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {

            }

        });
        return data;
    }

    public LiveData<List<Project>> getProjectList(final String userId, final AppDatabase appDatabase) {
        final MutableLiveData<List<Project>> mutableLiveData = new MutableLiveData<>();

        io.reactivex.Observable.fromCallable(new Callable<LiveData<List<Project>>>() {
            @Override
            public LiveData<List<Project>> call() throws Exception {
                return appDatabase.projectDao().getAll();
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new io.reactivex.Observer<LiveData<List<Project>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LiveData<List<Project>> listLiveData) {
                        if (listLiveData != null && listLiveData.getValue() != null && listLiveData.getValue().size() > 0)
                            mutableLiveData.setValue(listLiveData.getValue());
                        else
                            requestProjectList(userId, appDatabase);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return mutableLiveData;
    }*/
}
