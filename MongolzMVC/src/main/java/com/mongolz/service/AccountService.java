package com.mongolz.service;

import com.mongolz.domain.Account;

import java.util.List;

public interface AccountService {

	public List<Account> findAll();

	public List<Account> findByUser(Long userId);
}
