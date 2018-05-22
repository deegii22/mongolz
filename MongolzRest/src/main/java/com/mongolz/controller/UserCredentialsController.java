package com.mongolz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongolz.domain.User;
import com.mongolz.domain.UserCredentials;
import com.mongolz.service.UserCredentialsService;

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


    @RequestMapping("/add")
    public void addOne(@RequestBody UserCredentials userCredentials) {

        //encryption will be here
        credentialsService.save(userCredentials);
        return;
    }

    @RequestMapping("/{id}")
    public UserCredentials findOne(@PathVariable("id") String userName) {

        UserCredentials validCredentials = credentialsService.findByUserName(userName);

        return validCredentials;
    }


}


