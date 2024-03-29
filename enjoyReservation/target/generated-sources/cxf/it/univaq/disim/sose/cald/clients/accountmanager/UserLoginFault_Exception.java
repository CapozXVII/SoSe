
package it.univaq.disim.sose.cald.clients.accountmanager;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.1
 * 2018-02-14T17:20:34.580+01:00
 * Generated source version: 3.2.1
 */

@WebFault(name = "userLoginFault", targetNamespace = "http://it.univaq.disim.sose.cald/accountManager")
public class UserLoginFault_Exception extends Exception {
    public static final long serialVersionUID = 1L;
    
    private it.univaq.disim.sose.cald.clients.accountmanager.UserLoginFault userLoginFault;

    public UserLoginFault_Exception() {
        super();
    }
    
    public UserLoginFault_Exception(String message) {
        super(message);
    }
    
    public UserLoginFault_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLoginFault_Exception(String message, it.univaq.disim.sose.cald.clients.accountmanager.UserLoginFault userLoginFault) {
        super(message);
        this.userLoginFault = userLoginFault;
    }

    public UserLoginFault_Exception(String message, it.univaq.disim.sose.cald.clients.accountmanager.UserLoginFault userLoginFault, Throwable cause) {
        super(message, cause);
        this.userLoginFault = userLoginFault;
    }

    public it.univaq.disim.sose.cald.clients.accountmanager.UserLoginFault getFaultInfo() {
        return this.userLoginFault;
    }
}
