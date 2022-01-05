package ru.otus.spring.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import ru.otus.spring.domain.Authors;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@DisplayName("репозиторий AuthorsRepository")
class AuthorsRepositoryTest {
    @Autowired
    private AuthorsRepository authorsRepository;
    @Autowired
    private GenreRepository genreRepository;

    @DisplayName("корректый вывод авторов")
    @Test
    void shouldHaveCorrectFindAll() {
        List<Authors> exprected = Arrays.asList(new Authors(1l, "Хорстман", "Кей"),
                new Authors(2l, "Михаил", "Лабковcкий"),
                new Authors(3l, "Джеймс", "Леонард"));

        List<Authors> actual = authorsRepository.findAll(Sort.by(Sort.Direction.DESC, "firstName"));
        assertEquals(exprected, actual);
    }
}
