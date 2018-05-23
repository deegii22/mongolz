package com.mongolz.rest.service.impl;

import com.mongolz.domain.Transaction;
import com.mongolz.rest.RestHttpHeader;
import com.mongolz.rest.service.TransactionRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Component
public class TransactionRestServiceImpl implements TransactionRestService {

    @Autowired
    RestHttpHeader restHelper;

    String baseUrl = "http://localhost:8080/transactions";
    String baseUrlExtended = baseUrl + "/";

    public void doTransaction(Transaction transaction) {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity<Transaction> httpEntity = new HttpEntity<>(transaction, restHelper.getHttpHeaders());
        restTemplate.postForObject(baseUrlExtended + "txn/", httpEntity, Transaction.class);

    }

    public List<Transaction> findByAccountAndDate(Long accountNo, Date startTxnDate, Date endTxnDate) {
        return null;
    }
}
