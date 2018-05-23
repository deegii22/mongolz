 
package com.mongolz.integration;

import com.mongolz.domain.Transaction;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import com.mongolz.domain.Account;

/**
 * Routes order based on order type.
 * 
 */
@MessageEndpoint
public class ChannelRouter {

     /**
     * Process order.  Routes based on whether or 
     * not the order is a delivery or pickup.
     */
	@Router(inputChannel="routeAlert")
	public String determineChannelRoute(Transaction transaction) {
	    String destination = "email";
	    
 	    	if (transaction.getFromAccount().getUser().getChannel().equals("SMS"))
	        	destination = "sms";

		return destination;
	}

}
