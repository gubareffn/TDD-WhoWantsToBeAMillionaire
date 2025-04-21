package com.millionaire;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MillionaireGameTest {
    @Test
    void shouldInitializeWithGameState() {
        Question[] questions = { new Question("Q1", new String[]{"A"}, 0) };
        MillionaireGame game = new MillionaireGame(questions);

        assertFalse(game.isGameOver());
        assertEquals(0, game.getScore());
        assertNotNull(game.getCurrentQuestion());
    }
}