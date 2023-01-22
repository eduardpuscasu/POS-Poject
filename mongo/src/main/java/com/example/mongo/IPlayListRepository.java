package com.example.mongo;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IPlayListRepository
        extends MongoRepository <PlayList, String> {


}
