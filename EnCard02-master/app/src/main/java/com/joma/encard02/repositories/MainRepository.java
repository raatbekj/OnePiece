package com.joma.encard02.repositories;


import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.joma.encard02.common.Resource;
import com.joma.encard02.data.model.PixabayResponse;
import com.joma.encard02.data.network.PixabayApi;
import com.joma.encard02.data.videoModel.MainVideoResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    private final PixabayApi api;

    public MainRepository(PixabayApi api) {
        this.api = api;
    }

    public MutableLiveData<Resource<PixabayResponse>> getImages(String keyWord) {
        MutableLiveData<Resource<PixabayResponse>> liveData = new MutableLiveData<>();
        liveData.setValue(Resource.loading());
        api.getImages(keyWord).enqueue(new Callback<PixabayResponse>() {
            @Override
            public void onResponse(@NonNull Call<PixabayResponse> call,
                                   @NonNull Response<PixabayResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    liveData.setValue(Resource.success(response.body()));
                } else {
                    liveData.setValue(Resource.error(response.message()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<PixabayResponse> call, @NonNull Throwable t) {
                liveData.setValue(Resource.error(t.getLocalizedMessage()));
            }
        });
        return liveData;
    }

    public MutableLiveData<Resource<MainVideoResponce>> getVideo(String tags) {
        MutableLiveData<Resource<MainVideoResponce>> liveData = new MutableLiveData<>();
        liveData.setValue(Resource.loading());
        api.getVideo(tags)
                .enqueue(new Callback<MainVideoResponce>() {
            @Override
            public void onResponse(@NonNull Call<MainVideoResponce> call,
                                   @NonNull Response<MainVideoResponce> response) {
                if (response.isSuccessful() && response.body() != null) {
                    liveData.setValue(Resource.success(response.body()));
                } else {
                    liveData.setValue(Resource.error(response.message()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<MainVideoResponce> call, @NonNull Throwable t) {
                liveData.setValue(Resource.error(t.getLocalizedMessage()));
            }
        });
        return liveData;
    }
}
