package com.mongolz.controller;

import com.mongolz.domain.Account;
import com.mongolz.domain.Transaction;
import com.mongolz.service.AccountService;
import com.mongolz.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

        HttpHeaders responseHeader = new HttpHeaders();
        try {
            Account toAccount = accountService.findOne(itemToBeAdded.getToAccount().getId());
            if(toAccount == null) {
                itemToBeAdded.setError("To account not found.");
                return itemToBeAdded;
            }
            Account fromAccount = accountService.findOne(itemToBeAdded.getFromAccount().getId());
            if(fromAccount.getBalance().compareTo(itemToBeAdded.getAmount()) < 0)
            {
                itemToBeAdded.setError("Account balance is insufficient");
                return itemToBeAdded;
            }
            toAccount.setBalance(toAccount.getBalance().add(itemToBeAdded.getAmount()));
            fromAccount.setBalance(fromAccount.getBalance().subtract(itemToBeAdded.getAmount()));
            //itemToBeAdded.setFromAccount(fromAccount);
            //itemToBeAdded.setToAccount(toAccount);
            accountService.update(toAccount);
            accountService.update(fromAccount);
            transactionService.doTransaction(itemToBeAdded);
            itemToBeAdded.setError("");
        } catch (Exception up) {
            System.out.println(up.toString());
            itemToBeAdded.setError("Transaction Failed!!!");
        }
        return itemToBeAdded;
    }

}
