package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @ParameterizedTest
    @MethodSource("provideScoreExamples")
    @DisplayName("correct score is shown when calculated")
    void calculateCorrectScore(List<Round> rounds, int score) {
        Game game = new Game(GameStatus.ENDED, rounds);
        game.calculateScore();

        assertEquals(score, game.getScore());
    }

    private static Stream<Arguments> provideScoreExamples() {
        Round firstAttemptGuess = new Round(true, new Word("woord"), List.of(new Feedback("woord", List.of(Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT))));
        Round secondAttemptGuess = new Round(true, new Word("woord"), List.of(new Feedback("moord", List.of(Mark.ABSENT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT)), new Feedback("woord", List.of(Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT))));

        return Stream.of(
                Arguments.of(List.of(firstAttemptGuess, secondAttemptGuess), 45)
        );
    }

}