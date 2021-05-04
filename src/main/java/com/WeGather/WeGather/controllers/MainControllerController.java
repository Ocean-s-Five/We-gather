package com.WeGather.WeGather.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public
class MainControllerController {


    @GetMapping("/")
    public String home(){
        return "index.html";
    }

    @GetMapping("/login")
    public String login(){

        return "login.html";
    }

    @GetMapping("/signup")
    public String signup(){

        return "signup.html";
    }

    @GetMapping("/profile")
    public String profile(){

        return "profile.html";
    }
    @GetMapping("/navbar")
    public String navbar(){

        return "navbar.html";
    }

    @GetMapping("/footer")
    public String footer(){

        return "footer.html";
    }



}
