package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.trainer.domain.exception.InvalidWordLengthException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "words")
public class Word {
    @Id
    @Column(name = "word")
    private String value;
    private Integer length;

    public Word() {}
    public Word(String word) {
        this.value = word;
        this.length = word.length();

        if (this.length < 5 || this.length > 7) {
            throw new InvalidWordLengthException();
        }
    }

    public String getValue() {
        return value;
    }

    public Integer getLength() {
        return length;
    }
}
