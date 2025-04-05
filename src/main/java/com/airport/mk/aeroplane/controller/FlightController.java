package com.airport.mk.aeroplane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FlightController {

    @GetMapping("/flights")
    public ModelAndView getByFlight(@RequestParam("flightId") Integer flightId, ModelAndView model) {
        model.addObject("flightId", "The flightId is " + flightId);
        model.setViewName("flightDetailsPage");

        return model;
    }
}
