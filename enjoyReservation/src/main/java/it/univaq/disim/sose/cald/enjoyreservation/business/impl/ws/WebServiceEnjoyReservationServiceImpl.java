package it.univaq.disim.sose.cald.enjoyreservation.business.impl.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import com.google.maps.errors.ApiException;

import it.univaq.disim.sose.cald.clients.accountmanager.AccountManagerPT;
import it.univaq.disim.sose.cald.clients.accountmanager.AccountManagerService;
import it.univaq.disim.sose.cald.clients.accountmanager.CheckCinemaOwnerFault_Exception;
import it.univaq.disim.sose.cald.clients.accountmanager.CheckCinemaOwnerRequest;
import it.univaq.disim.sose.cald.clients.accountmanager.CheckCinemaOwnerResponse;
import it.univaq.disim.sose.cald.clients.accountmanager.CheckRestaurantOwnerFault_Exception;
import it.univaq.disim.sose.cald.clients.accountmanager.CheckRestaurantOwnerRequest;
import it.univaq.disim.sose.cald.clients.accountmanager.CheckRestaurantOwnerResponse;
import it.univaq.disim.sose.cald.clients.accountmanager.CheckSessionFault_Exception;
import it.univaq.disim.sose.cald.clients.accountmanager.CheckSessionRequest;
import it.univaq.disim.sose.cald.clients.accountmanager.CheckSessionResponse;
import it.univaq.disim.sose.cald.clients.accountmanager.UserLoginFault_Exception;
import it.univaq.disim.sose.cald.clients.accountmanager.UserLoginRequest;
import it.univaq.disim.sose.cald.clients.accountmanager.UserLoginResponse;
import it.univaq.disim.sose.cald.clients.accountmanager.UserLogoutFault_Exception;
import it.univaq.disim.sose.cald.clients.accountmanager.UserLogoutRequest;
import it.univaq.disim.sose.cald.clients.accountmanager.UserLogoutResponse;
import it.univaq.disim.sose.cald.clients.accountmanager.UserSignupFault_Exception;
import it.univaq.disim.sose.cald.clients.accountmanager.UserSignupRequest;
import it.univaq.disim.sose.cald.clients.accountmanager.UserSignupResponse;
import it.univaq.disim.sose.cald.clients.cinemabooking.CinemaBookingFault_Exception;
import it.univaq.disim.sose.cald.clients.cinemabooking.CinemaBookingPT;
import it.univaq.disim.sose.cald.clients.cinemabooking.CinemaBookingRequest;
import it.univaq.disim.sose.cald.clients.cinemabooking.CinemaBookingResponse;
import it.univaq.disim.sose.cald.clients.cinemabooking.CinemaBookingService;
import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationFault_Exception;
import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationPT;
import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationRequest;
import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationResponse;
import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationService;
import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaType;
import it.univaq.disim.sose.cald.clients.cinemainformation.HallInfoType;
import it.univaq.disim.sose.cald.clients.cinemainformation.HallType;
import it.univaq.disim.sose.cald.clients.cinemainformation.SingleCinemaInformationRequest;
import it.univaq.disim.sose.cald.clients.cinemainformation.SingleCinemaInformationResponse;
import it.univaq.disim.sose.cald.clients.cinemainserting.CinemaDeleteFault_Exception;
import it.univaq.disim.sose.cald.clients.cinemainserting.CinemaDeleteRequest;
import it.univaq.disim.sose.cald.clients.cinemainserting.CinemaDeleteResponse;
import it.univaq.disim.sose.cald.clients.cinemainserting.CinemaInsertFault_Exception;
import it.univaq.disim.sose.cald.clients.cinemainserting.CinemaInsertRequest;
import it.univaq.disim.sose.cald.clients.cinemainserting.CinemaInsertResponse;
import it.univaq.disim.sose.cald.clients.cinemainserting.CinemaInsertingService;
import it.univaq.disim.sose.cald.clients.cinemainserting.CinemaPT;
import it.univaq.disim.sose.cald.clients.cinemainserting.CinemaUpdateFault_Exception;
import it.univaq.disim.sose.cald.clients.cinemainserting.CinemaUpdateRequest;
import it.univaq.disim.sose.cald.clients.cinemainserting.CinemaUpdateResponse;
import it.univaq.disim.sose.cald.clients.restaurantbooking.RestaurantBookingFault_Exception;
import it.univaq.disim.sose.cald.clients.restaurantbooking.RestaurantBookingPT;
import it.univaq.disim.sose.cald.clients.restaurantbooking.RestaurantBookingRequest;
import it.univaq.disim.sose.cald.clients.restaurantbooking.RestaurantBookingResponse;
import it.univaq.disim.sose.cald.clients.restaurantbooking.RestaurantBookingService;
import it.univaq.disim.sose.cald.clients.restaurantinformation.RestaurantInformationFault_Exception;
import it.univaq.disim.sose.cald.clients.restaurantinformation.RestaurantInformationPT;
import it.univaq.disim.sose.cald.clients.restaurantinformation.RestaurantInformationRequest;
import it.univaq.disim.sose.cald.clients.restaurantinformation.RestaurantInformationResponse;
import it.univaq.disim.sose.cald.clients.restaurantinformation.SingleRestaurantInformationRequest;
import it.univaq.disim.sose.cald.clients.restaurantinformation.SingleRestaurantInformationResponse;
import it.univaq.disim.sose.cald.clients.restaurantinformation.RestaurantInformationService;
import it.univaq.disim.sose.cald.clients.restaurantinformation.RestaurantType;
import it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantDeleteFault_Exception;
import it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantDeleteRequest;
import it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantDeleteResponse;
import it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantInsertFault_Exception;
import it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantInsertRequest;
import it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantInsertResponse;
import it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantInsertingService;
import it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantPT;
import it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantUpdateFault_Exception;
import it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantUpdateRequest;
import it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantUpdateResponse;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLoginFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLoginRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLoginResponse;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutResponse;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionResponse;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSignupFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSignupRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSignupResponse;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantResponse;
import it.univaq.disim.sose.cald.enjoyreservation.CinemaOwnerFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.CinemaOwnerRequest;
import it.univaq.disim.sose.cald.enjoyreservation.CinemaOwnerResponse;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteRestaurantFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteRestaurantResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetAllInfoFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.GetAllInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetAllInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetSingleCinemaInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetSingleCinemaInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetSingleRestaurantInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetSingleRestaurantInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantFault_Exception;
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
import it.univaq.disim.sose.cald.enjoyreservation.RestaurantOwnerFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.RestaurantOwnerRequest;
import it.univaq.disim.sose.cald.enjoyreservation.RestaurantOwnerResponse;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateRestaurantFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateRestaurantResponse;
import it.univaq.disim.sose.cald.enjoyreservation.business.EnjoyReservationService;
import it.univaq.disim.sose.cald.enjoyreservation.business.GoogleMaps;

