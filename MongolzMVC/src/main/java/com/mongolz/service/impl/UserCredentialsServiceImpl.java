package com.mongolz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongolz.domain.UserCredentials;
import com.mongolz.rest.service.UserCredentialsRestService;

@Service
@Transactional
public class UserCredentialsServiceImpl implements com.mongolz.service.UserCredentialsService {

    @Autowired
    private UserCredentialsRestService userCredentialsRestService;

    // Kludge for Authenticating on REST  - used in RestHttpHeader & LoginController
    private UserCredentials userCredentials = new UserCredentials();

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public void save(UserCredentials userCredentials) {
        userCredentialsRestService.save(userCredentials);
    }

    public UserCredentials findByUserName(String userName) {
        return userCredentialsRestService.findByUserName(userName);
    }

    public List<UserCredentials> findAll() {
        return (List<UserCredentials>) userCredentialsRestService.findAll();
    }


}
