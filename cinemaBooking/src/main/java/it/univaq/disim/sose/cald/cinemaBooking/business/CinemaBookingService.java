package it.univaq.disim.sose.cald.cinemaBooking.business;

import it.univaq.disim.sose.cald.cinemaBooking.CinemaBookingResponse;
import it.univaq.disim.sose.cald.cinemaBooking.CinemaBookingRequest;


public interface CinemaBookingService {

	CinemaBookingResponse insertCinemaBooking(CinemaBookingRequest parameters) throws BusinessException;
	
}
