package com.example.starworld.domain.model.planets;

import com.example.starworld.data.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetStorage {
    public static  void getPlanetGyId(int id , Result result){
        RetrofitBuilder.getInstance().getPlanet(id).enqueue(new Callback<Planets>() {
            @Override
            public void onResponse(Call<Planets> call, Response<Planets> response) {
                if(response.isSuccessful() && response.body() != null){
                    result.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<Planets> call, Throwable t) {
                result.onFailure(t);
            }
        });
    }
    public interface  Result{
        void onSuccess(Planets planets);
        void onFailure(Throwable throwable);
    }
}
