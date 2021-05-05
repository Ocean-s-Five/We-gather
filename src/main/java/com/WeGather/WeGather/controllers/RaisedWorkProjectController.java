package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.CharityWorkContributors;
import com.WeGather.WeGather.models.Location;
import com.WeGather.WeGather.models.RaisedWorkProject;
import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.repositories.CharityWorkContributorsRepository;
import com.WeGather.WeGather.repositories.LocationRepository;
import com.WeGather.WeGather.repositories.RaisedWorkProjectRepository;
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
import java.util.ArrayList;
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

    @GetMapping(value = "/raisedWork")
    public String getRaisedWork() {
        return "AddRaisedWorkProject.html";
    }
//
    @PostMapping(value = "/raisedWork")
    public RedirectView addRaisedWork(@RequestParam(value = "startFrom") String startFrom,
                                      @RequestParam(value = "endAt") String endAt,
                                      @RequestParam(value = "image") String image,
                                      @RequestParam(value = "topic") String topic,
                                      @RequestParam(value = "requiredContAmount") Integer requiredContAmount,
                                      @RequestParam(value = "description") String description,

                                      @RequestParam(value = "longitude") String longitude,
                                      @RequestParam(value = "latitude") String latitude,
                                      @RequestParam(value = "locationDescription") String locationDescription
//                                      @RequestParam(value = "governorate_id") Long governorate_id,
//                                      @RequestParam(value = "district_id") Long district_id,
//                                      @RequestParam(value = "suburb_id") Long suburb_id
            , Principal p) {


//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter createdAt = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
//        //Date createAt = now.format(format);


        List<String> images = new ArrayList<>();
        images.add(image);
        System.out.println(images);
        Location location = new Location(longitude, latitude, locationDescription);
        System.out.println("location: " + location);
        String loggedInUserName = p.getName();
        locationRepository.save(location);

        Users loggedInUser = usersRepository.findByUsername(loggedInUserName);

        System.out.println("logged in user " + loggedInUser);
        RaisedWorkProject raisedWorkProject = new RaisedWorkProject(startFrom, endAt, images, topic, requiredContAmount, description, location, loggedInUser);
        System.out.println("raisedWorkProject " + raisedWorkProject);
        raisedWorkProjectRepository.save(raisedWorkProject);

        return new RedirectView("/raisedWorkView");

    }


    @GetMapping(value = "/raisedWorkView")
    public String getAllRaisedWork(Principal p, Model m) {
//        String userName = ((UsernamePasswordAuthenticationToken) p).getName();
//        Users user = usersRepository.findByUsername(userName);
//        m.addAttribute("user", usersRepository.findById(user.getId())
//                                              .get());
        Iterable<RaisedWorkProject> df =raisedWorkProjectRepository.findAll() ;
        System.out.println("This is DF:"+df);
        m.addAttribute("user",df);
        Integer amount = 0;
        ArrayList<Integer> array=new ArrayList<>();
        //----------------------------------------
                for (RaisedWorkProject don : df)
        {
            Long id=don.getId();
            List<CharityWorkContributors> donate = charityWorkContributorsRepository.findByUserWorkRaiserId(id);
            for (CharityWorkContributors donTow : donate)
            {
                amount+=donTow.getAvailableContAmount();
            }
            array.add(amount);
            amount=0;
        }
            System.out.println("This is the array:"+array);
        m.addAttribute("amountArray",array);
        return "ViewRaisedWork.html";
//        ------------------------------------------------
//        String userName = ((UsernamePasswordAuthenticationToken) p).getName();
//        Users user = usersRepository.findByUsername(userName);
//        m.addAttribute("user", usersRepository.findById(user.getId())
//                                              .get());
//        return "ViewRaisedWork.html";
    }

    @GetMapping(value = "/fundContributors/{id}")
    public String displayRaisedWork(@PathVariable Long id, Model m,Principal p) {


        RaisedWorkProject raisedWorkProject = raisedWorkProjectRepository.findById(id)
                                                                         .get();
        m.addAttribute("raisedWorkProject", raisedWorkProject);
        String loggedInUserName = p.getName();
        Users loggedInUser = usersRepository.findByUsername(loggedInUserName);
        m.addAttribute("userId",loggedInUser.getId());
        return "raisedWorkView.html";
    }
//    @GetMapping("/displayCards")
//    public String  displayPost(Principal p,Model m){
//        Iterable<RaisedFundProject> df =rasisdFundProjectRepositorise.findAll() ;
//        m.addAttribute("user",df);
//        Integer amount = 0;
//        ArrayList<Integer> array=new ArrayList<>();
//        for (RaisedFundProject don : df)
//        {
//            Long id=don.getId();
//            List<CharityFundContributors> donate = charityRepository.findByUserFundRaiserId(id);
//            for (CharityFundContributors donTow : donate)
//            {
//                amount+=donTow.getAmountPaid();
//            }
//            array.add(amount);
//            amount=0;
//        }
//        m.addAttribute("amountArray",array);
//        return "ViewRaisedFund.html";
//    }

    @PostMapping(value = "/addContributors")
    public RedirectView addContribute(@RequestParam(value = "workedRaised_id") Long workedRaised_id,
                                      @RequestParam(value = "userWorkRaiser_id") Long userWorkRaiser_id,

                                      @RequestParam(value = "status") Integer status ) {

        CharityWorkContributors charityWorkContributors = new CharityWorkContributors(workedRaised_id, userWorkRaiser_id, 1, status);
        charityWorkContributorsRepository.save(charityWorkContributors);


        return new RedirectView("/raisedWorkView");
    }
}
