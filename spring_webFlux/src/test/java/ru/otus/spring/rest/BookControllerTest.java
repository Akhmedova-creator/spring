package ru.otus.spring.rest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import ru.otus.spring.doman.Author;
import ru.otus.spring.doman.Book;
import ru.otus.spring.doman.Genre;
import ru.otus.spring.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@WebFluxTest(controllers = BookController.class)
@RunWith(SpringRunner.class)

class BookControllerTest {
    @Autowired
    private WebTestClient client;

    @MockBean
    private BookRepository bookRepository;

    @Test
    void listBook() {
        Book book1 = new Book(
                "2",
                "zara",
                new Genre("7",
                        "Fantasy"),
                new Author("6",
                        "first_name",
                        "last_name"));

        Book book2 = new Book(
                "1",
                "fara",
                new Genre("7",
                        "Fantasy"),
                new Author("6",
                        "first_name",
                        "last_name"));

        List<Book> list = new ArrayList<>();
        list.add(book1);
        list.add(book2);
        Flux<Book> bookFlux = Flux.fromIterable(list);

        Mockito.when(bookRepository.findAll()).thenReturn(bookFlux);

        client.get().uri("/api/books", 2).accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Book.class)
                .equals(bookRepository.findAll());

    }
}