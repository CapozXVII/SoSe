
package it.univaq.disim.sose.cald.enjoyreservation;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-02-09T21:59:22.886+01:00
 * Generated source version: 3.2.1
 */

@WebFault(name = "accountLogoutFault", targetNamespace = "http://it.univaq.disim.sose.cald/enjoyReservation")
public class AccountLogoutFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;
    
    private it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutFault accountLogoutFault;

    public AccountLogoutFault_Exception() {
        super();
    }
    
    public AccountLogoutFault_Exception(String message) {
        super(message);
    }
    
    public AccountLogoutFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountLogoutFault_Exception(String message, it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutFault accountLogoutFault) {
        super(message);
        this.accountLogoutFault = accountLogoutFault;
    }

    public AccountLogoutFault_Exception(String message, it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutFault accountLogoutFault, Throwable cause) {
        super(message, cause);
        this.accountLogoutFault = accountLogoutFault;
    }

    public it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutFault getFaultInfo() {
        return this.accountLogoutFault;
    }
}
