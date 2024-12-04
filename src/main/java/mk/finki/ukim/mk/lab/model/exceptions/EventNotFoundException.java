package mk.finki.ukim.mk.lab.model.exceptions;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(Long id) {
        super(String.format("Event with ID: %d was NOT FOUND", id));
    }
}
