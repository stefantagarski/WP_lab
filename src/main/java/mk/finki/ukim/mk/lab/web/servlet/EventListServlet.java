//package mk.finki.ukim.mk.lab.web.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.model.Category;
//import mk.finki.ukim.mk.lab.model.EventBooking;
//import mk.finki.ukim.mk.lab.service.CategoryService;
//import mk.finki.ukim.mk.lab.service.EventBookingService;
//import mk.finki.ukim.mk.lab.service.EventService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/servlet/events")
//public class EventListServlet extends HttpServlet {
//
//    private final EventService service;
//    private final SpringTemplateEngine engine;
//    private final EventBookingService eventBookingService;
//    private final CategoryService categoryService;
//
//    public EventListServlet(EventService service, SpringTemplateEngine engine, EventBookingService eventBookingService, CategoryService categoryService) {
//        this.service = service;
//        this.engine = engine;
//        this.eventBookingService = eventBookingService;
//        this.categoryService = categoryService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(webExchange);
//
//        String search = req.getParameter("search");
//        String rating = req.getParameter("rating");
//        String searchCat = req.getParameter("category");
//
//        context.setVariable("categories", categoryService.listAll());
//
//        if (search != null && !search.isEmpty() && rating != null && !rating.isEmpty()) {
//            context.setVariable("events", service.searchByNameAndPopularityScore(search, Double.parseDouble(rating)));
//        } else if (search != null && !search.isEmpty()) {
//            context.setVariable("events", service.searchEventsByName(search));
//        } else if (rating != null && !rating.isEmpty()) {
//            context.setVariable("events", service.searchByPopularityScore(Double.parseDouble(rating)));
//        } else if (searchCat != null && !searchCat.isEmpty()) {
//            context.setVariable("events", service.searchByCategory(new Category(searchCat)));
//        } else {
//            context.setVariable("events", service.listAll());
//        }
//
//        engine.process("listEvents.html", context, resp.getWriter());
//    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        String eventName = req.getParameter("eventName");
////        int numTickets = Integer.parseInt(req.getParameter("numTickets"));
////        String attendeeName = req.getParameter("attendeeName");
////        String attendeeAddress = req.getParameter("attendeeAddress");
////
////        EventBooking eventBooking = eventBookingService.placeBooking(eventName, attendeeName, attendeeAddress, numTickets);
////        req.getSession().setAttribute("eventBooking", eventBooking);
////        resp.sendRedirect("/eventBooking");
//    }
//
//}
