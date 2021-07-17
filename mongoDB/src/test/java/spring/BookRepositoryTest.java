package spring;
import com.github.cloudyrock.spring.v5.EnableMongock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.doman.Authors;
import spring.doman.Books;
import spring.doman.Comments;
import spring.doman.Genre;
import spring.repository.BooksRepository;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
@DisplayName("репозиторий BookRepository")
@ComponentScan

class BookRepositoryTest {

    @Autowired
    private BooksRepository booksRepository;

    @DisplayName("корректый вывод авторов")
    @Test
    void shouldHaveCorrectSavBooks() {
        String title = "50 оттенков серого";

        ArrayList<Comments> comments = new ArrayList<>();
        Comments comments1 = new Comments("1",
                "Комментарий 1",
                LocalDate.now());
        Comments comments2 = new Comments("2",
                "Комментарий 2",
                LocalDate.now());
        comments.add(comments1);
        comments.add(comments2);

        Genre genre = new Genre("1",
                "Роман");
        Authors authors = new Authors("1",
                "Джеймс",
                "Леонард");

        Books books = new Books(title,
                genre,
                authors,
                comments);

        Books books1 = booksRepository.findByTitle(title);
        assertEquals(books.getComments(), books1.getComments());
        assertEquals(books.getTitle(), books1.getTitle());
        assertEquals(books.getGenre(), books1.getGenre());
        assertEquals(books.getAuthors(), books1.getAuthors());

    }
}