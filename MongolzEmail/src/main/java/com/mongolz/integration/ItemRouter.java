 
package com.mongolz.integration;

import com.mongolz.domain.RouteTransaction;
import com.mongolz.domain.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

/**
 * Routes order based on order type.
 * 
 */
@MessageEndpoint
public class ItemRouter {

    final Logger logger = LoggerFactory.getLogger(ItemRouter.class);
    
    /**
     * Process order.  Routes based on whether or 
     * not the order is a delivery or pickup.
     */
	@Router(inputChannel="processItem")
	public String processItem(RouteTransaction transaction) {
	    String destination = null;

		System.out.println("In Router ....");

	    if (transaction.getChannel().equals("SMS")){
			destination = "sms";
		} else {
			destination = "email";
		}
	
		return destination;
	}

}
