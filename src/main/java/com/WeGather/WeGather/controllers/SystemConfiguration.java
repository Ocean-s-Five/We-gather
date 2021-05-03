package com.WeGather.WeGather.controllers;
import com.WeGather.WeGather.repositories.SystemConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SystemConfiguration {

    @Autowired
    SystemConfigurationRepository systemConfigurationRepository;
}
