
package it.univaq.disim.sose.cald.clients.cinemainformation;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-02-02T17:24:21.601+01:00
 * Generated source version: 3.2.1
 */

@WebFault(name = "cinemaInformationFault", targetNamespace = "http://it.univaq.disim.sose.cald/cinemaInformation")
public class CinemaInformationFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;
    
    private it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationFault cinemaInformationFault;

    public CinemaInformationFault_Exception() {
        super();
    }
    
    public CinemaInformationFault_Exception(String message) {
        super(message);
    }
    
    public CinemaInformationFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public CinemaInformationFault_Exception(String message, it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationFault cinemaInformationFault) {
        super(message);
        this.cinemaInformationFault = cinemaInformationFault;
    }

    public CinemaInformationFault_Exception(String message, it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationFault cinemaInformationFault, Throwable cause) {
        super(message, cause);
        this.cinemaInformationFault = cinemaInformationFault;
    }

    public it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationFault getFaultInfo() {
        return this.cinemaInformationFault;
    }
}
