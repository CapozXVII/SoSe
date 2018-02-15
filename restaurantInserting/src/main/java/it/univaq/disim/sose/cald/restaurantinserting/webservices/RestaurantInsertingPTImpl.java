package it.univaq.disim.sose.cald.restaurantinserting.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.cald.restaurantinserting.RestaurantDeleteFault_Exception;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantDeleteRequest;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantDeleteResponse;
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
	public RestaurantInsertResponse restaurantInsert(RestaurantInsertRequest parameters) throws RestaurantInsertFault_Exception{
		
		LOGGER.info("CALLED RestaurantInserting");
		try {
			RestaurantInsertResponse response=service.insertRestaurant(parameters);
			return response;
			
		} catch (Exception ex) {
			throw new RestaurantInsertFault_Exception("Something was wrong with Restaurant Inserting");
		}
		
	}

	@Override
	public RestaurantUpdateResponse restaurantUpdate(RestaurantUpdateRequest parameters) throws RestaurantUpdateFault_Exception{
		LOGGER.info("CALLED RestaurantInserting");
		
		try {
			RestaurantUpdateResponse response=service.updateRestaurant(parameters);
			return response;
			
		}catch (Exception ex) {
			throw new RestaurantUpdateFault_Exception("Something was wrong with Restaurant Update");
		}
	}

	@Override
	public RestaurantDeleteResponse restaurantDelete(RestaurantDeleteRequest parameters) throws RestaurantDeleteFault_Exception {
		LOGGER.info("CALLED Restaurant - delete");

		try {
			RestaurantDeleteResponse response = service.deleteRestaurant(parameters);
			return response;

		} catch (Exception ex) {
			throw new RestaurantDeleteFault_Exception("Something was wrong with Restaurant Delete");
		}

		
	}

}

