package com.example.starworld.domain.model.people;

import com.example.starworld.data.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleStorage {
    public static void getPeopleGyId(int id , Result result) {
        RetrofitBuilder.getInstance().getPeople(id).enqueue(new Callback<People>() {
            @Override
            public void onResponse(Call<People> call, Response<People> response) {
                if (response.isSuccessful() && response.body() != null) {
                    result.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<People> call, Throwable t) {
                result.onFailure(t);
            }
        });
    }

    public interface Result {
        void onSuccess(People people);

        void onFailure(Throwable throwable);
    }
}
