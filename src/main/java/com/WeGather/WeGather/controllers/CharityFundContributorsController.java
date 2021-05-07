
package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.CharityFundContributors;
import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.repositories.CharityFundContributorsRepository;
import com.WeGather.WeGather.repositories.RasisdFundProjectRepositorise;
import com.WeGather.WeGather.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class CharityFundContributorsController {

    @Autowired
    RasisdFundProjectRepositorise rasisdFundProjectRepositorise;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    CharityFundContributorsRepository charityFundContributorsRepository;

    @GetMapping("/RaisedFundDetail/{id}")
    public String displayContributors(@PathVariable(value = "id") Long id, Model m, Principal p) {

        Object principal = SecurityContextHolder.getContext(). getAuthentication(). getPrincipal();

        m.addAttribute("raisedFund", rasisdFundProjectRepositorise.findById(id).get());



        if(principal instanceof UserDetails) {
            String user =  p.getName();
            Users loggedInUser = usersRepository.findByUsername(user);
            m.addAttribute("loggedInUser", loggedInUser);
        }
        return "ViewRaisedFundDetail.html";
    }


    @PostMapping("/donate")
    public RedirectView AddContributors(@RequestParam(value = "amountPAid") Integer amountPAid,

                                        @RequestParam(value = "fundRaisedId") Long fundRaisedId,
                                        @RequestParam(value = "loggedInUser") Long loggedInUser,
                                  Integer status, Principal p) {

        CharityFundContributors charityFundContributors = new CharityFundContributors(fundRaisedId, loggedInUser, amountPAid, 1);
        charityFundContributorsRepository.save(charityFundContributors);

        return new RedirectView("/RaisedFundDetail"+fundRaisedId);
    }


}

