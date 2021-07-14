package ru.otus.spring.service;

import ru.otus.spring.domain.Comments;

import java.util.List;

public interface ServiceBook {
    List<Comments> getBooks();

    void deleteBook(Long id);
}
