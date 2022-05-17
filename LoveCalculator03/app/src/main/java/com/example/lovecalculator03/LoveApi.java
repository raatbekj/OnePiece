package com.example.lovecalculator03;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface LoveApi {
    @GET("getPercentage")
    Call<LoveModel> getLove(@Query("sname") String sName,
                            @Query("fname")String fName,
                            @Header("X-RapidAPI-Host")String host,
                            @Header("X-RapidAPI-Key")String key);

}
