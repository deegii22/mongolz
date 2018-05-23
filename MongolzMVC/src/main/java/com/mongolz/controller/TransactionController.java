package com.mongolz.controller;

import com.mongolz.domain.Transaction;
import com.mongolz.domain.TransactionPeriod;
import com.mongolz.service.AccountService;
import com.mongolz.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewTranForm(@ModelAttribute("newTransaction") Transaction newTransaction, Model model) {
        model.addAttribute("accounts", accountService.findByUser(1L));
        return "transaction";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewTranForm(Model model, @ModelAttribute("newTransaction") @Valid Transaction transactionToBeAdded, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("accounts", accountService.findByUser(1L));
            return "transaction";
        }

        //  Error caught by ControllerAdvice IF no authorization...
        transactionToBeAdded = transactionService.doTransaction(transactionToBeAdded);

        if (transactionToBeAdded.getError().equals(""))
            return "redirect:/accounts";
        else {
            model.addAttribute("error", transactionToBeAdded.getError());
            model.addAttribute("accounts", accountService.findByUser(1L));
            return "transaction";
        }

    }

    @RequestMapping({"/{accountId}"})
    public String list(@PathVariable("accountId") Long accountId, Model model, @ModelAttribute("transactionPeriod") TransactionPeriod transactionPeriod) {
        LocalDate toDate = LocalDate.now();
        LocalDate fromDate = toDate.plusMonths(-1);
        model.addAttribute("transactions", transactionService.findByAccountAndDate(accountId, fromDate, toDate.plusDays(1)));
        model.addAttribute("accountId",accountId);
        return "transactionList";
    }

    @RequestMapping(value = {"/{accountId}"}, method = RequestMethod.POST)
    public String list(@PathVariable("accountId") Long accountId, Model model, @ModelAttribute("transactionPeriod") @Valid TransactionPeriod transactionPeriod, BindingResult result) {
        LocalDate fromDate = transactionPeriod.getFromDate();
        LocalDate toDate = transactionPeriod.getToDate();
        model.addAttribute("transactions", transactionService.findByAccountAndDate(accountId, fromDate, toDate));
        return "transactionList";
    }
}
