package com.mongolz.dao;

import com.mongolz.domain.UserCredentials;

public interface UserCredentialsDao extends GenericDao<UserCredentials> {

    public UserCredentials findByUserName(String userName);
}
