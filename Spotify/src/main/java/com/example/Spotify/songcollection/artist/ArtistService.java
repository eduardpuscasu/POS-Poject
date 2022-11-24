package com.example.Spotify.songcollection.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {
    private final IArtistRepository artistRepository;

    @Autowired
    public ArtistService(IArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getArtists(){
        return artistRepository.findAll();
    }

    public List<Artist> getArtists(String name, boolean match){
        
        return artistRepository.findAll();
    }
    
    

    public Artist getArtist(Long artistId){
        return artistRepository.getReferenceById(artistId);
    }


    public void addNewArtist(Artist artist) {
        Optional<Artist> artistByEmail =
                artistRepository.findArtistByName(artist.getName());
        if(artistByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        artistRepository.save(artist);
        System.out.println(artist);
    }

    public void deleteArtist(Long artistID) {
        boolean exists = artistRepository.existsById(artistID);
        if(!exists){
            throw new IllegalStateException("artist with id " + artistID + " does not exists");
        }
        artistRepository.deleteById(artistID);
    }

    public List<Artist> getArtistByName(String name) {
        return artistRepository.findAllByName("%"+name+"%");
    }

    public List<Artist> getArtistsByNameMatch(String name) {
        return artistRepository.findAllByNameMatch(name);
    }
}
