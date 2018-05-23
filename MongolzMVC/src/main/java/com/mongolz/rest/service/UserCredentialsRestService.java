package com.mongolz.rest.service;

import com.mongolz.domain.UserCredentials;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserCredentialsRestService {

    public List<UserCredentials> findAll();
    public UserCredentials findByUserName(String userName);
    public UserCredentials save(UserCredentials user);

}
