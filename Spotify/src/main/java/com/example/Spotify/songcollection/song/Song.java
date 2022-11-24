package com.example.Spotify.songcollection.song;

import com.example.Spotify.songcollection.artist.Artist;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Table
public class Song {

    @Id
    @SequenceGenerator(
            name = "song_sequence",
            sequenceName = "song_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "song_sequence"
    )
    private Long songId;

    private String name;

    @Enumerated(EnumType.STRING)
    private GENRE GENRE;

    private int date;


    private TYPE type;

    @ManyToMany(mappedBy = "songs")
    Set<Artist> artists;

    public Song(){}

    public Song(String name, GENRE GENRE, int date, TYPE type) {
        this.name = name;
        this.GENRE = GENRE;
        this.date = date;
        this.type = type;
    }

    public Song(Long songId, String name, GENRE GENRE, int date, TYPE type) {
        this.songId = songId;
        this.name = name;
        this.GENRE = GENRE;
        this.date = date;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", GENRE=" + GENRE +
                ", date=" + date +
                ", type=" + type +
                '}';
    }
}
