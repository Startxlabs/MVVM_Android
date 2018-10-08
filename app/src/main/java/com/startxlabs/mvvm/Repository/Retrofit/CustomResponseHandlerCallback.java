package com.startxlabs.mvvm.Repository.Retrofit;

import com.startxlabs.mvvm.Model.Base.BaseError;
import com.startxlabs.mvvm.Model.Base.BaseException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public abstract class CustomResponseHandlerCallback<T> implements Callback<T> {


    abstract protected void handleResponse(T data);

    abstract protected void handleError(BaseError baseError);

    abstract protected void handleException(BaseException baseException);

    abstract protected void handleUnknownFailure();

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response != null)
            handleResponse(response.body());
        else {
            BaseError baseError = new BaseError();
            baseError.setCode(response.code());
            baseError.setMessage(response.message());
            handleError(baseError);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof Exception) {
            Exception e = (Exception) t;
            BaseException baseException = new BaseException();
            if (e instanceof HttpException) {
                baseException.setCode(((HttpException) e).code());
                baseException.setException(e);
                baseException.setMessage(((HttpException) e).getMessage());
            } else {
                baseException.setException(e);
            }
            handleException(baseException);
        } else
            handleUnknownFailure();

    }
   /* @Override
    public void onResponse(Call<Response<T>> call, Response<Response<T>> response) {
        if (response.body() != null)
            handleResponse(response.body().body());
        else
            handleError(response);

    }

    @Override
    public void onFailure(Call<Response<T>> call, Throwable t) {
        if (t instanceof Exception)
            handleException((Exception) t);
        else
            handleUnknownFailure();

    }*/
}
