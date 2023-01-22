package com.example.mongo;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/playlist")
@AllArgsConstructor
public class PlayListController {

    private final PlayListService playListService;

    @GetMapping
    public List<PlayList> fetchAllPlayLists(){
        return playListService.getAllStudent();
    }

    @PostMapping
    public void addNewPlayList(@RequestBody PlayList playList){
        playListService.save(playList);
    }

    @PutMapping("{songId}")
    public void update(@RequestBody PlayList playList, @PathVariable String songId){
        playListService.update(playList, songId);
    }


}
