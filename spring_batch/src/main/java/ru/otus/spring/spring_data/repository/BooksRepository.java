package ru.otus.spring.spring_data.repository;

import liquibase.pro.packaged.B;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.spring.spring_data.domain.Authors;
import ru.otus.spring.spring_data.domain.Books;
import ru.otus.spring.spring_data.domain.Genre;

import java.util.List;

public interface BooksRepository extends JpaRepository<Books, Long> {
    List<Books> findByGenreAndAuthors(Genre genre, Authors authors);

    List<Books> findAll();
}
