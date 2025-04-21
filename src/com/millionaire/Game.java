package com.millionaire;

public class Game {
    private final Question[] questions;
    private int currentLevel;
    private Question currentQuestion;
    private static final int[] PRIZES = {
            500, 1000, 2000, 5000, 10000,
            25000, 50000, 100000, 250000,
            500000, 750000, 1000000
    };

    public Game(Question[] questions) {
        this.questions = questions;
        this.currentLevel = 0;
        this.currentQuestion = questions[0];
    }

    public void nextQuestion() {
        currentLevel++;
        if (currentLevel < questions.length) {
            currentQuestion = questions[currentLevel];
        }
    }
    public int getPrize(int level) {
        return PRIZES[Math.min(level, PRIZES.length - 1)];
    }

    public int getCurrentPrize() {
        return getPrize(currentLevel);
    }

    public boolean isCompleted() {
        return currentLevel >= questions.length;
    }

    public Question getCurrentQuestion() { return currentQuestion; }
    public int getCurrentLevel() { return currentLevel; }
}