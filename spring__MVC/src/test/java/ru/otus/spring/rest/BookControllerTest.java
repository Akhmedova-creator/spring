package ru.otus.spring.rest;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.filter.TypeExcludeFilters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTypeExcludeFilter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.spring.doman.Author;
import ru.otus.spring.doman.Book;
import ru.otus.spring.doman.Genre;
import ru.otus.spring.service.ServiceBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TypeExcludeFilters({WebMvcTypeExcludeFilter.class})
@AutoConfigureCache
@AutoConfigureWebMvc
@AutoConfigureMockMvc
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceBook serviceBook;

    @Test
    void shouldHaveCorrectListBook() throws Exception {
        Book book = new Book("50 оттенков серого",
                new Genre("Роман"),
                new Author("Джеймс",
                        "Леонард"));
        List<Book> books = new ArrayList<>();
        books.add(book);
        given(serviceBook.getBooks()).willReturn(books);
        this.mockMvc.perform(get("/")).
                andExpect(status().isOk()).andReturn().equals(books);
    }

    @Test
    void shouldHaveCorrectEditBook() throws Exception {
        Book book = new Book("1",
                "50 оттенков серого",
                new Genre("Роман"),
                new Author("Джеймс",
                        "Леонард"));
        given(serviceBook.findByIdBook("1")).willReturn(Optional.of(book));
        this.mockMvc.perform(get("/edit/1")).
                andExpect(status().isOk()).andReturn().equals(book);

    }

}