package ru.otus.spring.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.otus.spring.domain.Comments;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@DisplayName("репозиторий CommentsRepository")
class CommentsRepositoryTest {

    @Autowired
    private CommentsRepository commentsRepository;

    @DisplayName("Должен получить комментарии по сегодняшней дате")
    @Test
    void shouldHaveCorrectGetNowDate() {
        Comments actuals = commentsRepository.save(new Comments("тест", LocalDate.now(),null));
        List<Comments> expected = commentsRepository.getNowDate(LocalDate.now());
        assertEquals(actuals, expected.get(0));
    }
}