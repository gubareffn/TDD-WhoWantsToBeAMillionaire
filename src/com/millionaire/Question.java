package com.millionaire;

public class Question {
    private final String text;
    private final String[] answers;
    private final int correctIndex;

    public Question(String text, String[] answers, int correctIndex) {
        this.text = text;
        this.answers = answers;
        this.correctIndex = correctIndex;
    }

    public String getText() { return text; }
    public String[] getAnswers() { return answers; }
    public int getCorrectIndex() { return correctIndex; }
}