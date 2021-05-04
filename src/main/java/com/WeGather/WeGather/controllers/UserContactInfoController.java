package com.WeGather.WeGather.controllers;
import com.WeGather.WeGather.repositories.UserContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class UserContactInfoController {

    @Autowired
    UserContactInfoRepository userContactInfoRepository;

//
//    @GetMapping("/contact_info")
//
//
//    @PostMapping


}
