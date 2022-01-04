package ru.otus.spring.spring_mongo.service_mongo;


import ru.otus.spring.spring_mongo.doman_mongo.AuthorsMongo;
import ru.otus.spring.spring_mongo.doman_mongo.BooksMongo;
import ru.otus.spring.spring_mongo.doman_mongo.GenreMongo;

import java.util.List;

public interface ServiceBookMongo {
    List<BooksMongo> getBooks();

    List<BooksMongo> getBooksByGenreAndAuthors(GenreMongo genreMongo, AuthorsMongo authorsMongo);
}
