package com.mongolz.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Account implements Serializable {
    private long id;

    private String accountName;

    private BigDecimal balance;

    private User user;

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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    // ********************** Business Methods ********************** //
}