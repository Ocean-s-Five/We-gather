package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.CharityWorkContributors;
import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.repositories.CharityWorkContributorsRepository;
import com.WeGather.WeGather.models.Location;
import com.WeGather.WeGather.models.RaisedWorkProject;
import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.repositories.LocationRepository;
import com.WeGather.WeGather.repositories.RaisedWorkProjectRepository;
import com.WeGather.WeGather.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    CharityWorkContributorsRepository charityWorkContributorsRepository;

    @Autowired
    LocationRepository locationRepository;

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

                                      @RequestParam(value = "longitude") String longitude,
                                      @RequestParam(value = "latitude") String latitude,
                                      @RequestParam(value = "locationDescription") String locationDescription
//                                      @RequestParam(value = "governorate_id") Long governorate_id,
//                                      @RequestParam(value = "district_id") Long district_id,
//                                      @RequestParam(value = "suburb_id") Long suburb_id
            , Principal p){



//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter createdAt = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
//        //Date createAt = now.format(format);


        List<String> images =new ArrayList<>();
        images.add(image);
        System.out.println(images);
        Location location =new Location(longitude,latitude,locationDescription);
        System.out.println("location: "+location);
        String loggedInUserName= p.getName();
        locationRepository.save(location);

        Users loggedInUser = usersRepository.findByUsername(loggedInUserName);

        System.out.println("logged in user " + loggedInUser);
        RaisedWorkProject raisedWorkProject =new RaisedWorkProject(startFrom,endAt,images,topic,description,location,loggedInUser);
        System.out.println("raisedWorkProject "+ raisedWorkProject);
        raisedWorkProjectRepository.save(raisedWorkProject);

        return new RedirectView("/raisedWorkView");

    }



    @GetMapping("/allRaisedWork")
    public String getAllRaisedWork(Principal p, Model m){
            String userName= ((UsernamePasswordAuthenticationToken)p).getName();
            Users user =usersRepository.findByUsername(userName);
            m.addAttribute("user",usersRepository.findById(user.getId()).get() );
        return "allRaisedWork.html";
    }



    @PostMapping("/addContribute")
    public RedirectView addContribute(@RequestParam (value="workedRaised_id")Long   workedRaised_id ,
                                      @RequestParam (value="userWorkRaiser_id") Long userWorkRaiser_id ,
                                      @RequestParam (value="status") Integer status){

        CharityWorkContributors charityWorkContributors = new CharityWorkContributors(workedRaised_id,userWorkRaiser_id,status);
        charityWorkContributorsRepository.save(charityWorkContributors);

        return new RedirectView("/allRaisedWork");
    }
}
