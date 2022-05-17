package com.example.starworld.domain.model.film;

import com.example.starworld.domain.model.film.Film;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Doors {
    @SerializedName("count")
    @Expose
    private Integer count;
    @Expose
    private List<Film> results = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    public List<Film> getResults() {
        return results;
    }

    public void setResults(List<Film> results) {
        this.results = results;
    }
}
