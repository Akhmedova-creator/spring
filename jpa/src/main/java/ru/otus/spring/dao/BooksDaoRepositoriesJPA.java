package ru.otus.spring.dao;

import ru.otus.spring.domain.Books;

import java.util.List;
import java.util.Optional;

public interface BooksDaoRepositoriesJPA {
    Integer count();

    Books insert(Books book);

    Optional<Books> findById(Long id);

    void updateNameById(long id, String name);

    void deleteById(long id);

    List<Books> findAll();
}
