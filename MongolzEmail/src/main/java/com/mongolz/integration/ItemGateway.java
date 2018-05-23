 
  
package com.mongolz.integration;

import com.mongolz.domain.Transaction;
import org.springframework.integration.annotation.Gateway;

/**
 * An entry point for the Bus Flow for local input.
 * 
 */
public interface ItemGateway {

    /**
     * Process a book order.
     */
	@Gateway(requestChannel="processItem")
	public void process(Transaction transaction);

}
