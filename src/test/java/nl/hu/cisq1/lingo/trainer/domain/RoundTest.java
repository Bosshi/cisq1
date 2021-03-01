package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class RoundTest {
    @Test
    @DisplayName("hint is shown when round has started")
    void startRound() {
        Round round = new Round(new Word("woord"), new ArrayList<>());
        Hint hint = round.startRound();
        assertEquals("[w, ., ., ., .]", hint.getHint().toString());
    }
}