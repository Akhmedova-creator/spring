package ru.otus.spring.service;

import ru.otus.spring.domain.Comments;

import java.util.List;

public interface ServiceBook {
    List<Comments> getCommentsOfBook(Long id);

    void deleteBook(Long id);
}
