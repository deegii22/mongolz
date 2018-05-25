package com.mongolz.domain;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String username;
    @Column(nullable = false)
    private String role;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String authority) {
        this.role = role;
    }


}
