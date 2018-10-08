package com.startxlabs.mvvm.Repository.Retrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final ApiClient ourInstance = new ApiClient();
    private static Retrofit retrofit = null;

    public static ApiClient getInstance() {
        return ourInstance;
    }

    /**
     * prepare api client setup for one time only.
     *
     * @return api service.
     */
    public ApiService getApiService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiService.class);
    }

    /**
     * prepared custom client here.
     *
     * @return OkHttpClient.
     */
    private OkHttpClient getClient() {

        OkHttpClient client = new OkHttpClient
                .Builder()
                .addInterceptor(getInterceptor())
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request request = original.newBuilder()
                                .method(original.method(), original.body())
                                .build();

                        return chain.proceed(request);
                    }
                })
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build();

        return client;
    }

    /**
     * get interceptor here.
     *
     * @return Interceptor.
     */
    private Interceptor getInterceptor() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }


}
