package com.mongolz.service.impl;

import com.mongolz.domain.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCredentialsServiceImpl implements com.mongolz.service.UserCredentialsService {
	
 // Kludge for Authenticating on REST  - used in RestHttpHeader & LoginController
 	private UserCredentials userCredentials  = new UserCredentials();	
    public UserCredentials getUserCredentials() {
		return userCredentials;
	}
	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}
 
 
}
