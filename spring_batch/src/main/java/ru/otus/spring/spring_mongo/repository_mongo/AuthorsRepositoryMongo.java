package ru.otus.spring.spring_mongo.repository_mongo;


import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.spring_mongo.doman_mongo.AuthorsMongo;

public interface AuthorsRepositoryMongo extends MongoRepository<AuthorsMongo, Long> {
    AuthorsMongo findByFirstName(String name);
}
