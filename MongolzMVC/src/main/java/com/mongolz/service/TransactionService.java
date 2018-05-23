package com.mongolz.service;

import com.mongolz.domain.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {

    public Transaction doTransaction(Transaction transaction);
    public List<Transaction> findByAccountAndDate(Long accountNo, LocalDate startTxnDate, LocalDate endTxnDate);
}
