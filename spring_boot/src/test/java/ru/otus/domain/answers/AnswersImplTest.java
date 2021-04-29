package ru.otus.domain.answers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Тестирование класса AnswersImpl")
class AnswersImplTest {

    @Autowired
    private Answers answers;

    @DisplayName("Тестирование метода getAnswers")
    @Test
    void shouldHaveCorrectGetAnswers() {

        List<Integer> ans = Arrays.asList(8, 16, 4, 4, 16);
        assertEquals(ans, answers.getAnswers());


    }
}