package ru.otus.spring.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ru.otus.spring.doman.Comment;

public interface CommentRepository extends ReactiveMongoRepository<Comment, String> {

    Mono<Comment> save(Mono<Comment>comment);

}
