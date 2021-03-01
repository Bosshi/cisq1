package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.trainer.domain.exception.InvalidWordLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordTest {

    @Test
    @DisplayName("length is based on given word")
    void lengthBasedOnWord() {
        Word word = new Word("woord");
        int length = word.getLength();
        assertEquals(5, length);
    }

    @Test
    @DisplayName("exception is thrown when the word length is not 5, 6 or 7")
    void wordLengthNotAllowed() {
        assertThrows(
                InvalidWordLengthException.class,
                () -> new Word("Tafelkleed")
        );
    }
}
