package mk.finki.ukim.mk.lab.model.exceptions;

public class InvalidRegisterException extends RuntimeException {
    public InvalidRegisterException(String message) {
        super("Invalid arguments for registration, please try again!");
    }
}
