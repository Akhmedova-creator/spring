package ru.otus.domain.testResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.domain.countaswers.CountAnswers;

import java.io.IOException;

@Service
public class TestResultImpl implements TestResult {

    final private CountAnswers countAnswers;

    @Autowired
    public TestResultImpl(CountAnswers countAnswers) {
        this.countAnswers = countAnswers;
    }

    private final int ANSWERCOUNT = 4;

    @Override
    public String getResultAnswer() {
        if (countAnswers.getCountAnswers() >= ANSWERCOUNT) {
            return TextAnswer.PositiveText.getText();
        } else return TextAnswer.NegativeText.getText();
    }
}
