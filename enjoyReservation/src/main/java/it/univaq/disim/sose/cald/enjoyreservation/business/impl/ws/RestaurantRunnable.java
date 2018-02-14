package it.univaq.disim.sose.cald.enjoyreservation.business.impl.ws;

import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationPT;
import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationService;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoResponse;

public class RestaurantRunnable implements Runnable{

	private String city;
	private GetRestaurantInfoResponse response;
	
	public RestaurantRunnable(String city) {
		this.city = city;
		this.response = new GetRestaurantInfoResponse();
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public GetRestaurantInfoResponse getResponse() {
		return response;
	}

	public void setResponse(GetRestaurantInfoResponse response) {
		this.response = response;
	}

	@Override
	public void run() {
		GetRestaurantInfoRequest request = new GetRestaurantInfoRequest();
		request.setCity(this.city);
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		try {
			this.response = enjoyReservation.getRestaurantInfo(request);
		} catch (GetRestaurantInfoFault_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
