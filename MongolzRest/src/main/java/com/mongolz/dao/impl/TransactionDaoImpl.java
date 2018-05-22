package com.mongolz.dao.impl;

import com.mongolz.dao.TransactionDao;
import com.mongolz.domain.Account;
import com.mongolz.domain.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository
public class TransactionDaoImpl extends GenericDaoImpl<Transaction> implements TransactionDao {

    public TransactionDaoImpl() {
        super.setDaoType(Transaction.class);
    }

    public List<Transaction> findByAccountAndDate(Long accountNo, Date startTxnDate, Date endTxnDate){
        Query query = entityManager.createQuery("select p from Transaction p where " +
                "(p.fromAccount.id = :accountNo or p.toAccount.id=:accountNo) and " +
                "p.txnDate between :startTxnDate and :endTxnDate");
        return (List<Transaction>) query.setParameter("accountNo", accountNo).
                setParameter("startTxnDate", startTxnDate).
                setParameter("endTxnDate", endTxnDate).getResultList();
    }

}
