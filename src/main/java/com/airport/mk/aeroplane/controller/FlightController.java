package com.airport.mk.aeroplane.controller;

import com.airport.mk.aeroplane.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes("flightId")
public class FlightController {

    //we try to not show the value of id, just to try how @InitBinder can work
    @InitBinder("user")
    void validateUser(WebDataBinder binder) {
        binder.setDisallowedFields("id");
    }

    @GetMapping("/flights")
    public ModelAndView getByFlight(@RequestParam("flightId") Integer flightId, ModelAndView model, RedirectAttributes redirectAttributes) {
        model.addObject("flightId", flightId);
        model.setViewName("flightDetailsPage");

        //random list of numbers to be printed in Thymeleaf
        List<Integer> flightIds = Arrays.asList(5, 3, 2, 1);
        model.addObject("flightIds", flightIds);

        User user = new User();
        model.addObject("user", user);

        return model;
    }

    @PostMapping("/flights")
    public String submitUser(@ModelAttribute User user, ModelAndView model, RedirectAttributes redirectAttributes) {
        model.setViewName("flightDetailsPage");
        redirectAttributes.addFlashAttribute("user", user);

        return "redirect:/successPage";
    }

    @GetMapping("/successPage")
    public String userUpdateSuccessPage(ModelAndView model) {

        return "userUpdateSuccessPage";
    }
}
