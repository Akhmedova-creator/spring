package ru.otus.domain.countaswers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.domain.answers.Answers;
import ru.otus.domain.correctAnswers.CorrectAnswers;
import java.util.List;

@Service
public class CountAnswersImpl implements CountAnswers {


    final private CorrectAnswers printQue;

    final private Answers answers;

    @Autowired
    public CountAnswersImpl(CorrectAnswers printQue, Answers answers) {
        this.printQue = printQue;
        this.answers = answers;
    }

    public int getCountAnswers() {

        List<Integer> array = printQue.getAnswers();
        List<Integer> ans = answers.getAnswers();

        int countAnswers = 0;
        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i).equals(array.get(i))) {
                countAnswers++;
            }
        }
        return countAnswers;
    }
}
