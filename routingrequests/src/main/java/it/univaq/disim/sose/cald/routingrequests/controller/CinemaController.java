package it.univaq.disim.sose.cald.routingrequests.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionRequest;
import it.univaq.disim.sose.cald.enjoyreservation.AccountSessionResponse;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationPT;
import it.univaq.disim.sose.cald.enjoyreservation.EnjoyReservationService;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.InsertCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.OSMCinemaInfoType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMCinemaType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMFilmType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMHallInfoType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMHallType;
import it.univaq.disim.sose.cald.routingrequests.model.Cinema;
import it.univaq.disim.sose.cald.routingrequests.model.CinemaBooking;
import it.univaq.disim.sose.cald.routingrequests.model.Hall;
import it.univaq.disim.sose.cald.routingrequests.model.HallInfo;

@RestController
@RequestMapping(value = "/cinema")
public class CinemaController {
	
	@GetMapping("/{token}/information/{city}")
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
			response = null;
		}
		
		return response;
	}
	
	@PostMapping("/{token}/inserting")
	public InsertCinemaResponse insertCinema(@PathVariable(value = "token") String token, @RequestBody Cinema cinema) throws AccountSessionFault_Exception, InsertCinemaFault_Exception {
		
		EnjoyReservationService enjoyReservationService = new EnjoyReservationService();
		EnjoyReservationPT enjoyReservation = enjoyReservationService.getEnjoyReservationPort();
		InsertCinemaResponse response = new InsertCinemaResponse();
		
		if(checkSession(enjoyReservation, token)) {
			InsertCinemaRequest request = new InsertCinemaRequest();
			OSMCinemaType cinemaRequest = new OSMCinemaType();
			OSMCinemaInfoType cinemaInfoRequest = new OSMCinemaInfoType();
			for(Hall hall : cinema.getHall()) {
				OSMHallType hallRequest = new OSMHallType();
				for(HallInfo hallInfo : hall.getHallInfo()) {
					OSMHallInfoType hallInfoRequest = new OSMHallInfoType();
					OSMFilmType filmRequest = new OSMFilmType();
					
					filmRequest.setCast(hallInfo.getFilm().getCast());
					filmRequest.setDirector(hallInfo.getFilm().getDirector());
					filmRequest.setDuration(hallInfo.getFilm().getDuration());
					filmRequest.setName(hallInfo.getFilm().getName());
					filmRequest.setPlot(hallInfo.getFilm().getPlot());
					filmRequest.setType(hallInfo.getFilm().getType());
					hallInfoRequest.setFilm(filmRequest);
					hallInfoRequest.setFreeSeatsNumber(hallInfo.getFreeSeatsNumber());
					hallInfoRequest.setPrice(hallInfo.getPrice());
					hallInfoRequest.setTime(toXMLGregorianCalendarDate(hallInfo.getTime()));
					hallRequest.getHallInfo().add(hallInfoRequest);
				}
				hallRequest.setNumber(hall.getNumber());
				hallRequest.setSeatsNumber(hall.getSeatsNumber());
				cinemaInfoRequest.getHall().add(hallRequest);
			}
			cinemaInfoRequest.setAddress(cinema.getAddress());
			cinemaInfoRequest.setCap(cinema.getCap());
			cinemaInfoRequest.setCity(cinema.getCity());
			cinemaInfoRequest.setName(cinema.getName());
			cinemaInfoRequest.setTelephoneNumber(cinema.getTelephoneNumber());
			cinemaRequest.setCinemaInfo(cinemaInfoRequest);
			cinemaRequest.setLat(cinema.getLatitude());
			cinemaRequest.setLon(cinema.getLongitude());
			
			request.setCinema(cinemaRequest);
			
			response = enjoyReservation.insertCinema(request);
		} else {
			response = null;
		}
		
		return response;
	}
	
	public boolean checkSession(EnjoyReservationPT prosumer, String token) throws AccountSessionFault_Exception {
		AccountSessionRequest request = new AccountSessionRequest();
		request.setToken(token);
		AccountSessionResponse response = prosumer.accountSession(request);
		
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

}
