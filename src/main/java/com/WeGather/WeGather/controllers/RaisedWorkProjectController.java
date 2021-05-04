package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.CharityWorkContributors;
import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.repositories.CharityWorkContributorsRepository;
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

@Controller
public class RaisedWorkProjectController {
    @Autowired
    RaisedWorkProjectRepository raisedWorkProjectRepository;
    @Autowired
    CharityWorkContributorsRepository charityWorkContributorsRepository;

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/raisedWork")
    public String getRaisedWork(){
        return "raisedWorkProject.html";
    }

//    @PostMapping("/raisedWork")
//    public RedirectView addRaisedWork(@RequestParam(value = "strartFrom") String staartFrom)



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
