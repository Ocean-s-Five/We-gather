package com.WeGather.WeGather.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public
class MainController {


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



}
