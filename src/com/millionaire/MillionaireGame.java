package com.millionaire;

public class MillionaireGame {
    private final Game game;
    private boolean gameOver;
    private int score;

    public MillionaireGame(Question[] questions) {
        this.game = new Game(questions);
        this.gameOver = false;
        this.score = 0;
    }

    public boolean isGameOver() { return gameOver; }
    public int getScore() { return score; }
    public Question getCurrentQuestion() { return game.getCurrentQuestion(); }
    public static void main(String[] args) {
        Question[] questions = { /* вопросы из предыдущего примера */ };
        new MillionaireGame(questions).start();
    }

    private void start() {
    }
}