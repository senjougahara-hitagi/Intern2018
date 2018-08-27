package com.duclm.fss.internproject.service;

import com.duclm.fss.internproject.helper.Config;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator_2 {
    private static Retrofit retrofit = null;
    private static Retrofit.Builder builder = new Retrofit.Builder()
        .baseUrl(Config.BASE_URL_2)
        .addConverterFactory(GsonConverterFactory.create());
    private final static OkHttpClient.Builder sOkHttpClientBuilder = new OkHttpClient.Builder();
    private final static OkHttpClient sOkHttpClient = sOkHttpClientBuilder.build();

    public static <T> T createService(Class<T> serviceClass) {
        if (retrofit == null) {
            retrofit = builder.client(sOkHttpClient).build();
        }
        return retrofit.create(serviceClass);
    }
}
