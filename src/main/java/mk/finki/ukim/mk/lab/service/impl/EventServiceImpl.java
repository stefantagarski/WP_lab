package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.repository.EventRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    public EventServiceImpl(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Event> listAll() {
        return repository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        return repository.searchEvents(text);
    }

    @Override
    public List<Event> searchByPopularityScore(double rating) {
        return repository.searchByRating(rating);
    }

    @Override
    public List<Event> searchByNameAndPopularityScore(String text, double rating) {
        return repository.searchNameAndRating(text, rating);
    }
}
