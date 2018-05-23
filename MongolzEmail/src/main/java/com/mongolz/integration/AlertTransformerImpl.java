 
package com.mongolz.integration;

import com.mongolz.domain.RouteTransaction;
import com.mongolz.domain.Transaction;
import org.springframework.integration.annotation.Transformer;

/**
 * Routes order based on order type.
 * 
 */
public class AlertTransformerImpl implements AlertTransformer {

     /**
     * Transform Transaction from AMQP to RouteTransaction for JMS
      */
	@Transformer(inputChannel="fromAmqpNotification", outputChannel="processTransaction")
	public RouteTransaction transformAlert(Transaction transaction) {

		RouteTransaction routeTransaction = new RouteTransaction(transaction, transaction.getFromAccount().getUser().getChannel());
		
		return routeTransaction;
	}

}
