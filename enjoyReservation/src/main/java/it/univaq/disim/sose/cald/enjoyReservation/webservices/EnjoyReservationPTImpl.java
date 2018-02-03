package it.univaq.disim.sose.cald.enjoyreservation.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantResponse;
import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationPT;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantResponse;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateRestaurantFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateRestaurantResponse;
import it.univaq.disim.sose.cald.enjoyreservation.business.EnjoyReservationService;

@Component(value = "EnjoyReservationPTImpl")
public class EnjoyReservationPTImpl implements EnjoyReservationPT{
	
	private static Logger LOGGER = LoggerFactory.getLogger(EnjoyReservationPTImpl.class);
	
	@Autowired
	EnjoyReservationService service;

	@Override
	public GetRestaurantInfoResponse getRestaurantInfo(GetRestaurantInfoRequest parameters)
			throws GetRestaurantInfoFault_Exception {
		LOGGER.info("CALLED getRestaurantInfo ON enjoyreservation");
		GetRestaurantInfoResponse response =  service.getRestaurantInfo(parameters);
		return response;
	}

	@Override
	public UpdateRestaurantResponse updateRestaurant(UpdateRestaurantRequest parameters)
			throws UpdateRestaurantFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateCinemaResponse updateCinema(UpdateCinemaRequest parameters) throws UpdateCinemaFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InsertRestaurantResponse insertRestaurant(InsertRestaurantRequest parameters)
			throws InsertRestaurantFault_Exception {
		LOGGER.info("CALLED insertRestaurant ON enjoyreservation");
		InsertRestaurantResponse response = service.insertRestaurant(parameters);
		return response;
	}

	@Override
	public BookingCinemaResponse cinemaBooking(BookingCinemaRequest parameters) throws BookingCinemaFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingRestaurantResponse restaurantBooking(BookingRestaurantRequest parameters)
			throws BookingRestaurantFault_Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetCinemaInfoResponse getCinemaInfo(GetCinemaInfoRequest parameters) throws GetCinemaInfoFault_Exception {
		LOGGER.info("CALLED getCinemaInfo ON enjoyreservation");
		GetCinemaInfoResponse response = service.getCinemaInfo(parameters);
		return response;
	}

	@Override
	public InsertCinemaResponse insertCinema(InsertCinemaRequest parameters) throws InsertCinemaFault_Exception {
		LOGGER.info("CALLED insertCinema ON enjoyreservation");
		InsertCinemaResponse response = service.insertCinema(parameters);
		return response;
	}

}
