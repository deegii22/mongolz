package com.mongolz.controller;


import com.mongolz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mongolz.service.UserCredentialsService;
import com.mongolz.domain.UserCredentials;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    UserCredentialsService credentialsService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/postLogin", method = RequestMethod.POST)
    public String PostLogin(UserCredentials credentials, Model model) {

        System.out.println("Orj irsen");
        System.out.println("Orj irsen username:"+credentials.getUsername());
//        if(credentials == null){
//            System.out.println("Orj irsen");
//            credentials = new UserCredentials();
//            credentials.setPassword("eta");
//            credentials.setUsername("eta");
//        }
//        credentials = new UserCredentials();
//        credentials.setPassword("eta");
//        credentials.setUsername("eta");
        UserCredentials validCredentials = credentialsService.findByUserName(credentials.getUsername());

        if (validCredentials == null)
            return "login";

        //System.out.println(validCredentials.getUsername());

        model.addAttribute("user", validCredentials.getUsername());
        return "redirect:/welcome";
    }
}
