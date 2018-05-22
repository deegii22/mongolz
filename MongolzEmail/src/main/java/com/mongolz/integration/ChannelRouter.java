 
package com.mongolz.integration;

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
	@Router(inputChannel="routeTransaction")
	public String determineChannelRoute(Account account) {
	    String destination = "email";
	    
 	    	if (account.getChannel().equals("SMS"))
	        	destination = "sms";

		return destination;
	}

}
