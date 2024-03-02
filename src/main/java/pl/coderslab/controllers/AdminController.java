package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.loginCredentials.AdminLogin;
import pl.coderslab.services.AdminService;
import pl.coderslab.services.ProductService;
import pl.coderslab.services.UserService;

@Controller
public class AdminController {

    private final AdminService adminService;
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public AdminController(AdminService adminService, UserService userService, ProductService productService) {
        this.adminService = adminService;
        this.userService = userService;
        this.productService = productService;
    }

    @PostMapping("/adminLogin")
    public String adminLogin(@ModelAttribute("adminLogin") AdminLogin login, Model model) {
        String email = login.getEmail();
        String password = login.getPassword();
        if (adminService.validateAdminCredentials(email, password)) {
            return "redirect:/services";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "Login";
        }
    }
}
