
package it.univaq.disim.sose.cald.enjoyReservation;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-01-29T21:29:36.959+01:00
 * Generated source version: 3.2.1
 */

@WebFault(name = "getRestaurantInformationFault", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
public class GetRestaurantInformationFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;
    
    private it.univaq.disim.sose.cald.enjoyReservation.GetRestaurantInformationFault getRestaurantInformationFault;

    public GetRestaurantInformationFault_Exception() {
        super();
    }
    
    public GetRestaurantInformationFault_Exception(String message) {
        super(message);
    }
    
    public GetRestaurantInformationFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public GetRestaurantInformationFault_Exception(String message, it.univaq.disim.sose.cald.enjoyReservation.GetRestaurantInformationFault getRestaurantInformationFault) {
        super(message);
        this.getRestaurantInformationFault = getRestaurantInformationFault;
    }

    public GetRestaurantInformationFault_Exception(String message, it.univaq.disim.sose.cald.enjoyReservation.GetRestaurantInformationFault getRestaurantInformationFault, Throwable cause) {
        super(message, cause);
        this.getRestaurantInformationFault = getRestaurantInformationFault;
    }

    public it.univaq.disim.sose.cald.enjoyReservation.GetRestaurantInformationFault getFaultInfo() {
        return this.getRestaurantInformationFault;
    }
}