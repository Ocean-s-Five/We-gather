package com.WeGather.WeGather.controllers;


import com.WeGather.WeGather.models.ApplicationUsers;
import com.WeGather.WeGather.models.User;
//import com.WeGather.WeGather.repositories.ApplicationUsersRepository;
import com.WeGather.WeGather.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public
class MainControllerController {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    private
    PasswordEncoder passwordEncoder;

//    @Autowired
//    ApplicationUsersRepository applicationUsersRepository;

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/login")
    public String login() {

        return "login.html";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

            return "login.html";

    }


    @GetMapping("/signup")
    public String signup() {

        return "signup.html";
    }

    @PostMapping("/signup")
    public RedirectView addNewUser(@RequestParam(value = "username") String username,
                                   @RequestParam(value = "email") String email,
                                   @RequestParam(value = "firstName") String firstName,
                                   @RequestParam(value = "lastName") String lastName,
                                   @RequestParam(value = "password") String password,
                                   @RequestParam(value = "middleName") String middleName,
                                   @RequestParam(value = "profilePictures") String profilePictures,
                                   @RequestParam(value = "nationalNumber") String nationalNumber,
                                   @RequestParam(value = "nationalCardNumber") String nationalCardNumber,
                                   @RequestParam(value = "passportNumber") String passportNumber,
                                   @RequestParam(value = "nameWrittenInPassport") String nameWrittenInPassport) {
        List<String> profilepictures = new ArrayList();
        profilepictures.add(profilePictures);

        Date date = new Date();
        User user = new User(username,
                passwordEncoder.encode(password),
                firstName,
                middleName,
                lastName,
                nationalNumber,
                nationalCardNumber,
                passportNumber,
                nameWrittenInPassport,
                profilepictures,
                date,
                null, email);
        ApplicationUsers applicationUsers = new ApplicationUsers(user);
        usersRepository.save(user);
        return new RedirectView("/");
    }

    @GetMapping("/profile")
    public String profile() {

        return "profile.html";
    }

    @GetMapping("/navbar")
    public String navbar() {

        return "navbar.html";
    }

    @GetMapping("/footer")
    public String footer() {

        return "footer.html";
    }


}
