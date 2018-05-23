package com.mongolz.service.impl;

import com.mongolz.domain.Transaction;
import com.mongolz.rest.service.TransactionRestService;
import com.mongolz.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRestService transactionRestService;

    public void doTransaction(Transaction transaction){
        transactionRestService.doTransaction(transaction);
    }
    public List<Transaction> findByAccountAndDate(Long accountNo, LocalDate startTxnDate, LocalDate endTxnDate){
        return transactionRestService.findByAccountAndDate(accountNo, startTxnDate, endTxnDate);
    }
}
