package ru.otus.spring.dao;

import ru.otus.spring.domain.Book;

import java.util.List;

public interface BooksDao {
    int count();

    long insert(Book book);

    Book getById(Long id);

    void update(String title, long id);

    void delete(long id);

    List<Book> getAll();
}
