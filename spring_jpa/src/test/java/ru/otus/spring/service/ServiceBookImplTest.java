package ru.otus.spring.service;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.otus.spring.dao.BooksDaoRepositoriesJPA;
import ru.otus.spring.dao.BooksDaoRepositoriesJPAImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("класс BooksDaoJdbcTest")
@DataJpaTest
@Import({ServiceBookImpl.class, BooksDaoRepositoriesJPAImpl.class})
class ServiceBookImplTest {

    @Autowired
    private ServiceBook serviceBook;

    @Test
    void shouldReturnExpectedBookAll() {
        val comments = serviceBook.getCommentsOfBook(1l);
        assertThat(comments).isNotNull().hasSize(2)
                .allMatch(b -> b.getCommentData() != null)
                .allMatch(b -> b.getCommentName() != null);

    }
}