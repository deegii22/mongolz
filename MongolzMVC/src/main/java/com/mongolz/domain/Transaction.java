package com.mongolz.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TRANSACTIONS")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANSACTION_NO")
    private long id;

    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED", nullable = false, updatable = false)
    private Date txnDate = new Date();

    @ManyToOne(fetch=FetchType.EAGER,  cascade = CascadeType.MERGE)
    @JoinColumn(name="fromAccount")
    private Account  fromAccount;

    @ManyToOne(fetch=FetchType.EAGER,  cascade = CascadeType.MERGE)
    @JoinColumn(name="toAccount")
    private Account  toAccount;

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