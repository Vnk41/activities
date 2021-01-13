package com.web.activities.controllers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

    @GetMapping("/add_activity")
    public String add_activity(Model model) {
        return "add_activity";
    }

    @GetMapping("/add_movieshow")
    public String add_movieshow(Model model) {
        return "add_movieshow";
    }
}
