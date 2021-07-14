package ru.otus.spring.dao;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.spring.domain.Authors;
import ru.otus.spring.domain.Books;
import ru.otus.spring.domain.Comments;
import ru.otus.spring.domain.Genre;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("класс BooksDaoJdbcTest")
@DataJpaTest
@Import({BooksDaoRepositoriesJPAImpl.class,CommentRepositoyJPAImpl.class})

class BooksDaoJdbcTest {

    @Autowired
    private BooksDaoRepositoriesJPA booksDaoJdbc;

    @Autowired
    private CommentRepositoryJPA commentRepositoryJPA;

    @Autowired
    private TestEntityManager em;

    private static final long FIRST_BOOK = 1L;
    private static final long SECOND_BOOK = 2L;
    private static final int SIZE_BOOKS = 4;

    @DisplayName("проверка метода getCount")
    @Test
    void shouldReturnExpectedBookCount() {
        int expectedBookCount = booksDaoJdbc.count();
        assertThat(expectedBookCount).isEqualTo(SIZE_BOOKS);
    }

    @DisplayName("проверка метода InsertBook")
    @Test
    void shouldInsertBook() {
        String title = "Гарри Потор";
        val genre = new Genre("Фантастика");
        val authors = new Authors("Карл",
                "Маркс");
        List<Comments> comments = Arrays.asList(new Comments("Исправили имя",
                LocalDate.now()));
        val book = new Books(title,
                genre,
                authors,
                comments);
        booksDaoJdbc.insert(book);

        assertThat(book.getId()).isGreaterThan(0);

        val actualBooks = em.find(Books.class,
                book.getId());

        assertThat(actualBooks).isNotNull().matches(b -> !b.getTitle().equals(""))
                .matches(b -> b.getAuthors() != null)
                .matches(b -> b.getGenre() != null)
                .matches(b -> b.getComments() != null);
    }

    @DisplayName("должен корректно выдавать книгу по Id")
    @Test
    void shouldReturnExpectedBookById() {
        String title = "Гарри Потор";
        val genre = new Genre("Фантастика");
        val authors = new Authors("Карл",
                "Маркс");
        List<Comments> comments = Arrays.asList(new Comments("Исправили имя",
                LocalDate.now()));
        val book = new Books(title,
                genre,
                authors,
                comments);
        booksDaoJdbc.insert(book);

        val actualBook = booksDaoJdbc.findById(book.getId()).get();
        assertThat(actualBook).isEqualTo(book);
    }

    @DisplayName("Должен корректно книгу удалять по id")
    @Test
    void shouldDeleteBook() {
        val firstBook = em.find(Books.class,
                SECOND_BOOK);
        assertThat(firstBook).isNotNull();
        em.detach(firstBook);

        booksDaoJdbc.deleteById(firstBook.getId());
        val deleteBook = em.find(Books.class,
                SECOND_BOOK);

        assertThat(deleteBook).isNull();
    }

    @DisplayName(" должен изменять имя книги по его id")
    @Test
    void shouldUpdateBook() {
        val title = "title";
        val firstStudent = em.find(Books.class,
                FIRST_BOOK);
        String oldTitle = firstStudent.getTitle();
        em.detach(firstStudent);

        booksDaoJdbc.updateNameById(FIRST_BOOK,
                title);

        Books books = em.find(Books.class,
                FIRST_BOOK);
        assertThat(books.getTitle()).isNotEqualTo(oldTitle);
    }

    @Test
    void shouldReturnExpectedBookAll() {

        val comments = booksDaoJdbc.findCommentsByBookId(1l);
        assertThat(comments).isNotNull().hasSize(2)
                .allMatch(b -> b.getCommentData() != null)
                .allMatch(b -> b.getCommentName() != null);

    }
}

