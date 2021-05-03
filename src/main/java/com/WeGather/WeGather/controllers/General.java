package com.WeGather.WeGather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class General {


    @GetMapping("/login")
    public String loginPage(){
        return"login.html";
    }


    @GetMapping("/signup")
    public String signupPage(){
        return "signup.html";
    }
}
