package it.univaq.disim.sose.cald.enjoyreservation.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.cald.enjoyreservation.AccountLoginFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLoginRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLoginResponse;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutResponse;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionResponse;
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
import it.univaq.disim.sose.cald.enjoyreservation.GetSingleCinemaInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetSingleCinemaInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetSingleRestaurantInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetSingleRestaurantInfoResponse;
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
		LOGGER.info("CALLED updateRestaurant ON enjoyreservation");
		UpdateRestaurantResponse response = service.updateRestaurant(parameters);
		return response;
	}

	@Override
	public UpdateCinemaResponse updateCinema(UpdateCinemaRequest parameters) throws UpdateCinemaFault_Exception {
		LOGGER.info("CALLED updateCinema ON enjoyreservation");
		UpdateCinemaResponse response = service.updateCinema(parameters);
		return response;
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
		LOGGER.info("CALLED cinemaBooking ON enjoyreservation");
		BookingCinemaResponse response = service.cinemaBooking(parameters);
		return response;
	}

	@Override
	public BookingRestaurantResponse restaurantBooking(BookingRestaurantRequest parameters)
			throws BookingRestaurantFault_Exception {
		LOGGER.info("CALLED restaurantBooking ON enjoyreservation");
		BookingRestaurantResponse response = service.restaurantBooking(parameters);
		return response;
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

	@Override
	public AccountLoginResponse userLogin(AccountLoginRequest parameters) throws AccountLoginFault_Exception {
		LOGGER.info("CALLED userLogin ON enjoyreservation");
		AccountLoginResponse response = service.userLogin(parameters);
		return response;
	}

	@Override
	public AccountSessionResponse accountSession(AccountSessionRequest parameters) throws AccountSessionFault_Exception {
		LOGGER.info("CALLED checkSession ON enjoyreservation");
		AccountSessionResponse response = service.accountSession(parameters);
		return response;
	}

	@Override
	public AccountLogoutResponse userLogout(AccountLogoutRequest parameters) throws AccountLogoutFault_Exception {
		LOGGER.info("CALLED userLogout ON enjoyreservation");
		AccountLogoutResponse response = service.userLogout(parameters);
		return response;
	}

	@Override
	public GetSingleCinemaInfoResponse getSingleCinemaInfo(GetSingleCinemaInfoRequest parameters) 
			throws GetCinemaInfoFault_Exception {
		LOGGER.info("CALLED getSingleCinemaInfo ON enjoyreservation");
		GetSingleCinemaInfoResponse response = service.getSingleCinemaInfo(parameters);
		return response;
	}

	@Override
	public GetSingleRestaurantInfoResponse getSingleRestaurantInfo(GetSingleRestaurantInfoRequest parameters) 
			throws GetRestaurantInfoFault_Exception {
		LOGGER.info("CALLED getSingleRestaurantInfo ON enjoyreservation");
		GetSingleRestaurantInfoResponse response = service.getSingleRestaurantInfo(parameters);
		return response;
	}

}
