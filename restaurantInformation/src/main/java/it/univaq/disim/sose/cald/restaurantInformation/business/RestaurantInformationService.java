package it.univaq.disim.sose.cald.restaurantInformation.business;

import java.util.List;

import it.univaq.disim.sose.cald.restaurantInformation.business.model.Restaurant;

public interface RestaurantInformationService {

	List<Restaurant> getRestaurants(String city) throws BusinessException;
}
