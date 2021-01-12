package com.web.activities.controllers;

import com.web.activities.controllers.models.MovieShow;
import com.web.activities.controllers.models.TicketMovieShow;
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
    //private Optional<TicketMovieShow> TicketsMovie;
    //private TicketMovieShow TicketsMovie;

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal User user, Model model)
    {
        Iterable<TicketMovieShow> TicketsMovie = ticketMovieShowRepo.findByUserId(user.getId());

        model.addAttribute("TicketsMovie", TicketsMovie);
        model.addAttribute("Username", user.getUsername());
        return "profile";
    }
}
