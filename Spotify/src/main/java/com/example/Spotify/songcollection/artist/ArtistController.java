package com.example.Spotify.songcollection.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/artist")
public class ArtistController {
    @Autowired
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public List<Artist> getArtists() {
        return artistService.getArtists();
    }

    @PostMapping
    public void registerNewArtist(@RequestBody Artist artist){
        artistService.addNewArtist(artist);
    }

    @DeleteMapping(path = "{artistID}")
    public void deleteArtist(@PathVariable("artistID") Long artistId){
        artistService.deleteArtist(artistId);
    }
}
