package com.mongolz.service.impl;

import com.mongolz.domain.Account;
import com.mongolz.rest.service.AccountRestService;
import com.mongolz.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
	
 	@Autowired
// 	@Qualifier("Jersey")
   @Qualifier("MVC")
	private AccountRestService productRestService;

	public List<Account> findAll() {
		return productRestService.findAll();
	}

 

}
