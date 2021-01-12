package com.web.activities.controllers;

import com.web.activities.controllers.models.MovieShow;
import com.web.activities.controllers.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class ProfileController {
    @Autowired
    private MovieShowRepo movieShowRepo;

    @Autowired
    private TicketMovieShowRepo ticketMovieShowRepo;
    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal User user, Model model)
    {
        Optional<MovieShow> movieshows = movieShowRepo.findByMovie_year(2020);
        model.addAttribute("movieshows", movieshows);
        return "profile";
    }
}
