package com.mongolz.controller;

import com.mongolz.domain.Transaction;
import  com.mongolz.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/tran", method = RequestMethod.GET)
    public String getAddNewUserForm(@ModelAttribute("newTransaction") Transaction newTransaction) {
        return "transaction";
    }

    @RequestMapping(value = "/tran", method = RequestMethod.POST)
    public String processAddNewUserForm(@ModelAttribute("newTransaction") @Valid Transaction transactionToBeAdded, BindingResult result) {

        if(result.hasErrors()) {
            return "transaction";
        }

        //  Error caught by ControllerAdvice IF no authorization...
        transactionService.doTransaction(transactionToBeAdded);

        return "redirect:/accounts";

    }
}
