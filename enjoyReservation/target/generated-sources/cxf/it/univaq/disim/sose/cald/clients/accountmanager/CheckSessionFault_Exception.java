
package it.univaq.disim.sose.cald.clients.accountmanager;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-02-09T15:04:15.648+01:00
 * Generated source version: 3.2.1
 */

@WebFault(name = "checkSessionFault", targetNamespace = "http://it.univaq.disim.sose.cald/accountManager")
public class CheckSessionFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;
    
    private it.univaq.disim.sose.cald.clients.accountmanager.CheckSessionFault checkSessionFault;

    public CheckSessionFault_Exception() {
        super();
    }
    
    public CheckSessionFault_Exception(String message) {
        super(message);
    }
    
    public CheckSessionFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckSessionFault_Exception(String message, it.univaq.disim.sose.cald.clients.accountmanager.CheckSessionFault checkSessionFault) {
        super(message);
        this.checkSessionFault = checkSessionFault;
    }

    public CheckSessionFault_Exception(String message, it.univaq.disim.sose.cald.clients.accountmanager.CheckSessionFault checkSessionFault, Throwable cause) {
        super(message, cause);
        this.checkSessionFault = checkSessionFault;
    }

    public it.univaq.disim.sose.cald.clients.accountmanager.CheckSessionFault getFaultInfo() {
        return this.checkSessionFault;
    }
}