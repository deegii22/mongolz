package com.mongolz.service.impl;

import com.mongolz.dao.AccountDao;
import com.mongolz.domain.Account;
import com.mongolz.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    //@PreAuthorize("hasRole('ROLE_TRAN')")
    public List<Account> getAllAccounts() {
        return accountDao.findAll();
    }

    public List<Account> findByUser(Long userId) {
        return accountDao.findByUser(userId);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public Account findOne(Long id) {
        return accountDao.findOne(id);
    }
}
