package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> eventList = new ArrayList<>();
    public static List<Category> categories = new ArrayList<>();
    public static List<Location> locations = new ArrayList<>();

    @PostConstruct
    public void init() {

        categories.add(new Category("Music"));
        categories.add(new Category("Art"));
        categories.add(new Category("Film"));

        locations.add(new Location("Skopje", "Macedonia", "2312", "desc1"));
        locations.add(new Location("Bloom", "Belgium", "23123", "desc2"));
        locations.add(new Location("Miami", "USA", "2314", "desc3"));
        locations.add(new Location("Budapest", "Hungary", "2315", "desc4"));
        locations.add(new Location("Barcelona", "Spain", "2316", "desc5"));

        Location location1 = locations.getFirst();
        Location location2 = locations.get(1);
        Location location3 = locations.get(2);
        Location location4 = locations.get(3);
        Location location5 = locations.get(4);

        eventList.add(new Event("Tomorrowland", "desc1", 9.8, new Category("Music"), location2));
        eventList.add(new Event("Ultra Music Festival", "desc2", 9.7, new Category("Film"), location1));
        eventList.add(new Event("Exit Festival", "desc3", 9.6, new Category("Art"), location3));
        eventList.add(new Event("Coachella", "desc4", 9.5, new Category("Music"), location4));
        eventList.add(new Event("Electric Daisy Carnival", "desc5", 9.4, new Category("Film"), location5));
        eventList.add(new Event("Sziget Festival", "desc6", 9.3, new Category("Music"), location1));
        eventList.add(new Event("Rock in Rio", "desc7", 9.2, new Category("Art"), location2));
        eventList.add(new Event("Lollapalooza", "desc8", 9.1, new Category("Film"), location3));
        eventList.add(new Event("Glastonbury", "desc9", 9.0, new Category("Art"), location4));
        eventList.add(new Event("Burning Man", "desc10", 8.9, new Category("Music"), location5));


    }

}
