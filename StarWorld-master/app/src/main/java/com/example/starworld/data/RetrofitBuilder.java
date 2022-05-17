package com.example.starworld.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private RetrofitBuilder() {
    }
    private static Api instance;

    public static Api getInstance() {
        if (instance == null) {
            instance = buildRetrofit();
        }
        return instance;
    }
    private static Api buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Api.class);
    }

}
