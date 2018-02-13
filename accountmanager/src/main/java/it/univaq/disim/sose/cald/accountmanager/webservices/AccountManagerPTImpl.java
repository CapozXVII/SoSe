package it.univaq.disim.sose.cald.accountmanager.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.cald.accountmanager.AccountManagerPT;
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
import it.univaq.disim.sose.cald.accountmanager.business.AccountManagerService;

@Component(value = "AccountManagerPTImpl")
public class AccountManagerPTImpl implements AccountManagerPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(AccountManagerPTImpl.class);
	
	@Autowired
	AccountManagerService service;

	@Override
	public UserLoginResponse userLogin(UserLoginRequest parameters) throws UserLoginFault_Exception {
		LOGGER.info("called User Login in Account Service");
		UserLoginResponse response = new UserLoginResponse();
		response = service.userLogin(parameters);
		return response;
	}

	@Override
	public UserLogoutResponse userLogout(UserLogoutRequest parameters) throws UserLogoutFault_Exception {
		LOGGER.info("called User Logout in Account Service");
		UserLogoutResponse response = new UserLogoutResponse();
		response = service.userLogout(parameters);
		return response;
	}

	@Override
	public CheckSessionResponse checkSession(CheckSessionRequest parameters) throws CheckSessionFault_Exception {
		LOGGER.info("called Check Session in Account Service");
		CheckSessionResponse response = new CheckSessionResponse();
		response = service.checkSession(parameters);
		return response;
	}

	@Override
	public UserSignupResponse userSignup(UserSignupRequest parameters) throws UserSignupFault_Exception {
		LOGGER.info("called User Signup in Account Service");
		UserSignupResponse response = new UserSignupResponse();
		response = service.userSignup(parameters);
		return response;
	}

	@Override
	public CheckRestaurantOwnerResponse checkRestaurantOwner(CheckRestaurantOwnerRequest parameters)
			throws CheckRestaurantOwnerFault_Exception {
		LOGGER.info("called Check Restaurant Owner in Account Service");
		CheckRestaurantOwnerResponse response = new CheckRestaurantOwnerResponse();
		response = service.checkRestaurantOwner(parameters);
		return response;
	}

	@Override
	public CheckCinemaOwnerResponse checkCinemaOwner(CheckCinemaOwnerRequest parameters)
			throws CheckCinemaOwnerFault_Exception {
		LOGGER.info("called Check Cinema Owner in Account Service");
		CheckCinemaOwnerResponse response = new CheckCinemaOwnerResponse();
		response = service.checkCinemaOwner(parameters);
		return response;
	}

}
