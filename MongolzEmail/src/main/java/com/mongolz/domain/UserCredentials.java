package com.mongolz.domain;

import java.util.ArrayList;
import java.util.List;


public class UserCredentials {

    String userName;
    String password;
    String verifyPassword;
    Boolean enabled;

    private User user;

    List<Role> roles = new ArrayList<Role>();


    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles(){ return roles;}
    public void setRoles(List<Role> roles) {this.roles = roles;}


}
