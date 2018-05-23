package com.mongolz.domain;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {
    private long id;

    private double amount;

    private Date txnDate = new Date();

    private Account fromAccount;

    private Account toAccount;

    /**
     * No-arg constructor for JavaBean tools
     */
    public Transaction() {}

    /**
     * Full constructor
     */
    public Transaction(double amount) {
        this.amount = amount;
    }

    // ********************** Accessor Methods ********************** //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public Date getTxnDate() {
        return txnDate;
    }

    // ********************** Business Methods ********************** //
}