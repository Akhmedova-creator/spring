package ru.otus.spring.service;


import ru.otus.spring.doman.Author;
import ru.otus.spring.doman.Book;
import ru.otus.spring.doman.Genre;

import java.util.List;

public interface ServiceBook {
    List<Book> getBooks();

    List<Book> getBooksByGenreAndAuthors(Genre genre, Author author);
}
