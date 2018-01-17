package it.univaq.disim.sose.cald.restaurantInformation.business.impl.dummy;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.restaurantInformation.business.BusinessException;
import it.univaq.disim.sose.cald.restaurantInformation.business.RestaurantInformationService;
import it.univaq.disim.sose.cald.restaurantInformation.business.model.Restaurant;
import it.univaq.disim.sose.cald.restaurantInformation.webservices.RestaurantInformationPTImpl;

@Service
public class DummyRestaurantInformationServiceImpl implements RestaurantInformationService{
	private static Logger LOGGER = LoggerFactory.getLogger(RestaurantInformationPTImpl.class);


	@Override
	public List<Restaurant> getRestaurants(String city) throws BusinessException {
		LOGGER.info("CIAO");
		List<Restaurant> result = new ArrayList<Restaurant>();
		return result;
	}

}
