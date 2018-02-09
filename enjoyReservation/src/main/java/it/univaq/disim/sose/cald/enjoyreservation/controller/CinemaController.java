package it.univaq.disim.sose.cald.enjoyreservation.controller;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaRequest;
import it.univaq.disim.sose.cald.enjoyreservation.BookingCinemaResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoFault_Exception;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.business.model.CinemaBooking;
import it.univaq.disim.sose.cald.enjoyreservation.webservices.EnjoyReservationPTImpl;

@RestController
@RequestMapping(value = "/cinema")
public class CinemaController {

	@PostMapping("information")
	public GetCinemaInfoResponse getInformation(@RequestBody String city) throws GetCinemaInfoFault_Exception {
		GetCinemaInfoRequest request = new GetCinemaInfoRequest();
		EnjoyReservationPTImpl prosumer = new EnjoyReservationPTImpl();
		request.setCity(city);
		GetCinemaInfoResponse response = prosumer.getCinemaInfo(request);
		return response;	
	}
	
	@PostMapping("/booking")
	public BookingCinemaResponse booking(@RequestBody CinemaBooking cinemaBooking) throws BookingCinemaFault_Exception {
		BookingCinemaRequest request = new BookingCinemaRequest();
		request.setIdFilm(cinemaBooking.getId_film());
		request.setIdHall(cinemaBooking.getId_hall());
		request.setIdUtente(cinemaBooking.getId_utente());
		request.setSeats(cinemaBooking.getSeats());
		Date date = new Date(cinemaBooking.getSchedule().getTime());
		request.setSchedule(toXMLGregorianCalendar(date));
		
		EnjoyReservationPTImpl prosumer = new EnjoyReservationPTImpl();
		BookingCinemaResponse response = prosumer.cinemaBooking(request);
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
}
