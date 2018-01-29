package it.univaq.disim.sose.cald.enjoyReservation.business;

import it.univaq.disim.sose.cald.clients.cinemaInformation.CinemaInformationResponse;
import it.univaq.disim.sose.cald.clients.restaurantInformation.RestaurantInformationRequest;
import it.univaq.disim.sose.cald.clients.restaurantInformation.RestaurantInformationResponse;
import it.univaq.disim.sose.cald.clients.cinemaInformation.CinemaInformationRequest;


public interface EnjoyReservationService {
	
	CinemaInformationResponse getCinemaInformation(CinemaInformationRequest cinemaInformationRequest) throws BusinessException; 

	RestaurantInformationResponse getRestaurantInformationResponse(RestaurantInformationRequest restaurantInformationRequest) throws BusinessException;
}
