 
package com.mongolz.integration;

import com.mongolz.domain.RouteTransaction;
import com.mongolz.domain.Transaction;
import org.springframework.integration.annotation.Transformer;

/**
 * Routes order based on order type.
 * 
 */
public class ItemTransformerImpl implements ItemTransformer {

     /**
     * Transform Order from AMQP to RouteOrder for JMS
      */
	@Transformer(inputChannel="fromAmqpOrder", outputChannel="processItem")
	public RouteTransaction transformItem(Transaction transaction) {

		System.out.println("In Transform ....");
		RouteTransaction routeTransaction = new RouteTransaction(transaction);
	    	 	
		return routeTransaction;
	}

}
