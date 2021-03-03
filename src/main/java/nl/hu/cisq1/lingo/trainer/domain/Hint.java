package nl.hu.cisq1.lingo.trainer.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Hint {
    private List<Character> hintValues;

    public Hint(List<Character> hintValues) {
        this.hintValues = hintValues;
    }
}
