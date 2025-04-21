package com.millionaire;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    void shouldInitialize() {
        Question[] questions = {
                new Question("Q1", new String[]{"A"}, 0),
                new Question("Q2", new String[]{"B"}, 0)
        };
        Game game = new Game(questions);
        assertEquals(questions[0], game.getCurrentQuestion());
        assertEquals(0, game.getCurrentLevel());

    }

    @Test
    void shouldMoveToNextQuestion() {
        Question[] questions = new Question[2]; // Заглушки
        Game game = new Game(questions);
        game.nextQuestion();
        assertEquals(1, game.getCurrentLevel());
    }

    @Test
    void shouldDetectGameCompletion() {
        Question[] questions = {new Question("Q", new String[]{""}, 0)};
        Game game = new Game(questions);
        assertFalse(game.isCompleted());
        game.nextQuestion();
        assertTrue(game.isCompleted());
    }

    @Test
    void shouldReturnCorrectPrizeAmounts() {
        Game game = new Game(new Question[0]);
        assertEquals(500, game.getPrize(0));
        assertEquals(1000000, game.getPrize(11));
    }
}