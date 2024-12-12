package mk.finki.ukim.mk.lab.model.exceptions;

public class PasswordsDontMatchException extends RuntimeException {
    public PasswordsDontMatchException() {
        super("Passwords dont match");
    }
}
