package com.mongolz.service;

import com.mongolz.domain.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionService {

    public void doTransaction(Transaction transaction);
    public List<Transaction> findByAccountAndDate(Long accountNo, Date startTxnDate, Date endTxnDate);
}
