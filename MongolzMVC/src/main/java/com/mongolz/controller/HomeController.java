package com.mongolz.controller;

import com.mongolz.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class HomeController {

    @Autowired
    UserCredentialsService credentialsService;

    @RequestMapping({"/", "/welcome"})
    public String welcome(Model model) {

        if(credentialsService.LoggedIn()){
            return "welcome";
        }
        else
        {
            return "redirect:/login";
        }



    }

}
