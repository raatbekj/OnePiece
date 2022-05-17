package com.example.starworld.ui.fragment.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.starworld.domain.model.people.People;
import com.example.starworld.domain.model.people.PeopleStorage;
import com.example.starworld.domain.model.people.PersonAboba;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<PersonAboba>> aboba;

    public HomeViewModel() {
        aboba = new MutableLiveData<>();
    }

    public void init(int id) {
        PeopleStorage.getPeopleGyId(id, new PeopleStorage.Result() {
            @Override
            public void onSuccess(People people) {
                aboba.setValue(people.getResults());
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

    public MutableLiveData<List<PersonAboba>> getAboba() {
        return aboba;
    }
}