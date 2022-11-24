package com.example.Spotify.songcollection;


import com.example.Spotify.songcollection.artist.*;
import com.example.Spotify.songcollection.song.Song;
import com.example.Spotify.songcollection.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "api/songcollection")
public class Controller {

    @Autowired
    private final ArtistService artistService;

    @Autowired
    private final SongService songService;

    public Controller(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

//    @GetMapping("/artists")
//    public List<Artist> getArtists() {
//        return artistService.getArtists();
//    }


    @GetMapping("/artists/{artistID}")
    public Artist getArtist(@PathVariable("artistID") Long artistId) {
        return artistService.getArtist(artistId);
    }

    @GetMapping("/songs-all")
    public List<Song> getSong() {
        return songService.getSongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getSong(@PathVariable("songId") Long songId){
        return songService.getSong(songId);
    }

    @GetMapping("/songs/genre/{genre}")
    public List<Song> getSongByGenre(@PathVariable("genre") String genre){
        System.out.println(genre);
        return songService.selectByGenre(genre);
    }

    @GetMapping("/artists/{uuid}/songs")
    public void NuStiuCeFace(@PathVariable("uuid") Long uuid){

    }

//    @GetMapping(params = { "page", "size" })
//    public List<Song> findPaginated(@RequestParam("page") int page,
//                                   @RequestParam("size") int size, UriComponentsBuilder uriBuilder,
//                                   HttpServletResponse response){
//        Page<Song> resultPage = service.findPaginated(page, size);
//        if (page > resultPage.getTotalPages()) {
//            throw new IllegalStateException("My resource not found ");
//        }
//        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<Song>(
//                Song.class, uriBuilder, response, page, resultPage.getTotalPages(), size));
//
//        return resultPage.getContent();
//    }

    @GetMapping("/songs")
    public List<Song> getPaginated(@RequestParam int page, @RequestParam int size){
        System.out.println(page + "\n " + size);
        return songService.findPaginated(page, size);
    }



    @GetMapping("/artists")
    public List<Artist> getArtistsByExactName(@RequestParam String name, @RequestParam(required = false) String match){
        boolean exact;
        if(Objects.equals(match, "exact"))
            return artistService.getArtistsByNameMatch(name);
        else{
            return artistService.getArtistByName(name);
        }
    }

}
