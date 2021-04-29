package ru.otus.domain.countaswers;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import ru.otus.domain.answers.AnswersImpl;
import ru.otus.domain.correctAnswers.CorrectAnswers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@ConditionalOnProperty(
        value = "enable.bean",
        havingValue = "false"
)
public class OtherAnswers implements CorrectAnswers {

    private List<Integer> answers;

    @Override
    public List<Integer> getAnswers() {
        return answers;
    }

    @Override
    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }


}
