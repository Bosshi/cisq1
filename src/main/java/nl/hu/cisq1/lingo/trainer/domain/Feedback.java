package nl.hu.cisq1.lingo.trainer.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nl.hu.cisq1.lingo.trainer.domain.exception.InvalidFeedbackException;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Feedback {
    private final String attempt;
    private final List<Mark> marks;

    public Feedback(String attempt, List<Mark> marks) {
        this.attempt = attempt;
        this.marks = marks;

        if (attempt.length() != marks.size()) {
            throw new InvalidFeedbackException();
        }
    }

    public boolean isWordGuessed() {
        return marks.stream().allMatch(mark -> mark == Mark.CORRECT);
    }

    public boolean isGuessInvalid() {
        return marks.stream().allMatch(mark -> mark == Mark.INVALID);
    }

    public Hint giveHint() {
        List<Character> characters = new ArrayList<>();

        int index = 0;
        for (Mark mark : marks) {
            if (mark == Mark.CORRECT) {
                characters.add(attempt.charAt(index));
            } else {
                characters.add('.');
            }

            index++;
        }

        return new Hint(characters);
    }
}
