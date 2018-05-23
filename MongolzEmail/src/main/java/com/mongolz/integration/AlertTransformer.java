 
package com.mongolz.integration;

import com.mongolz.domain.RouteTransaction;
import com.mongolz.domain.Transaction;

public interface AlertTransformer {

	public RouteTransaction transformAlert(Transaction transaction);

}
