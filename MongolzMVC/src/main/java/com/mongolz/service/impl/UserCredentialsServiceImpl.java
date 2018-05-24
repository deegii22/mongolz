package com.mongolz.service.impl;


import java.util.List;

import com.mongolz.domain.User;
import com.mongolz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongolz.dao.GenericDao;
import com.mongolz.dao.UserCredentialsDao;
import com.mongolz.domain.UserCredentials;

@Service
@Transactional
public class UserCredentialsServiceImpl implements com.mongolz.service.UserCredentialsService {

    @Autowired
    private UserCredentialsDao userCredentialsDao;

    @Autowired
    private UserService userService;


    public void save(UserCredentials userCredentials) {
        userCredentialsDao.save(userCredentials);
    }

    public void update(UserCredentials userCredentials) {
        userCredentialsDao.update(userCredentials);
    }

    public List<UserCredentials> findAll() {
        return (List<UserCredentials>) userCredentialsDao.findAll();
    }

    public UserCredentials findOne(Long id) {
        return userCredentialsDao.findOne(id);
    }

    public boolean LoggedIn() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && !(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
            //System.out.println("Username:" + auth.getName());
            return true;
        } else
            return false;
    }


    public User getUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = userService.findByUsername(auth.getName());
        return user;
    }

    public UserCredentials findByUserName(String userName) {

        return userCredentialsDao.findByUserName(userName);
    }

}
