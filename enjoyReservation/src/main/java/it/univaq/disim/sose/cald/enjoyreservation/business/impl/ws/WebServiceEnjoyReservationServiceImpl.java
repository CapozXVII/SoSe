package it.univaq.disim.sose.cald.enjoyreservation.business.impl.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.maps.errors.ApiException;

import it.univaq.disim.sose.cald.clients.accountmanager.AccountManagerPT;
import it.univaq.disim.sose.cald.clients.accountmanager.AccountManagerService;
import it.univaq.disim.sose.cald.clients.accountmanager.CheckSessionFault_Exception;
import it.univaq.disim.sose.cald.clients.accountmanager.CheckSessionRequest;
import it.univaq.disim.sose.cald.clients.accountmanager.CheckSessionResponse;
import it.univaq.disim.sose.cald.clients.accountmanager.UserLoginFault_Exception;
import it.univaq.disim.sose.cald.clients.accountmanager.UserLoginRequest;
import it.univaq.disim.sose.cald.clients.accountmanager.UserLoginResponse;
import it.univaq.disim.sose.cald.clients.accountmanager.UserLogoutFault_Exception;
import it.univaq.disim.sose.cald.clients.accountmanager.UserLogoutRequest;
import it.univaq.disim.sose.cald.clients.accountmanager.UserLogoutResponse;
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
import it.univaq.disim.sose.cald.clients.cinemainserting.CinemaInsertFault_Exception;
import it.univaq.disim.sose.cald.clients.cinemainserting.CinemaInsertRequest;
import it.univaq.disim.sose.cald.clients.cinemainserting.CinemaInsertResponse;
import it.univaq.disim.sose.cald.clients.cinemainserting.CinemaInsertingService;
import it.univaq.disim.sose.cald.clients.cinemainserting.CinemaPT;
import it.univaq.disim.sose.cald.clients.restaurantbooking.RestaurantBookingFault_Exception;
import it.univaq.disim.sose.cald.clients.restaurantbooking.RestaurantBookingPT;
import it.univaq.disim.sose.cald.clients.restaurantbooking.RestaurantBookingRequest;
import it.univaq.disim.sose.cald.clients.restaurantbooking.RestaurantBookingResponse;
import it.univaq.disim.sose.cald.clients.restaurantbooking.RestaurantBookingService;
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
import it.univaq.disim.sose.cald.enjoyreservation.AccountLoginRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLoginResponse;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountLogoutResponse;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionResponse;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantResponse;
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
import it.univaq.disim.sose.cald.enjoyreservation.business.GoogleMaps;

@Service
public class WebServiceEnjoyReservationServiceImpl implements EnjoyReservationService {

