package it.univaq.disim.sose.cald.routingrequests.controller;

import org.springframework.web.bind.annotation.GetMapping;
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
import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationPT;
import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationService;
import it.univaq.disim.sose.cald.routingrequests.model.User;

@RestController
public class AccountController {
	
	@PostMapping("/login")
	public AccountLoginResponse login(@RequestBody User user) throws AccountLoginFault_Exception  {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		AccountLoginResponse response = new AccountLoginResponse();
		AccountLoginRequest request = new AccountLoginRequest();
		
		request.setEmail(user.getEmail());
		request.setPassword(user.getPassword());
		response = enjoyReservation.userLogin(request);
	
		return response;
	}
	
	@GetMapping("/logout/{token}")
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
