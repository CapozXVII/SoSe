package it.univaq.disim.sose.cald.enjoyreservation.business;

import it.univaq.disim.sose.cald.enjoyreservation.AccountLoginFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLoginRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLoginResponse;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutResponse;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionResponse;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSignupFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSignupRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSignupResponse;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantResponse;
import it.univaq.disim.sose.cald.enjoyreservation.CinemaOwnerFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.CinemaOwnerRequest;
import it.univaq.disim.sose.cald.enjoyreservation.CinemaOwnerResponse;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteRestaurantFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteRestaurantResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetAllInfoFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.GetAllInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetAllInfoResponse;
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
import it.univaq.disim.sose.cald.enjoyreservation.RestaurantOwnerFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.RestaurantOwnerRequest;
import it.univaq.disim.sose.cald.enjoyreservation.RestaurantOwnerResponse;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateRestaurantFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateRestaurantResponse;

public interface EnjoyReservationService {
	
	GetRestaurantInfoResponse getRestaurantInfo(GetRestaurantInfoRequest request) throws GetRestaurantInfoFault_Exception;
	
	GetCinemaInfoResponse getCinemaInfo(GetCinemaInfoRequest request) throws GetCinemaInfoFault_Exception;
	
	GetSingleRestaurantInfoResponse getSingleRestaurantInfo(GetSingleRestaurantInfoRequest request) throws GetRestaurantInfoFault_Exception;
	
	GetSingleCinemaInfoResponse getSingleCinemaInfo(GetSingleCinemaInfoRequest request) throws GetCinemaInfoFault_Exception;
	
	InsertRestaurantResponse insertRestaurant(InsertRestaurantRequest request) throws InsertRestaurantFault_Exception;

	InsertCinemaResponse insertCinema(InsertCinemaRequest request) throws InsertCinemaFault_Exception;
	
	UpdateRestaurantResponse updateRestaurant(UpdateRestaurantRequest request) throws UpdateRestaurantFault_Exception;

	UpdateCinemaResponse updateCinema(UpdateCinemaRequest request) throws UpdateCinemaFault_Exception;
	
	BookingRestaurantResponse restaurantBooking(BookingRestaurantRequest request) throws BookingRestaurantFault_Exception;
	
	BookingCinemaResponse cinemaBooking(BookingCinemaRequest request) throws BookingCinemaFault_Exception;
	
	AccountSignupResponse userSignup(AccountSignupRequest request) throws AccountSignupFault_Exception;
	
	AccountLoginResponse userLogin(AccountLoginRequest request) throws AccountLoginFault_Exception;
	
	AccountLogoutResponse userLogout(AccountLogoutRequest request) throws AccountLogoutFault_Exception;
	
	AccountSessionResponse accountSession(AccountSessionRequest request) throws AccountSessionFault_Exception;
	
	CinemaOwnerResponse checkCinemaOwner(CinemaOwnerRequest request) throws CinemaOwnerFault_Exception;
	
	RestaurantOwnerResponse checkRestaurantOwner(RestaurantOwnerRequest request) throws RestaurantOwnerFault_Exception;
	
	DeleteCinemaResponse deleteCinema(DeleteCinemaRequest request) throws DeleteCinemaFault_Exception;
	
	DeleteRestaurantResponse deleteRestautant(DeleteRestaurantRequest request) throws DeleteRestaurantFault_Exception;
	
	GetAllInfoResponse getAllInfo(GetAllInfoRequest request) throws GetAllInfoFault_Exception;
}
