package com.example.Spotify.songcollection.artist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IArtistRepository extends JpaRepository<Artist, Long> { // the first one is the class we are using in our code and second is PK

    @Query("SELECT a FROM Artist a WHERE a.name = ?1")
    Optional<Artist> findArtistByName(String name);

    @Query("Select a FROM Artist a where a.name like ?1")
    List<Artist> findAllByName(String name);

    @Query("Select a FROM Artist a where a.name = ?1")
    List<Artist> findAllByNameMatch(String name);
}
