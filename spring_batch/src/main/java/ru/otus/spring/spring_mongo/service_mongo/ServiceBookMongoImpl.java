package ru.otus.spring.spring_mongo.service_mongo;

import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.spring_mongo.doman_mongo.AuthorsMongo;
import ru.otus.spring.spring_mongo.doman_mongo.BooksMongo;
import ru.otus.spring.spring_mongo.doman_mongo.GenreMongo;
import ru.otus.spring.spring_mongo.repository_mongo.BooksRepositoryMongo;
import ru.otus.spring.spring_mongo.repository_mongo.GenreRepositoryMongo;


import java.util.List;

@Service
public class ServiceBookMongoImpl implements ServiceBookMongo {

    @Autowired
    private BooksRepositoryMongo booksRepositoryMongo;

    @Autowired
    private GenreRepositoryMongo genreRepositoryMongo;

    @Override
    public List<BooksMongo> getBooks() {
        return booksRepositoryMongo.findAll();
    }

    @Transactional
    @Override
    public List<BooksMongo> getBooksByGenreAndAuthors(GenreMongo genreMongo,
                                                      AuthorsMongo authorsMongo) {
        return booksRepositoryMongo.findByGenreMongoAndAuthorsMongo(genreMongo,
                authorsMongo);
    }

}
