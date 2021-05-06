package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.User;
import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/profile")
    public String profile(Principal p, Model m) {
        String userName = ((UsernamePasswordAuthenticationToken) p).getName();
        Users user = usersRepository.findByUsername(userName);
        m.addAttribute("user", usersRepository.findById(user.getId())
                .get());

        return "profile.html";
    }

    @PutMapping("/profile")
    public RedirectView editProfile(@RequestParam String userName,
                                        @RequestParam String firstName,
                                        @RequestParam String middleName,
                                        @RequestParam String lastName,
                                        @RequestParam String email,
                                         @RequestParam String nationalNumber,
                                         @RequestParam String nationalCardNumber,
                                         @RequestParam String passportNumber,
                                         @RequestParam String nameWrittenInPassport,


                                    Principal p){

        String loggedInUserName = p.getName();
        User user = (User) usersRepository.findByUsername(loggedInUserName);

        user.setUserName(userName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setMiddleName(middleName);
        user.setEmail(email);
        user.setNationalNumber(nationalNumber);
        user.setNationalCardNumber(nationalCardNumber);
        user.setPassportNumber(passportNumber);
        user.setNameWrittenInPassport(nameWrittenInPassport);
        usersRepository.save(user);
        return new RedirectView("/profile");

    }



}
