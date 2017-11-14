package com.graduationthesis.lungpanda.deliveryfast_deliman.api;

/**
 * Created by LungPanda on 10/12/2017.
 */

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    private static Retrofit retrofit = null;
    private static String mBaseUrl = "https://97ed7400.ngrok.io";


    public static Retrofit retrofit () {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }
    public static String getBaseUrl(){
        return mBaseUrl;
    }




}
