package it.univaq.disim.sose.cald.restaurantBooking.business;

import it.univaq.disim.sose.cald.restaurantBooking.RestaurantBookingResponse;
import it.univaq.disim.sose.cald.restaurantBooking.RestaurantBookingRequest;


public interface RestaurantBookingService {

	RestaurantBookingResponse insertRestaurantBooking(RestaurantBookingRequest parameters) throws BusinessException;
	
}
