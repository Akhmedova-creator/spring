package ru.otus.domain.testResult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.domain.countaswers.CountAnswers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@DisplayName("тестирование класса TestResultImpl")
class TestResultImplTest {

    @MockBean
    private CountAnswers countAnswers;
    private TestResult testResult = new TestResultImpl(countAnswers);

    @Test
    void shouldHaveGetResultNegativeAnswer() {
        testResult = new TestResultImpl(countAnswers);
        given(countAnswers.getCountAnswers()).willReturn(1);
        assertEquals("Вы не сдали тест", testResult.getResultAnswer());
    }

    @Test
    void shouldHaveGetResultPositiveAnswer() {
        given(countAnswers.getCountAnswers()).willReturn(5);
        testResult = new TestResultImpl(countAnswers);
        assertEquals("Вы сдали тест!!!", testResult.getResultAnswer());
    }
}