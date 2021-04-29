package ru.otus.domain.testResult;

public enum TextAnswer {

    NegativeText("Вы не сдали тест"),
    PositiveText("Вы сдали тест!!!");

    public String getText() {
        return text;
    }

    private String text;

    TextAnswer(String text) {
        this.text = text;
    }
}
