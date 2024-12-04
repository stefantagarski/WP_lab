package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.model.exceptions.EventNotFoundException;
import mk.finki.ukim.mk.lab.model.exceptions.NoCategoryFoundException;
import mk.finki.ukim.mk.lab.model.exceptions.NoLocationIDFoundException;
import mk.finki.ukim.mk.lab.repository.impl.InMemoryCategoryRepository;
import mk.finki.ukim.mk.lab.repository.impl.InMemoryEventRepository;
import mk.finki.ukim.mk.lab.repository.impl.InMemoryLocationRepository;
import mk.finki.ukim.mk.lab.repository.jpa.CategoryRepository;
import mk.finki.ukim.mk.lab.repository.jpa.EventRepository;
import mk.finki.ukim.mk.lab.repository.jpa.LocationRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final CategoryRepository categoryRepository;
    private final LocationRepository locationRepository;

    public EventServiceImpl(EventRepository eventRepository, CategoryRepository categoryRepository
            , LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.categoryRepository = categoryRepository;
        this.locationRepository = locationRepository;
    }


    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEventsByNameAndDesc(String name) {
        return eventRepository.searchEventByNameOrDescriptionIgnoreCase(name);
    }


    @Override
    public List<Event> searchByPopularityScore(double rating) {
        return eventRepository.searchEventByPopularityScoreGreaterThanEqual(rating);
    }

    @Override
    public List<Event> searchByNameAndPopularityScore(String text, double rating) {
        return eventRepository.searchByNameAndPopularityScore(text, rating);
    }

    @Override
    public List<Event> searchByCategoryID(Long categoryID) {
        return eventRepository.findAllByCategory_Id(categoryID);
    }


    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Optional<Event> findByName(String name) {
        return eventRepository.findByName(name);
    }

    @Override
    public Optional<Event> save(String name, String description, double popularityScore, Long categoryID
            , Long locationID, int ticketCount) {

        Category category = categoryRepository.findById(categoryID)
                .orElseThrow(NoCategoryFoundException::new);

        Location location = locationRepository.findById(locationID)
                .orElseThrow(() -> new NoLocationIDFoundException(locationID));


        Event event = new Event(name, description, popularityScore, category, location, ticketCount);

        return Optional.of(eventRepository.save(event));

    }

    @Override
    public Optional<Event> update(Long id, String name, String description, double popularityScore, Long categoryID, Long locationID, int ticketCount) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));

        Category category = categoryRepository.findById(categoryID)
                .orElseThrow(NoCategoryFoundException::new);

        Location location = locationRepository.findById(locationID)
                .orElseThrow(() -> new NoLocationIDFoundException(locationID));

        event.setName(name);
        event.setDescription(description);
        event.setPopularityScore(popularityScore);
        event.setCategory(category);
        event.setLocation(location);
        event.setTicketCount(ticketCount);

        return Optional.of(eventRepository.save(event));
    }

    @Override
    public List<Event> findAllByLocationId(Long locationId) {
        return eventRepository.findAllByLocation_Id(locationId);
    }

    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }
}
