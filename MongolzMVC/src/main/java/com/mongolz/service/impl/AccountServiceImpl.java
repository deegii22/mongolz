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

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TRAN')")
    public List<Account> findAll() {
        return accountRestService.findAll();
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TRAN')")
    public List<Account> findByUser(Long userId) {
        return accountRestService.findByUser(userId);
    }

}
