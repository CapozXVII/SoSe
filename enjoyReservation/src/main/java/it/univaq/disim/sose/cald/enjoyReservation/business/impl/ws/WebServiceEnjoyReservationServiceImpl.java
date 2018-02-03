package it.univaq.disim.sose.cald.enjoyreservation.business.impl.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationFault_Exception;
import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationPT;
import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationRequest;
import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationResponse;
import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationService;
import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaType;
import it.univaq.disim.sose.cald.clients.cinemainformation.HallType;
import it.univaq.disim.sose.cald.clients.restaurantinformation.DiscountType;
import it.univaq.disim.sose.cald.clients.restaurantinformation.RestaurantInfoType;
import it.univaq.disim.sose.cald.clients.restaurantinformation.RestaurantInformationFault_Exception;
import it.univaq.disim.sose.cald.clients.restaurantinformation.RestaurantInformationPT;
import it.univaq.disim.sose.cald.clients.restaurantinformation.RestaurantInformationRequest;
import it.univaq.disim.sose.cald.clients.restaurantinformation.RestaurantInformationResponse;
import it.univaq.disim.sose.cald.clients.restaurantinformation.RestaurantInformationService;
import it.univaq.disim.sose.cald.clients.restaurantinformation.RestaurantType;
import it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantInsertFault_Exception;
import it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantInsertRequest;
import it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantInsertResponse;
import it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantInsertingService;
import it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantPT;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantResponse;
import it.univaq.disim.sose.cald.enjoyreservation.OSMCinemaInfoType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMCinemaType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMDiscountType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMFilmType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMHallInfoType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMHallType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMRestaurantInfoType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMRestaurantType;
import it.univaq.disim.sose.cald.enjoyreservation.business.BusinessException;
import it.univaq.disim.sose.cald.enjoyreservation.business.EnjoyReservationService;

@Service
public class WebServiceEnjoyReservationServiceImpl implements EnjoyReservationService {

