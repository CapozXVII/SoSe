package it.univaq.disim.sose.cald.restaurantInformation.webservices;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.cald.restaurantInformation.DiscountType;
import it.univaq.disim.sose.cald.restaurantInformation.RestaurantInfoType;
import it.univaq.disim.sose.cald.restaurantInformation.RestaurantInformationPT;
import it.univaq.disim.sose.cald.restaurantInformation.RestaurantInformationRequest;
import it.univaq.disim.sose.cald.restaurantInformation.RestaurantInformationResponse;
import it.univaq.disim.sose.cald.restaurantInformation.RestaurantType;
import it.univaq.disim.sose.cald.restaurantInformation.TableType;
import it.univaq.disim.sose.cald.restaurantInformation.business.RestaurantInformationService;
import it.univaq.disim.sose.cald.restaurantInformation.business.model.Restaurant;

@Component(value = "RestaurantInformationPTImpl")
public class RestaurantInformationPTImpl implements RestaurantInformationPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(RestaurantInformationPTImpl.class);
	
	@Autowired
	RestaurantInformationService service;
	
	public RestaurantInformationResponse restaurantInformation(RestaurantInformationRequest parameters) {
		
		LOGGER.info("CALLED cinemaInformation");
		try {
			List<Restaurant> restaurants = service.getRestaurants(parameters.getCity());
			List<TableType> tables = new ArrayList<TableType>();
			RestaurantInformationResponse response = new RestaurantInformationResponse();
			
			for(Restaurant restaurant : restaurants) {
				RestaurantInfoType osmRestaurantInfoType = new RestaurantInfoType();
				RestaurantType osmRestaurantType = new RestaurantType();
				DiscountType osmDiscountType = new DiscountType();
				for(int i = 0; i < restaurant.getTables().size(); i++) {
					TableType osmTableType = new TableType();
					osmTableType.setNumber(restaurant.getTables().get(i).getNumber());
					osmTableType.setSeatsNumber(restaurant.getTables().get(i).getSeatsNumber());
					tables.add(osmTableType);
				}
				osmRestaurantInfoType.setAddress(restaurant.getAddress());
				osmRestaurantInfoType.setCap(restaurant.getCap());
				osmRestaurantInfoType.setCity(restaurant.getCity());
				osmRestaurantInfoType.setCuisine(restaurant.getCousine());
				osmRestaurantInfoType.setMenu(restaurant.getMenu());
				osmRestaurantInfoType.setName(restaurant.getName());
				osmRestaurantInfoType.setStyle(restaurant.getStyle());
				osmRestaurantInfoType.setTelephoneNumber(restaurant.getTelephoneNumber());
				osmDiscountType.setCinema(restaurant.getDiscount().getCinema().getName());
				osmDiscountType.setPrice(restaurant.getDiscount().getPrice());
				osmRestaurantInfoType.setDiscount(osmDiscountType);
				osmRestaurantType.setLat(restaurant.getLatitude());
				osmRestaurantType.setLon(restaurant.getLongitude());
				osmRestaurantType.setRestaurantInfo(osmRestaurantInfoType);
				response.getRestaurants().add(osmRestaurantType);
			}
			return response;
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}
}
