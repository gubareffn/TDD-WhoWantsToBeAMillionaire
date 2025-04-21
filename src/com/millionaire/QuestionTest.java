package com.millionaire;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {
    @Test
    void shouldCreateQuestionWithTextAndAnswers() {
        Question q = new Question("Test?", new String[]{"A", "B"}, 0);
        assertEquals("Test?", q.getText());
        assertArrayEquals(new String[]{"A", "B"}, q.getAnswers());
        assertEquals(0, q.getCorrectIndex());
    }

    @Test
    void shouldCheckAnswerCorrectly() {
        Question q = new Question("Test?", new String[]{"A", "B"}, 1);
        assertTrue(q.checkAnswer(1));
        assertFalse(q.checkAnswer(0));
    }
}