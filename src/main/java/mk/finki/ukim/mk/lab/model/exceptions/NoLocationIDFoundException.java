package mk.finki.ukim.mk.lab.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoLocationIDFoundException extends RuntimeException {
    public NoLocationIDFoundException(Long id) {
        super(String.format("Location with id %d was not found", id));
    }
}
