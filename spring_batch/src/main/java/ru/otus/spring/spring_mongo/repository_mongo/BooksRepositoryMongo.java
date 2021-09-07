package ru.otus.spring.spring_mongo.repository_mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.spring.spring_mongo.doman_mongo.AuthorsMongo;
import ru.otus.spring.spring_mongo.doman_mongo.BooksMongo;
import ru.otus.spring.spring_mongo.doman_mongo.GenreMongo;

import java.util.List;


public interface BooksRepositoryMongo extends MongoRepository<BooksMongo, Long> {
    List<BooksMongo> findByGenreMongoAndAuthorsMongo(GenreMongo genreMongo, AuthorsMongo authorsMongo);

    List<BooksMongo> findAll();
}
