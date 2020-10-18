package com.carlosllerenatest.reactiveprogrammingfull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit2 {

    public  final String BASE_URL =  "http://www.omdbapi.com/";
    public  final String API_KEY =  "597f1459";

    public   OkHttpClient providerClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    public static Retrofit provideRetrofit(String baseUrl, OkHttpClient client)
    {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }


    public    MoviesExtraInfoApisService provideApiservice(){
        return provideRetrofit(BASE_URL,providerClient()).create(MoviesExtraInfoApisService.class);
    }
}
