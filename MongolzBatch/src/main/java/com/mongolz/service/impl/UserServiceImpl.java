package com.mongolz.service.impl;

import com.mongolz.dao.UserDao;
import com.mongolz.domain.User;
import com.mongolz.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements com.mongolz.service.UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserCredentialsService credentialsService;


    public void save( User user) {
        userDao.save(user);
    }

    @Override
    public void saveFull( User user) {
        credentialsService.save(user.getUserCredentials());
        userDao.save(user);
    }


    public List<User> findAll() {
        return (List<User>)userDao.findAll();
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public User update(User user) {
        return userDao.update(user);

    }

    @Override
    public User findOne(Long id) {

        return userDao.findOne(id);
    }


}
