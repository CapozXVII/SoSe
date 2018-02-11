package it.univaq.disim.sose.cald.cinemabooking.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.cald.cinemabooking.CinemaBookingFault_Exception;
import it.univaq.disim.sose.cald.cinemabooking.CinemaBookingRequest;
import it.univaq.disim.sose.cald.cinemabooking.CinemaBookingResponse;
import it.univaq.disim.sose.cald.cinemabooking.business.CinemaBookingService;
import it.univaq.disim.sose.cald.cinemabooking.CinemaBookingPT;
import it.univaq.disim.sose.cald.cinemabooking.CinemaBookingFault_Exception;
import it.univaq.disim.sose.cald.cinemabooking.CinemaBookingRequest;
import it.univaq.disim.sose.cald.cinemabooking.CinemaBookingResponse;
//import it.univaq.disim.sose.cald.cinemaBooking.business.CinemaBookingService;
@Component(value = "CinemaBookingPTImpl")
public class CinemaBookingPTImpl implements CinemaBookingPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CinemaBookingPTImpl.class);
	
	@Autowired
	private CinemaBookingService service;
	
	@Override
	public CinemaBookingResponse cinemaBooking(CinemaBookingRequest parameters) throws CinemaBookingFault_Exception {
		
		try {
			CinemaBookingResponse response = service.insertCinemaBooking(parameters);
			return response;
			
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
		
		
	}

}
