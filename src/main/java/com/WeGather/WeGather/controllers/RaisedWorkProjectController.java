package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.repositories.RaisedWorkProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RaisedWorkProjectController {
    @Autowired
    RaisedWorkProjectRepository raisedWorkProjectRepository;

    @GetMapping("/raisedWork")
    public String getRaisedWork(){
        return "raisedWorkProject.html";
    }

//    @PostMapping("/raisedWork")
//    public RedirectView addRaisedWork(@RequestParam(value = "strartFrom") String staartFrom)

}
