 
package com.mongolz.integration;

import com.mongolz.domain.RouteTransaction;
import com.mongolz.domain.Transaction;

/**
 * Routes order based on order type.
 * 
 */

public interface ItemTransformer {

	public RouteTransaction transformItem(Transaction transaction);

}
