package com.startxlabs.mvvm.Repository;

import com.startxlabs.mvvm.Model.Base.BaseError;
import com.startxlabs.mvvm.Model.Base.BaseException;
import com.startxlabs.mvvm.Model.Project;
import com.startxlabs.mvvm.Model.ProjectRes;
import com.startxlabs.mvvm.Repository.Retrofit.ApiClient;
import com.startxlabs.mvvm.Repository.Retrofit.CustomResponseHandlerCallback;
import com.startxlabs.mvvm.Repository.Room.AppDatabase;

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


    public LiveData<List<Project>> getProjectListSSOT(ApiClient apiClient, final AppDatabase appDatabase, String repoName) {

        LiveData<List<Project>> temp = appDatabase.projectDao().getAll();

        apiClient
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


    public MutableLiveData<ProjectRes> getProjectListServerWithErrorHandling(ApiClient apiClient, final AppDatabase appDatabase, String repoName) {

        final MutableLiveData<ProjectRes> mutableLiveData = new MutableLiveData<>();
        final ProjectRes projectRes = new ProjectRes();

        apiClient.getApiService().getProjectList2(repoName)
                .enqueue(new CustomResponseHandlerCallback<List<Project>>() {
                    @Override
                    protected void handleResponse(List<Project> data) {
                        projectRes.setProjectList(data);
                        projectRes.setFine(true);
                        mutableLiveData.setValue(projectRes);
                    }

                    @Override
                    protected void handleError(BaseError baseError) {
                        projectRes.setBaseError(baseError);
                        projectRes.setFine(false);
                        mutableLiveData.setValue(projectRes);
                    }

                    @Override
                    protected void handleException(BaseException baseException) {
                        projectRes.setBaseException(baseException);
                        projectRes.setFine(false);
                        mutableLiveData.setValue(projectRes);
                    }

                    @Override
                    protected void handleUnknownFailure() {
                        projectRes.setFine(false);
                        mutableLiveData.setValue(projectRes);
                    }
                });

        return mutableLiveData;
    }

    public LiveData<List<Project>> getProjectListServer(ApiClient apiClient, String repoName) {


        apiClient
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
