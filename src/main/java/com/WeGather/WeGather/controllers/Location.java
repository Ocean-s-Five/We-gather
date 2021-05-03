package com.WeGather.WeGather.controllers;
import com.WeGather.WeGather.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Location {

    @Autowired
    LocationRepository locationRepository;
}
