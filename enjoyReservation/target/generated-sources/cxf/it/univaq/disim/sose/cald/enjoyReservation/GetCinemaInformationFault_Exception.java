
package it.univaq.disim.sose.cald.enjoyReservation;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-01-29T21:29:37.014+01:00
 * Generated source version: 3.2.1
 */

@WebFault(name = "getCinemaInformationFault", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
public class GetCinemaInformationFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;
    
    private it.univaq.disim.sose.cald.enjoyReservation.GetCinemaInformationFault getCinemaInformationFault;

    public GetCinemaInformationFault_Exception() {
        super();
    }
    
    public GetCinemaInformationFault_Exception(String message) {
        super(message);
    }
    
    public GetCinemaInformationFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public GetCinemaInformationFault_Exception(String message, it.univaq.disim.sose.cald.enjoyReservation.GetCinemaInformationFault getCinemaInformationFault) {
        super(message);
        this.getCinemaInformationFault = getCinemaInformationFault;
    }

    public GetCinemaInformationFault_Exception(String message, it.univaq.disim.sose.cald.enjoyReservation.GetCinemaInformationFault getCinemaInformationFault, Throwable cause) {
        super(message, cause);
        this.getCinemaInformationFault = getCinemaInformationFault;
    }

    public it.univaq.disim.sose.cald.enjoyReservation.GetCinemaInformationFault getFaultInfo() {
        return this.getCinemaInformationFault;
    }
}