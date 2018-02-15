package it.univaq.disim.sose.cald.enjoyreservation.business.impl.ws;

import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationPT;
import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationService;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoResponse;

public class CinemaRunnable implements Runnable{
		
	private String city;
	private GetCinemaInfoResponse response;
	
	public CinemaRunnable(String city) {
		this.city = city;
		this.response = new GetCinemaInfoResponse();
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public GetCinemaInfoResponse getResponse() {
		return this.response;
	}

	public void setResponse(GetCinemaInfoResponse response) {
		this.response = response;
	}

	@Override
	public void run() {
		GetCinemaInfoRequest request = new GetCinemaInfoRequest();
		request.setCity(this.city);
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();		
		try {
			this.response = enjoyReservation.getCinemaInfo(request);
			
		} catch (GetCinemaInfoFault_Exception e) {
			e.printStackTrace();
		}	
	}

}
