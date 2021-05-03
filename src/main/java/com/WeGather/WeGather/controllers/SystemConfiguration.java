package com.WeGather.WeGather.controllers;
import com.WeGather.WeGather.repositories.SystemConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemConfiguration {

    @Autowired
    SystemConfigurationRepository systemConfigurationRepository;


    @GetMapping("/system_configuration")
    public String systemConfiguration() {

        return "SystemConfiguration.html";
    }
}
