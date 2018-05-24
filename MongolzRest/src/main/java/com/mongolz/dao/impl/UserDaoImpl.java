package com.mongolz.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mongolz.dao.UserDao;
import com.mongolz.domain.User;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    public UserDaoImpl() {
        super.setDaoType(User.class );
    }


    @Override
    public User findByUsername(String username) {
        Query query = entityManager.createQuery("select u from User u join fetch u.userCredentials uc where uc.username =:username");
        return (User) query.setParameter("username", username).getSingleResult();
    }


    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("select u from User u");
        return (List<User>) query.getResultList();
    }

}
