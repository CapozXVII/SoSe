package it.univaq.disim.sose.cald.cinemabooking.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.cald.cinemabooking.CinemaBookingFault_Exception;
import it.univaq.disim.sose.cald.cinemabooking.CinemaBookingRequest;
import it.univaq.disim.sose.cald.cinemabooking.CinemaBookingResponse;
import it.univaq.disim.sose.cald.cinemabooking.business.CinemaBookingService;
import it.univaq.disim.sose.cald.cinemabooking.CinemaBookingPT;

@Component(value = "CinemaBookingPTImpl")
public class CinemaBookingPTImpl implements CinemaBookingPT {
		
	@Autowired
	private CinemaBookingService service;
	
	@Override
	public CinemaBookingResponse cinemaBooking(CinemaBookingRequest parameters) throws CinemaBookingFault_Exception {
		
		try {
			CinemaBookingResponse response = service.insertCinemaBooking(parameters);
			return response;
			
		} catch (Exception ex) {
			throw new CinemaBookingFault_Exception("Something was wrong with Cinema Booking");
		}
	}
}
