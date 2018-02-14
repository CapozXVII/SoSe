package it.univaq.disim.sose.cald.routingrequests.controller;

import java.sql.Timestamp;
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
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.CinemaOwnerFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.CinemaOwnerRequest;
import it.univaq.disim.sose.cald.enjoyreservation.CinemaOwnerResponse;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.DeleteCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationPT;
import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationService;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetSingleCinemaInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetSingleCinemaInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.OSMCinemaInfoType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMCinemaType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMFilmType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMHallInfoType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMHallType;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.UpdateCinemaResponse;
import it.univaq.disim.sose.cald.routingrequests.model.Cinema;
import it.univaq.disim.sose.cald.routingrequests.model.CinemaBooking;
import it.univaq.disim.sose.cald.routingrequests.model.Hall;
import it.univaq.disim.sose.cald.routingrequests.model.HallInfo;

@RestController
@RequestMapping(value = "/cinema")
public class CinemaController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CinemaController.class);

		
	@GetMapping("/{token}/information/city/{city}")
	public GetCinemaInfoResponse getInformation(@PathVariable(value = "token") String token, @PathVariable(value = "city") String city) throws AccountSessionFault_Exception, GetCinemaInfoFault_Exception {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		GetCinemaInfoResponse response = new GetCinemaInfoResponse();
		
		if(checkSession(enjoyReservation, token)) {
			GetCinemaInfoRequest request = new GetCinemaInfoRequest();
			request.setCity(city);
			
			response = enjoyReservation.getCinemaInfo(request);
		} else {
			response = null;
		}
		return response;
	}
	
	@GetMapping("/{token}/information/{id}")
	public GetSingleCinemaInfoResponse getSingleInformation(@PathVariable(value = "token") String token, @PathVariable(value = "id") int id) throws AccountSessionFault_Exception, GetCinemaInfoFault_Exception {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		GetSingleCinemaInfoResponse response = new GetSingleCinemaInfoResponse();
		
		if(checkSession(enjoyReservation, token)) {
			GetSingleCinemaInfoRequest request = new GetSingleCinemaInfoRequest();
			request.setId(id);
			
			response = enjoyReservation.getSingleCinemaInfo(request);
		} else {
			response = null;
		}
		return response;
	}
	
	@PostMapping("/{token}/booking")
	public BookingCinemaResponse insertBooking(@PathVariable(value = "token") String token, @RequestBody CinemaBooking cinemaBooking) throws AccountSessionFault_Exception, BookingCinemaFault_Exception {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		BookingCinemaResponse response = new BookingCinemaResponse();
		
		if(checkSession(enjoyReservation, token)) {
			BookingCinemaRequest request = new BookingCinemaRequest();
			request.setIdFilm(cinemaBooking.getId_film());
			request.setIdHall(cinemaBooking.getId_hall());
			request.setIdUtente(cinemaBooking.getId_utente());
			request.setSchedule(toXMLGregorianCalendar(cinemaBooking.getSchedule()));
			request.setSeats(cinemaBooking.getSeats());
			
			response = enjoyReservation.cinemaBooking(request);
		} else {
			response.setAccepted("You are not logging it");
		}
		
		return response;
	}
	
	@PostMapping("/{token}/insert")
	public InsertCinemaResponse insertCinema(@PathVariable(value = "token") String token, @RequestBody Cinema cinema) throws AccountSessionFault_Exception, InsertCinemaFault_Exception {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		InsertCinemaResponse response = new InsertCinemaResponse();
		
		if(checkSession(enjoyReservation, token)) {
			InsertCinemaRequest request = new InsertCinemaRequest();
			
			request.setId(cinema.getOwner());
			request.setCinema(createCinema(cinema));
			
			response = enjoyReservation.insertCinema(request);
		} else {
			response.setAccepted(false);
		}
		
		return response;
	}
	
	@PutMapping("/{token}/update")
	public UpdateCinemaResponse updateCinema(@PathVariable(value = "token") String token, @RequestBody Cinema cinema) throws AccountSessionFault_Exception, UpdateCinemaFault_Exception, CinemaOwnerFault_Exception {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		UpdateCinemaResponse response = new UpdateCinemaResponse();
		
		if(checkSession(enjoyReservation, token)) {
			if(checkOwner(enjoyReservation, token, cinema.getId())) {
				UpdateCinemaRequest request = new UpdateCinemaRequest();
				
				request.setCinema(createCinema(cinema));
				
				response = enjoyReservation.updateCinema(request);
			} else {
				response.setAccepted(false);
			}
		
		} else {
			response.setAccepted(false);
		}
		
		return response;
	}
	
	@DeleteMapping("/{token}/delete/{id}")
	public DeleteCinemaResponse deleteCinema(@PathVariable(value = "token") String token, @PathVariable(value = "id") long id) throws DeleteCinemaFault_Exception, AccountSessionFault_Exception {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		DeleteCinemaResponse response = new DeleteCinemaResponse();
		
		if(checkSession(enjoyReservation, token)) {
			DeleteCinemaRequest request = new DeleteCinemaRequest();
			
			request.setHallFilmId(id);
			
			response = enjoyReservation.cinemaDelete(request);
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
	
	public boolean checkOwner(EnjoyReservationPT prosumer, String token, Long id) throws CinemaOwnerFault_Exception {
		CinemaOwnerRequest request = new CinemaOwnerRequest();
		request.setToken(token);
		request.setCinemaId(id);
		CinemaOwnerResponse response = prosumer.checkCinemaOwner(request);
		
		return response.isResponse();
	}
	
	public static XMLGregorianCalendar toXMLGregorianCalendar(Timestamp timestamp){
		Date date = new Date(timestamp.getTime());
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
        }
        return xmlCalendar;
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
	
	private OSMCinemaType createCinema(Cinema cinema) {
		OSMCinemaType cinemaRequest = new OSMCinemaType();
		OSMCinemaInfoType cinemaInfoRequest = new OSMCinemaInfoType();
		
		for(Hall hall : cinema.getHall()) {
			OSMHallType hallRequest = new OSMHallType();
			for(HallInfo hallInfo : hall.getHallInfo()) {
				OSMHallInfoType hallInfoRequest = new OSMHallInfoType();
				OSMFilmType filmRequest = new OSMFilmType();
				
				if(hallInfo.getFilm().getId() != null) {
					filmRequest.setIdFilm(hallInfo.getFilm().getId());
				}
				
				filmRequest.setCast(hallInfo.getFilm().getCast());
				filmRequest.setDirector(hallInfo.getFilm().getDirector());
				filmRequest.setDuration(hallInfo.getFilm().getDuration());
				filmRequest.setName(hallInfo.getFilm().getName());
				filmRequest.setPlot(hallInfo.getFilm().getPlot());
				filmRequest.setType(hallInfo.getFilm().getType());
				hallInfoRequest.setFilm(filmRequest);
				
				if(hallInfo.getId() != null) {
					hallInfoRequest.setIdHallFilm(hallInfo.getId());
				}
				
				hallInfoRequest.setFreeSeatsNumber(hall.getSeatsNumber());
				hallInfoRequest.setPrice(hallInfo.getPrice());
				hallInfoRequest.setTime(toXMLGregorianCalendarDate(hallInfo.getTime()));
				hallRequest.getHallInfo().add(hallInfoRequest);
			}
			
			if(hall.getHall_id() != null) {
				hallRequest.setIdHall(hall.getHall_id());
			}
			
			hallRequest.setNumber(hall.getNumber());
			hallRequest.setSeatsNumber(hall.getSeatsNumber());
			cinemaInfoRequest.getHall().add(hallRequest);
		}
		
		if(cinema.getId() != null) {
			cinemaInfoRequest.setIdCinema(cinema.getId());
		}
		
		cinemaInfoRequest.setAddress(cinema.getAddress());
		cinemaInfoRequest.setCap(cinema.getCap());
		cinemaInfoRequest.setCity(cinema.getCity());
		cinemaInfoRequest.setName(cinema.getName());
		cinemaInfoRequest.setTelephoneNumber(cinema.getTelephoneNumber());
		cinemaRequest.setCinemaInfo(cinemaInfoRequest);
		cinemaRequest.setLat(cinema.getLat());
		cinemaRequest.setLon(cinema.getLongitude());
		
		return cinemaRequest;
	}

}
