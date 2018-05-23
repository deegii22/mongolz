package com.mongolz.service.impl;


import java.util.List;

import com.mongolz.rest.service.UserRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongolz.domain.User;
import com.mongolz.service.UserCredentialsService;

@Service
@Transactional
public class UserServiceImpl implements com.mongolz.service.UserService {

    @Autowired
    private UserRestService userRestService;

    @Autowired
    private UserCredentialsService credentialsService;


    public void save( User user) {
        userRestService.save(user);
    }

    @Override
    public void saveFull( User user) {
        System.out.println(user.toString());
        System.out.println(user.getUserCredentials().toString());
        credentialsService.save(user.getUserCredentials());
        userRestService.save(user);
    }


    public List<User> findAll() {
        return (List<User>)userRestService.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRestService.findByUsername(username);
    }

    public User update(User user) {
        return userRestService.update(user);

    }



}
