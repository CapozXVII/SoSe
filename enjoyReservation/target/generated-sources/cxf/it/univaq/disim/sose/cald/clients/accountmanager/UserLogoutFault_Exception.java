
package it.univaq.disim.sose.cald.clients.accountmanager;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-02-09T15:04:15.644+01:00
 * Generated source version: 3.2.1
 */

@WebFault(name = "userLogoutFault", targetNamespace = "http://it.univaq.disim.sose.cald/accountManager")
public class UserLogoutFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;
    
    private it.univaq.disim.sose.cald.clients.accountmanager.UserLogoutFault userLogoutFault;

    public UserLogoutFault_Exception() {
        super();
    }
    
    public UserLogoutFault_Exception(String message) {
        super(message);
    }
    
    public UserLogoutFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLogoutFault_Exception(String message, it.univaq.disim.sose.cald.clients.accountmanager.UserLogoutFault userLogoutFault) {
        super(message);
        this.userLogoutFault = userLogoutFault;
    }

    public UserLogoutFault_Exception(String message, it.univaq.disim.sose.cald.clients.accountmanager.UserLogoutFault userLogoutFault, Throwable cause) {
        super(message, cause);
        this.userLogoutFault = userLogoutFault;
    }

    public it.univaq.disim.sose.cald.clients.accountmanager.UserLogoutFault getFaultInfo() {
        return this.userLogoutFault;
    }
}