	@Override
	public GetRestaurantInfoResponse getRestaurantInfo(GetRestaurantInfoRequest request) throws BusinessException {
		GetRestaurantInfoResponse response = new GetRestaurantInfoResponse();
		List<RestaurantType> restaurants = new ArrayList<RestaurantType>();
		List<OSMRestaurantType> restaurantsResponse = new ArrayList<OSMRestaurantType>();
		
		RestaurantInformationService restaurantInformationService = new RestaurantInformationService();
		RestaurantInformationPT restaurantInformation = restaurantInformationService.getRestaurantInformationPort();
		RestaurantInformationRequest restaurantInformationRequest = new RestaurantInformationRequest();
		restaurantInformationRequest.setCity(request.getCity());
		try {
			RestaurantInformationResponse restaurantInformationResponse = restaurantInformation.restaurantInformation(restaurantInformationRequest);
			restaurants = restaurantInformationResponse.getRestaurants();
			for(RestaurantType restaurant : restaurants) {
				OSMRestaurantType newRestaurant = new OSMRestaurantType();
				OSMRestaurantInfoType newRestaurantInfo = new OSMRestaurantInfoType();
				OSMDiscountType newDiscount = new OSMDiscountType();
				
				if(restaurant.getRestaurantInfo().getDiscount() != null) {
					newDiscount.setPrice(restaurant.getRestaurantInfo().getDiscount().getPrice());
					newDiscount.setCinema(restaurant.getRestaurantInfo().getDiscount().getCinema());
				} else {
					newDiscount = null;
				}
				newRestaurantInfo.setDiscount(newDiscount);
				newRestaurantInfo.setAddress(restaurant.getRestaurantInfo().getAddress());
				newRestaurantInfo.setCap(restaurant.getRestaurantInfo().getCap());
				newRestaurantInfo.setCity(restaurant.getRestaurantInfo().getCity());
				newRestaurantInfo.setCuisine(restaurant.getRestaurantInfo().getCuisine());
				newRestaurantInfo.setMenu(restaurant.getRestaurantInfo().getMenu());
				newRestaurantInfo.setName(restaurant.getRestaurantInfo().getName());
				newRestaurantInfo.setStyle(restaurant.getRestaurantInfo().getStyle());
				newRestaurantInfo.setTelephoneNumber(restaurant.getRestaurantInfo().getTelephoneNumber());
				newRestaurant.setRestaurantInfo(newRestaurantInfo);
				newRestaurant.setLat(restaurant.getLat());
				newRestaurant.setLon(restaurant.getLon());
				restaurantsResponse.add(newRestaurant);
			}
			response.setRestaurants(restaurantsResponse);
		} catch (RestaurantInformationFault_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public GetCinemaInfoResponse getCinemaInfo(GetCinemaInfoRequest request) throws BusinessException {
		GetCinemaInfoResponse response = new GetCinemaInfoResponse();
		List<CinemaType> cinemas = new ArrayList<CinemaType>();
		List<OSMCinemaType> cinemasResponse = new ArrayList<OSMCinemaType>();
		List<OSMHallType> hallResponse = new ArrayList<OSMHallType>();
		
		CinemaInformationService cinemaInformationService = new CinemaInformationService();
		CinemaInformationPT cinemaInformation = cinemaInformationService.getCinemaInformationPort();
		CinemaInformationRequest cinemaInformationRequest = new CinemaInformationRequest();
		cinemaInformationRequest.setCity(request.getCity());
		try {
			CinemaInformationResponse cinemaInformationResponse = cinemaInformation.cinemaInformation(cinemaInformationRequest);
			cinemas = cinemaInformationResponse.getCinemas();
			for(CinemaType cinema : cinemas) {
				OSMCinemaType newCinema = new OSMCinemaType();
				OSMCinemaInfoType newCinemaInfo = new OSMCinemaInfoType();
				
				for(HallType hall : cinema.getCinemaInfo().getHall()) {
					OSMHallType newHall = new OSMHallType();
					OSMHallInfoType newHallInfo = new OSMHallInfoType();
					OSMFilmType newFilm = new OSMFilmType();
					newFilm.setCast(hall.getHallInfo().getFilm().getCast());
					newFilm.setDirector(hall.getHallInfo().getFilm().getDirector());
					newFilm.setDuration(hall.getHallInfo().getFilm().getDuration());
					newFilm.setName(hall.getHallInfo().getFilm().getName());
					newFilm.setPlot(hall.getHallInfo().getFilm().getPlot());
					newFilm.setType(hall.getHallInfo().getFilm().getType());
					newHallInfo.setFilm(newFilm);
					newHallInfo.setFreeSeatsNumber(hall.getHallInfo().getFreeSeatsNumber());
					newHallInfo.setPrice(hall.getHallInfo().getPrice());
					newHallInfo.setTime(hall.getHallInfo().getTime());
					newHall.setHallInfo(newHallInfo);
					newHall.setNumber(hall.getNumber());
					newHall.setSeatsNumber(hall.getSeatsNumber());
					hallResponse.add(newHall);
				}
				newCinemaInfo.setAddress(cinema.getCinemaInfo().getAddress());
				newCinemaInfo.setCap(cinema.getCinemaInfo().getCap());
				newCinemaInfo.setCity(cinema.getCinemaInfo().getCity());
				newCinemaInfo.setName(cinema.getCinemaInfo().getName());
				newCinemaInfo.setTelephoneNumber(cinema.getCinemaInfo().getTelephoneNumber());
				newCinemaInfo.setHall(hallResponse);
				newCinema.setCinemaInfo(newCinemaInfo);
				newCinema.setLat(cinema.getLat());
				newCinema.setLon(cinema.getLon());
				cinemasResponse.add(newCinema);
			}
			response.setCinemas(cinemasResponse);
		} catch (CinemaInformationFault_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public InsertRestaurantResponse insertRestaurant(InsertRestaurantRequest request) throws BusinessException {
		InsertRestaurantResponse response = new InsertRestaurantResponse();
		it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantType restaurant = new it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantType();
		it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantInfoType restaurantInfo = new it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantInfoType();
		it.univaq.disim.sose.cald.clients.restaurantinserting.DiscountType discount = new it.univaq.disim.sose.cald.clients.restaurantinserting.DiscountType();
		
		RestaurantInsertingService restaurantInsertingService = new RestaurantInsertingService();
		RestaurantPT restaurantInserting = restaurantInsertingService.getRestaurantPort();
		RestaurantInsertRequest restaurantInsertRequest = new RestaurantInsertRequest();
		
		discount.setPrice(request.getRestaurant().getRestaurantInfo().getDiscount().getPrice());
		discount.setCinema(request.getRestaurant().getRestaurantInfo().getDiscount().getCinema());
		restaurantInfo.setDiscount(discount);
		restaurantInfo.setAddress(request.getRestaurant().getRestaurantInfo().getAddress());
		restaurantInfo.setCap(request.getRestaurant().getRestaurantInfo().getCap());
		restaurantInfo.setCity(request.getRestaurant().getRestaurantInfo().getCity());
		restaurantInfo.setCuisine(request.getRestaurant().getRestaurantInfo().getCuisine());
		restaurantInfo.setMaxSeats(restaurant.getRestaurantInfo().getMaxSeats());
		restaurantInfo.setMenu(request.getRestaurant().getRestaurantInfo().getMenu());
		restaurantInfo.setName(request.getRestaurant().getRestaurantInfo().getName());
		restaurantInfo.setStyle(request.getRestaurant().getRestaurantInfo().getStyle());
		restaurantInfo.setTelephoneNumber(request.getRestaurant().getRestaurantInfo().getTelephoneNumber());
		restaurant.setRestaurantInfo(restaurantInfo);
		restaurant.setLat(request.getRestaurant().getLat());
		restaurant.setLon(request.getRestaurant().getLon());
	
		restaurantInsertRequest.setRestaurant(restaurant);
		
		try {
			RestaurantInsertResponse restaurantInsertResponse = restaurantInserting.restaurantInsert(restaurantInsertRequest);
			
			response.setAccepted(restaurantInsertResponse.isAccepted());
		} catch (RestaurantInsertFault_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public InsertCinemaResponse insertCinema(InsertCinemaRequest request) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
