package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.Location;
import com.WeGather.WeGather.models.RaisedWorkProject;
import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.repositories.RaisedWorkProjectRepository;
import com.WeGather.WeGather.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class RaisedWorkProjectController {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    RaisedWorkProjectRepository raisedWorkProjectRepository;

    @GetMapping("/raisedWork")
    public String getRaisedWork(){
        return "raisedWorkProject.html";
    }

    @PostMapping("/raisedWork")
    public RedirectView addRaisedWork(@RequestParam(value = "startFrom") String startFrom,
                                      @RequestParam(value = "endAt") String endAt,
                                      @RequestParam(value = "image") String image,
                                      @RequestParam(value = "topic") String topic,
                                      @RequestParam(value = "description") String description ,
                                      @RequestParam(value = "raisedWork_id") String raisedWork_id,
                                      @RequestParam(value = "longitude") Long longitude,
                                      @RequestParam(value = "latitude") Long latitude,
                                      @RequestParam(value = "locationDescription") String locationDescription,
                                      @RequestParam(value = "governorate_id") Long governorate_id,
                                      @RequestParam(value = "district_id") Long district_id,
                                      @RequestParam(value = "suburb_id") Long suburb_id, Principal p){



//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter createdAt = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
//        //Date createAt = now.format(format);


        List<String> images =new ArrayList<>();
        images.add(image);

        Location location =new Location(longitude,latitude,locationDescription,governorate_id, district_id,suburb_id);

        String loggedInUserName= p.getName();

        Users loggedInUser = usersRepository.findByUsername(loggedInUserName);

        RaisedWorkProject raisedWorkProject =new RaisedWorkProject(startFrom,endAt,images,topic,description,location,loggedInUser);

        raisedWorkProjectRepository.save(raisedWorkProject);

        return new RedirectView("/raisedWorkView");

    }

}
