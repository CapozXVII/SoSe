package it.univaq.disim.sose.cald.accountmanager.business;

import it.univaq.disim.sose.cald.accountmanager.CheckSessionFault_Exception;
import it.univaq.disim.sose.cald.accountmanager.CheckSessionRequest;
import it.univaq.disim.sose.cald.accountmanager.CheckSessionResponse;
import it.univaq.disim.sose.cald.accountmanager.UserLoginFault_Exception;
import it.univaq.disim.sose.cald.accountmanager.UserLoginRequest;
import it.univaq.disim.sose.cald.accountmanager.UserLoginResponse;
import it.univaq.disim.sose.cald.accountmanager.UserLogoutFault_Exception;
import it.univaq.disim.sose.cald.accountmanager.UserLogoutRequest;
import it.univaq.disim.sose.cald.accountmanager.UserLogoutResponse;

public interface AccountManagerService {

	UserLoginResponse userLogin(UserLoginRequest parameters) throws UserLoginFault_Exception;
	
	CheckSessionResponse checkSession(CheckSessionRequest parameters) throws CheckSessionFault_Exception;
	
	UserLogoutResponse userLogout(UserLogoutRequest parameters) throws UserLogoutFault_Exception;
}
