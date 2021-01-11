package com.web.activities.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("error", "Информации нет");
        return "about";
    }

    @GetMapping("/add_activity")
    public String add_activity(Model model) {
        model.addAttribute("title", "Добавление нового мероприятия");
        return "add_activity";
    }

    @GetMapping("/add_movieshow")
    public String add_movieshow(Model model) {
        //model.addAttribute("title", "Добавление нового мероприятия");
        return "add_movieshow";
    }

    /*@GetMapping("/activities_schedule")
    public String activities_schedule(Model model) {
        model.addAttribute("title", "Расписание мероприятий");
        return "activities_schedule";
    }*/

    /*@GetMapping("/cinema_schedule")
    public String cinema_schedule(Model model) {
        model.addAttribute("title", "Расписание сеансов");
        return "cinema_schedule";
    }*/
}
