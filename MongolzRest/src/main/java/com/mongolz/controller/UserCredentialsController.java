package com.mongolz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mongolz.domain.User;
import com.mongolz.domain.UserCredentials;
import com.mongolz.service.UserCredentialsService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping({"/userCredentials"})
public class UserCredentialsController {

    @Autowired
    UserCredentialsService credentialsService;

    @RequestMapping({"","all"})
    public List<UserCredentials> listCredentials(Model model) {
        return credentialsService.findAll();
    }


    @RequestMapping(value="/add",method = RequestMethod.POST)
    public void addOne(@RequestBody UserCredentials userCredentials) {

        //encryption will be here
        System.out.println(userCredentials.toString());
        credentialsService.save(userCredentials);
        return;
    }

    @RequestMapping("/{id}")
    public UserCredentials findOne(@PathVariable("id") String userName) {

        UserCredentials validCredentials = credentialsService.findByUserName(userName);

        return validCredentials;
    }

//    @RequestMapping(value = "/403", method = RequestMethod.GET)
//    public ModelAndView accesssDenied() {
//
//        ModelAndView model = new ModelAndView();
//
//        //check if user is login
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (!(auth instanceof AnonymousAuthenticationToken)) {
//            UserDetails userDetail = (UserDetails) auth.getPrincipal();
//            System.out.println(userDetail);
//
//            model.addObject("username", userDetail.getUsername());
//
//        }
//
//        model.setViewName("403");
//        return model;
//
//    }

}


