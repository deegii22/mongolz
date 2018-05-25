package com.mongolz.dao;

import com.mongolz.domain.User;

import java.util.List;

public interface UserDao extends GenericDao<User> {

    User findByEmail(String email);

    public List<User> getAllUsers();

}
