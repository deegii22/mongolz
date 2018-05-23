

package com.mongolz.domain;


import java.io.Serializable;

public class RouteItem  implements Serializable {

    Item item;
    private String auctionId;

    /**
     * Constructor
     */
    public RouteItem(Item item) {
        this.auctionId = item.getName() + item.getVersion();
        this.item  = item;
    }


    public String getAuctionId() {
        return auctionId;
    }


    /**
     * Gets item type.
     */




    public Item getItem() {
        return item;
    }

}
