package com.mongolz.rest.service.impl;

import com.mongolz.domain.Transaction;
import com.mongolz.rest.RestHttpHeader;
import com.mongolz.rest.service.TransactionRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
        DateFormat df = new SimpleDateFormat("MMddyyyy");
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
        ResponseEntity<Transaction[]> responseEntity = restTemplate.exchange(baseUrlExtended + accountNo
                + "/startDate/" + df.format(startTxnDate) + "/endDate/" + df.format(endTxnDate), HttpMethod.GET, httpEntity, Transaction[].class);
        List<Transaction> transactionList = Arrays.asList(responseEntity.getBody());
        return transactionList;
    }
}
