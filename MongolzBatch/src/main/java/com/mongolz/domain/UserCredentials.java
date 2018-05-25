package com.mongolz.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "CREDENTIALS")
public class UserCredentials {

    @Id
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "{String.empty}")
    String userName;
    @Column(nullable = false)
    @Size(min = 6, max = 32, message = "{Size.name.validation}")
    String password;
    String verifyPassword;
    Boolean enabled;

    @OneToOne(mappedBy = "userCredentials", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
// 	@JsonManagedReference
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "CREDENTIAL_ROLE", joinColumns = {@JoinColumn(name = "credential_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", unique = true)})
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
