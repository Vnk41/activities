package com.web.activities.controllers.controllers;

import com.web.activities.controllers.models.Role;
import com.web.activities.controllers.models.User;
import com.web.activities.controllers.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    //user.setActive(true);
    //user.setRoles(Collections.singleton());

    @PostMapping("/registration")
    public String addUser(User user){

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepo.save(user);

        System.out.println(user.getUsername());
        System.out.println(user.getId());

        return "redirect:/login";
    }

//    @PostMapping("/login")
//    public String loginUser(User user){
//        User UserDB = userRepo.findByUsername(user.getUsername());
//        System.out.println(UserDB.getId());
//        return "/login";
//    }

    /*@Bean
    //public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }*/

    /*@PostMapping("/logout")
    public String logout(){
        return "logout";
    }*/

}
