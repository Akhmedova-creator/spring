package ru.otus.domain.correctAnswers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import ru.otus.domain.questions.Questions;

import java.util.*;


@Component
@ConditionalOnProperty(
        value = "enable.bean",
        havingValue = "true"
)
public class CorrectAnswersImpl implements CorrectAnswers {

    final private Questions questions;
    private List<Integer> answers;

    @Autowired
    public CorrectAnswersImpl(Questions questions) {
        this.questions = questions;
    }

    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }

    @Override
    public List<Integer> getAnswers() {
        //локализация
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("ru", "RU"));

        List<String> question = questions.getQuestions();
        answers = new ArrayList<>();

        try {
            for (int i = 0; i < question.size(); i++) {
                System.out.println(bundle.getString(question.get(i)));
                Scanner sc = new Scanner(System.in);
                answers.add(i, sc.nextInt());
            }
        } catch (Exception e) {
            System.out.println("Ошибка при вводе ответа ");
        }

        return answers;

    }
}
