package ru.otus.spring.service;

import ru.otus.spring.domain.Authors;
import ru.otus.spring.domain.Books;
import ru.otus.spring.domain.Genre;

import java.util.List;

public interface ServiceBook {
    List<Books> getBooks();

    List<Books> getBooksByGenreAndAuthors(Genre genre, Authors authors);
}
