package com.mongolz.rest;

import com.mongolz.domain.UserCredentials;
import com.mongolz.service.UserCredentialsService;
import com.mongolz.service.impl.UserCredentialsServiceImpl;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Collections;


@Component
public class RestHttpHeader {
    protected RestTemplate restTemplate;

    @Autowired
    protected UserCredentialsService userCredentialsService;

    public RestHttpHeader() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    /*
     *		Set up authentication header
     *		PLUS JSON Accept header
     */
    public HttpHeaders getHttpHeaders() {

        // KLUDGE to get Credentials...
        UserCredentials userCredentials =
                ((UserCredentialsServiceImpl)
                        userCredentialsService).getUserCredentials();

        String username = userCredentials.getUserName();
        String password = userCredentials.getPassword();

        String auth = username + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.set("Authorization", authHeader);
        return requestHeaders;
    }

    public HttpEntity<?> getHttpEntity() {
        return new HttpEntity(getHttpHeaders());
    }

}

