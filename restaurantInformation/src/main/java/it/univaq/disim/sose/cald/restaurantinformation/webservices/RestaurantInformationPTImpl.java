package it.univaq.disim.sose.cald.restaurantinformation.webservices;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.cald.restaurantinformation.DiscountType;
import it.univaq.disim.sose.cald.restaurantinformation.RestaurantInfoType;
import it.univaq.disim.sose.cald.restaurantinformation.RestaurantInformationFault_Exception;
import it.univaq.disim.sose.cald.restaurantinformation.RestaurantInformationPT;
import it.univaq.disim.sose.cald.restaurantinformation.RestaurantInformationRequest;
import it.univaq.disim.sose.cald.restaurantinformation.RestaurantInformationResponse;
import it.univaq.disim.sose.cald.restaurantinformation.RestaurantType;
import it.univaq.disim.sose.cald.restaurantinformation.SingleRestaurantInformationRequest;
import it.univaq.disim.sose.cald.restaurantinformation.SingleRestaurantInformationResponse;
import it.univaq.disim.sose.cald.restaurantinformation.business.RestaurantInformationService;
import it.univaq.disim.sose.cald.restaurantinformation.business.model.Restaurant;

@Component(value = "RestaurantInformationPTImpl")
public class RestaurantInformationPTImpl implements RestaurantInformationPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(RestaurantInformationPTImpl.class);
	
	@Autowired
	RestaurantInformationService service;
	
	public RestaurantInformationResponse restaurantInformation(RestaurantInformationRequest parameters) throws RestaurantInformationFault_Exception  {
		
		LOGGER.info("CALLED RestaurantInformation");
		try {
			List<Restaurant> restaurants = service.getRestaurants(parameters.getCity());
			RestaurantInformationResponse response = new RestaurantInformationResponse();
			
			for(Restaurant restaurant : restaurants) {
				RestaurantInfoType osmRestaurantInfoType = new RestaurantInfoType();
				RestaurantType osmRestaurantType = new RestaurantType();
				DiscountType osmDiscountType = new DiscountType();
		
				osmRestaurantInfoType.setAddress(restaurant.getAddress());
				osmRestaurantInfoType.setCap(restaurant.getCap());
				osmRestaurantInfoType.setCity(restaurant.getCity());
				osmRestaurantInfoType.setCuisine(restaurant.getCousine());
				osmRestaurantInfoType.setMenu(restaurant.getMenu());
				osmRestaurantInfoType.setName(restaurant.getName());
				osmRestaurantInfoType.setStyle(restaurant.getStyle());
				osmRestaurantInfoType.setMaxSeats(restaurant.getMaxSeats());
				osmRestaurantInfoType.setTelephoneNumber(restaurant.getTelephoneNumber());
				osmRestaurantInfoType.setId(restaurant.getId());
				if (restaurant.getDiscount() != null) {
					osmDiscountType.setCinema(restaurant.getDiscount().getCinema());
					osmDiscountType.setPrice(restaurant.getDiscount().getPrice());
					osmDiscountType.setDiscountId(restaurant.getDiscount().getId());
				} else {
					osmDiscountType = null;
				}
				osmRestaurantInfoType.setDiscount(osmDiscountType);
				osmRestaurantType.setLat(restaurant.getLatitude());
				osmRestaurantType.setLon(restaurant.getLongitude());
				osmRestaurantType.setRestaurantInfo(osmRestaurantInfoType);
				response.getRestaurants().add(osmRestaurantType);
			}
			return response;
		} catch (Exception ex) {
			throw new RestaurantInformationFault_Exception("Something was wrong with response");
		}
	}

	
	public SingleRestaurantInformationResponse singleRestaurantInformation(
			SingleRestaurantInformationRequest parameters) throws RestaurantInformationFault_Exception {
		LOGGER.info("CALLED SingleRestaurantInformation");
		
		Restaurant restaurant = service.getSingleRestaurant(parameters.getId());
		SingleRestaurantInformationResponse response = new SingleRestaurantInformationResponse();
		
		RestaurantInfoType osmRestaurantInfoType = new RestaurantInfoType();
		RestaurantType osmRestaurantType = new RestaurantType();
		DiscountType osmDiscountType = new DiscountType();

		osmRestaurantInfoType.setAddress(restaurant.getAddress());
		osmRestaurantInfoType.setCap(restaurant.getCap());
		osmRestaurantInfoType.setCity(restaurant.getCity());
		osmRestaurantInfoType.setCuisine(restaurant.getCousine());
		osmRestaurantInfoType.setMenu(restaurant.getMenu());
		osmRestaurantInfoType.setName(restaurant.getName());
		osmRestaurantInfoType.setStyle(restaurant.getStyle());
		osmRestaurantInfoType.setMaxSeats(restaurant.getMaxSeats());
		osmRestaurantInfoType.setTelephoneNumber(restaurant.getTelephoneNumber());
		osmRestaurantInfoType.setId(restaurant.getId());
		if (restaurant.getDiscount() != null) {
			osmDiscountType.setCinema(restaurant.getDiscount().getCinema());
			osmDiscountType.setPrice(restaurant.getDiscount().getPrice());
			osmDiscountType.setDiscountId(restaurant.getDiscount().getId());
		} else {
			osmDiscountType = null;
		}
		osmRestaurantInfoType.setDiscount(osmDiscountType);
		osmRestaurantType.setLat(restaurant.getLatitude());
		osmRestaurantType.setLon(restaurant.getLongitude());
		osmRestaurantType.setRestaurantInfo(osmRestaurantInfoType);
		response.setRestaurant(osmRestaurantType);
		return response;
	}
}
