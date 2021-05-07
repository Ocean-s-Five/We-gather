package com.WeGather.WeGather.controllers;

import com.WeGather.WeGather.models.Comments;
import com.WeGather.WeGather.models.Users;
import com.WeGather.WeGather.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class CommentsController {
    @Autowired
    CommentsRepository commentsRepository;

//    @PostMapping("/addComment")
//    public RedirectView addComment (@RequestParam(value = "body") String body, Principal p){
//        Users userDetails = (Users) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
////        Comments newComment = new Comments(body, userDetails);
//        ret
//    }


}
