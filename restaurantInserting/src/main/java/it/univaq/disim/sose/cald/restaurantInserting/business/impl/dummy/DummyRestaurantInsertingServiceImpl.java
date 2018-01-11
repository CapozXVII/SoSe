package it.univaq.disim.sose.cald.restaurantInserting.business.impl.dummy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertRequest;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertResponse;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantUpdateRequest;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantUpdateResponse;
import it.univaq.disim.sose.cald.restaurantInserting.business.BusinessException;
import it.univaq.disim.sose.cald.restaurantInserting.business.RestaurantInsertingService;
import it.univaq.disim.sose.cald.restaurantInserting.business.Model.Restaurant;
import it.univaq.disim.sose.cald.restaurantInserting.business.Model.Table;

@Service
public class DummyRestaurantInsertingServiceImpl implements RestaurantInsertingService {
	
	@Override
	public RestaurantInsertResponse insertRestaurant(RestaurantInsertRequest parameters) throws BusinessException {
		RestaurantInsertResponse result= new RestaurantInsertResponse(); 
		result.setAccepted(true); /* controllare se va bene*/
		return result;
	}
	
	@Override
	public RestaurantUpdateResponse updateRestaurant(RestaurantUpdateRequest parameters) throws BusinessException {
		RestaurantUpdateResponse result= new RestaurantUpdateResponse(); 
		result.setAccepted(true);/* controllare se va bene*/
		return result;
	}
	
	

}
