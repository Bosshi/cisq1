package nl.hu.cisq1.lingo.trainer.domain;

import lombok.Data;

import java.util.List;

@Data
public class Hint {
    private List<Character> hintValues;

    public Hint(List<Character> hintValues) {
        this.hintValues = hintValues;
    }
}
