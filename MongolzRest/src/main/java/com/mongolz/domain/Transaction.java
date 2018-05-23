package com.mongolz.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANSACTION_NO")
    private long id;

    private double amount;

    @Column(length = 50)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED", nullable = false, updatable = false)
    private Date transactionDate = new Date();

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

    public Date getTransactionDateDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // ********************** Business Methods ********************** //
}