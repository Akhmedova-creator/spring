package spring;

import com.github.cloudyrock.spring.v5.EnableMongock;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.doman.Authors;
import spring.doman.Books;
import spring.doman.Comments;
import spring.doman.Genre;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
@ExtendWith(SpringExtension.class)
@DisplayName("репозиторий BookRepository")
class BookRepositoryTest {
    @DisplayName("корректый вывод авторов")
    @Test
    void shouldHaveCorrectSavBooks(@Autowired MongoTemplate mongoTemplate) {
        String title = "Джава.Spring-фреймворк";

        ArrayList<Comments> comments =new ArrayList<>();
        Comments comments1=new Comments("3","Комментарий 3",
                LocalDate.now());
        Comments comments2= new Comments("4","Комментарий 4",LocalDate.now());
        comments.add(comments1);
        comments.add(comments2);

        Genre genre = new Genre("2","Наука");
        Authors authors= new Authors("2","Хорстман","Кей");

        Books books=new Books(title,genre,authors,comments);

        mongoTemplate.save(books, "books");

        Books books1=mongoTemplate.findById(books.getId(),Books.class,"books");

        assertEquals(books,books1);
    }
}