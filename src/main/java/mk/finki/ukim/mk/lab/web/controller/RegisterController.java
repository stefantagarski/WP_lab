package mk.finki.ukim.mk.lab.web.controller;


import mk.finki.ukim.mk.lab.model.exceptions.InvalidRegisterException;
import mk.finki.ukim.mk.lab.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthService service;

    public RegisterController(AuthService service) {
        this.service = service;
    }

    @GetMapping
    public String registerPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username, @RequestParam String password,
                           @RequestParam String repeatPassword) {
        try {
            service.register(username, password, repeatPassword);
            return "redirect:/login";
        } catch (InvalidRegisterException e) {
            return "redirect:/register?error=" + e.getMessage();
        }
    }
}