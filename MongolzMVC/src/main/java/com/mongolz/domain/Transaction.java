package com.mongolz.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANSACTION_NO")
    private long id;

    @NotNull
    @Min(value = 1, message = "{Min.size}")
    private BigDecimal amount;

    @Column(length = 50)
    @NotEmpty(message = "{NotEmpty})")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED", nullable = false, updatable = false)
    @DateTimeFormat(pattern = "MM.dd.yyyy")
    private Date transactionDate = new Date();

    @Transient
    private String error;

    @ManyToOne(fetch=FetchType.EAGER,  cascade = CascadeType.MERGE)
    @JoinColumn(name="fromAccount")
    @Valid
    private Account  fromAccount;

    @ManyToOne(fetch=FetchType.EAGER,  cascade = CascadeType.MERGE)
    @JoinColumn(name="toAccount")
    @Valid
    private Account  toAccount;

    // ********************** Accessor Methods ********************** //
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
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

    public Date getTransactionDate() {
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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    // ********************** Business Methods ********************** //
}