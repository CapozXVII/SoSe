package it.univaq.disim.sose.cald.restaurantinformation.business;

import java.util.List;

import it.univaq.disim.sose.cald.restaurantinformation.RestaurantInformationFault_Exception;
import it.univaq.disim.sose.cald.restaurantinformation.business.model.Restaurant;

public interface RestaurantInformationService {

	List<Restaurant> getRestaurants(String city) throws RestaurantInformationFault_Exception;
	
	Restaurant getSingleRestaurant(long id)  throws RestaurantInformationFault_Exception;
}
