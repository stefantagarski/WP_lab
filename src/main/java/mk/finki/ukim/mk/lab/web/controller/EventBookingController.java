package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventBookingController {

    @GetMapping("/eventBooking")
    public String getBookingConfirmation(HttpServletRequest req, Model model) {
        model.addAttribute("ipAddress", req.getRemoteAddr());
        return "bookingConfirmation";
    }
}
