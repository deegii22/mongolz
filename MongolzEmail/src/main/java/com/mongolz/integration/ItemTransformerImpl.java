 
package com.mongolz.integration;

import com.mongolz.domain.Item;
import com.mongolz.domain.RouteItem;
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
	public RouteItem transformItem(Item item) {

		RouteItem routeItem = new RouteItem(item);
	    	 	
		return routeItem;
	}

}
