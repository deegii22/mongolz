package com.mongolz.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.mongolz.domain.Account;


public class EmailListener implements MessageListener {
 
    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        Account account = null;
		try {
            account = (Account) objectMessage.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Email transaction - Message received: " );
        System.out.println("         Item Name: "  + account.getAccountId());

    }
}
