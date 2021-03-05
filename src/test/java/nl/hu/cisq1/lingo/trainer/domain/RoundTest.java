package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.trainer.domain.exception.ExceededGuessAttemptException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {
    @Test
    @DisplayName("correct hint is shown when round has started")
    void startingTheRoundGivesCorrectHint() {
        Round round = new Round(new Word("woord"));
        Hint hint = round.start();
        assertEquals("[w, ., ., ., .]", hint.getHintValues().toString());
    }

    @ParameterizedTest
    @MethodSource("provideFeedbackExamplesAfterGuessAttempt")
    @DisplayName("correct hint and marks are shown when attempt is made")
    void correctFeedbackIsGivenAfterGuessAttempt(String attempt, List<Mark> marks) {
        Round round = new Round(new Word("woord"));
        Feedback feedback = round.guessWord(attempt);
        assertEquals(marks, feedback.getMarks());
    }

    private static Stream<Arguments> provideFeedbackExamplesAfterGuessAttempt() {
        return Stream.of(
                Arguments.of("wafel", List.of(Mark.CORRECT, Mark.ABSENT, Mark.ABSENT, Mark.ABSENT, Mark.ABSENT)),
                Arguments.of("poort", List.of(Mark.ABSENT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.ABSENT)),
                Arguments.of("motor", List.of(Mark.ABSENT, Mark.CORRECT, Mark.ABSENT, Mark.PRESENT, Mark.PRESENT)),
                Arguments.of("scooter", List.of(Mark.INVALID, Mark.INVALID, Mark.INVALID, Mark.INVALID, Mark.INVALID, Mark.INVALID, Mark.INVALID))
        );
    }

    @Test
    @DisplayName("exception is thrown when the guess attempt limit of 5 has been exceeded")
    void guessAttemptsLimitExceeded() {
        Round round = new Round(new Word("woord"));
        round.guessWord("poort");
        round.guessWord("loord");
        round.guessWord("moord");
        round.guessWord("horde");
        round.guessWord("gekte");

        assertThrows(
                ExceededGuessAttemptException.class,
                () -> round.guessWord("grappig")
        );
    }


}