package com.web.activities.controllers;

import com.web.activities.controllers.models.Activity;
import com.web.activities.controllers.models.Tickets;
import com.web.activities.controllers.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
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
                              @RequestParam Date date, @RequestParam Date time,
                              @RequestParam Integer all_tickets, @RequestParam Integer free_tickets, Model model){
        //System.out.println(title + place + address + description + date + time + all_tickets + free_tickets);
        Activity activity = new Activity(title, place, address, description, date, time, all_tickets, free_tickets);
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
        Tickets tickets = new Tickets(id, user);
        activityTicketsRepo.save(tickets);
        return "buy_tickets";
    }

}
