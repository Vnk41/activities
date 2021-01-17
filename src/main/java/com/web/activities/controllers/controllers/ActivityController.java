package com.web.activities.controllers.controllers;

import com.web.activities.controllers.models.Activity;
import com.web.activities.controllers.models.TicketActivity;
import com.web.activities.controllers.models.TicketMovieShow;
import com.web.activities.controllers.models.User;
import com.web.activities.controllers.repos.ActivityRepo;
import com.web.activities.controllers.repos.ActivityTicketsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Controller
public class ActivityController {

    @Autowired
    private ActivityRepo activityRepo;

    @Autowired
    private ActivityTicketsRepo activityTicketsRepo;

    @GetMapping("/activities_schedule")
    public String activitiesSchedule(@AuthenticationPrincipal User user, Model model) {
        Iterable<Activity> activities = activityRepo.findAll();
        model.addAttribute("activities", activities);
        System.out.println(user.getUsername());
        System.out.println(user.getId());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
       // user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "/activities_schedule";
    }

    @PostMapping("/add_activity")
    public String addActivity(@RequestParam String title, @RequestParam String place,
                              @RequestParam String address, @RequestParam String description,
                              @RequestParam String datetime,  Model model){
        //System.out.println(title + place + address + description + date + time + all_tickets + free_tickets);
        Activity activity = new Activity(title, place, address, description, datetime);
        activityRepo.save(activity);
        //System.out.println(title + place + address + description + date + time + all_tickets + free_tickets);
        return "/add_activity";
    }

    @GetMapping("/activities_schedule/{id}")
    public String activitiesScheduleId(@PathVariable(value = "id") long id, Model model, User user)
    {
        Optional<Activity> activity = activityRepo.findById(id);
        ArrayList<Activity> res = new ArrayList<>();
        activity.ifPresent(res::add);
        model.addAttribute("activity", res);

        System.out.println(id);
        System.out.println(user.getUsername());
        System.out.println(user.getId());

        return "buy_tickets";
    }

    @PostMapping("/activities_schedule/{id}")
    public String activitiesScheduleIdBuyTickets(@AuthenticationPrincipal User user,
                                                 @PathVariable(value = "id") Long id, Model model){
        Activity activity = activityRepo.findById(id).orElse(null);
        System.out.println(activity.getDescription());
        TicketActivity ticketActivity = new TicketActivity(activity, user);
        activityTicketsRepo.save(ticketActivity);


        return "buy_tickets";
    }

}
