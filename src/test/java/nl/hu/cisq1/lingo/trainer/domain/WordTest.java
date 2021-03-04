package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.trainer.domain.exception.InvalidWordLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource("provideWordExamples")
    @DisplayName("exception is thrown when the word length is not 5, 6 or 7")
    void wordLengthNotAllowed(String word) {
        assertThrows(
                InvalidWordLengthException.class,
                () -> new Word(word)
        );
    }

    private static Stream<Arguments> provideWordExamples() {
        return Stream.of(
                Arguments.of("kat"),
                Arguments.of("meer"),
                Arguments.of("kaasboer"),
                Arguments.of("wafelhuis")
        );
    }

}
