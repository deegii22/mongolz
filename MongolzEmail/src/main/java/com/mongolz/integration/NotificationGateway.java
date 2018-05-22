 
  
package com.mongolz.integration;

import com.mongolz.domain.Account;
import org.springframework.integration.annotation.Gateway;

/**
 * An entry point for the Bus Flow for local input.
 * 
 */
public interface NotificationGateway {

    /**
     * Process a book order.
     */
	@Gateway(requestChannel="processTransaction")
	public void process(Account account);

}
