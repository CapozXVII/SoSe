package it.univaq.disim.sose.cald.enjoyreservation.business;

import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoResponse;

public interface EnjoyReservationService {
	
	GetRestaurantInfoResponse getRestaurantInfo(GetRestaurantInfoRequest request) throws BusinessException;
	
	GetCinemaInfoResponse getCinemaInfo(GetCinemaInfoRequest request) throws BusinessException;

}
