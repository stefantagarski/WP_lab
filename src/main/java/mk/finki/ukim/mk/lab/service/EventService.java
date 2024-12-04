package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;

import java.util.List;
import java.util.Optional;


public interface EventService {
    List<Event> listAll();

    List<Event> searchEventsByNameAndDesc(String name);

    List<Event> searchByPopularityScore(double rating);

    List<Event> searchByNameAndPopularityScore(String text, double rating);

    List<Event> searchByCategoryID(Long categoryID);

    Optional<Event> findById(Long id);

    Optional<Event> findByName(String name);

    Optional<Event> save(String name, String description, double popularityScore, Long categoryID, Long locationID, int ticketCount);

    Optional<Event> update(Long id, String name, String description, double popularityScore, Long categoryID, Long locationID, int ticketCount);

    List<Event> findAllByLocationId(Long locationId);

    void deleteById(Long id);

}