package ru.otus.spring;

import org.springframework.stereotype.Service;
import ru.otus.spring.spring_data.domain.Authors;
import ru.otus.spring.spring_data.domain.Books;
import ru.otus.spring.spring_data.domain.Genre;
import ru.otus.spring.spring_mongo.doman_mongo.BooksMongo;

@Service
public class Transfor {

    public Books doBooks(BooksMongo booksMongo) {
        String name = booksMongo.getGenreMongo().getName();
        Genre genre = new Genre(name);
        String title = booksMongo.getTitle();
        String firstName = booksMongo.getAuthorsMongo().getFirstName();
        String lastName = booksMongo.getAuthorsMongo().getLastName();
        Authors authors = new Authors(firstName,
                lastName);
        return new Books(title,
                genre,
                authors);
    }
}
