package it.univaq.disim.sose.cald.restaurantInserting.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertFault_Exception;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertRequest;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertResponse;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantPT;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantUpdateFault_Exception;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantUpdateRequest;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantUpdateResponse;
import it.univaq.disim.sose.cald.restaurantInserting.business.RestaurantInsertingService;



@Component(value = "restaurantInsertingPTImpl")
public class restaurantInsertingPTImpl implements RestaurantPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(restaurantInsertingPTImpl.class);
	
	@Autowired
	private RestaurantInsertingService service;

	@Override
	public RestaurantInsertResponse restaurantInsert(RestaurantInsertRequest parameters){
		
		LOGGER.info("CALLED RestaurantInserting");
		try {
			RestaurantInsertResponse response=service.insertRestaurant(parameters);
			return response;
			
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
		
	}

	@Override
	public RestaurantUpdateResponse restaurantUpdate(RestaurantUpdateRequest parameters){
		LOGGER.info("CALLED RestaurantInserting");
		try {
			RestaurantUpdateResponse response=service.updateRestaurant(parameters);
			return response;
			
		}catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

}
