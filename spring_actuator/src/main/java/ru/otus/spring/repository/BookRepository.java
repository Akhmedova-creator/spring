package ru.otus.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.otus.spring.doman.Book;
import ru.otus.spring.doman.Author;
import ru.otus.spring.doman.Genre;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "books")
public interface BookRepository extends MongoRepository<Book, Long> {
    List<Book> findByGenreAndAuthor(Genre genre, Author author);

    Optional<Book> findById(String id);
}
