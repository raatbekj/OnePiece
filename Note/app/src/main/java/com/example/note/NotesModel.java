package com.example.note;

import java.io.Serializable;

public class NotesModel implements Serializable {
    private String title, description, data;

    public NotesModel(String title, String description, String data) {
        this.title = title;
        this.description = description;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getData() {
        return data;
    }
}
