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

    @RequestMapping("/{id}")
    public User getByUserId(@PathVariable("id") Long id) {
        return userService.findOne(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User addNewUserForm(@RequestBody User userToBeAdded) {
        userService.saveFull(userToBeAdded);
        return null;
    }
}
