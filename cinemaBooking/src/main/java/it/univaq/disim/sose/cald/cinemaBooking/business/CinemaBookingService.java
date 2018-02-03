package it.univaq.disim.sose.cald.cinemabooking.business;

import it.univaq.disim.sose.cald.cinemabooking.CinemaBookingResponse;
import it.univaq.disim.sose.cald.cinemabooking.CinemaBookingRequest;


public interface CinemaBookingService {

	CinemaBookingResponse insertCinemaBooking(CinemaBookingRequest parameters) throws BusinessException;
	
}
