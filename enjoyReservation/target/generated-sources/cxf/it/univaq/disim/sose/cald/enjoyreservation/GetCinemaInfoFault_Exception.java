
package it.univaq.disim.sose.cald.enjoyreservation;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-02-09T21:59:22.867+01:00
 * Generated source version: 3.2.1
 */

@WebFault(name = "getCinemaInfoFault", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
public class GetCinemaInfoFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;
    
    private it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoFault getCinemaInfoFault;

    public GetCinemaInfoFault_Exception() {
        super();
    }
    
    public GetCinemaInfoFault_Exception(String message) {
        super(message);
    }
    
    public GetCinemaInfoFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public GetCinemaInfoFault_Exception(String message, it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoFault getCinemaInfoFault) {
        super(message);
        this.getCinemaInfoFault = getCinemaInfoFault;
    }

    public GetCinemaInfoFault_Exception(String message, it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoFault getCinemaInfoFault, Throwable cause) {
        super(message, cause);
        this.getCinemaInfoFault = getCinemaInfoFault;
    }

    public it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoFault getFaultInfo() {
        return this.getCinemaInfoFault;
    }
}
