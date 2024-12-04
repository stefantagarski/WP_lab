//package mk.finki.ukim.mk.lab.repository.impl;
//
//import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
//import mk.finki.ukim.mk.lab.model.Category;
//import mk.finki.ukim.mk.lab.model.Event;
//import mk.finki.ukim.mk.lab.model.Location;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Repository
//public class InMemoryEventRepository {
//    public List<Event> findAll() {
//        return DataHolder.eventList;
//    }
//
//    public List<Event> searchEvents(String text) {
//        if (text == null || text.isEmpty()) {
//            return null;
//        }
//        return DataHolder.eventList.stream().filter(r -> r.getName().toLowerCase().contains(text.toLowerCase())
//                || r.getDescription().toLowerCase().contains(text.toLowerCase())).collect(Collectors.toList());
//    }
//
//    public List<Event> searchByRating(double rating) {
//        return DataHolder.eventList.stream().filter(r -> r.getPopularityScore() >= rating)
//                .collect(Collectors.toList());
//    }
//
//    public List<Event> searchNameAndRating(String text, double rating) {
//        return DataHolder.eventList.stream()
//                .filter(r -> (r.getName().toLowerCase().contains(text.toLowerCase())
//                        || r.getDescription().toLowerCase().contains(text.toLowerCase()))
//                        && r.getPopularityScore() >= rating)
//                .collect(Collectors.toList());
//    }
//
//    public List<Event> searchByCategory(Category category) {
//        return DataHolder.eventList.stream()
//                .filter(r -> r.getCategory().getName().toLowerCase().contains(category.getName().toLowerCase()))
//                .collect(Collectors.toList());
//    }
//
//    public Optional<Event> findById(Long id) {
//        return DataHolder.eventList.stream().filter(r -> r.getId().equals(id)).findFirst();
//    }
//
//    public void deleteById(Long id) {
//        DataHolder.eventList.removeIf(r -> r.getId().equals(id));
//    }
//
//    public Optional<Event> saveOrUpdate(String name, String description, double popularityScore, Category category
//            , Location location, int ticketCount) {
//        Event event = new Event(name, description, popularityScore, category, location, ticketCount);
//        DataHolder.eventList.removeIf(r -> r.getName().equals(event.getName()));
//        DataHolder.eventList.add(event);
//        return Optional.of(event);
//    }
//
//    public Optional<Event> findByName(String name) {
//        return DataHolder.eventList.stream().filter(r -> r.getName().equals(name)).findFirst();
//    }
//
//}
