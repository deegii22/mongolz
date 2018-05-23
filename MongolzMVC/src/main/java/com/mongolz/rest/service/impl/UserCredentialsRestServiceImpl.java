package com.mongolz.rest.service.impl;


import com.mongolz.rest.RestHttpHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import com.mongolz.domain.UserCredentials;
import com.mongolz.rest.service.UserCredentialsRestService;


@Component
public class UserCredentialsRestServiceImpl implements UserCredentialsRestService {

    @Autowired
    RestHttpHeader restHttpHeader;

    // Kludge for Authenticating on REST  - used in RestHttpHeader & LoginController
    private UserCredentials userCredentials = new UserCredentials();

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public List<UserCredentials> findAll() {

        RestTemplate restTemplate = restHttpHeader.getRestTemplate();
        return Arrays.asList(restTemplate.exchange("http://localhost:8080/userCredentials/", HttpMethod.GET, restHttpHeader.getHttpEntity(), UserCredentials[].class).getBody());
    }

    @Override
    public UserCredentials findByUserName(String userName) {
        RestTemplate restTemplate = restHttpHeader.getRestTemplate();
        UserCredentials userCredentials = null;
        try {
           // System.out.println("Rest ruu orj irsen!");
            userCredentials = (restTemplate.exchange("http://localhost:8080/userCredentials/" + userName, HttpMethod.GET, restHttpHeader.getHttpEntity(), UserCredentials.class).getBody());
            if (userCredentials == null) {
                System.out.println("userCredentials null bn");
            }
            //System.out.println("Rest ner:"+userCredentials.getUsername());
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return userCredentials;
    }

    @Override
    public UserCredentials save(UserCredentials userCred) {

        RestTemplate restTemplate = restHttpHeader.getRestTemplate();
        HttpEntity<UserCredentials> httpEntity = new HttpEntity<UserCredentials>(userCred, restHttpHeader.getHttpHeaders());
        restTemplate.postForObject("http://localhost:8080/userCredentials/add/", httpEntity, UserCredentials.class);

        return null;
    }

}
