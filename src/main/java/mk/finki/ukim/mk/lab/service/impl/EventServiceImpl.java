package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.model.exceptions.NoCategoryFoundException;
import mk.finki.ukim.mk.lab.model.exceptions.NoLocationIDFoundException;
import mk.finki.ukim.mk.lab.repository.CategoryRepository;
import mk.finki.ukim.mk.lab.repository.EventRepository;
import mk.finki.ukim.mk.lab.repository.LocationRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repository;
    private final CategoryRepository categoryRepository;
    private final LocationRepository locationRepository;

    public EventServiceImpl(EventRepository repository, CategoryRepository categoryRepository, LocationRepository locationRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.locationRepository = locationRepository;
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

    @Override
    public List<Event> searchByCategory(Category category) {
        return repository.searchByCategory(category);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Event> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Optional<Event> saveOrUpdate(String name, String description, double popularityScore, Long categoryID, Long locationID, int ticketCount) {
        Category category = categoryRepository.findById(categoryID).orElseThrow(NoCategoryFoundException::new);
        Location location = locationRepository.findById(locationID).orElseThrow(() -> new NoLocationIDFoundException(locationID));

        return repository.saveOrUpdate(name, description, popularityScore, category, location, ticketCount);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
