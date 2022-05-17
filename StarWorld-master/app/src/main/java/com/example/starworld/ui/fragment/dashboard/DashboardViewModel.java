package com.example.starworld.ui.fragment.dashboard;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.starworld.domain.model.film.Film;
import com.example.starworld.domain.model.film.FilmStorage;
import com.example.starworld.domain.model.film.Doors;


import java.util.List;



public class DashboardViewModel extends ViewModel {

    private MutableLiveData<List<Film>> peopleMutableLiveData;

    public DashboardViewModel() {
        peopleMutableLiveData = new MutableLiveData<>();
    }

    public void init() {
        FilmStorage.getFilmGyId(new FilmStorage.Result() {
            @Override
            public void onSuccess(Doors doors) {
                peopleMutableLiveData.setValue(doors.getResults());
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });

    }

    public MutableLiveData<List<Film>> getPeopleMutableLiveData() {
        return peopleMutableLiveData;
    }
}