@Service
public class WebServiceEnjoyReservationServiceImpl implements EnjoyReservationService {
	
	@Override
	public GetRestaurantInfoResponse getRestaurantInfo(GetRestaurantInfoRequest request) throws GetRestaurantInfoFault_Exception {
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
					newDiscount.setDiscountId(restaurant.getRestaurantInfo().getDiscount().getDiscountId());
					newDiscount.setPrice(restaurant.getRestaurantInfo().getDiscount().getPrice());
					newDiscount.setCinema(restaurant.getRestaurantInfo().getDiscount().getCinema());
				} else {
					newDiscount = null;
				}
				newRestaurantInfo.setDiscount(newDiscount);
				newRestaurantInfo.setId(restaurant.getRestaurantInfo().getId());
				newRestaurantInfo.setAddress(restaurant.getRestaurantInfo().getAddress());
				newRestaurantInfo.setCap(restaurant.getRestaurantInfo().getCap());
				newRestaurantInfo.setCity(restaurant.getRestaurantInfo().getCity());
				newRestaurantInfo.setCuisine(restaurant.getRestaurantInfo().getCuisine());
				newRestaurantInfo.setMenu(restaurant.getRestaurantInfo().getMenu());
				newRestaurantInfo.setName(restaurant.getRestaurantInfo().getName());
				newRestaurantInfo.setStyle(restaurant.getRestaurantInfo().getStyle());
				newRestaurantInfo.setMaxSeats(restaurant.getRestaurantInfo().getMaxSeats());
				newRestaurantInfo.setTelephoneNumber(restaurant.getRestaurantInfo().getTelephoneNumber());
				newRestaurant.setRestaurantInfo(newRestaurantInfo);
				newRestaurant.setLat(restaurant.getLat());
				newRestaurant.setLon(restaurant.getLon());
				restaurantsResponse.add(newRestaurant);
			}
			for(OSMRestaurantType restaurant : restaurantsResponse) {
				response.getRestaurants().add(restaurant);
			}
		} catch (RestaurantInformationFault_Exception e) {
			e.printStackTrace();
			throw new GetRestaurantInfoFault_Exception("Something was wrong with Restaurant Info");
		}
		return response;
	}

	@Override
	public GetCinemaInfoResponse getCinemaInfo(GetCinemaInfoRequest request) throws GetCinemaInfoFault_Exception {
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
				
				hallResponse = new ArrayList<OSMHallType>();
				for(HallType hall : cinema.getCinemaInfo().getHall()) {
					OSMHallType newHall = new OSMHallType();
					
					for(HallInfoType hallInfo : hall.getHallInfo()) {
						OSMHallInfoType newHallInfo = new OSMHallInfoType();
						OSMFilmType newFilm = new OSMFilmType();
						
						newFilm.setIdFilm(hallInfo.getFilm().getId());
						newFilm.setCast(hallInfo.getFilm().getCast());
						newFilm.setDirector(hallInfo.getFilm().getDirector());
						newFilm.setDuration(hallInfo.getFilm().getDuration());
						newFilm.setName(hallInfo.getFilm().getName());
						newFilm.setPlot(hallInfo.getFilm().getPlot());
						newFilm.setType(hallInfo.getFilm().getType());
						newHallInfo.setFilm(newFilm);
						newHallInfo.setFreeSeatsNumber(hallInfo.getFreeSeatsNumber());
						newHallInfo.setPrice(hallInfo.getPrice());						
						newHallInfo.setTime(hallInfo.getTime());
						newHall.getHallInfo().add(newHallInfo);
					}
					newHall.setIdHall(hall.getId());
					newHall.setNumber(hall.getNumber());
					newHall.setSeatsNumber(hall.getSeatsNumber());
					hallResponse.add(newHall);
				}
				newCinemaInfo.setIdCinema(cinema.getCinemaInfo().getId());
				newCinemaInfo.setAddress(cinema.getCinemaInfo().getAddress());
				newCinemaInfo.setCap(cinema.getCinemaInfo().getCap());
				newCinemaInfo.setCity(cinema.getCinemaInfo().getCity());
				newCinemaInfo.setName(cinema.getCinemaInfo().getName());
				newCinemaInfo.setTelephoneNumber(cinema.getCinemaInfo().getTelephoneNumber());
				for(OSMHallType hall : hallResponse) {
					newCinemaInfo.getHall().add(hall);
				}
				newCinema.setCinemaInfo(newCinemaInfo);
				newCinema.setLat(cinema.getLat());
				newCinema.setLon(cinema.getLon());
				cinemasResponse.add(newCinema);
			}
			for(OSMCinemaType cinema : cinemasResponse) {
				response.getCinemas().add(cinema);
			}
		} catch (CinemaInformationFault_Exception e) {
			e.printStackTrace();
			throw new GetCinemaInfoFault_Exception("Something was wrong with Cinema Info");
		}
		return response;
	}
	
	/**
     * Get all the cinemas and restaurants information in parallel given a city
     * @param request city
     * @return response List of all the cinemas and list of all the restaurants
     */
	@Override
	public GetAllInfoResponse getAllInfo(GetAllInfoRequest request) throws GetAllInfoFault_Exception {
		GetAllInfoResponse response = new GetAllInfoResponse();
		CinemaRunnable cinemaRunnable = new CinemaRunnable(request.getCity());
		RestaurantRunnable restaurantRunnable = new RestaurantRunnable(request.getCity());
			
		try {
			Thread myCinema = new Thread(cinemaRunnable);
			myCinema.start();
			myCinema.join();
			
			if(cinemaRunnable.getResponse().getCinemas() != null) {
				for(OSMCinemaType cinema : cinemaRunnable.getResponse().getCinemas()) {
					response.getCinemas().add(cinema);
				}
			} else {
				response.getCinemas().add(null);
			}
			
			Thread myRestaurant = new Thread(restaurantRunnable);
			myRestaurant.start();
			myRestaurant.join();
			
			if(restaurantRunnable.getResponse().getRestaurants() != null) {
				for(OSMRestaurantType restaurant : restaurantRunnable.getResponse().getRestaurants()) {
					response.getRestaurants().add(restaurant);
				}
			} else {
				response.getRestaurants().add(null);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new GetAllInfoFault_Exception("Something was wrong with All Info");
		}
		
		return response;
	}

	@Override
	public InsertRestaurantResponse insertRestaurant(InsertRestaurantRequest request) throws InsertRestaurantFault_Exception {
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
		restaurantInfo.setMaxSeats(request.getRestaurant().getRestaurantInfo().getMaxSeats());
		restaurantInfo.setMenu(request.getRestaurant().getRestaurantInfo().getMenu());
		restaurantInfo.setName(request.getRestaurant().getRestaurantInfo().getName());
		restaurantInfo.setStyle(request.getRestaurant().getRestaurantInfo().getStyle());
		restaurantInfo.setTelephoneNumber(request.getRestaurant().getRestaurantInfo().getTelephoneNumber());
		restaurant.setRestaurantInfo(restaurantInfo);
		
		double[] coordinates = new double[2];
		coordinates = coordinatesGoogle(restaurantInfo.getAddress(), restaurantInfo.getCity());
		restaurant.setLat(coordinates[0]);
		restaurant.setLon(coordinates[1]);
	
		restaurantInsertRequest.setRestaurant(restaurant);
		restaurantInsertRequest.setId(request.getId());
		
		try {
			RestaurantInsertResponse restaurantInsertResponse = restaurantInserting.restaurantInsert(restaurantInsertRequest);
			
			response.setAccepted(restaurantInsertResponse.isAccepted());
		} catch (RestaurantInsertFault_Exception e) {
			e.printStackTrace();
			throw new InsertRestaurantFault_Exception("Something was wrong with Insert Restaurant");
		}
		return response;
	}

	@Override
	public InsertCinemaResponse insertCinema(InsertCinemaRequest request) throws InsertCinemaFault_Exception {
		InsertCinemaResponse response = new InsertCinemaResponse();
		it.univaq.disim.sose.cald.clients.cinemainserting.CinemaType cinema = new it.univaq.disim.sose.cald.clients.cinemainserting.CinemaType();
		it.univaq.disim.sose.cald.clients.cinemainserting.CinemaInfoType cinemaInfo = new it.univaq.disim.sose.cald.clients.cinemainserting.CinemaInfoType();
		List<it.univaq.disim.sose.cald.clients.cinemainserting.HallType> hallList = new ArrayList<it.univaq.disim.sose.cald.clients.cinemainserting.HallType>();
		
		CinemaInsertingService cinemaInsertingService = new CinemaInsertingService();
		CinemaPT cinemaInserting = cinemaInsertingService.getCinemaPort();
		CinemaInsertRequest cinemaInsertRequest = new CinemaInsertRequest();
		
		for(OSMHallType hallRequest : request.getCinema().getCinemaInfo().getHall()) {
			it.univaq.disim.sose.cald.clients.cinemainserting.HallType hall = new it.univaq.disim.sose.cald.clients.cinemainserting.HallType();

			for(OSMHallInfoType hallInfoRequest : hallRequest.getHallInfo()) {
				it.univaq.disim.sose.cald.clients.cinemainserting.HallInfoType hallInfo = new it.univaq.disim.sose.cald.clients.cinemainserting.HallInfoType();
				it.univaq.disim.sose.cald.clients.cinemainserting.FilmType film = new it.univaq.disim.sose.cald.clients.cinemainserting.FilmType();
				
				film.setCast(hallInfoRequest.getFilm().getCast());
				film.setDirector(hallInfoRequest.getFilm().getDirector());
				film.setDuration(hallInfoRequest.getFilm().getDuration());
				film.setName(hallInfoRequest.getFilm().getName());
				film.setPlot(hallInfoRequest.getFilm().getPlot());
				film.setType(hallInfoRequest.getFilm().getType());
				hallInfo.setFilm(film);
				hallInfo.setFreeSeatsNumber(hallInfoRequest.getFreeSeatsNumber());
				hallInfo.setPrice(hallInfoRequest.getPrice());
				hallInfo.setTime(hallInfoRequest.getTime());
				hall.getHallInfo().add(hallInfo);
			}
			
			hall.setSeatsNumber(hallRequest.getSeatsNumber());
			hall.setNumber(hallRequest.getNumber());
			hallList.add(hall);
		}
		for(it.univaq.disim.sose.cald.clients.cinemainserting.HallType hall : hallList) {
			cinemaInfo.getHall().add(hall);
		}
		cinemaInfo.setAddress(request.getCinema().getCinemaInfo().getAddress());
		cinemaInfo.setCap(request.getCinema().getCinemaInfo().getCap());
		cinemaInfo.setCity(request.getCinema().getCinemaInfo().getCity());
		cinemaInfo.setName(request.getCinema().getCinemaInfo().getName());
		cinemaInfo.setTelephoneNumber(request.getCinema().getCinemaInfo().getTelephoneNumber());
		cinema.setCinemaInfo(cinemaInfo);
		
		double[] coordinates = new double[2];
		coordinates	= coordinatesGoogle(cinemaInfo.getAddress(), cinemaInfo.getCity());
		cinema.setLat(coordinates[0]);
		cinema.setLon(coordinates[1]);
		
		cinemaInsertRequest.setCinema(cinema);
		cinemaInsertRequest.setId(request.getId());
		
		try {
			CinemaInsertResponse cinemaInsertResponse = cinemaInserting.cinemaInsert(cinemaInsertRequest);
			
			response.setAccepted(cinemaInsertResponse.isAccepted());
		} catch (CinemaInsertFault_Exception e) {
			e.printStackTrace();
			throw new InsertCinemaFault_Exception("Something was wrong with Cinema Insert");
		}
		return response;
	}

	@Override
	public BookingRestaurantResponse restaurantBooking(BookingRestaurantRequest request) throws BookingRestaurantFault_Exception {
		BookingRestaurantResponse response = new BookingRestaurantResponse();
		
		RestaurantBookingService restaurantBookingService = new RestaurantBookingService();
		RestaurantBookingPT restaurantBooking = restaurantBookingService.getRestaurantBookingPort();
		RestaurantBookingRequest restaurantBookingRequest = new RestaurantBookingRequest();
		restaurantBookingRequest.setRestaurant(request.getRestaurant());
		restaurantBookingRequest.setSchedule(request.getSchedule());
		restaurantBookingRequest.setSeats(request.getSeats());
		restaurantBookingRequest.setUser(request.getUser());
		
		try {
			RestaurantBookingResponse restaurantBookingResponse = restaurantBooking.restaurantBooking(restaurantBookingRequest);
			
			response.setAccepted(restaurantBookingResponse.getAccepted());
		} catch (RestaurantBookingFault_Exception e) {
			e.printStackTrace();
			throw new BookingRestaurantFault_Exception("Something was wrong with Restaurant Booking");
		}
		return response;
	}

	@Override
	public BookingCinemaResponse cinemaBooking(BookingCinemaRequest request) throws BookingCinemaFault_Exception {
		BookingCinemaResponse response = new BookingCinemaResponse();
		
		CinemaBookingService cinemaBookingService = new CinemaBookingService();
		CinemaBookingPT cinemaBooking = cinemaBookingService.getCinemaBookingPort();
		CinemaBookingRequest cinemaBookingRequest = new CinemaBookingRequest();
		
		cinemaBookingRequest.setIdFilm(request.getIdFilm());
		cinemaBookingRequest.setIdHall(request.getIdHall());
		cinemaBookingRequest.setIdUtente(request.getIdUtente());
		cinemaBookingRequest.setSchedule(request.getSchedule());
		cinemaBookingRequest.setSeats(request.getSeats());
		
		try {
			CinemaBookingResponse cinemaBookingResponse = cinemaBooking.cinemaBooking(cinemaBookingRequest);
			
			response.setAccepted(cinemaBookingResponse.getAccepted());
		} catch (CinemaBookingFault_Exception e) {
			e.printStackTrace();
			throw new BookingCinemaFault_Exception("Something was wrong with Cinema Booking");
		}
		return response;
	}
	
	@Override
	public AccountSignupResponse userSignup(AccountSignupRequest request) throws AccountSignupFault_Exception {
		AccountSignupResponse response = new AccountSignupResponse();
		
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		UserSignupRequest userSignupRequest = new UserSignupRequest();
		
		userSignupRequest.setEmail(request.getEmail());
		userSignupRequest.setName(request.getName());
		userSignupRequest.setPassword(request.getPassword());
		userSignupRequest.setSurname(request.getSurname());
		userSignupRequest.setUsername(request.getUsername());
		
		try {
			UserSignupResponse userSignupResponse = accountManager.userSignup(userSignupRequest);
			
			response.setId(userSignupResponse.getId());
			response.setToken(userSignupResponse.getToken());
		} catch (UserSignupFault_Exception e) {
			e.printStackTrace();
			throw new AccountSignupFault_Exception("Something was wrong with Account Signup");
		}
		return response;
	}
	
	@Override
	public AccountLoginResponse userLogin(AccountLoginRequest request) throws AccountLoginFault_Exception {
		AccountLoginResponse response = new AccountLoginResponse();
		
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		UserLoginRequest userLoginRequest = new UserLoginRequest();
		
		userLoginRequest.setEmail(request.getEmail());
		userLoginRequest.setPassword(request.getPassword());
		
		try {
			UserLoginResponse userLoginResponse = accountManager.userLogin(userLoginRequest);
			
			response.setId(userLoginResponse.getId());
			response.setToken(userLoginResponse.getToken());
		} catch (UserLoginFault_Exception e) {
			e.printStackTrace();
			throw new AccountLoginFault_Exception("Something was wrong with Account Login");
		}
		return response;
	}

	@Override
	public AccountLogoutResponse userLogout(AccountLogoutRequest request) throws AccountLogoutFault_Exception {
		AccountLogoutResponse response = new AccountLogoutResponse();
		
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		UserLogoutRequest userLogoutRequest = new UserLogoutRequest();
		
		userLogoutRequest.setToken(request.getToken());
		
		try {
			UserLogoutResponse userLogoutResponse = accountManager.userLogout(userLogoutRequest);
			response.setResponse(userLogoutResponse.getResponse());
			
		} catch (UserLogoutFault_Exception e) {
			e.printStackTrace();
			throw new AccountLogoutFault_Exception("Something was wrong with Account Logout");
		}
		return response;
	}

	@Override
	public AccountSessionResponse accountSession(AccountSessionRequest request) throws AccountSessionFault_Exception {
		AccountSessionResponse response = new AccountSessionResponse();
		
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		CheckSessionRequest checkSessionRequest = new CheckSessionRequest();
		
		checkSessionRequest.setToken(request.getToken());
		
		try {
			CheckSessionResponse checkSessionResponse = accountManager.checkSession(checkSessionRequest);
			response.setResponse(checkSessionResponse.isResponse());
			
		} catch (CheckSessionFault_Exception e) {
			e.printStackTrace();
			throw new AccountSessionFault_Exception("Something was wrong with Account Session");
		}
		
		return response;
	}

	@Override
	public GetSingleRestaurantInfoResponse getSingleRestaurantInfo(GetSingleRestaurantInfoRequest request)
			throws GetRestaurantInfoFault_Exception {
		GetSingleRestaurantInfoResponse response = new GetSingleRestaurantInfoResponse();
		RestaurantType restaurant = new RestaurantType();
		
		RestaurantInformationService restaurantInformationService = new RestaurantInformationService();
		RestaurantInformationPT restaurantInformation = restaurantInformationService.getRestaurantInformationPort();
		SingleRestaurantInformationRequest restaurantInformationRequest = new SingleRestaurantInformationRequest();
		restaurantInformationRequest.setId(request.getId());
		try {
			SingleRestaurantInformationResponse restaurantInformationResponse = restaurantInformation.singleRestaurantInformation(restaurantInformationRequest);
			restaurant = restaurantInformationResponse.getRestaurant();
				OSMRestaurantType newRestaurant = new OSMRestaurantType();
				OSMRestaurantInfoType newRestaurantInfo = new OSMRestaurantInfoType();
				OSMDiscountType newDiscount = new OSMDiscountType();
				
				if(restaurant.getRestaurantInfo().getDiscount() != null) {
					newDiscount.setDiscountId(restaurant.getRestaurantInfo().getDiscount().getDiscountId());
					newDiscount.setPrice(restaurant.getRestaurantInfo().getDiscount().getPrice());
					newDiscount.setCinema(restaurant.getRestaurantInfo().getDiscount().getCinema());
				} else {
					newDiscount = null;
				}
				newRestaurantInfo.setDiscount(newDiscount);
				newRestaurantInfo.setId(restaurant.getRestaurantInfo().getId());
				newRestaurantInfo.setAddress(restaurant.getRestaurantInfo().getAddress());
				newRestaurantInfo.setCap(restaurant.getRestaurantInfo().getCap());
				newRestaurantInfo.setCity(restaurant.getRestaurantInfo().getCity());
				newRestaurantInfo.setCuisine(restaurant.getRestaurantInfo().getCuisine());
				newRestaurantInfo.setMenu(restaurant.getRestaurantInfo().getMenu());
				newRestaurantInfo.setName(restaurant.getRestaurantInfo().getName());
				newRestaurantInfo.setStyle(restaurant.getRestaurantInfo().getStyle());
				newRestaurantInfo.setMaxSeats(restaurant.getRestaurantInfo().getMaxSeats());
				newRestaurantInfo.setTelephoneNumber(restaurant.getRestaurantInfo().getTelephoneNumber());
				newRestaurant.setRestaurantInfo(newRestaurantInfo);
				newRestaurant.setLat(restaurant.getLat());
				newRestaurant.setLon(restaurant.getLon());
				
				response.setRestaurant(newRestaurant);
			
		} catch (RestaurantInformationFault_Exception e) {
			e.printStackTrace();
			throw new GetRestaurantInfoFault_Exception("Something was wrong with Single Restaunt Info");
		}
		return response;
	}

	@Override
	public GetSingleCinemaInfoResponse getSingleCinemaInfo(GetSingleCinemaInfoRequest request)
			throws GetCinemaInfoFault_Exception {
		GetSingleCinemaInfoResponse response = new GetSingleCinemaInfoResponse();
		CinemaType cinema = new CinemaType();
		List<OSMHallType> hallResponse = new ArrayList<OSMHallType>();
		
		CinemaInformationService cinemaInformationService = new CinemaInformationService();
		CinemaInformationPT cinemaInformation = cinemaInformationService.getCinemaInformationPort();
		SingleCinemaInformationRequest cinemaInformationRequest = new SingleCinemaInformationRequest();
		cinemaInformationRequest.setId(request.getId());
		try {
			SingleCinemaInformationResponse cinemaInformationResponse = cinemaInformation.singleCinemaInformation(cinemaInformationRequest);
			cinema = cinemaInformationResponse.getCinema();
			
			OSMCinemaType newCinema = new OSMCinemaType();
			OSMCinemaInfoType newCinemaInfo = new OSMCinemaInfoType();
						
			for(HallType hall : cinema.getCinemaInfo().getHall()) {
				OSMHallType newHall = new OSMHallType();
							
				for(HallInfoType hallInfo : hall.getHallInfo()) {
					OSMHallInfoType newHallInfo = new OSMHallInfoType();
					OSMFilmType newFilm = new OSMFilmType();
								
					newFilm.setIdFilm(hallInfo.getFilm().getId());
					newFilm.setCast(hallInfo.getFilm().getCast());
					newFilm.setDirector(hallInfo.getFilm().getDirector());
					newFilm.setDuration(hallInfo.getFilm().getDuration());
					newFilm.setName(hallInfo.getFilm().getName());
					newFilm.setPlot(hallInfo.getFilm().getPlot());
					newFilm.setType(hallInfo.getFilm().getType());
					newHallInfo.setFilm(newFilm);
					newHallInfo.setFreeSeatsNumber(hallInfo.getFreeSeatsNumber());
					newHallInfo.setPrice(hallInfo.getPrice());						
					newHallInfo.setTime(hallInfo.getTime());
					newHall.getHallInfo().add(newHallInfo);
				}
				newHall.setIdHall(hall.getId());
				newHall.setNumber(hall.getNumber());
				newHall.setSeatsNumber(hall.getSeatsNumber());
				hallResponse.add(newHall);
			}
			newCinemaInfo.setIdCinema(cinema.getCinemaInfo().getId());
			newCinemaInfo.setAddress(cinema.getCinemaInfo().getAddress());
			newCinemaInfo.setCap(cinema.getCinemaInfo().getCap());
			newCinemaInfo.setCity(cinema.getCinemaInfo().getCity());
			newCinemaInfo.setName(cinema.getCinemaInfo().getName());
			newCinemaInfo.setTelephoneNumber(cinema.getCinemaInfo().getTelephoneNumber());
			
			for(OSMHallType hall : hallResponse) {
					newCinemaInfo.getHall().add(hall);
			}
			newCinema.setCinemaInfo(newCinemaInfo);
			newCinema.setLat(cinema.getLat());
			newCinema.setLon(cinema.getLon());
			response.setCinema(newCinema);
		
		} catch (CinemaInformationFault_Exception e) {
			e.printStackTrace();
			throw new GetCinemaInfoFault_Exception("Something was wrong with Single Cinema Info");
		}
		return response;
	}

	@Override
	public UpdateRestaurantResponse updateRestaurant(UpdateRestaurantRequest request) throws UpdateRestaurantFault_Exception {
		UpdateRestaurantResponse response = new UpdateRestaurantResponse();
		it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantType restaurant = new it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantType();
		it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantInfoType restaurantInfo = new it.univaq.disim.sose.cald.clients.restaurantinserting.RestaurantInfoType();
		it.univaq.disim.sose.cald.clients.restaurantinserting.DiscountType discount = new it.univaq.disim.sose.cald.clients.restaurantinserting.DiscountType();
		
		RestaurantInsertingService restaurantInsertingService = new RestaurantInsertingService();
		RestaurantPT restaurantInserting = restaurantInsertingService.getRestaurantPort();
		RestaurantUpdateRequest restaurantUpdateRequest = new RestaurantUpdateRequest();
		
		discount.setDiscountId(request.getRestaurant().getRestaurantInfo().getDiscount().getDiscountId());
		discount.setPrice(request.getRestaurant().getRestaurantInfo().getDiscount().getPrice());
		discount.setCinema(request.getRestaurant().getRestaurantInfo().getDiscount().getCinema());
		restaurantInfo.setDiscount(discount);
		restaurantInfo.setId(request.getRestaurant().getRestaurantInfo().getId());
		restaurantInfo.setAddress(request.getRestaurant().getRestaurantInfo().getAddress());
		restaurantInfo.setCap(request.getRestaurant().getRestaurantInfo().getCap());
		restaurantInfo.setCity(request.getRestaurant().getRestaurantInfo().getCity());
		restaurantInfo.setCuisine(request.getRestaurant().getRestaurantInfo().getCuisine());
		restaurantInfo.setMaxSeats(request.getRestaurant().getRestaurantInfo().getMaxSeats());
		restaurantInfo.setMenu(request.getRestaurant().getRestaurantInfo().getMenu());
		restaurantInfo.setName(request.getRestaurant().getRestaurantInfo().getName());
		restaurantInfo.setStyle(request.getRestaurant().getRestaurantInfo().getStyle());
		restaurantInfo.setTelephoneNumber(request.getRestaurant().getRestaurantInfo().getTelephoneNumber());
		restaurant.setRestaurantInfo(restaurantInfo);
		
		double[] coordinates = new double[2];
		coordinates	= coordinatesGoogle(request.getRestaurant().getRestaurantInfo().getAddress(), request.getRestaurant().getRestaurantInfo().getCity());
		restaurant.setLat(coordinates[0]);
		restaurant.setLon(coordinates[1]);

		restaurantUpdateRequest.setRestaurant(restaurant);
		
		try {
			RestaurantUpdateResponse restaurantUpdateResponse = restaurantInserting.restaurantUpdate(restaurantUpdateRequest);
			
			response.setAccepted(restaurantUpdateResponse.isAccepted());
		} catch (RestaurantUpdateFault_Exception e) {
			e.printStackTrace();
			throw new UpdateRestaurantFault_Exception("Something was wrong with Update Restaurant");
		}
		return response;
	}

	@Override
	public UpdateCinemaResponse updateCinema(UpdateCinemaRequest request) throws UpdateCinemaFault_Exception {
		UpdateCinemaResponse response = new UpdateCinemaResponse();
		it.univaq.disim.sose.cald.clients.cinemainserting.CinemaType cinema = new it.univaq.disim.sose.cald.clients.cinemainserting.CinemaType();
		it.univaq.disim.sose.cald.clients.cinemainserting.CinemaInfoType cinemaInfo = new it.univaq.disim.sose.cald.clients.cinemainserting.CinemaInfoType();
		List<it.univaq.disim.sose.cald.clients.cinemainserting.HallType> hallList = new ArrayList<it.univaq.disim.sose.cald.clients.cinemainserting.HallType>();
		
		CinemaInsertingService cinemaInsertingService = new CinemaInsertingService();
		CinemaPT cinemaInserting = cinemaInsertingService.getCinemaPort();
		CinemaUpdateRequest cinemaUpdateRequest = new CinemaUpdateRequest();
		
		for(OSMHallType hallRequest : request.getCinema().getCinemaInfo().getHall()) {
			it.univaq.disim.sose.cald.clients.cinemainserting.HallType hall = new it.univaq.disim.sose.cald.clients.cinemainserting.HallType();

			for(OSMHallInfoType hallInfoRequest : hallRequest.getHallInfo()) {
				it.univaq.disim.sose.cald.clients.cinemainserting.HallInfoType hallInfo = new it.univaq.disim.sose.cald.clients.cinemainserting.HallInfoType();
				it.univaq.disim.sose.cald.clients.cinemainserting.FilmType film = new it.univaq.disim.sose.cald.clients.cinemainserting.FilmType();
				
				film.setIdFilm(hallInfoRequest.getFilm().getIdFilm());
				film.setCast(hallInfoRequest.getFilm().getCast());
				film.setDirector(hallInfoRequest.getFilm().getDirector());
				film.setDuration(hallInfoRequest.getFilm().getDuration());
				film.setName(hallInfoRequest.getFilm().getName());
				film.setPlot(hallInfoRequest.getFilm().getPlot());
				film.setType(hallInfoRequest.getFilm().getType());
				hallInfo.setFilm(film);
				hallInfo.setIdHallFilm(hallInfoRequest.getIdHallFilm());
				hallInfo.setFreeSeatsNumber(hallInfoRequest.getFreeSeatsNumber());
				hallInfo.setPrice(hallInfoRequest.getPrice());
				hallInfo.setTime(hallInfoRequest.getTime());
				hall.getHallInfo().add(hallInfo);
			}
			
			hall.setIdHall(hallRequest.getIdHall());
			hall.setNumber(hallRequest.getNumber());
			hallList.add(hall);
		}
		for(it.univaq.disim.sose.cald.clients.cinemainserting.HallType hall : hallList) {
			cinemaInfo.getHall().add(hall);
		}
		cinemaInfo.setIdCinema(request.getCinema().getCinemaInfo().getIdCinema());
		cinemaInfo.setAddress(request.getCinema().getCinemaInfo().getAddress());
		cinemaInfo.setCap(request.getCinema().getCinemaInfo().getCap());
		cinemaInfo.setCity(request.getCinema().getCinemaInfo().getCity());
		cinemaInfo.setName(request.getCinema().getCinemaInfo().getName());
		cinemaInfo.setTelephoneNumber(request.getCinema().getCinemaInfo().getTelephoneNumber());
		cinema.setCinemaInfo(cinemaInfo);
		
		double[] coordinates = new double[2];
		coordinates	= coordinatesGoogle(request.getCinema().getCinemaInfo().getAddress(), request.getCinema().getCinemaInfo().getCity());
		cinema.setLat(coordinates[0]);
		cinema.setLon(coordinates[1]);
		
		cinemaUpdateRequest.setCinema(cinema);
		
		try {
			CinemaUpdateResponse cinemaUpdateResponse = cinemaInserting.cinemaUpdate(cinemaUpdateRequest);
			
			response.setAccepted(cinemaUpdateResponse.isAccepted());
		} catch (CinemaUpdateFault_Exception e) {
			e.printStackTrace();
			throw new UpdateCinemaFault_Exception("Something was wrong Update Cinema");
		}
		return response;
	}
	
	@Override
	public DeleteCinemaResponse deleteCinema(DeleteCinemaRequest request) throws DeleteCinemaFault_Exception {
		DeleteCinemaResponse response = new DeleteCinemaResponse();
		
		CinemaInsertingService cinemaInsertingService = new CinemaInsertingService();
		CinemaPT cinemaInserting = cinemaInsertingService.getCinemaPort();
		CinemaDeleteRequest cinemaDeleteRequest = new CinemaDeleteRequest();
		
		if(request.getHallFilmId() != null) {
			cinemaDeleteRequest.setHallFilmId(request.getHallFilmId());
		}
		
		try {
			CinemaDeleteResponse cinemaDeleteResponse = cinemaInserting.cinemaDelete(cinemaDeleteRequest);
			
			response.setAccepted(cinemaDeleteResponse.isAccepted());
		} catch (CinemaDeleteFault_Exception e) {
			e.printStackTrace();
			throw new DeleteCinemaFault_Exception("Something was wrong with with Delete Cinema");
		}
		
		return response;
	}

	@Override
	public DeleteRestaurantResponse deleteRestautant(DeleteRestaurantRequest request) throws DeleteRestaurantFault_Exception {
		DeleteRestaurantResponse response = new DeleteRestaurantResponse();
		
		RestaurantInsertingService restaurantInsertingService = new RestaurantInsertingService();
		RestaurantPT restaurantInserting = restaurantInsertingService.getRestaurantPort();
		RestaurantDeleteRequest restaurantDeleteRequest = new RestaurantDeleteRequest();
		
		if((Long) request.getRestaurantId() != null) {
			restaurantDeleteRequest.setRestaurantId(request.getRestaurantId());
		}
		
		try {
			RestaurantDeleteResponse restaurantDeleteResponse = restaurantInserting.restaurantDelete(restaurantDeleteRequest);
			
			response.setAccepted(restaurantDeleteResponse.isAccepted());
		} catch (RestaurantDeleteFault_Exception e) {
			e.printStackTrace();
			throw new DeleteRestaurantFault_Exception("Something was wrong with Delete Restaurant");
		}
		
		return response;
	}
	
	@Override
	public CinemaOwnerResponse checkCinemaOwner(CinemaOwnerRequest request) throws CinemaOwnerFault_Exception {
		CinemaOwnerResponse response = new CinemaOwnerResponse();
		
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		CheckCinemaOwnerRequest checkCinemaOwnerRequest = new CheckCinemaOwnerRequest();
		
		checkCinemaOwnerRequest.setToken(request.getToken());
		checkCinemaOwnerRequest.setCinemaId(request.getCinemaId());
		
		try {
			CheckCinemaOwnerResponse checkCinemaOwnerResponse = accountManager.checkCinemaOwner(checkCinemaOwnerRequest);
			response.setResponse(checkCinemaOwnerResponse.isResponse());
			
		} catch (CheckCinemaOwnerFault_Exception e) {
			e.printStackTrace();
			throw new CinemaOwnerFault_Exception("Something was wrong with Check Cinema Owner");
		}
		
		return response;
	}

	@Override
	public RestaurantOwnerResponse checkRestaurantOwner(RestaurantOwnerRequest request) throws RestaurantOwnerFault_Exception {
		RestaurantOwnerResponse response = new RestaurantOwnerResponse();
		
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		CheckRestaurantOwnerRequest checkRestaurantOwnerRequest = new CheckRestaurantOwnerRequest();
		
		checkRestaurantOwnerRequest.setToken(request.getToken());
		checkRestaurantOwnerRequest.setRestaurantId(request.getRestaurantId());
		
		try {
			CheckRestaurantOwnerResponse checkRestaurantOwnerResponse = accountManager.checkRestaurantOwner(checkRestaurantOwnerRequest);
			response.setResponse(checkRestaurantOwnerResponse.isResponse());
			
		} catch (CheckRestaurantOwnerFault_Exception e) {
			e.printStackTrace();
			throw new RestaurantOwnerFault_Exception("Something was wrong with Check Restaurant Owner");
		}
		
		return response;
	}
	
	/**
     * Instance of Google class creation for found coordinates given an address and a city
     * @param address
     * * @param city
     * @return coordinates building's latitude and longitude 
     */
	private double[] coordinatesGoogle(String address, String city) {
		GoogleMaps google = new GoogleMaps();
		double[] coordinates = new double[2];
		try {
			coordinates = google.foundCoordinates(address, city);
		} catch (ApiException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return coordinates;
	}
	
	/**
     * Convert a Date date in XMLGregorianCalendar date
     * @param date
     * @return xmlCalendar XMLGregorianCalendar date
     */
	public static XMLGregorianCalendar toXMLGregorianCalendar(Date date){
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
        }
        return xmlCalendar;
    }
	
	/**
     * Convert a XMLGregorianCalendar date to a Date date
     * @param calendar
     * @return Date date
     */
	public static Date toDate(XMLGregorianCalendar calendar){
        if(calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }
	
}
