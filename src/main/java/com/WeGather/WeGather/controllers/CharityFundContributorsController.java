package com.WeGather.WeGather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CharityFundContributorsController {
    @GetMapping("/addfund")
    public String addfund(){
        return "CharityFundContributors.html";
    }


}
