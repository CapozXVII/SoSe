package it.univaq.disim.sose.cald.restaurantInserting.business.impl.dummy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertRequest;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertResponse;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantUpdateRequest;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantUpdateResponse;
import it.univaq.disim.sose.cald.restaurantInserting.business.BusinessException;
import it.univaq.disim.sose.cald.restaurantInserting.business.RestaurantInsertingService;
import it.univaq.disim.sose.cald.restaurantInserting.business.impl.jdbc.JDBCRestaurantInsertingImpl;

@Service
public class DummyRestaurantInsertingServiceImpl implements RestaurantInsertingService {
	private static Logger LOGGER = LoggerFactory.getLogger(JDBCRestaurantInsertingImpl.class);

	@Override
	public RestaurantInsertResponse insertRestaurant(RestaurantInsertRequest parameters) throws BusinessException {
		RestaurantInsertResponse result = new RestaurantInsertResponse(); 
		result.setAccepted(false); /* controllare se va bene*/
		LOGGER.info("CALLED dummy pollo");
		return result;
	}
	
	@Override
	public RestaurantUpdateResponse updateRestaurant(RestaurantUpdateRequest parameters) throws BusinessException {
		RestaurantUpdateResponse result = new RestaurantUpdateResponse(); 
		result.setAccepted(true);/* controllare se va bene*/
		return result;
	}
}
