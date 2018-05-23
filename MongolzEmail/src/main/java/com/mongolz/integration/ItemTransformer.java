 
package com.mongolz.integration;

import com.mongolz.domain.Item;
import com.mongolz.domain.RouteItem;

/**
 * Routes order based on order type.
 * 
 */

public interface ItemTransformer {

	public RouteItem transformItem(Item item);

}
