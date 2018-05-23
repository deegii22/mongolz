package com.mongolz.controller;

import java.util.List;

import com.mongolz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mongolz.domain.Account;
import com.mongolz.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping({"","/all"})
    public List<Account> list(Model model) {
        return  accountService.getAllAccounts();
    }

    @RequestMapping({"/{userId}"})
    public List<Account> findByUser(@PathVariable("userId") Long userId) {
        return  accountService.findByUser(userId);

    }

}
