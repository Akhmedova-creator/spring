package ru.otus.domain.countaswers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import ru.otus.domain.answers.Answers;
import ru.otus.domain.correctAnswers.CorrectAnswers;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@TestExecutionListeners(MockitoTestExecutionListener.class)
@DisplayName("Тесирование класса CountAnswersImpl ")
class CountAnswersImplTest {

    @MockBean
    private Answers answers;

    @MockBean
    private CorrectAnswers correctAnswers;

    private CountAnswers countAnswers;

    @DisplayName("Тестирование метода getCountAnswers ")
    @Test
    void shouldHaveCorrectGetCountAnswers() {
        countAnswers = new CountAnswersImpl(correctAnswers, answers);

        List<Integer> ans = Arrays.asList(8, 16, 4, 4, 16);
        List<Integer> que = Arrays.asList(4, 4, 16, 16, 4);

        given(answers.getAnswers()).willReturn(ans);
        given(correctAnswers.getAnswers()).willReturn(que);

        assertThat(countAnswers.getCountAnswers()).isEqualTo(0);

    }
}