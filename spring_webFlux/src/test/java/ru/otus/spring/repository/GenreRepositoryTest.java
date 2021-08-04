package ru.otus.spring.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.otus.spring.doman.Genre;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataMongoTest
class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;

    @Test
    void shouldFindAll() {
        Genre genre1 = new Genre("1","Roman");
        Genre genre2 = new Genre("2","Fantasy");
        genreRepository.saveAll(Arrays.asList(genre1,genre2)).subscribe();

        StepVerifier.create(
                genreRepository.findAll()
        )
                .expectNextCount(2).
                expectNext(genre1,genre2)
                .expectComplete()
                .verify();
    }

    @Test
    void shouldFindById() {
        genreRepository.save(new Genre("2","Roman")).subscribe();

        StepVerifier.create(
                genreRepository.findById("2")
        )
                .expectNextCount(1)
                .expectComplete()
                .verify();
    }

    @Test
    void shouldSetIdOnSave() {
        Mono<Genre> genreMono = genreRepository.save(new Genre("1", "Fantasy"));

        StepVerifier
                .create(genreMono)
                .assertNext(genre-> assertNotNull(genre.getId()))
                .expectComplete()
                .verify();
    }
}