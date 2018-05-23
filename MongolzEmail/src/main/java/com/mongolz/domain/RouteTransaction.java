

package com.mongolz.domain;


import java.io.Serializable;

public class RouteTransaction implements Serializable {

    Transaction transaction;
    private String channel;

    /**
     * Constructor
     */
    public RouteTransaction(Transaction transaction) {
        this.channel = transaction.getFromAccount().getUser().getChannel();
        this.transaction  = transaction;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public String getChannel() {
        return channel;
    }
}
