
package it.univaq.disim.sose.cald.restaurantInserting;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-01-16T15:53:22.342+01:00
 * Generated source version: 3.2.1
 */

@WebFault(name = "restaurantInsertFault", targetNamespace = "http://it.univaq.disim.sose.cald/restaurantInserting")
public class RestaurantUpdateFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;
    
    private it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertFault restaurantInsertFault;

    public RestaurantUpdateFault_Exception() {
        super();
    }
    
    public RestaurantUpdateFault_Exception(String message) {
        super(message);
    }
    
    public RestaurantUpdateFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public RestaurantUpdateFault_Exception(String message, it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertFault restaurantInsertFault) {
        super(message);
        this.restaurantInsertFault = restaurantInsertFault;
    }

    public RestaurantUpdateFault_Exception(String message, it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertFault restaurantInsertFault, Throwable cause) {
        super(message, cause);
        this.restaurantInsertFault = restaurantInsertFault;
    }

    public it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertFault getFaultInfo() {
        return this.restaurantInsertFault;
    }
}
