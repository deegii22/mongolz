package com.mongolz.controller;

import com.mongolz.domain.Account;
import com.mongolz.domain.Transaction;
import com.mongolz.service.AccountService;
import com.mongolz.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/{accountNo}&{startDate}&{endDate}")
    public List<Transaction> findByAccountAndDate(@PathVariable("accountNo") Long accountNo, @PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate) {

        return transactionService.findByAccountAndDate(accountNo, startDate, endDate);
    }

    @RequestMapping(value = "/txn", method = RequestMethod.POST)
    public Transaction processAddNewItemForm(@Valid @RequestBody Transaction itemToBeAdded) {

        try {
            Account toAccount = accountService.findOne(itemToBeAdded.getToAccount().getId());
//            if(toAccount == null)
//                return "to not found";
            Account fromAccount = accountService.findOne(itemToBeAdded.getFromAccount().getId());
//            if(fromAccount.getBalance() < itemToBeAdded.getAmount())
//                return "balance";
            toAccount.setBalance(toAccount.getBalance() + itemToBeAdded.getAmount());
            fromAccount.setBalance(fromAccount.getBalance() - itemToBeAdded.getAmount());
            itemToBeAdded.setFromAccount(fromAccount);
            itemToBeAdded.setToAccount(toAccount);
            transactionService.save(itemToBeAdded);
        } catch (Exception up) {
            System.out.println("Transaction Failed!!!");

        }

        return null;
    }


}
