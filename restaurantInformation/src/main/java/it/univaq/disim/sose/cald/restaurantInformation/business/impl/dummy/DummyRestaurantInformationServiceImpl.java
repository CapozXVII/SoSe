package it.univaq.disim.sose.cald.restaurantInformation.business.impl.dummy;

import java.util.ArrayList;
import java.util.List;

import it.univaq.disim.sose.cald.restaurantInformation.business.BusinessException;
import it.univaq.disim.sose.cald.restaurantInformation.business.RestaurantInformationService;
import it.univaq.disim.sose.cald.restaurantInformation.business.model.Restaurant;

public class DummyRestaurantInformationServiceImpl implements RestaurantInformationService{

	public List<Restaurant> getRestaurants(String city) throws BusinessException {
		List<Restaurant> result = new ArrayList<Restaurant>();
		return result;
	}

}
