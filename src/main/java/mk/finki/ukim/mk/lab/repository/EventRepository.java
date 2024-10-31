package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventRepository {
    public List<Event> findAll() {
        return DataHolder.eventList;
    }

    public List<Event> searchEvents(String text) {
        if (text == null || text.isEmpty()) {
            return null;
        }
        return DataHolder.eventList.stream().filter(r -> r.getName().toLowerCase().contains(text.toLowerCase())
                || r.getDescription().toLowerCase().contains(text.toLowerCase())).collect(Collectors.toList());
    }

    public List<Event> searchByRating(double rating) {
        return DataHolder.eventList.stream().filter(r -> r.getPopularityScore() >= rating).collect(Collectors.toList());
    }

    public List<Event> searchNameAndRating(String text, double rating) {
        return DataHolder.eventList.stream()
                .filter(r -> (r.getName().toLowerCase().contains(text.toLowerCase())
                        || r.getDescription().toLowerCase().contains(text.toLowerCase()))
                        && r.getPopularityScore() >= rating)
                .collect(Collectors.toList());
    }

    public List<Event> searchByCategory(Category category) {
        return DataHolder.eventList.stream()
                .filter(r -> r.getCategory().getName().toLowerCase().contains(category.getName().toLowerCase()))
                .collect(Collectors.toList());
    }

}
