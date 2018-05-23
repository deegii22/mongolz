package com.mongolz.service;

import java.util.List;

import com.mongolz.domain.User;

public interface UserService {

    public void save(User user);
    public List<User> findAll();
    public User findById(Long id);
    public User update(User user);
    public void saveFull( User user);

}
