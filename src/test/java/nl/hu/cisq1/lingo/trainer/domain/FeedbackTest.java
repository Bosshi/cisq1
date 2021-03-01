package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.trainer.domain.exception.InvalidFeedbackException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


class FeedbackTest {

    @Test
    @DisplayName("word is guessed if all letters are correct")
    void wordIsGuessed() {
        Feedback feedback = new Feedback("woord", List.of(Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT));
        assertTrue(feedback.isWordGuessed());
    }

    @Test
    @DisplayName("word is not guessed if all letters are not correct")
    void wordIsNotGuessed() {
        Feedback feedback = new Feedback("woort", List.of(Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.ABSENT));
        assertFalse(feedback.isWordGuessed());
    }

    @Test
    @DisplayName("word is invalid if it doesnt exist is or has more letters then the to guess word")
    void guessIsInvalid() {
        Feedback feedback = new Feedback("woordje", List.of(Mark.INVALID, Mark.INVALID, Mark.INVALID, Mark.INVALID, Mark.INVALID, Mark.INVALID, Mark.INVALID));
        assertTrue(feedback.isGuessInvalid());
    }

    @Test
    @DisplayName("word is valid if it exists and has the same amount of letters then the to guess word")
    void guessIsNotInvalid() {
        Feedback feedback = new Feedback("moord", List.of(Mark.ABSENT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT));
        assertFalse(feedback.isGuessInvalid());
    }

    @Test
    @DisplayName("exception is thrown when the word length of the attempt doesn't equal the mark length")
    void attemptLengthDoesNotEqualMarkSize() {
        assertThrows(
                InvalidFeedbackException.class,
                () -> new Feedback("woord", List.of(Mark.CORRECT))
        );
    }

    @Test
    @DisplayName("letters are shown in hint if marks are correct")
    void correctLettersAreShownInHint() {
        Feedback feedback = new Feedback("moord", List.of(Mark.ABSENT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT));
        assertEquals("[., o, o, r, d]", feedback.giveHint().getHint().toString());
    }
}