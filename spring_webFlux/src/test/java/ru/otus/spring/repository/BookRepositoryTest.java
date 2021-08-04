package ru.otus.spring.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.otus.spring.doman.Author;
import ru.otus.spring.doman.Book;
import ru.otus.spring.doman.Genre;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataMongoTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void shouldFindById() {
        bookRepository.save(new Book(
                "1","fara",new Genre("2","Roman"),
                new Author("1","firstname","lastname"))).subscribe();

        StepVerifier.create(
                bookRepository.findById("1")
        )
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }


    @Test
    void shouldSetIdOnSave() {
        Book book = new Book(
                "2",
                "zara",
                new Genre("7",
                        "Fantasy"),
                new Author("6",
                        "first_name",
                        "last_name"));
        Mono<Book> bookMono = bookRepository.save(book);

        StepVerifier
                .create(bookMono)
                .assertNext(book1-> assertNotNull(book1.getId()))
                .expectComplete()
                .verify();
    }

    @Test
    void shouldDeleteById() {
        Book book = new Book(
                "2",
                "zara",
                new Genre("7",
                        "Fantasy"),
                new Author("6",
                        "first_name",
                        "last_name"));
        Mono<Book> bookMono = bookRepository.save(book);

        StepVerifier.create(
                bookRepository.deleteById("2")
        )
                .expectNextCount(0)
                .expectComplete()
                .verify();

    }
}