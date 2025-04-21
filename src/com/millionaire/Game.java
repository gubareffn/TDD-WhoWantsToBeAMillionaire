package com.millionaire;

public class Game {
    private final Question[] questions;
    private int currentLevel;
    private Question currentQuestion;

    public Game(Question[] questions) {
        this.questions = questions;
        this.currentLevel = 0;
        this.currentQuestion = questions[0];
    }

    public Question getCurrentQuestion() { return currentQuestion; }
    public int getCurrentLevel() { return currentLevel; }
}