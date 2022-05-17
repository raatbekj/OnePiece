package com.example.starworld.ui.fragment.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.starworld.domain.model.planets.Planet;
import com.example.starworld.domain.model.planets.PlanetStorage;
import com.example.starworld.domain.model.planets.Planets;

import java.util.List;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<List<Planet>> list;

    public NotificationsViewModel() {
        list = new MutableLiveData<>();
    }

    public void init(int id) {
        PlanetStorage.getPlanetGyId(id, new PlanetStorage.Result() {
            @Override
            public void onSuccess(Planets planets) {
                list.setValue(planets.getResults());
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

    public MutableLiveData<List<Planet>> getList() {
        return list;
    }
}