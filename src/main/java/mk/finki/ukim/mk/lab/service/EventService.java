package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;

import java.util.List;
import java.util.Optional;


public interface EventService {
    List<Event> listAll();

    List<Event> searchEvents(String text);

    List<Event> searchByPopularityScore(double rating);

    List<Event> searchByNameAndPopularityScore(String text, double rating);

    List<Event> searchByCategory(Category category);

    Optional<Event> findById(Long id);

    Optional<Event> findByName(String name);

    Optional<Event> saveOrUpdate(String name, String description, double popularityScore, Long categoryID, Long locationID, int ticketCount);

    void deleteById(Long id);

}