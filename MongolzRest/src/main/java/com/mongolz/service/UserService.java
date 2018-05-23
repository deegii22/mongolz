package com.mongolz.service;

import java.util.List;

import com.mongolz.domain.User;

public interface UserService {

    public void save(User user);
    public List<User> findAll();
    public User findOne(Long id);
    public User findByUsername(String username);
    public User update(User user);
    public void saveFull( User user);

}
