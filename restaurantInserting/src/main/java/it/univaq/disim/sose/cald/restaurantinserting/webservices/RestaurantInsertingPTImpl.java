package it.univaq.disim.sose.cald.restaurantinserting.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.cald.restaurantinserting.RestaurantInsertFault_Exception;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantInsertRequest;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantInsertResponse;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantPT;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantUpdateFault_Exception;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantUpdateRequest;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantUpdateResponse;
import it.univaq.disim.sose.cald.restaurantinserting.business.RestaurantInsertingService;



@Component(value = "RestaurantInsertingPTImpl")
public class RestaurantInsertingPTImpl implements RestaurantPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(RestaurantInsertingPTImpl.class);
	
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

