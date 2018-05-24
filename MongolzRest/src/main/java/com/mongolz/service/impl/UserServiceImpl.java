package com.mongolz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongolz.dao.UserDao;
import com.mongolz.domain.User;
import com.mongolz.service.UserCredentialsService;

@Service
@Transactional
public class UserServiceImpl implements com.mongolz.service.UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserCredentialsService credentialsService;


    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void saveFull(User user) {
        credentialsService.save(user.getUserCredentials());
        userDao.save(user);
    }

    //@PreAuthorize("hasRole('ROLE_TRAN')")
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public User update(User user) {
        return userDao.update(user);

    }

    @Override
    public User findOne(Long id) {

        return userDao.findOne(id);
    }


}
