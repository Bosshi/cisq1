package nl.hu.cisq1.lingo.trainer.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nl.hu.cisq1.lingo.words.domain.Word;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Round {
    private Word toGuessWord;
    private List<Feedback> feedback;

    public Round(Word toGuessWord, List<Feedback> feedback) {
        this.toGuessWord = toGuessWord;
        this.feedback = feedback;
    }

    public Hint startRound() {
        Feedback feedback = new Feedback(toGuessWord.getValue());
        this.feedback.add(feedback);
        return feedback.giveHint();
    }
}
