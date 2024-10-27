package mk.finki.ukim.mk.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.EventBooking;
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

    public EventListServlet(EventService service, SpringTemplateEngine engine) {
        this.service = service;
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        String search = req.getParameter("search");
        String rating = req.getParameter("rating");

        //I don't know is this a good practice, but it works :/

        if (search != null && !search.isEmpty()) {
            context.setVariable("events", service.searchEvents(search));
            engine.process("listEvents.html", context, resp.getWriter());
            return;
        }
        if (rating != null && !rating.isEmpty()) {
            context.setVariable("events", service.searchByPopularityScore(Double.parseDouble(rating)));
            engine.process("listEvents.html", context, resp.getWriter());
            return;
        }

        context.setVariable("events", service.listAll());
        engine.process("listEvents.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eventName = req.getParameter("eventName");
        String numTickets = req.getParameter("numTickets");
        String attendeeName = req.getParameter("attendeeName");
        String attendeeAddress = req.getParameter("attendeeAddress");

        EventBooking eventBooking = new EventBooking(eventName, attendeeName, attendeeAddress, Long.parseLong(numTickets));

        req.getSession().setAttribute("eventBooking", eventBooking);
        resp.sendRedirect("/eventBooking");
    }
}
