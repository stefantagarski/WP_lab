package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpSession;
import mk.finki.ukim.mk.lab.model.*;
import mk.finki.ukim.mk.lab.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final CategoryService categoryService;
    private final LocationService locationService;
    private final EventBookingService eventBookingService;
    private final UserService userService;

    public EventController(EventService eventService, CategoryService categoryService
            , LocationService locationService
            , EventBookingService eventBookingService, UserService userService) {
        this.eventService = eventService;
        this.categoryService = categoryService;
        this.locationService = locationService;
        this.eventBookingService = eventBookingService;
        this.userService = userService;
    }


    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error,
                                @RequestParam(required = false) String searchND,
                                @RequestParam(required = false) String rating,
                                @RequestParam(required = false) String category,
                                @RequestParam(required = false) String location,
                                Model model) {

        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Category> categories = categoryService.listAll();
        model.addAttribute("categories", categories);

        List<Location> locations = locationService.findAll();
        model.addAttribute("locations", locations);

        List<User> userList = userService.listAll();
        model.addAttribute("userList", userList);

        List<Event> eventList;

        if (searchND != null && !searchND.isEmpty() && rating != null && !rating.isEmpty()) {
            eventList = eventService.searchByNameAndPopularityScore(searchND, Double.parseDouble(rating));
        } else if (searchND != null && !searchND.isEmpty()) {
            eventList = eventService.searchEventsByNameAndDesc(searchND);
        } else if (rating != null && !rating.isEmpty()) {
            eventList = eventService.searchByPopularityScore(Double.parseDouble(rating));
        } else if (category != null && !category.equals("All")) {
            eventList = eventService.searchByCategoryID(Long.parseLong(category));
        } else if (location != null && !location.equals("All")) {
            eventList = eventService.findAllByLocationId(Long.parseLong(location));
        } else {
            eventList = eventService.listAll();
        }


        model.addAttribute("eventList", eventList);
        return "listEvents";
    }


    @PostMapping("/booking")
    public String placeBooking(@RequestParam String eventName,
                               @RequestParam int numTickets,
                               @RequestParam Long userListID,
                               HttpSession session) {


        eventBookingService.placeBooking(eventName, userListID, numTickets);

        Event event = eventService.findByName(eventName).get();
        if (numTickets > event.getTicketCount()) {
            return "redirect:/events?error=InvalidNumberOfTickets";
        } else if (event.getTicketCount() == 0) {
            return "redirect:/events?error=NoMoreTicketsAvailable";
        } else {
            //TODO DOMA da go popravam
            //session.setAttribute("eventBooking", events);
            event.setTicketCount(event.getTicketCount() - numTickets);
            return "redirect:/eventBooking";
        }
    }


    @GetMapping("/delete-form/{id}")
    public String getDeletePageForm(@PathVariable Long id, Model model) {
        Event event = eventService.findById(id).get();
        List<Location> locations = locationService.findAll();
        List<Category> categories = categoryService.listAll();

        model.addAttribute("event", event);
        model.addAttribute("categories", categories);
        model.addAttribute("locations", locations);
        return "delete-event";

    }

    @PostMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteById(id);
        return "redirect:/events";
    }

    @GetMapping("/edit/{id}")
    public String editEvent(@PathVariable Long id, Model model) {
        if (eventService.findById(id).isPresent()) {
            Event event = eventService.findById(id).get();
            List<Location> locations = locationService.findAll();
            List<Category> categories = categoryService.listAll();

            model.addAttribute("event", event);
            model.addAttribute("categories", categories);
            model.addAttribute("locations", locations);
            return "add-event";
        }
        return "redirect:/events?error=NoLocationIDFound";
    }


    @GetMapping("/add-form")
    public String getAddEventPage(Model model) {
        List<Location> locations = locationService.findAll();
        List<Category> categories = categoryService.listAll();

        model.addAttribute("categories", categories);
        model.addAttribute("locations", locations);
        return "add-event";
    }

    @PostMapping("/add")
    public String saveEvent(@RequestParam(required = false) Long id,
                            @RequestParam String name,
                            @RequestParam String description,
                            @RequestParam double popularityScore,
                            @RequestParam Long categoryID,
                            @RequestParam Long locationID,
                            @RequestParam int ticketCount) {

        if (id != null) {
            eventService.update(id, name, description, popularityScore, categoryID, locationID, ticketCount);
        } else {
            eventService.save(name, description, popularityScore, categoryID, locationID, ticketCount);
        }
        return "redirect:/events";
    }

}
