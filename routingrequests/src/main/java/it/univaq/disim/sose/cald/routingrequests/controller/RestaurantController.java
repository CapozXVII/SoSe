package it.univaq.disim.sose.cald.routingrequests.controller;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionResponse;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.BookingRestaurantResponse;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteRestaurantFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteRestaurantResponse;
import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationPT;
import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationService;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetSingleRestaurantInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetSingleRestaurantInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.InsertRestaurantResponse;
import it.univaq.disim.sose.cald.enjoyreservation.OSMDiscountType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMRestaurantInfoType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMRestaurantType;
import it.univaq.disim.sose.cald.enjoyreservation.RestaurantOwnerFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.RestaurantOwnerRequest;
import it.univaq.disim.sose.cald.enjoyreservation.RestaurantOwnerResponse;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateRestaurantFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateRestaurantRequest;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateRestaurantResponse;
import it.univaq.disim.sose.cald.routingrequests.model.Restaurant;
import it.univaq.disim.sose.cald.routingrequests.model.RestaurantBooking;

@RestController
@RequestMapping(value = "/restaurant")
public class RestaurantController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(RestaurantController.class);
	
		
	@GetMapping("/{token}/information/city/{city}")
	public GetRestaurantInfoResponse getInformation(@PathVariable(value = "token") String token, @PathVariable(value = "city") String city) throws AccountSessionFault_Exception, GetRestaurantInfoFault_Exception {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		GetRestaurantInfoResponse response = new GetRestaurantInfoResponse();
		
		if(checkSession(enjoyReservation, token)) {
			GetRestaurantInfoRequest request = new GetRestaurantInfoRequest();
			request.setCity(city);
			
			response = enjoyReservation.getRestaurantInfo(request);
		} else {
			response = null;
		}
		
		return response;
	}
	
	@GetMapping("/{token}/information/{id}")
	public GetSingleRestaurantInfoResponse getSingleInformation(@PathVariable(value = "token") String token, @PathVariable(value = "id") int id) throws AccountSessionFault_Exception, GetRestaurantInfoFault_Exception {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		GetSingleRestaurantInfoResponse response = new GetSingleRestaurantInfoResponse();
		
		if(checkSession(enjoyReservation, token)) {
			GetSingleRestaurantInfoRequest request = new GetSingleRestaurantInfoRequest();
			request.setId(id);
			
			response = enjoyReservation.getSingleRestaurantInfo(request);
		} else {
			response = null;
		}
		
		return response;
	}
	
	@PostMapping("/{token}/booking")
	public BookingRestaurantResponse insertBooking(@PathVariable(value = "token") String token, @RequestBody RestaurantBooking restaurantBooking) throws AccountSessionFault_Exception, BookingRestaurantFault_Exception {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		BookingRestaurantResponse response = new BookingRestaurantResponse();
		
		if(checkSession(enjoyReservation, token)) {
			BookingRestaurantRequest request = new BookingRestaurantRequest();
			LOGGER.info(restaurantBooking.getRestaurant() +"ciao");
			LOGGER.info(restaurantBooking.getUser() + "ciao2");
			LOGGER.info(toXMLGregorianCalendarDate(restaurantBooking.getSchedule()).toString());
			LOGGER.info(restaurantBooking.getSeats() + "ciao3");
			request.setRestaurant(restaurantBooking.getRestaurant());
			request.setUser(restaurantBooking.getUser());
			request.setSchedule(toXMLGregorianCalendarDate(restaurantBooking.getSchedule()));
			request.setSeats(restaurantBooking.getSeats());
			
			response = enjoyReservation.restaurantBooking(request);
		} else {
			response.setAccepted("You are not logging it");
		}
		
		return response;
	}
	
	@PostMapping("/{token}/insert")
	public InsertRestaurantResponse insertRestaurant(@PathVariable(value = "token") String token, @RequestBody Restaurant restaurant) throws AccountSessionFault_Exception, InsertRestaurantFault_Exception {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		InsertRestaurantResponse response = new InsertRestaurantResponse();
		
		if(checkSession(enjoyReservation, token)) {
			InsertRestaurantRequest request = new InsertRestaurantRequest();

			request.setRestaurant(createRestaurant(restaurant));
			request.setId(restaurant.getOwner());
			
			response = enjoyReservation.insertRestaurant(request);
		} else {
			response.setAccepted(false);
		}
		
		return response;
	}
	
	@PutMapping("/{token}/update")
	public UpdateRestaurantResponse updateRestaurant(@PathVariable(value = "token") String token, @RequestBody Restaurant restaurant) throws AccountSessionFault_Exception, UpdateRestaurantFault_Exception, RestaurantOwnerFault_Exception {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		UpdateRestaurantResponse response = new UpdateRestaurantResponse();
		
		if(checkSession(enjoyReservation, token)) {
			if(checkOwner(enjoyReservation, token, restaurant.getId())) {
				UpdateRestaurantRequest request = new UpdateRestaurantRequest();
				
				request.setRestaurant(createRestaurant(restaurant));
				response = enjoyReservation.updateRestaurant(request);
			} else {
				response.setAccepted(false);
			}
			
		} else {
			response.setAccepted(false);
		}
		
		return response;
	}
	
	@DeleteMapping("/{token}/delete/{id}")
	public DeleteRestaurantResponse deleteRestaurant(@PathVariable(value = "token") String token, @PathVariable(value = "id") long id) throws  AccountSessionFault_Exception, DeleteRestaurantFault_Exception, RestaurantOwnerFault_Exception {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		DeleteRestaurantResponse response = new DeleteRestaurantResponse();
		
		if(checkSession(enjoyReservation, token)) {
			if(checkOwner(enjoyReservation, token, id)) {
				DeleteRestaurantRequest request = new DeleteRestaurantRequest();
				
				request.setRestaurantId(id);
				
				response = enjoyReservation.restaurantDelete(request);
			}
			else {
				response.setAccepted(false);
			}
			
		} else {
			response.setAccepted(false);
		}
		
		return response;
	}
	
	public boolean checkSession(EnjoyReservationPT prosumer, String token) throws AccountSessionFault_Exception {
		AccountSessionRequest request = new AccountSessionRequest();
		request.setToken(token);
		AccountSessionResponse response = prosumer.accountSession(request);
		
		return response.isResponse();
	}
	
	public boolean checkOwner(EnjoyReservationPT prosumer, String token, long id) throws RestaurantOwnerFault_Exception {
		RestaurantOwnerRequest request = new RestaurantOwnerRequest();
		request.setToken(token);
		request.setRestaurantId(id);
		RestaurantOwnerResponse response = prosumer.checkRestaurantOwner(request);
		
		return response.isResponse();
	}
	
	public static XMLGregorianCalendar toXMLGregorianCalendarDate(Date date){
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
        }
        return xmlCalendar;
    }
	
	private OSMRestaurantType createRestaurant(Restaurant restaurant) {
		OSMRestaurantType restaurantRequest = new OSMRestaurantType();
		OSMRestaurantInfoType restaurantInfoRequest = new OSMRestaurantInfoType();
		OSMDiscountType discountRequest = new OSMDiscountType();
		
		if(restaurant.getDiscount() != null) {
			if(restaurant.getDiscount().getId() != null) {
				discountRequest.setDiscountId(restaurant.getDiscount().getId());
			}
			
			discountRequest.setCinema(restaurant.getDiscount().getCinema());
			discountRequest.setPrice(restaurant.getDiscount().getPrice());
			restaurantInfoRequest.setDiscount(discountRequest);
		} else {
			restaurantInfoRequest.setDiscount(null);
		}
		
		if(restaurant.getId() != null) {
			restaurantInfoRequest.setId(restaurant.getId());
		}
		
		restaurantInfoRequest.setAddress(restaurant.getAddress());
		restaurantInfoRequest.setCap(restaurant.getCap());
		restaurantInfoRequest.setCity(restaurant.getCity());
		restaurantInfoRequest.setCuisine(restaurant.getCuisine());
		restaurantInfoRequest.setMaxSeats(restaurant.getMaxSeats());
		restaurantInfoRequest.setMenu(restaurant.getMenu());
		restaurantInfoRequest.setName(restaurant.getName());
		restaurantInfoRequest.setStyle(restaurant.getStyle());
		restaurantInfoRequest.setTelephoneNumber(restaurant.getTelephoneNumber());
		restaurantRequest.setRestaurantInfo(restaurantInfoRequest);
		restaurantRequest.setLat(restaurant.getLat());
		restaurantRequest.setLon(restaurant.getLon());
		
		return restaurantRequest;
	}

}
