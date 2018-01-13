package it.univaq.disim.sose.cald.restaurantInformation.business.impl.dummy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.restaurantInformation.business.BusinessException;
import it.univaq.disim.sose.cald.restaurantInformation.business.RestaurantInformationService;
import it.univaq.disim.sose.cald.restaurantInformation.business.model.Restaurant;

@Service
public class DummyRestaurantInformationServiceImpl implements RestaurantInformationService{

	@Override
	public List<Restaurant> getRestaurants(String city) throws BusinessException {
		List<Restaurant> result = new ArrayList<Restaurant>();
		return result;
	}

}
