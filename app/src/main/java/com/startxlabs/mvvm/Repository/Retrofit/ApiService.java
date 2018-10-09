package com.startxlabs.mvvm.Repository.Retrofit;

import com.startxlabs.mvvm.Model.Project;
import com.startxlabs.mvvm.Model.ProjectRes;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("users/{user}/repos")
    Call<List<Project>> getProjectList(@Path("user") String user);

    @GET("users/{user}/repos")
    Call<List<Project>> getProjectList2(@Path("user") String user);

    @GET("/repos/{user}/{reponame}")
    Call<Project> getProjectDetails(@Path("user") String user, @Path("reponame") String projectName);


}
