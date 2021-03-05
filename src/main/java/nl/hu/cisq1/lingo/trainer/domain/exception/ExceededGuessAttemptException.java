package nl.hu.cisq1.lingo.trainer.domain.exception;

public class ExceededGuessAttemptException extends RuntimeException{
    public ExceededGuessAttemptException() {
        super("You have exceeded the guess attempt limit of 5!");
    }
}
