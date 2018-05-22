package com.mongolz.dao;

import com.mongolz.domain.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionDao extends GenericDao<Transaction>  {

    public List<Transaction> findByAccountAndDate(Long accountNo, Date startTxnDate, Date endTxnDate);
}
