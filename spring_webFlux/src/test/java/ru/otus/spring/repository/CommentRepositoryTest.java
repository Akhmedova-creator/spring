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
import ru.otus.spring.doman.Comment;
import ru.otus.spring.doman.Genre;

import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataMongoTest
class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;

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
        Mono<Comment> commentMono = commentRepository.save(new Comment("1",
                LocalDate.now(),book));

        StepVerifier
                .create(commentMono)
                .assertNext(comment-> assertNotNull(comment.getId()))
                .expectComplete()
                .verify();
    }
}