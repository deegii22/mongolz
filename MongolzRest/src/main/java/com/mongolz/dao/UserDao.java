package com.mongolz.dao;

import com.mongolz.domain.User;

import java.util.List;

public interface UserDao extends GenericDao<User> {

    User findByUsername(String username);

    public List<User> getAllUsers();

    //User findByUsername(String username);

}
