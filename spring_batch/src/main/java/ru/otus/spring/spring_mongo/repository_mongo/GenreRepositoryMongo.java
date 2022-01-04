package ru.otus.spring.spring_mongo.repository_mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.spring_mongo.doman_mongo.GenreMongo;

import java.util.List;

public interface GenreRepositoryMongo extends MongoRepository<GenreMongo, Long> {
    GenreMongo findByName(String name);

    List<GenreMongo> findAll();
}
