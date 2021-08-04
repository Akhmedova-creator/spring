package ru.otus.spring.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.spring.doman.Genre;

public interface GenreRepository extends ReactiveMongoRepository<Genre, String> {


    Flux<Genre> findAll();

    Mono<Genre> findById(String id);

    Mono<Genre> save(Mono<Genre> genre);
}
