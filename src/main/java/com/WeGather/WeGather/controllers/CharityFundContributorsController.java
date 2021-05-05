package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.CharityFundContributors;
import com.WeGather.WeGather.models.RaisedFundProject;
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
    RasisdFundProjectRepositorise rasisdRepositorise;

    @Autowired
    UsersRepository usersRepository ;

    @Autowired
    CharityFundContributorsRepository charityFundContributorsRepository ;

    @GetMapping("/addfund")
    public String addfund(){
        return "CharityFundContributors.html";
    }

    @GetMapping("/displayContributors/{id}")
    public String displayContributors(@PathVariable(value="id")Long id , Model m, Principal p){
        String userName= ((UsernamePasswordAuthenticationToken)p).getName();
        m.addAttribute("user",rasisdRepositorise.findById(id).get() );

        String meUser= ((UsernamePasswordAuthenticationToken)p).getName();
        Users logedUser =usersRepository.findByUsername(meUser);
        m.addAttribute("logedUser",logedUser );

        return "displayContributors.html";
    }
    @PostMapping("/AddContributors")
    public RedirectView AddContributors(@RequestParam(value="amountPAid") String amountPAid,
                                        @RequestParam(value="fundRaisedId") Long fundRaisedId,
                                        @RequestParam(value="logedUserId") Long logedUserId,
                                        @RequestParam(value="date") String date, Integer status, Principal p){

        String userName= ((UsernamePasswordAuthenticationToken)p).getName();
        Users user =usersRepository.findByUsername(userName);
        CharityFundContributors charityFundContributors=new CharityFundContributors( fundRaisedId, logedUserId,amountPAid, date,1);
        charityFundContributorsRepository.save(charityFundContributors);

return new RedirectView("/displayCards") ;  }


}
