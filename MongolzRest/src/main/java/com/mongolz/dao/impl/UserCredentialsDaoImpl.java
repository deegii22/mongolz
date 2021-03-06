package com.mongolz.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mongolz.dao.UserCredentialsDao;
import com.mongolz.domain.UserCredentials;




@SuppressWarnings("unchecked")
@Repository
public class UserCredentialsDaoImpl extends GenericDaoImpl<UserCredentials> implements UserCredentialsDao {

    public UserCredentialsDaoImpl() {
        super.setDaoType(UserCredentials.class );
    }

    public UserCredentials findByUserName(String userName) {

        Query query = entityManager.createQuery("select m from CREDENTIALS m  where m.username =:userName");
        return (UserCredentials) query.setParameter("userName", userName).getSingleResult();

    }


}