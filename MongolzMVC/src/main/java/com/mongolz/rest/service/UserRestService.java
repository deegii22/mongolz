package com.mongolz.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mongolz.domain.User;

@Component
public interface UserRestService {

    public List<User> findAll();

    public User findByUsername(String username);

    public User save(User user);

    public User update(User user);

}
