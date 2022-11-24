package com.example.Spotify.songcollection.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final ISongRepository songRepository;

    @Autowired
    public SongService( ISongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    public Song getSong(Long songId){
        return songRepository.getReferenceById(songId);
    }

    public void addNewSong(Song song){
        Optional<Song> songExist =
                songRepository.findSongByName(song.getName());
        if(songExist.isPresent()){
            throw new IllegalStateException("the name for this song is taken");
        }
        songRepository.save(song);
        System.out.println(song);
    }

    public void deleteSong(Long songId){
        boolean exists = songRepository.existsById(songId);
        if(!exists){
            throw new IllegalStateException("song with id " +
                    songId + " does not exists");
        }
        songRepository.deleteById(songId);
    }

    public List<Song> selectByGenre(String genre){
        return songRepository.findAllByGenre(GENRE.valueOf(genre));
    }


    public List<Song> findPaginated(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Song> pageResult = songRepository.findAll(paging);
        return pageResult.toList();
    }
}
