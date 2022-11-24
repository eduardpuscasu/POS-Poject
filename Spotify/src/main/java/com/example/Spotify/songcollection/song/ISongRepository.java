package com.example.Spotify.songcollection.song;

import com.example.Spotify.songcollection.artist.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface ISongRepository extends JpaRepository<Song, Long>{

   @Query("SELECT s FROM Song s WHERE s.name = ?1")
    Optional<Song> findSongByName(String name);

   @Query("SELECT s FROM Song s where s.GENRE = ?1")
    List<Song> findAllByGenre(GENRE genre);

}
