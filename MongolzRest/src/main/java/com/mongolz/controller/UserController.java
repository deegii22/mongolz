package com.mongolz.controller;

import com.mongolz.domain.User;
import com.mongolz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping({"", "all"})
    public List<User> listUsers(Model model) {
        return userService.findAll();
    }

    @RequestMapping("/{username}")
    public User findByUsername(@PathVariable("username") String username) {

        System.out.println("Orj irsen email:"+username);
        return userService.findByUsername(username);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User addNewUserForm(@RequestBody User userToBeAdded) {

        System.out.println(userToBeAdded.toString());
        try {
            userService.saveFull(userToBeAdded);
        }catch (Exception up) {
            System.out.println(up.toString());
            System.out.println("User creation failed!!!");
        }

        return null;
    }
}
