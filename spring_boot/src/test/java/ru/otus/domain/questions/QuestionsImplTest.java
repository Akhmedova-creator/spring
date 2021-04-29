package ru.otus.domain.questions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.listeners.MockitoListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@TestExecutionListeners(MockitoTestExecutionListener.class)
@DisplayName("проверка класса  QuestionsImpl")
class QuestionsImplTest {

    @MockBean
    private Questions questions;

    @DisplayName("проверка метода  getQuestions")
    @Test
    void shouldHaveGetQuestions() {
        List<String> exp = Arrays.asList("How many bytes does the int data type have?",
                "How many bytes does the double data type have?",
                "How many bytes does the char data type have?",
                "How many bytes does a short data type have?",
                "How many bytes does a long data type have?");
        given(this.questions.getQuestions()).willReturn(exp);

        assertEquals(exp, questions.getQuestions());

    }
}