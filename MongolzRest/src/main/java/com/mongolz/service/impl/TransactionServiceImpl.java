package com.mongolz.service.impl;

import com.mongolz.dao.TransactionDao;
import com.mongolz.domain.Transaction;
import com.mongolz.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    public void save(Transaction transaction) {
        transactionDao.save(transaction);
    }

    public List<Transaction> findByAccountAndDate(Long accountNo, Date startTxnDate, Date endTxnDate) {
        return transactionDao.findByAccountAndDate(accountNo, startTxnDate, endTxnDate);
    }
}
