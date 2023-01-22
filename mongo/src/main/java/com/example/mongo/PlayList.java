package com.example.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class PlayList {
    @Id
    private String id;
    private String name;
    private List<String> songsName = new ArrayList<>();
    private String link;

    public PlayList(){
        super();
    }

    public PlayList(String name, String link) {
        this.name = name;
        this.link = link;
    }
}
