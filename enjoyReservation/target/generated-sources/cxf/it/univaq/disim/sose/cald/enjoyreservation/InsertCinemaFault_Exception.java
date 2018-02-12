
package it.univaq.disim.sose.cald.enjoyreservation;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-02-11T15:06:24.418+01:00
 * Generated source version: 3.2.1
 */

@WebFault(name = "insertRestaurantFault", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
public class InsertCinemaFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;
    
    private it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantFault insertRestaurantFault;

    public InsertCinemaFault_Exception() {
        super();
    }
    
    public InsertCinemaFault_Exception(String message) {
        super(message);
    }
    
    public InsertCinemaFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertCinemaFault_Exception(String message, it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantFault insertRestaurantFault) {
        super(message);
        this.insertRestaurantFault = insertRestaurantFault;
    }

    public InsertCinemaFault_Exception(String message, it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantFault insertRestaurantFault, Throwable cause) {
        super(message, cause);
        this.insertRestaurantFault = insertRestaurantFault;
    }

    public it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantFault getFaultInfo() {
        return this.insertRestaurantFault;
    }
}
