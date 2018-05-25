package com.mongolz.service;

import com.mongolz.domain.Account;

import java.util.List;

public interface AccountService {

    public List<Account> getAllAccounts();

    public List<Account> findByUser(Long userId);

    public void update(Account account);

    public Account findOne(Long id);

}
