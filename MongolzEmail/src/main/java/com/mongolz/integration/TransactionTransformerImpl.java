 
package com.mongolz.integration;

import org.springframework.integration.annotation.Transformer;

import com.mongolz.domain.Account;

/**
 * Routes order based on order type.
 * 
 */
public class TransactionTransformerImpl implements TransactionTransformer {

     /**
     * Transform Transaction from AMQP to RouteTransaction for JMS
      */
	@Transformer(inputChannel="fromAmqpNotification", outputChannel="processTransaction")
	public Account transformTransaction(Account account) {


		account.setAccountId("333");
		
		return account;
	}

}
