package com.sancrisxa.helpdesk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index(Model model) {
        return "home/index";
    }

    @GetMapping("/denied")
    public String accessDenied() {
        return "home/403";
    }
}
