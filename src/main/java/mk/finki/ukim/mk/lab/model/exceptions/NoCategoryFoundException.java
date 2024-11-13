package mk.finki.ukim.mk.lab.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoCategoryFoundException extends RuntimeException{
    public NoCategoryFoundException() {
        super("No Category found!");
    }
}
