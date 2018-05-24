package com.mongolz.controller;

import com.mongolz.domain.Transaction;
import com.mongolz.domain.TransactionPeriod;
import com.mongolz.domain.User;
import com.mongolz.service.AccountService;
import com.mongolz.service.TransactionService;
import com.mongolz.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @Autowired
    UserCredentialsService credentialsService;

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewTranForm(@ModelAttribute("newTransaction") Transaction newTransaction, Model model) {

        User user = credentialsService.getUser();
        if (credentialsService.LoggedIn()) {
            model.addAttribute("accounts", accountService.findByUser(user.getId()));
            return "transaction";
        } else {
            return "redirect:/login";
        }

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewTranForm(Model model, @ModelAttribute("newTransaction") @Valid Transaction transactionToBeAdded, BindingResult result) {

        User user = credentialsService.getUser();
        if (result.hasErrors()) {
            model.addAttribute("accounts", accountService.findByUser(user.getId()));
            return "transaction";
        }

        //  Error caught by ControllerAdvice IF no authorization...
        transactionToBeAdded = transactionService.doTransaction(transactionToBeAdded);

        if (transactionToBeAdded.getError().equals(""))
            return "redirect:/accounts";
        else {
            model.addAttribute("error", transactionToBeAdded.getError());
            model.addAttribute("accounts", accountService.findByUser(user.getId()));
            return "transaction";
        }

    }

    @RequestMapping({"/{accountId}"})
    public String list(@PathVariable("accountId") Long accountId, Model model, @ModelAttribute("transactionPeriod") TransactionPeriod transactionPeriod) {
        LocalDate toDate = LocalDate.now();
        LocalDate fromDate = toDate.plusMonths(-1);
        model.addAttribute("transactions", transactionService.findByAccountAndDate(accountId, fromDate, toDate.plusDays(1)));
        model.addAttribute("accountId", accountId);
        model.addAttribute("fromDate", fromDate);
        model.addAttribute("toDate", toDate);
        return "transactionList";
    }

    @RequestMapping(value = {"/{accountId}"}, method = RequestMethod.POST)
    public String list(@PathVariable("accountId") Long accountId, Model model, @Valid @ModelAttribute("transactionPeriod") TransactionPeriod transactionPeriod, BindingResult result) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fromDate = LocalDate.parse(transactionPeriod.getFromDate(), dtf);
        LocalDate toDate = LocalDate.parse(transactionPeriod.getToDate(), dtf);
        model.addAttribute("transactions", transactionService.findByAccountAndDate(accountId, fromDate, toDate.plusDays(1)));
        return "transactionList";
    }
}
