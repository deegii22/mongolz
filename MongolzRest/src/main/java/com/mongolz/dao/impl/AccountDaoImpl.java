package com.mongolz.dao.impl;


import com.mongolz.dao.AccountDao;
import com.mongolz.domain.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class AccountDaoImpl extends GenericDaoImpl<Account> implements AccountDao
{
    
    public AccountDaoImpl() {
        super.setDaoType(Account.class );
        }


  public Account getAccountByAccountId(String key) {
     return  this.getAccountByAccountId(key);
  }

     public List<Account> getAllAccounts() {
        return this.findAll();
    }
 
    public Account getAccountById(String key) {	     
        Query query = entityManager.createQuery("select p from Account p  where p.productId =:productId");
        return (Account) query.setParameter("productId", key).getSingleResult();

    }
    
    public List<Account> getAccountsByCategory(String category) {
        
        Query query = entityManager.createQuery("select p from Account p where p.category = :category");
         
        return (List<Account>) query.setParameter("category", category).getResultList();
     }


    @SuppressWarnings("unchecked")
    public List<Account> getAccountsByDescOrder() {
        Query query = entityManager.createQuery("select p from Account p order by p.productId desc");
        return (List<Account>) query.getResultList();

    }


}

