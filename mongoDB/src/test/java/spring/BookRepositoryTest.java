package spring;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.doman.Authors;
import spring.doman.Books;
import spring.doman.Comments;
import spring.doman.Genre;
import spring.repository.BooksRepository;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
@ExtendWith(SpringExtension.class)
@ImportAutoConfiguration
@DisplayName("репозиторий BookRepository")
class BookRepositoryTest {

    @Autowired
    private BooksRepository booksRepository;

    @DisplayName("корректый вывод авторов")
    @Test
    void shouldHaveCorrectSavBooks() {
        String title = "Джава.Spring-фреймворк";

        ArrayList<Comments> comments = new ArrayList<>();
        Comments comments1 = new Comments("3",
                "Комментарий 3",
                LocalDate.now());
        Comments comments2 = new Comments("4",
                "Комментарий 4",
                LocalDate.now());
        comments.add(comments1);
        comments.add(comments2);

        Genre genre = new Genre("2",
                "Наука");
        Authors authors = new Authors("2",
                "Хорстман",
                "Кей");

        Books books = new Books(title,
                genre,
                authors,
                comments);

        booksRepository.save(books);

        Books books1 = booksRepository.findByTitle(title);
        assertEquals(books,
                books1);
    }
}