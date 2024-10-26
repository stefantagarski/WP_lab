package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> eventList = new ArrayList<>();

    @PostConstruct
    public void init() {
        eventList.add(new Event("Tomorrowland", "desc1", 9.8));
        eventList.add(new Event("Ultra Music Festival", "desc2", 9.7));
        eventList.add(new Event("Exit Festival", "desc3", 9.6));
        eventList.add(new Event("Coachella", "desc4", 9.5));
        eventList.add(new Event("Electric Daisy Carnival", "desc5", 9.4));
        eventList.add(new Event("Sziget Festival", "desc6", 9.3));
        eventList.add(new Event("Rock in Rio", "desc7", 9.2));
        eventList.add(new Event("Lollapalooza", "desc8", 9.1));
        eventList.add(new Event("Glastonbury", "desc9", 9.0));
        eventList.add(new Event("Burning Man", "desc10", 8.9));

    }

}
