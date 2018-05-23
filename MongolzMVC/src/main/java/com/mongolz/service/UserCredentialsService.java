package com.mongolz.service;

import com.mongolz.domain.UserCredentials;

import java.util.List;


public interface UserCredentialsService {

    public void save(UserCredentials userCredentials);
    public List<UserCredentials> findAll();
    public UserCredentials findByUserName(String username);


  }
