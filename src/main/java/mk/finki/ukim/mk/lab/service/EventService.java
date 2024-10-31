package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;

import java.util.List;


public interface EventService {
    List<Event> listAll();

    List<Event> searchEvents(String text);

    List<Event> searchByPopularityScore(double rating);

    List<Event> searchByNameAndPopularityScore(String text, double rating);


}