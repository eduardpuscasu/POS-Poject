package com.example.mongo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Song {
    private long songId;
    private String name;
    private int date;
    private GENRE GENRE;
    private TYPE type;

    public Song(long songId, String name, int date, com.example.mongo.GENRE GENRE, TYPE type) {
        this.songId = songId;
        this.name = name;
        this.date = date;
        this.GENRE = GENRE;
        this.type = type;
    }
}
