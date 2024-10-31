package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> eventList = new ArrayList<>();

    public static  List<Category> categories = new ArrayList<>();

    @PostConstruct
    public void init() {

        categories.add(new Category("Music"));
        categories.add(new Category("Art"));
        categories.add(new Category("Film"));

        eventList.add(new Event("Tomorrowland", "desc1", 9.8, new Category("Music")));
        eventList.add(new Event("Ultra Music Festival", "desc2", 9.7, new Category("Film")));
        eventList.add(new Event("Exit Festival", "desc3", 9.6, new Category("Art")));
        eventList.add(new Event("Coachella", "desc4", 9.5, new Category("Music")));
        eventList.add(new Event("Electric Daisy Carnival", "desc5", 9.4, new Category("Film")));
        eventList.add(new Event("Sziget Festival", "desc6", 9.3, new Category("Music")));
        eventList.add(new Event("Rock in Rio", "desc7", 9.2, new Category("Art")));
        eventList.add(new Event("Lollapalooza", "desc8", 9.1, new Category("Film")));
        eventList.add(new Event("Glastonbury", "desc9", 9.0, new Category("Art")));
        eventList.add(new Event("Burning Man", "desc10", 8.9, new Category("Music")));


    }

}
