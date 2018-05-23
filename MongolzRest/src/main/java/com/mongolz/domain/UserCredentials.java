package com.mongolz.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Authentication")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@jid")
public class UserCredentials {

    @Id
    @Column(name = "USER", nullable = false, unique = true, length = 127)
    String userName;

    @Column(nullable = false)
    String password;

    @Column(name = "PASSWORD", nullable = false, length = 32)
    String verifyPassword;
    Boolean enabled;

    @OneToOne(mappedBy = "userCredentials", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
// 	@JsonManagedReference
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "credential_authority", joinColumns = {@JoinColumn(name = "credential_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", unique = true)})
    List<Authority> authority = new ArrayList<Authority>();


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

    public List<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(List<Authority> authority) {
        this.authority = authority;
    }


}
