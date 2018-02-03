package it.univaq.disim.sose.cald.enjoyreservation.business;

import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantResponse;

public interface EnjoyReservationService {
	
	GetRestaurantInfoResponse getRestaurantInfo(GetRestaurantInfoRequest request) throws BusinessException;
	
	GetCinemaInfoResponse getCinemaInfo(GetCinemaInfoRequest request) throws BusinessException;
	
	InsertRestaurantResponse insertRestaurant(InsertRestaurantRequest request) throws BusinessException;

	InsertCinemaResponse insertCinema(InsertCinemaRequest request) throws BusinessException;
	
	BookingRestaurantResponse restaurantBooking(BookingRestaurantRequest request) throws BusinessException;
	
	BookingCinemaResponse cinemaBooking(BookingCinemaRequest request) throws BusinessException;
}
