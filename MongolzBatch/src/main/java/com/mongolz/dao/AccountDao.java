package com.mongolz.dao;

import com.mongolz.domain.Account;

import java.util.List;

public interface AccountDao extends GenericDao<Account> {

    public List<Account> findByUser(Long userId);

}

