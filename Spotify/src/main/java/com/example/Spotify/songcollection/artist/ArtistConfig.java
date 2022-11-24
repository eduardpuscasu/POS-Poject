package com.example.Spotify.songcollection.artist;

import com.example.Spotify.songcollection.song.GENRE;
import com.example.Spotify.songcollection.song.ISongRepository;
import com.example.Spotify.songcollection.song.Song;
import com.example.Spotify.songcollection.song.TYPE;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class ArtistConfig {

    @Bean
    CommandLineRunner commandLineRunner(IArtistRepository artistRepository, ISongRepository songRepository){
        return args ->{
            Artist ian = new Artist(
                "Ian",
                true);
            Artist nane = new Artist(
                    "nane",
                    true);
            Artist ina = new Artist(
                    "ina",
                    true);
            Artist mirela = new Artist(
                    "mirela",
                    false);
            Song song1 = new Song(
                    "ce am facut sefu ?",
                    GENRE.POP,
                    2022,
                    TYPE.SONG
            );

            Song song2 = new Song(
                    "Steluta ta",
                    GENRE.POP,
                    2021,
                    TYPE.ALBUM
            );

            Song song3 = new Song(
                    "Sefu",
                    GENRE.POP,
                    2018,
                    TYPE.SINGLE
            );
            artistRepository.saveAll(List.of(ian,nane,ina,mirela));
            songRepository.saveAll(List.of(song1,song2,song3));


        };

    }
}
