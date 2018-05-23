 
  
package com.mongolz.integration;

import com.mongolz.domain.Transaction;
import org.springframework.integration.annotation.Gateway;

/**
 * An entry point for the Bus Flow for local input.
 * 
 */
public interface AlertGateway {

    /**
     * Process a book order.
     */
	@Gateway(requestChannel="processAlert")
	public void process(Transaction transaction);

}
