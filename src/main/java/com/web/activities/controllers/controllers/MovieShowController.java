package com.web.activities.controllers.controllers;

import com.web.activities.controllers.models.*;
import com.web.activities.controllers.repos.MovieShowRepo;
import com.web.activities.controllers.repos.TicketMovieShowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class MovieShowController {
    @Autowired
    private MovieShowRepo movieShowRepo;

    @Autowired
    private TicketMovieShowRepo ticketMovieShowRepo;

    @GetMapping("/cinema_schedule")
    public String cinemaSchedule(Model model)
    {
        Iterable<MovieShow> movieshows = movieShowRepo.findAll();
        model.addAttribute("movieshows", movieshows);
        return "/cinema_schedule";
    }

    @PostMapping("/add_movieshow")
    public String addMovieShow(@RequestParam String movie_russian_title, @RequestParam String movie_english_title,
                              @RequestParam String movie_director, @RequestParam String movie_actors,
                              @RequestParam Integer movie_year, @RequestParam String datetime,
                              @RequestParam Integer running_time, @RequestParam String description, Model model){
        //System.out.println(title + place + address + description + date + time + all_tickets + free_tickets);
        MovieShow movieShow = new MovieShow(movie_russian_title, movie_english_title, movie_director, movie_actors, movie_year, datetime, running_time, description);
        movieShowRepo.save(movieShow);
        //System.out.println(title + place + address + description + date + time + all_tickets + free_tickets);
        return "/add_movieshow";
    }

    @GetMapping("/cinema_schedule/{id}")
    public String cinemaScheduleId(@PathVariable(value = "id") long id, Model model, User user)
    {
        Optional<MovieShow> movieShow = movieShowRepo.findById(id);
        ArrayList<MovieShow> res = new ArrayList<>();
        movieShow.ifPresent(res::add);
        model.addAttribute("movieShow", res);

        return "buy_movieshow_tickets";
    }

    @PostMapping("/cinema_schedule/{id}")
    public String cinemaScheduleIdBuyTickets(@AuthenticationPrincipal User user,
                                                 @PathVariable(value = "id") Long id,
                                             @RequestParam Integer row,
                                             @RequestParam Integer col, Model model){
        MovieShow movieShow = movieShowRepo.findById(id).orElse(null);
        TicketMovieShow ticketMovieShow = new TicketMovieShow(movieShow, user, row, col);
        ticketMovieShowRepo.save(ticketMovieShow);

        return "buy_movieshow_tickets";
    }
}
