package com.onedaydent.gigongrequest.data.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GigongClient {

    private static String TAG = GigongClient.class.getSimpleName();
    private static GigongClient instance = null;
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://117.52.172.59:50004/";

    private GigongClient(){
        super();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public static Retrofit getRetrofit(){
        return retrofit;
    }

    public static GigongClient getInstance(){
        if(retrofit == null) instance = new GigongClient();
        return instance;
    }
}