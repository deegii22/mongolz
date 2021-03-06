package com.mongolz.controller;

import javax.validation.Valid;

import com.mongolz.domain.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongolz.domain.User;
import com.mongolz.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService  userService;

    @RequestMapping(value = {"","/all"},method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping("/{username}")
    public String getUserById(@PathVariable("username") String username,Model model) {
        User user = userService.findByUsername(username);
        model.addAttribute("userDetail", user);

        return "user";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewUserForm(@ModelAttribute("newUser") User newUser) {
        return "addUser";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewUserForm(@ModelAttribute("newUser") @Valid User userToBeAdded, BindingResult result) {

        if(result.hasErrors()) {
            return "addUser";
        }

        System.out.println("Add post orj irsen");
        //  Error caught by ControllerAdvice IF no authorization...
        userService.saveFull(userToBeAdded);

        return "redirect:/users";

    }


}
