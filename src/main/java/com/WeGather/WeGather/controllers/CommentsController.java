package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.ApplicationUsers;
import com.WeGather.WeGather.models.Comments;
import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class CommentsController {

    @Autowired
    CommentsRepository commentsRepository;

    @PostMapping("/addComment")
    public RedirectView addComment (@RequestParam(value = "body") String body,@RequestParam (value="workId") Long workId , Principal p ) {
        ApplicationUsers userDetails = (ApplicationUsers) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
//        System.out.println(id);
        Date date = new Date();
        Comments comments = new Comments(userDetails.getId(), date, body,workId, 1);
        commentsRepository.save(comments);
String redirectView = "/fundContributors/"+workId;
        return new RedirectView(redirectView);
    }

}
