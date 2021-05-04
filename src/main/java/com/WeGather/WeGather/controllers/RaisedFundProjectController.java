package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.ApplicationUsers;
import com.WeGather.WeGather.models.RaisedFundProject;
import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.repositories.RasisdFundProjectRepositorise;
import com.WeGather.WeGather.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class RaisedFundProjectController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RasisdFundProjectRepositorise rasisdFundProjectRepositorise;

    @GetMapping("/displayForm")
    public String displayRaisedFund() {

        return "RaisedFundProject.html";
    }

//        @GetMapping("/header")
//    public String navbar() {
//
//        return "footer.html";
//    }

//    @GetMapping("/displayForm")
//    public String displayRaisedFund(Principal p, Model m){
//        Users users=(Users) ((UsernamePasswordAuthenticationToken)p).getPrincipal();
//        m.addAttribute("user",usersRepository.findById(users.getId()).get() );
//        return "RaisedFundProject.html";
//    }


    @PostMapping("/AddRaise")
    public String saveData(
                           @RequestParam(value = "RequiredAmount") String RequiredAmount,
                           @RequestParam(value = "topic") String topic,
                           @RequestParam(value = "Description") String description,
                           @RequestParam(value = "createDate") String createDate,
                           @RequestParam(value = "image") List image,
                           @RequestParam(value = "StartFrom") String StartFrom,
                           @RequestParam(value = "EndAt") String endAt,Principal p) {
//        Users user = (Users) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
        Date date=new Date(12/8/2020);
        List<String>list= Arrays.asList("1","s");
        Users userTow = new Users("S","1","s","a", "s", list,date, "a", "email@w");
        RaisedFundProject raisedFundProject= new RaisedFundProject( RequiredAmount,  topic,  description, createDate,  StartFrom, endAt, image,userTow) ;
        rasisdFundProjectRepositorise.save(raisedFundProject);


            return "ss";
    }
}
