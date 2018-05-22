package com.mongolz.dao;

import com.mongolz.domain.User;

import java.util.List;

public interface UserDao extends GenericDao<User> {

    User findUserByEmail(String email);

    public List<User> getAllUsers();

}
