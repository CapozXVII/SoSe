
package it.univaq.disim.sose.cald.enjoyreservation;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-02-14T17:25:04.771+01:00
 * Generated source version: 3.2.1
 */

@WebFault(name = "getAllInfoFault", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
public class GetAllInfoFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;
    
    private it.univaq.disim.sose.cald.enjoyreservation.GetAllInfoFault getAllInfoFault;

    public GetAllInfoFault_Exception() {
        super();
    }
    
    public GetAllInfoFault_Exception(String message) {
        super(message);
    }
    
    public GetAllInfoFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public GetAllInfoFault_Exception(String message, it.univaq.disim.sose.cald.enjoyreservation.GetAllInfoFault getAllInfoFault) {
        super(message);
        this.getAllInfoFault = getAllInfoFault;
    }

    public GetAllInfoFault_Exception(String message, it.univaq.disim.sose.cald.enjoyreservation.GetAllInfoFault getAllInfoFault, Throwable cause) {
        super(message, cause);
        this.getAllInfoFault = getAllInfoFault;
    }

    public it.univaq.disim.sose.cald.enjoyreservation.GetAllInfoFault getFaultInfo() {
        return this.getAllInfoFault;
    }
}
