package com.mongolz.service.impl;

import com.mongolz.dao.AccountDao;
import com.mongolz.domain.Account;
import com.mongolz.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional 
public class AccountServiceImpl implements AccountService{
	
 	@Autowired
	private AccountDao accountDao;

	public List<Account> getAllAccounts() {
		return accountDao.getAllAccounts();
	}

}
