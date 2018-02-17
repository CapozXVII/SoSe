package it.univaq.disim.sose.cald.routingrequests.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.disim.sose.cald.enjoyreservation.AccountLoginFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLoginRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLoginResponse;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutResponse;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSignupFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSignupRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSignupResponse;
import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationPT;
import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationService;
import it.univaq.disim.sose.cald.routingrequests.model.User;

@RestController
public class AccountController {
	
	@PostMapping("/signup")
	public AccountSignupResponse signup(@RequestBody User user) throws AccountSignupFault_Exception  {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		AccountSignupResponse response = new AccountSignupResponse();
		AccountSignupRequest request = new AccountSignupRequest();
		
		request.setEmail(user.getEmail());
		request.setPassword(user.getPassword());
		request.setName(user.getName());
		request.setSurname(user.getSurname());
		request.setUsername(user.getUsername());
		response = enjoyReservation.userSignup(request);
	
		return response;
	}
	
	@PostMapping("/login")
	public AccountLoginResponse login(@RequestBody User user) throws AccountLoginFault_Exception {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		AccountLoginResponse response = new AccountLoginResponse();
		AccountLoginRequest request = new AccountLoginRequest();
		
		request.setEmail(user.getEmail());
		request.setPassword(user.getPassword());
		response = enjoyReservation.userLogin(request);
	
		return response;
	}
	
	@DeleteMapping("/logout/{token}")
	public AccountLogoutResponse logout(@PathVariable String token) throws AccountLogoutFault_Exception {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		AccountLogoutResponse response = new AccountLogoutResponse();
		AccountLogoutRequest request = new AccountLogoutRequest();
		
		request.setToken(token);
		response = enjoyReservation.userLogout(request);
	
		return response;
	}

}
