package com.mongolz.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity(name = "CREDENTIALS")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@jid")
public class UserCredentials {

    @Id
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "{String.empty}")
    String username;
    @Column(nullable = false)
    @Size(min = 6, max = 32, message = "{Size.name.validation}")
    String password;
    String verifyPassword;
    Boolean enabled;

    @OneToOne(mappedBy="userCredentials", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
// 	@JsonManagedReference
    private User user;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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


}
