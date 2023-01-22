package com.example.mongo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@AllArgsConstructor
@Service
public class PlayListService {


    private final IPlayListRepository playListRepository;

    public List<PlayList> getAllStudent() {
        return playListRepository.findAll();
    }

    public void save(PlayList playList){
        playListRepository.save(playList);
    }

    public void update(PlayList playList, String songId) {
        Object song;
        try {
            URL url = new URL("http://localhost:8080/api/songcollection/song/" + songId);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("accept", "application/json");
            InputStream responseStream = con.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            song = mapper.readValue(responseStream, Object.class);

        } catch (IOException e){
            throw new RuntimeException("The connection didn't work");
        }


    }
}
