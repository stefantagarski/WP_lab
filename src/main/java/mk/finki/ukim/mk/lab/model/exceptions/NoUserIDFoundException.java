package mk.finki.ukim.mk.lab.model.exceptions;

public class NoUserIDFoundException extends RuntimeException {
    public NoUserIDFoundException(Long id) {
        super(String.format("User with id %d Not Found", id));
    }
}
