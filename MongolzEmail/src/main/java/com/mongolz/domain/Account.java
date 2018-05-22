package com.mongolz.domain;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = 5784L;

    private long id;

    private String accountId;

    private String channel;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Account(String accountId) {
        this.accountId = accountId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}