package com.mongolz.dao.impl;

import com.mongolz.dao.AccountDao;
import com.mongolz.domain.Account;
import com.mongolz.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class AccountDaoImpl extends GenericDaoImpl<Account> implements AccountDao {

    public AccountDaoImpl() {
        super.setDaoType(Account.class);
    }

    public List<Account> findByUser(Long userId) {
        Query query = entityManager.createQuery("select p from Account p where p.user.id = :userId");
        return (List<Account>) query.setParameter("userId", userId).getResultList();
    }

}

