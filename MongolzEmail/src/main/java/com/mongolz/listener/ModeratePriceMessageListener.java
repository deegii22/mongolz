package com.mongolz.listener;

import com.mongolz.domain.RouteItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;


public class ModeratePriceMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(ModeratePriceMessageListener.class);

    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        RouteItem routeItem = null;
		try {
			routeItem = (RouteItem) objectMessage.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Moderate Priced Item - Message received: " );
        System.out.println("         Item Name: "  +    routeItem.getItem().getName());
        System.out.println("         Item Price: "  +    routeItem.getItem().getPrice());
        System.out.println("         Auction ID: "  +    routeItem.getAuctionId());

    }
}
