package com.example.starworld.data;

import com.example.starworld.domain.model.film.Doors;
import com.example.starworld.domain.model.people.People;
import com.example.starworld.domain.model.planets.Planets;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("films")
    Call<Doors> getFilms();

    @GET("people")
    Call<People> getPeople(@Query("page") int page);

    @GET("planets")
    Call<Planets> getPlanet(@Query("page") int page );
}
