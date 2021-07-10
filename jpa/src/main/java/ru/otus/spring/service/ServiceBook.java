package ru.otus.spring.service;

import ru.otus.spring.domain.Books;

import java.util.List;

public interface ServiceBook {
    List<Books> getBooks();

    void deleteBook(Long id);
}
