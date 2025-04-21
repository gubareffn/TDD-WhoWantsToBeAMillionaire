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
}