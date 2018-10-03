package com.startxlabs.mvvm.Repository;

import com.startxlabs.mvvm.Model.Project;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.CompositeDisposable;

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
//TODO()Applying Business logic)
        /*data.setValue(temp.getValue());

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

        });*/
        return temp;
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
