package ru.otus.spring.spring_data.service;

import ru.otus.spring.spring_data.domain.Authors;
import ru.otus.spring.spring_data.domain.Books;
import ru.otus.spring.spring_data.domain.Genre;

import java.util.List;

public interface ServiceBook {
    List<Books> getBooks();

    List<Books> getBooksByGenreAndAuthors(Genre genre, Authors authors);
}
