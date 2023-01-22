package com.example.mongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(IPlayListRepository repository, MongoTemplate mongoTemplate){
		return args ->{
			PlayList playlist = new PlayList("ceva", "www.ceva.com");
			PlayList playlist1 = new PlayList("ceva", "www.ceva.com");
			PlayList playlist2= new PlayList("ceva", "www.ceva.com");
			PlayList playlist3 = new PlayList("ceva", "www.ceva.com");

			repository.insert(playlist);
			repository.insert(playlist1);
			repository.insert(playlist2);
			repository.insert(playlist3);

			Query query = new Query();
			query.addCriteria(Criteria.where("link").is("www.ceva.com"));
//			Optional<PlayList> playlists  = repository.findPlayListByLink("www.ceva.com");


		};
	}
}
