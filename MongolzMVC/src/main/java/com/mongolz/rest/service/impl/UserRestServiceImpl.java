package com.mongolz.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mongolz.domain.User;
import com.mongolz.rest.RestHttpHeader;
import com.mongolz.rest.service.UserRestService;

@Component
public class UserRestServiceImpl implements UserRestService {

    @Autowired
    RestHttpHeader restHttpHeader;

    @Override
    public List<User> findAll() {
        RestTemplate restTemplate = restHttpHeader.getRestTemplate();
        System.out.println(restTemplate.toString());
        return Arrays.asList(restTemplate.exchange("http://localhost:8080/users", HttpMethod.GET, restHttpHeader.getHttpEntity(), User[].class).getBody());
    }

    @Override
    public User findByUsername(String username) {
        RestTemplate restTemplate = restHttpHeader.getRestTemplate();
        return (restTemplate.exchange("http://localhost:8080/users/" + username, HttpMethod.GET, restHttpHeader.getHttpEntity(), User.class).getBody());
    }

    @Override
    public User save(User user) {
        RestTemplate restTemplate = restHttpHeader.getRestTemplate();
        HttpEntity<User> httpEntity = new HttpEntity<User>(user, restHttpHeader.getHttpHeaders());
        restTemplate.postForObject("http://localhost:8080/users/add", httpEntity, User.class);
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

}
