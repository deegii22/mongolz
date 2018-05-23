package com.mongolz.controller;

import  com.mongolz.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping({"","/all"})
    public String list(Model model) {
        //model.addAttribute("accounts", transactionService.findAll());
        return "accounts";
    }
}
