package it.univaq.disim.sose.cald.restaurantinserting.business;

import it.univaq.disim.sose.cald.restaurantinserting.RestaurantDeleteFault_Exception;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantDeleteRequest;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantDeleteResponse;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantInsertFault_Exception;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantInsertRequest;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantInsertResponse;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantUpdateFault_Exception;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantUpdateRequest;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantUpdateResponse;

public interface RestaurantInsertingService {

	RestaurantInsertResponse insertRestaurant(RestaurantInsertRequest parameters) throws RestaurantInsertFault_Exception;
	
	RestaurantUpdateResponse updateRestaurant(RestaurantUpdateRequest parameters) throws RestaurantUpdateFault_Exception;
	
	RestaurantDeleteResponse deleteRestaurant(RestaurantDeleteRequest parameters) throws RestaurantDeleteFault_Exception;
}
