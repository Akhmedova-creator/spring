package ru.otus.domain.correctAnswers;

import java.io.IOException;
import java.util.List;

public interface CorrectAnswers {

    public void setAnswers(List<Integer> answers);

    List<Integer> getAnswers();
}
