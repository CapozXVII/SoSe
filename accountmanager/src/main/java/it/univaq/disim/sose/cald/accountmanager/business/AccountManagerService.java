package it.univaq.disim.sose.cald.accountmanager.business;

import it.univaq.disim.sose.cald.accountmanager.CheckCinemaOwnerFault_Exception;
import it.univaq.disim.sose.cald.accountmanager.CheckCinemaOwnerRequest;
import it.univaq.disim.sose.cald.accountmanager.CheckCinemaOwnerResponse;
import it.univaq.disim.sose.cald.accountmanager.CheckRestaurantOwnerFault_Exception;
import it.univaq.disim.sose.cald.accountmanager.CheckRestaurantOwnerRequest;
import it.univaq.disim.sose.cald.accountmanager.CheckRestaurantOwnerResponse;
import it.univaq.disim.sose.cald.accountmanager.CheckSessionFault_Exception;
import it.univaq.disim.sose.cald.accountmanager.CheckSessionRequest;
import it.univaq.disim.sose.cald.accountmanager.CheckSessionResponse;
import it.univaq.disim.sose.cald.accountmanager.UserLoginFault_Exception;
import it.univaq.disim.sose.cald.accountmanager.UserLoginRequest;
import it.univaq.disim.sose.cald.accountmanager.UserLoginResponse;
import it.univaq.disim.sose.cald.accountmanager.UserLogoutFault_Exception;
import it.univaq.disim.sose.cald.accountmanager.UserLogoutRequest;
import it.univaq.disim.sose.cald.accountmanager.UserLogoutResponse;
import it.univaq.disim.sose.cald.accountmanager.UserSignupFault_Exception;
import it.univaq.disim.sose.cald.accountmanager.UserSignupRequest;
import it.univaq.disim.sose.cald.accountmanager.UserSignupResponse;

public interface AccountManagerService {
	
	UserSignupResponse userSignup(UserSignupRequest parameters) throws UserSignupFault_Exception;

	UserLoginResponse userLogin(UserLoginRequest parameters) throws UserLoginFault_Exception;
	
	CheckSessionResponse checkSession(CheckSessionRequest parameters) throws CheckSessionFault_Exception;
	
	UserLogoutResponse userLogout(UserLogoutRequest parameters) throws UserLogoutFault_Exception;
	
	CheckCinemaOwnerResponse checkCinemaOwner(CheckCinemaOwnerRequest parameters) throws CheckCinemaOwnerFault_Exception;
	
	CheckRestaurantOwnerResponse checkRestaurantOwner(CheckRestaurantOwnerRequest parameters) throws CheckRestaurantOwnerFault_Exception;
}
