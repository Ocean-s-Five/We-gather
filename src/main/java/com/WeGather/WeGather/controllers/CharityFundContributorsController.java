package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.CharityFundContributors;
import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.repositories.CharityFundContributorsRepository;
import com.WeGather.WeGather.repositories.RasisdFundProjectRepositorise;
import com.WeGather.WeGather.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class CharityFundContributorsController {

    @Autowired
    RasisdFundProjectRepositorise rasisdFundProjectRepositorise;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    CharityFundContributorsRepository charityFundContributorsRepository;
//
//    @GetMapping("/addfund")
//    public String addfund(){
//        return "CharityFundContributors.html";
//    }

    @GetMapping("/displayContributors/{id}")
    public String displayContributors(@PathVariable(value = "id") Long id, Model m, Principal p) {

        m.addAttribute("raisedFund", rasisdFundProjectRepositorise.findById(id)
                                                                  .get());
        String user = ((UsernamePasswordAuthenticationToken) p).getName();
        Users loggedInUser = usersRepository.findByUsername(user);
        m.addAttribute("loggedInUser", loggedInUser);

        return "displayContributors.html";
    }

    @PostMapping("/AddContributors")
    public RedirectView AddContributors(@RequestParam(value = "amountPAid") Integer amountPAid,
                                        @RequestParam(value = "fundRaisedId") Long fundRaisedId,
                                        @RequestParam(value = "loggedInUser") Long loggedInUser,
                                        @RequestParam(value = "date") String date, Integer status, Principal p) {
//
//        String userName = ((UsernamePasswordAuthenticationToken) p).getName();
//        Users user = usersRepository.findByUsername(userName);
        CharityFundContributors charityFundContributors = new CharityFundContributors(fundRaisedId, loggedInUser, amountPAid, date, 1);
        charityFundContributorsRepository.save(charityFundContributors);

        return new RedirectView("/displayCards");
    }


}
