
package it.univaq.disim.sose.cald.clients.restaurantinserting;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-02-03T11:39:33.803+01:00
 * Generated source version: 3.2.1
 */

@WebFault(name = "restaurantInsertFault", targetNamespace = "http://it.univaq.disim.sose.cald/restaurantInserting")
public class RestaurantInsertFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;
    
    private it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantInsertFault restaurantInsertFault;

    public RestaurantInsertFault_Exception() {
        super();
    }
    
    public RestaurantInsertFault_Exception(String message) {
        super(message);
    }
    
    public RestaurantInsertFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public RestaurantInsertFault_Exception(String message, it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantInsertFault restaurantInsertFault) {
        super(message);
        this.restaurantInsertFault = restaurantInsertFault;
    }

    public RestaurantInsertFault_Exception(String message, it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantInsertFault restaurantInsertFault, Throwable cause) {
        super(message, cause);
        this.restaurantInsertFault = restaurantInsertFault;
    }

    public it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantInsertFault getFaultInfo() {
        return this.restaurantInsertFault;
    }
}