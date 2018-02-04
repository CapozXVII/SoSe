package it.univaq.disim.sose.cald.restaurantbooking.business;

import it.univaq.disim.sose.cald.restaurantbooking.RestaurantBookingResponse;
import it.univaq.disim.sose.cald.restaurantbooking.RestaurantBookingRequest;


public interface RestaurantBookingService {

	RestaurantBookingResponse insertRestaurantBooking(RestaurantBookingRequest parameters) throws BusinessException;
	
}
