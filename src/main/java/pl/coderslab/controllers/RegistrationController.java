package pl.coderslab.controllers;

import pl.coderslab.entities.User;
import pl.coderslab.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/userRegister")
    public String registerUser(@ModelAttribute("user") User user) {
        registrationService.registerUser(user);
        // Po udanej rejestracji przekieruj użytkownika do strony głównej
        return "redirect:/home";
    }

}
