package com.mongolz.rest.service.impl;

import com.mongolz.domain.Account;
import com.mongolz.rest.RestHttpHeader;
import com.mongolz.rest.service.AccountRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class AccountRestServiceImpl implements AccountRestService {

	@Autowired
	RestHttpHeader restHelper;
	
	String baseUrl = "http://localhost:8080/accounts";
	String baseUrlExtended = baseUrl + "/";

	public List<Account> findAll() {
		
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<Account[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, Account[].class);	
 		List<Account> accountList = Arrays.asList(responseEntity.getBody());
		return accountList;
	}

	public List<Account> findByUser(Long userId) {

		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<Account[]> responseEntity = restTemplate.exchange(baseUrlExtended + userId, HttpMethod.GET, httpEntity, Account[].class);
		List<Account> accountList = Arrays.asList(responseEntity.getBody());
		return accountList;
	}
}
