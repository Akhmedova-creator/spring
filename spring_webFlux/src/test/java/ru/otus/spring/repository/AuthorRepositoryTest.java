package ru.otus.spring.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.otus.spring.doman.Author;
import ru.otus.spring.doman.Genre;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataMongoTest
class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void shouldFindAll() {
        Author author1 = new Author("1","Roman","Roma");
        Author author2 = new Author("2","Vika","Vitya");
        authorRepository.saveAll(Arrays.asList(author1,author2)).subscribe();

        StepVerifier.create(
                authorRepository.findAll()
        )
                .expectNextCount(2).
                expectNext(author1,author2)
                .expectComplete()
                .verify();
    }

    @Test
    void shouldFindById() {
        authorRepository.save(new Author("3","Roman","Roman")).subscribe();

        StepVerifier.create(
                authorRepository.findById("3")
        )
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }

    @Test
    void shouldSetIdOnSave() {
        Mono<Author> authorMono = authorRepository.save(new Author("1", "Fantasy","Fantasy"));

        StepVerifier
                .create(authorMono)
                .assertNext(author-> assertNotNull(author.getId()))
                .expectComplete()
                .verify();
    }
}