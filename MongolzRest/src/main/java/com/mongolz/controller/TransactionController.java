package com.mongolz.controller;

import com.mongolz.domain.Account;
import com.mongolz.domain.Transaction;
import com.mongolz.service.AccountService;
import com.mongolz.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/{accountNo}/startDate/{startDate}/endDate/{endDate}")
    public List<Transaction> findByAccountAndDate(@PathVariable("accountNo") Long accountNo, @PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) {
        DateFormat df = new SimpleDateFormat("MMddyyyy");
        try {
            return transactionService.findByAccountAndDate(accountNo, df.parse(startDate), df.parse(endDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/txn", method = RequestMethod.POST)
    public Transaction processAddNewItemForm(@RequestBody Transaction itemToBeAdded) {

        try {
            Account toAccount = accountService.findOne(itemToBeAdded.getToAccount().getId());
//            if(toAccount == null)
//                return "to not found";
            Account fromAccount = accountService.findOne(itemToBeAdded.getFromAccount().getId());
//            if(fromAccount.getBalance() < itemToBeAdded.getAmount())
//                return "balance";
            toAccount.setBalance(toAccount.getBalance().add(itemToBeAdded.getAmount()));
            fromAccount.setBalance(fromAccount.getBalance().subtract(itemToBeAdded.getAmount()));
            accountService.update(toAccount);
            accountService.update(fromAccount);
            transactionService.doTransaction(itemToBeAdded);
        } catch (Exception up) {
            System.out.println(up.toString());
            System.out.println("Transaction Failed!!!");

        }

        return null;
    }

}
