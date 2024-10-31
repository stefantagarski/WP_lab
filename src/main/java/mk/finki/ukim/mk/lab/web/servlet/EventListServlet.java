package mk.finki.ukim.mk.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.EventService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet()
public class EventListServlet extends HttpServlet {

    private final EventService service;
    private final SpringTemplateEngine engine;
    private final EventBookingService eventBookingService;

    public EventListServlet(EventService service, SpringTemplateEngine engine, EventBookingService eventBookingService) {
        this.service = service;
        this.engine = engine;
        this.eventBookingService = eventBookingService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        String search = req.getParameter("search");
        String rating = req.getParameter("rating");

        // I don't know if it is a good practice, but it works :3

        if (search != null && !search.isEmpty() && rating != null && !rating.isEmpty()) {
            context.setVariable("events", service.searchByNameAndPopularityScore(search, Double.parseDouble(rating)));
            engine.process("listEvents.html", context, resp.getWriter());
        } else if (search != null && !search.isEmpty()) {
            context.setVariable("events", service.searchEvents(search));
            engine.process("listEvents.html", context, resp.getWriter());
        } else if (rating != null && !rating.isEmpty()) {
            context.setVariable("events", service.searchByPopularityScore(Double.parseDouble(rating)));
            engine.process("listEvents.html", context, resp.getWriter());
        }else {
            context.setVariable("events", service.listAll());
            engine.process("listEvents.html", context, resp.getWriter());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eventName = req.getParameter("eventName");
        String numTickets = req.getParameter("numTickets");
        String attendeeName = req.getParameter("attendeeName");
        String attendeeAddress = req.getParameter("attendeeAddress");


        EventBooking eventBooking = eventBookingService.placeBooking(eventName, attendeeName, attendeeAddress, Integer.parseInt(numTickets));

        req.getSession().setAttribute("eventBooking", eventBooking);
        resp.sendRedirect("/eventBooking");
    }
}
