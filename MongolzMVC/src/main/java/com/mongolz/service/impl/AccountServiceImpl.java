package com.mongolz.service.impl;

import com.mongolz.domain.Account;
import com.mongolz.rest.service.AccountRestService;
import com.mongolz.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRestService accountRestService;


    public List<Account> findAll() {
        return accountRestService.findAll();
    }

    public List<Account> findByUser(Long userId) {
        return accountRestService.findByUser(userId);
    }

}
