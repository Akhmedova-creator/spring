package ru.otus.spring.spring_mongo.mongock.changelog;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import ru.otus.spring.spring_mongo.doman_mongo.AuthorsMongo;
import ru.otus.spring.spring_mongo.doman_mongo.BooksMongo;
import ru.otus.spring.spring_mongo.doman_mongo.CommentsMongo;
import ru.otus.spring.spring_mongo.doman_mongo.GenreMongo;
import ru.otus.spring.spring_mongo.repository_mongo.BooksRepositoryMongo;

import java.util.ArrayList;

@ChangeLog
public class DatabaseChangelog {
    @ChangeSet(order = "001", id = "addBooks1", author = "AkhmedovaFI")
    public void insertBooks1(BooksRepositoryMongo booksRepositoryMongo) {

        BooksMongo booksMongo = new BooksMongo("50 оттенков серого",
                new GenreMongo("1",
                        "Роман"),
                new AuthorsMongo("1",
                        "Джеймс",
                        "Леонард"));
        booksRepositoryMongo.save(booksMongo);

    }

    @ChangeSet(order = "002", id = "addBooks2", author = "AkhmedovaFI")
    public void insertBooks2(BooksRepositoryMongo booksRepositoryMongo) {
        BooksMongo booksMongo = new BooksMongo("50 серого",
                new GenreMongo("2",
                        "Роман"),
                new AuthorsMongo("3",
                        "Джеймс",
                        "Леонард"));
        booksRepositoryMongo.save(booksMongo);

    }
}