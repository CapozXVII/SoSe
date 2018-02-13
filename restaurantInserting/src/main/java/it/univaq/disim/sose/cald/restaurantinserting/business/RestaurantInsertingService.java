package it.univaq.disim.sose.cald.restaurantinserting.business;

import it.univaq.disim.sose.cald.restaurantinserting.RestaurantDeleteRequest;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantDeleteResponse;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantInsertRequest;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantInsertResponse;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantUpdateRequest;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantUpdateResponse;

public interface RestaurantInsertingService {
	/*dubbi tables*/
	RestaurantInsertResponse insertRestaurant(RestaurantInsertRequest parameters) throws BusinessException;
	
	RestaurantUpdateResponse updateRestaurant(RestaurantUpdateRequest parameters) throws BusinessException;
	
	RestaurantDeleteResponse deleteRestaurant(RestaurantDeleteRequest parameters) throws BusinessException;
}
