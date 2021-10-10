package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.otus.spring.domain.Authors;
import ru.otus.spring.domain.Book;
import ru.otus.spring.domain.Genre;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayName("класс BooksDaoJdbcTest")
@JdbcTest
@Import({BooksDaoJdbc.class, GenreDaoJdbc.class, AuthorsDaoJdbc.class})
class BooksDaoJdbcTest {

    @Autowired
    private BooksDao booksDaoJdbc;

    @Autowired
    private GenreDao genreDaoJdbc;

    @Autowired
    private AuthorsDao authorsDaoJdbc;

    @DisplayName("проверка метода getCount")
    @Test
    void shouldReturnExpectedBookCount() {
        int expectedBookCount = booksDaoJdbc.count();
        assertThat(expectedBookCount).isEqualTo(4);
    }

    @DisplayName("проверка метода InsertBook")
    @Test
    void shouldInsertBook() {

        String title = "Хочу и буду";
        Genre genre = new Genre("Наука");
        Authors authors = new Authors("Михаил",
                "Лабковкий");
        Book actualBook = new Book(title,
                genre,
                authors);

        long id = booksDaoJdbc.insert(actualBook);
        Book expectedBook = booksDaoJdbc.getById(id);

        assertThat(actualBook.toString()).isEqualTo(expectedBook.toString());
    }

    @Test
    void shouldReturnExpectedBookById() {
        String title = "Хочу и буду";
        Genre genre = new Genre("Наука");
        Authors authors = new Authors("Михаил",
                "Лабковкий");
        Book actualBook = new Book(title,
                genre,
                authors);

        long id = booksDaoJdbc.insert(actualBook);
        assertThat(actualBook.toString()).isEqualTo((booksDaoJdbc.getById(id).toString()));
    }

    @Test
    void shouldDeleteBook() {
        String title = "Хочу и буду";
        Genre genre = new Genre("Наука");
        Authors authors = new Authors("Михаил",
                "Лабковкий");
        Book actualBook = new Book(title,
                genre,
                authors);

        long id = booksDaoJdbc.insert(actualBook);

        assertThat(booksDaoJdbc.getById(id).toString()).isEqualTo((actualBook.toString()));

        booksDaoJdbc.delete(id);
        assertThatThrownBy(() -> booksDaoJdbc.getById(id)).isInstanceOf(EmptyResultDataAccessException.class);
    }

    @Test
    void shouldUpdateBook() {
        String title = "My books";
        long id = 1;
        booksDaoJdbc.update(title,
                id);
        assertThat(booksDaoJdbc.getById(id).getTitle()).isEqualTo(title);
    }

    @Test
    void shouldReturnExpectedBookAll() {
        String actualBooks = booksDaoJdbc.getAll().toString();
        Genre science = new Genre("Наука");
        Genre romans = new Genre("Роман");
        Authors horstman = new Authors("Хорстман",
                "Кей");
        Authors jems = new Authors("Джеймс",
                "Леонард");
        List<Book> expectedBooks = Arrays.asList(
                new Book("Алгоритмы и структуры данных",
                        science,
                        horstman),
                new Book("Джава.Основы",
                        science,
                        horstman),
                new Book("Джава.Spring-фреймворк",
                        science,
                        horstman),
                new Book("50 оттенков серого",
                        romans,
                        jems));
        assertThat(expectedBooks.toString()).isEqualTo(actualBooks);
    }
}

