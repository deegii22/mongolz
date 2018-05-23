package com.mongolz.rest.service;

import com.mongolz.domain.Transaction;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public interface TransactionRestService {

    public void doTransaction(Transaction transaction);
    public List<Transaction> findByAccountAndDate(Long accountNo, Date startTxnDate, Date endTxnDate);
}
