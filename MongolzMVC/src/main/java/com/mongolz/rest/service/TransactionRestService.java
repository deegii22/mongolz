package com.mongolz.rest.service;

import com.mongolz.domain.Transaction;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface TransactionRestService {

    public void doTransaction(Transaction transaction);
    public List<Transaction> findByAccountAndDate(Long accountNo, LocalDate startTxnDate, LocalDate endTxnDate);
}
