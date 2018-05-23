package com.mongolz.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {
    @Id
    @Column(name = "ACCOUNT_NO", length = 6)
    private long id;

    @Column(length = 50)
    private String accountName;

    private double balance;

//    @ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private User  user;

    /**
     * No-arg constructor for JavaBean tools
     */
    public Account() {
    }

    /**
     * Full constructor
     */
    public Account(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    // ********************** Accessor Methods ********************** //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }


    // ********************** Business Methods ********************** //
}