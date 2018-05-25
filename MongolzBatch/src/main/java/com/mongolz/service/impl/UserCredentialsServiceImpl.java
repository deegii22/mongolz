package com.mongolz.service.impl;


import com.mongolz.dao.UserCredentialsDao;
import com.mongolz.domain.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserCredentialsServiceImpl implements com.mongolz.service.UserCredentialsService {

    @Autowired
    private UserCredentialsDao userCredentialsDao;


    public void save( UserCredentials userCredentials) {
        userCredentialsDao.save(userCredentials);
    }


    public List<UserCredentials> findAll() {
        return (List<UserCredentials>)userCredentialsDao.findAll();
    }

    public UserCredentials findByUserName(String userName) {
        return userCredentialsDao.findByUserName(userName);
    }


    @Override
    public UserCredentials update(UserCredentials userCredentials) {
        return userCredentialsDao.update(userCredentials);

    }

}
