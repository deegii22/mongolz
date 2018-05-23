package com.mongolz.rest.service.impl;

import com.mongolz.domain.Transaction;
import com.mongolz.rest.RestHttpHeader;
import com.mongolz.rest.service.TransactionRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component("MVC")
public class TransactionRestServiceImpl implements TransactionRestService {

    @Autowired
    RestHttpHeader restHelper;

    String baseUrl = "http://localhost:8080/accounts";
    String baseUrlExtended = baseUrl + "/";

    public void doTransaction(Transaction transaction){

    }
    public List<Transaction> findByAccountAndDate(Long accountNo, Date startTxnDate, Date endTxnDate){
        return null;
    }
}
