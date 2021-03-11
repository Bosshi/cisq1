package nl.hu.cisq1.lingo.trainer.domain;

import lombok.Data;
import nl.hu.cisq1.lingo.trainer.domain.exception.ExceededGuessAttemptException;

import java.util.ArrayList;
import java.util.List;

@Data
public class Round {
    private Word toGuessWord;
    private List<Feedback> feedbacks;

    public Round(Word toGuessWord) {
        this(toGuessWord, new ArrayList<>());
    }

    public Round(Word toGuessWord, List<Feedback> feedback) {
        this.toGuessWord = toGuessWord;
        this.feedbacks = feedback;
    }

    public Hint start() {
        return new Feedback(toGuessWord.getValue()).giveHint();
    }

    public Feedback guessWord(String attempt) {
        checkGuessAttempts();

        List<Mark> feedbackMarks = new ArrayList<>();

        char[] guessWord  = toGuessWord.getValue().toCharArray();
        char[] guessAttempt = attempt.toCharArray();

        for (int i = 0; i < guessAttempt.length; i++) {
            if (guessAttempt.length != guessWord.length) {
                feedbackMarks.add(Mark.INVALID);
            } else if (guessWord[i] == guessAttempt[i]) {
                feedbackMarks.add(Mark.CORRECT);
            } else if (new String(guessWord).indexOf(guessAttempt[i]) != -1) {
                feedbackMarks.add(Mark.PRESENT);
            } else {
                feedbackMarks.add(Mark.ABSENT);
            }
        }

        Feedback feedback = new Feedback(attempt, feedbackMarks);
        this.feedbacks.add(feedback);

        return feedback;
    }

    private void checkGuessAttempts() {
        if (this.feedbacks.size() == 5) {
            throw new ExceededGuessAttemptException();
        }
    }

    public boolean isRoundCompleted() {
        return this.feedbacks.stream().anyMatch(Feedback::isWordGuessed);
    }
}
