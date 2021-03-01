package nl.hu.cisq1.lingo.trainer.domain.exception;

public class InvalidWordLengthException extends RuntimeException{
    public InvalidWordLengthException() {
        super("The word length should exist of 5, 6 or 7 letters!");
    }
}
