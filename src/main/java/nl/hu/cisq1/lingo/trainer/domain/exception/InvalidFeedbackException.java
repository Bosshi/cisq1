package nl.hu.cisq1.lingo.trainer.domain.exception;

public class InvalidFeedbackException extends RuntimeException {
    public InvalidFeedbackException() {
        super("The word attempt size does not equal the marks size");
    }
}
