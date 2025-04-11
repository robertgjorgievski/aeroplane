package com.airport.mk.aeroplane.controller;

import com.airport.mk.aeroplane.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    // InitBinder method to prevent 'age' from being bound
    @InitBinder("user")
    void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("age");  // Prevent 'name' from being bound
    }

    // Method to show the form
    @GetMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm";  // Thymeleaf or JSP form view
    }

    // Method to handle form submission
    @PostMapping("/submitUser")
    public String submitUser(@ModelAttribute User user, Model model) {
        // The 'name' field will be null because it was disallowed from binding
        model.addAttribute("user", user);
        return "userDetails";  // The view where user details will be shown
    }
}