	private static Logger LOGGER = LoggerFactory.getLogger(WebServiceEnjoyReservationServiceImpl.class);
	
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
				newRestaurantInfo.setTelephoneNumber(restaurant.getRestaurantInfo().getTelephoneNumber());
				newRestaurant.setRestaurantInfo(newRestaurantInfo);
				newRestaurant.setLat(restaurant.getLat());
				newRestaurant.setLon(restaurant.getLon());
				restaurantsResponse.add(newRestaurant);
			}
			for(OSMRestaurantType restaurant : restaurantsResponse) {
				response.getRestaurants().add(restaurant);
			}
			//response.setRestaurants(restaurantsResponse);
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
					
					for(HallInfoType hallInfo : hall.getHallInfo()) {
						OSMHallInfoType newHallInfo = new OSMHallInfoType();
						OSMFilmType newFilm = new OSMFilmType();
						
						newFilm.setId(hallInfo.getFilm().getId());
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
					newHall.setId(hall.getId());
					newHall.setNumber(hall.getNumber());
					newHall.setSeatsNumber(hall.getSeatsNumber());
					hallResponse.add(newHall);
				}
				newCinemaInfo.setId(cinema.getCinemaInfo().getId());
				newCinemaInfo.setAddress(cinema.getCinemaInfo().getAddress());
				newCinemaInfo.setCap(cinema.getCinemaInfo().getCap());
				newCinemaInfo.setCity(cinema.getCinemaInfo().getCity());
				newCinemaInfo.setName(cinema.getCinemaInfo().getName());
				newCinemaInfo.setTelephoneNumber(cinema.getCinemaInfo().getTelephoneNumber());
				for(OSMHallType hall : hallResponse) {
					newCinemaInfo.getHall().add(hall);
				}
				//newCinemaInfo.setHall(hallResponse);
				newCinema.setCinemaInfo(newCinemaInfo);
				newCinema.setLat(cinema.getLat());
				newCinema.setLon(cinema.getLon());
				cinemasResponse.add(newCinema);
			}
			for(OSMCinemaType cinema : cinemasResponse) {
				response.getCinemas().add(cinema);
			}
			//response.setCinemas(cinemasResponse);
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
		restaurantInfo.setMaxSeats(request.getRestaurant().getRestaurantInfo().getMaxSeats());
		restaurantInfo.setMenu(request.getRestaurant().getRestaurantInfo().getMenu());
		restaurantInfo.setName(request.getRestaurant().getRestaurantInfo().getName());
		restaurantInfo.setStyle(request.getRestaurant().getRestaurantInfo().getStyle());
		restaurantInfo.setTelephoneNumber(request.getRestaurant().getRestaurantInfo().getTelephoneNumber());
		restaurant.setRestaurantInfo(restaurantInfo);
		
		GoogleMaps google = new GoogleMaps();
		try {
			double[] coordinates = new double[2];
			coordinates = google.foundCoordinates(restaurantInfo.getAddress(), restaurantInfo.getCity());
			restaurant.setLat(coordinates[0]);
			restaurant.setLon(coordinates[1]);
		} catch (ApiException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
			
			hall.setNumber(hallRequest.getNumber());
			hall.setSeatsNumber(hallRequest.getSeatsNumber());
			hallList.add(hall);
		}
		for(it.univaq.disim.sose.cald.clients.cinemainserting.HallType hall : hallList) {
			cinemaInfo.getHall().add(hall);
		}
		//cinemaInfo.setHall(hallList);
		cinemaInfo.setAddress(request.getCinema().getCinemaInfo().getAddress());
		cinemaInfo.setCap(request.getCinema().getCinemaInfo().getCap());
		cinemaInfo.setCity(request.getCinema().getCinemaInfo().getCity());
		cinemaInfo.setName(request.getCinema().getCinemaInfo().getName());
		cinemaInfo.setTelephoneNumber(request.getCinema().getCinemaInfo().getTelephoneNumber());
		cinema.setCinemaInfo(cinemaInfo);
		
		GoogleMaps google = new GoogleMaps();
		try {
			double[] coordinates = new double[2];
			coordinates = google.foundCoordinates(cinemaInfo.getAddress(), cinemaInfo.getCity());
			cinema.setLat(request.getCinema().getLat());
			cinema.setLon(request.getCinema().getLon());
		} catch (ApiException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		cinemaInsertRequest.setCinema(cinema);
		
		try {
			CinemaInsertResponse cinemaInsertResponse = cinemaInserting.cinemaInsert(cinemaInsertRequest);
			
			response.setAccepted(cinemaInsertResponse.isAccepted());
		} catch (CinemaInsertFault_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public BookingRestaurantResponse restaurantBooking(BookingRestaurantRequest request) throws BusinessException {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public BookingCinemaResponse cinemaBooking(BookingCinemaRequest request) throws BusinessException {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	@Override
	public AccountLoginResponse userLogin(AccountLoginRequest request) throws BusinessException {
		AccountLoginResponse response = new AccountLoginResponse();
		
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		UserLoginRequest userLoginRequest = new UserLoginRequest();
		
		userLoginRequest.setEmail(request.getEmail());
		userLoginRequest.setPassword(request.getPassword());
		
		try {
			UserLoginResponse userLoginResponse = accountManager.userLogin(userLoginRequest);
			
			response.setToken(userLoginResponse.getToken());
		} catch (UserLoginFault_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public AccountLogoutResponse userLogout(AccountLogoutRequest request) throws BusinessException {
		AccountLogoutResponse response = new AccountLogoutResponse();
		
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		UserLogoutRequest userLogoutRequest = new UserLogoutRequest();
		
		userLogoutRequest.setToken(request.getToken());
		
		try {
			UserLogoutResponse userLogoutResponse = accountManager.userLogout(userLogoutRequest);
			response.setResponse(userLogoutResponse.getResponse());
			
		} catch (UserLogoutFault_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public AccountSessionResponse accountSession(AccountSessionRequest request) throws BusinessException {
		AccountSessionResponse response = new AccountSessionResponse();
		
		AccountManagerService accountManagerService = new AccountManagerService();
		AccountManagerPT accountManager = accountManagerService.getAccountManagerPort();
		CheckSessionRequest checkSessionRequest = new CheckSessionRequest();
		
		checkSessionRequest.setToken(request.getToken());
		
		try {
			CheckSessionResponse checkSessionResponse = accountManager.checkSession(checkSessionRequest);
			response.setResponse(checkSessionResponse.isResponse());
			
		} catch (CheckSessionFault_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
	
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
	
	public static Date toDate(XMLGregorianCalendar calendar){
        if(calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }
}
