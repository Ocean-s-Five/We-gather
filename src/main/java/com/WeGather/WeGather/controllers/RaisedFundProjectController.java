package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.ApplicationUsers;
import com.WeGather.WeGather.models.CharityFundContributors;
import com.WeGather.WeGather.models.RaisedFundProject;
import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.repositories.CharityFundContributorsRepository;
import com.WeGather.WeGather.repositories.RasisdFundProjectRepositorise;
import com.WeGather.WeGather.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class RaisedFundProjectController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RasisdFundProjectRepositorise rasisdFundProjectRepositorise;

    @Autowired
    CharityFundContributorsRepository charityRepository ;

//    @GetMapping("/displayForm")
//    public String displayRaisedFund() {
//
//        return "AddRaisedFundProject.html";
//    }

//        @GetMapping("/header")
//    public String navbar() {
//
//        return "footer.html";
//    }

    @GetMapping("/displayForm")
    public String displayRaisedFund(Principal p, Model m){
        return "AddRaisedFundProject.html";
    }


    @PostMapping("/AddRaise")
    public RedirectView saveData(
                           @RequestParam(value = "RequiredAmount") Integer RequiredAmount,
                           @RequestParam(value = "topic") String topic,
                           @RequestParam(value = "Description") String description,
                           @RequestParam(value = "image") List image,
                           @RequestParam(value = "StartFrom") String StartFrom,
                           @RequestParam(value = "EndAt") String endAt,Principal p) {

        String userName= ((UsernamePasswordAuthenticationToken)p).getName();
        Users user =usersRepository.findByUsername(userName);
        RaisedFundProject raisedFundProject= new RaisedFundProject( RequiredAmount,  topic,  description,   StartFrom, endAt, image,user) ;
        rasisdFundProjectRepositorise.save(raisedFundProject);

        return new RedirectView("/displayCards");
    }

    @GetMapping("/displayCards")
    public String  displayPost(Principal p,Model m){
        Iterable<RaisedFundProject> df =rasisdFundProjectRepositorise.findAll() ;
        m.addAttribute("user",df);
        Integer amount = 0;
        int counter=0;
        ArrayList<Integer> array=new ArrayList<>();
        array.add(0);
        ArrayList<Integer> arraycount=new ArrayList<>();
        for (RaisedFundProject don : df)
        {
            Long id=don.getId();
            List<CharityFundContributors> donate = charityRepository.findByUserFundRaiserId(id);
            for (CharityFundContributors donTow : donate)
            {
                amount+=donTow.getAmountPaid();
                counter++;
            }
            array.add(amount);
            arraycount.add(counter);
            amount=0;
            counter=0;

        }
        m.addAttribute("amountArray",array);
        m.addAttribute("arraycount",arraycount);


        return "ViewRaisedFund.html";
    }



}
