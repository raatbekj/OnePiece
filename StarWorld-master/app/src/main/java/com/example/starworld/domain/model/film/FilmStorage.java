package com.example.starworld.domain.model.film;

import com.example.starworld.data.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmStorage {

    public static void getFilmGyId(Result result) {
        RetrofitBuilder.getInstance().getFilms().enqueue(new Callback<Doors>() {
            @Override
            public void onResponse(Call<Doors> call, Response<Doors> response) {
                if (response.isSuccessful() && response.body() != null) {
                    result.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<Doors> call, Throwable t) {
                result.onFailure(t);
            }
        });

    }

    public interface Result {
        void onSuccess(Doors doors);

        void onFailure(Throwable throwable);
    }
}
