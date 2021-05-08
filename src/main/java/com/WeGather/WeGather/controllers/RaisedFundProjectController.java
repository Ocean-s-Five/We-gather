package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.ApplicationUsers;
import com.WeGather.WeGather.models.CharityFundContributors;
import com.WeGather.WeGather.models.RaisedFundProject;
import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.repositories.CharityFundContributorsRepository;
import com.WeGather.WeGather.repositories.RasisdFundProjectRepositorise;
import com.WeGather.WeGather.repositories.UsersRepository;
import com.WeGather.WeGather.services.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.*;

@Controller
public class RaisedFundProjectController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RasisdFundProjectRepositorise rasisdFundProjectRepositorise;

    @Autowired
    CharityFundContributorsRepository charityRepository ;

    @Autowired
    UploadFileService uploadFileService;


    @GetMapping("/AddRaise")
    public String displayRaisedFund(Principal p, Model m){

        return "AddRaisedFundProject.html";
    }


    @PostMapping("/AddRaise")
    public RedirectView saveData(
                           @RequestParam(value = "RequiredAmount") Integer RequiredAmount,
                           @RequestParam(value = "topic") String topic,
                           @RequestParam(value = "Description") String description,
                           @RequestParam(value = "image") MultipartFile image,
                           @RequestParam(value = "StartFrom") String StartFrom,
                           @RequestParam(value = "EndAt") String endAt,Principal p) {

        List<String> images=new ArrayList();
        String fileName=uploadFileService.uploadFile(image);

        if (fileName!=null) {
            images.add(fileName);
        }else{
            images.add("default.jpg");
        }
        String userName= ((UsernamePasswordAuthenticationToken)p).getName();
        Users user =usersRepository.findByUsername(userName);
        RaisedFundProject raisedFundProject= new RaisedFundProject( RequiredAmount,  topic,  description,   StartFrom, endAt, images,user) ;
        rasisdFundProjectRepositorise.save(raisedFundProject);

        return new RedirectView("/viewRaisedFund");
    }

    @GetMapping("/viewRaisedFund")
    public String  displayPost(Principal p,Model m){
        Iterable<RaisedFundProject> df =rasisdFundProjectRepositorise.findAll() ;
        m.addAttribute("user",df);
        Integer amount = 0;
        ArrayList<Integer> array=new ArrayList<>();
        array.add(0);
        for (RaisedFundProject don : df)
        {
            Long id=don.getId();
            List<CharityFundContributors> donate = charityRepository.findByFundRaiserId(id);
            for (CharityFundContributors donTow : donate)
            {
                amount+=donTow.getAmountPaid();
            }
            array.add(amount);
            amount=0;

        }
        m.addAttribute("amountArray",array);


        return "ViewRaisedFund.html";
    }

    @GetMapping("/search")
    public String findByDescription(@RequestParam String search,Model m) {
        List<RaisedFundProject> listSearch=rasisdFundProjectRepositorise.search(search);
        m.addAttribute("listSearch",listSearch);
        return "search.html";
    }







}
