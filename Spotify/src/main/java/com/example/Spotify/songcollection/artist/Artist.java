package com.example.Spotify.songcollection.artist;

import com.example.Spotify.songcollection.song.Song;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Table
public class Artist {
    @Id
    @SequenceGenerator(
            name = "artist_sequence",
            sequenceName = "artist_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "artist_sequence"
    )
    private Long artistId;
    private String name;
    private boolean active;

    @ManyToMany
    @JoinTable(
            name = "artist_song",
            joinColumns = @JoinColumn(name="artistId"),
            inverseJoinColumns = @JoinColumn(name="songId")
    )
    Set<Song> songs;



    public Artist(){}

    public Artist(Long artistId, String name, boolean active) {
        this.artistId = artistId;
        this.name = name;
        this.active = active;
    }

    public Artist(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + artistId +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }
}
