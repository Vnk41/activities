package com.web.activities.controllers.controllers;

import com.web.activities.controllers.models.TicketActivity;
import com.web.activities.controllers.models.TicketMovieShow;
import com.web.activities.controllers.models.User;
import com.web.activities.controllers.repos.ActivityTicketsRepo;
import com.web.activities.controllers.repos.MovieShowRepo;
import com.web.activities.controllers.repos.TicketMovieShowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    @Autowired
    private MovieShowRepo movieShowRepo;

    @Autowired
    private TicketMovieShowRepo ticketMovieShowRepo;

    @Autowired
    private ActivityTicketsRepo activityTicketsRepo;
    //private Optional<TicketMovieShow> TicketsMovie;
    //private TicketMovieShow TicketsMovie;

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal User user, Model model)
    {
        Iterable<TicketMovieShow> TicketsMovie = ticketMovieShowRepo.findByUserId(user.getId());
        Iterable<TicketActivity> TicketsActivity = activityTicketsRepo.findByUserId(user.getId());

        model.addAttribute("TicketsMovie", TicketsMovie);
        model.addAttribute("TicketsActivity", TicketsActivity);
        model.addAttribute("Username", user.getUsername());
        return "profile";
    }
}
