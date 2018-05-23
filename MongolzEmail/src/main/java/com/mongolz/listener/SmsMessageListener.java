package com.mongolz.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.mongolz.domain.RouteTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SmsMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(SmsMessageListener.class);

    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        RouteTransaction routeTransaction = null;
		try {
            routeTransaction = (RouteTransaction) objectMessage.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("SMS Item - Message received: " );
        System.out.println("         Item Name: "  +    routeTransaction.getChannel());
        System.out.println("         Item Name: "  +    routeTransaction.getTransaction().getAmount());

    }
}
