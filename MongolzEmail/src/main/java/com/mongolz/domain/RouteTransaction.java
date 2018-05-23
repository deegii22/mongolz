package com.mongolz.domain;

import java.io.Serializable;
import java.util.Date;

public class RouteTransaction implements Serializable {

    private Transaction transaction;
    private String channel;

    public RouteTransaction(Transaction transaction, String channel) {
        this.transaction = transaction;
        this.channel = channel;
    }
}