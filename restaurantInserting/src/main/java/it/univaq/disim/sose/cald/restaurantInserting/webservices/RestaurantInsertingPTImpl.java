package it.univaq.disim.sose.cald.restaurantInserting.webservices;

import org.springframework.stereotype.Component;

import it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertFault_Exception;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertRequest;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertResponse;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantPT;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantUpdateFault_Exception;

@Component(value = "RestaurantInsertingPTImpl")
public class RestaurantInsertingPTImpl implements RestaurantPT {

	@Override
	public RestaurantInsertResponse restaurantInsert(RestaurantInsertRequest parameters)
			throws RestaurantInsertFault_Exception {
		return null;
	}

	@Override
	public RestaurantInsertResponse restaurantUpdate(RestaurantInsertRequest parameters)
			throws RestaurantUpdateFault_Exception {
		return null;
	}

}
