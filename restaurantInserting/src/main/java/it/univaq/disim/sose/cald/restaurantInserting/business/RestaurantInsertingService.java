package it.univaq.disim.sose.cald.restaurantInserting.business;

import it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertRequest;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertResponse;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantUpdateRequest;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantUpdateResponse;

public interface RestaurantInsertingService {
	/*dubbi tables*/
	RestaurantInsertResponse insertRestaurant(RestaurantInsertRequest parameters) throws BusinessException;
	
	RestaurantUpdateResponse updateRestaurant(RestaurantUpdateRequest parameters) throws BusinessException;
}
