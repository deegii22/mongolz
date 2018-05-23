package com.mongolz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class HomeController {


    @RequestMapping({"/","/welcome"})
    public String welcome(Model model) {

        model.addAttribute("greeting", "Welcome to our internet bank");
        model.addAttribute("tagline", "Deegii and Enkhee");

        return "welcome";
    }

}
