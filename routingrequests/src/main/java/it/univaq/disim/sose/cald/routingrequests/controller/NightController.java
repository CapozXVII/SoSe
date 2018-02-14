package it.univaq.disim.sose.cald.routingrequests.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionResponse;
import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationPT;
import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationService;
import it.univaq.disim.sose.cald.enjoyreservation.GetAllInfoFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.GetAllInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetAllInfoResponse;

@RestController
@RequestMapping(value = "/night")
public class NightController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(NightController.class);
	
	@GetMapping("/{token}/information/city/{city}")
	public GetAllInfoResponse getInformation(@PathVariable(value = "token") String token, @PathVariable(value = "city") String city) throws AccountSessionFault_Exception, GetAllInfoFault_Exception {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		GetAllInfoResponse response = new GetAllInfoResponse();
		
		if(checkSession(enjoyReservation, token)) {
			GetAllInfoRequest request = new GetAllInfoRequest();
			request.setCity(city);
			
			response = enjoyReservation.getAllInfo(request);
		} else {
			response = null;
		}
		return response;
	}
	
	public boolean checkSession(EnjoyReservationPT prosumer, String token) throws AccountSessionFault_Exception {
		AccountSessionRequest request = new AccountSessionRequest();
		request.setToken(token);
		AccountSessionResponse response = prosumer.accountSession(request);
		
		return response.isResponse();
	}
	
}
