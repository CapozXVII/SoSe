package it.univaq.disim.sose.cald.enjoyreservation.business;

import it.univaq.disim.sose.cald.enjoyreservation.AccountLoginRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLoginResponse;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutResponse;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionResponse;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetSingleCinemaInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetSingleCinemaInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetSingleRestaurantInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetSingleRestaurantInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantResponse;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateRestaurantResponse;

public interface EnjoyReservationService {
	
	GetRestaurantInfoResponse getRestaurantInfo(GetRestaurantInfoRequest request) throws BusinessException;
	
	GetCinemaInfoResponse getCinemaInfo(GetCinemaInfoRequest request) throws BusinessException;
	
	GetSingleRestaurantInfoResponse getSingleRestaurantInfo(GetSingleRestaurantInfoRequest request) throws BusinessException;
	
	GetSingleCinemaInfoResponse getSingleCinemaInfo(GetSingleCinemaInfoRequest request) throws BusinessException;
	
	InsertRestaurantResponse insertRestaurant(InsertRestaurantRequest request) throws BusinessException;

	InsertCinemaResponse insertCinema(InsertCinemaRequest request) throws BusinessException;
	
	UpdateRestaurantResponse updateRestaurant(UpdateRestaurantRequest request) throws BusinessException;

	UpdateCinemaResponse updateCinema(UpdateCinemaRequest request) throws BusinessException;
	
	BookingRestaurantResponse restaurantBooking(BookingRestaurantRequest request) throws BusinessException;
	
	BookingCinemaResponse cinemaBooking(BookingCinemaRequest request) throws BusinessException;
	
	AccountLoginResponse userLogin(AccountLoginRequest request) throws BusinessException;
	
	AccountLogoutResponse userLogout(AccountLogoutRequest request) throws BusinessException;
	
	AccountSessionResponse accountSession(AccountSessionRequest request) throws BusinessException;
}
