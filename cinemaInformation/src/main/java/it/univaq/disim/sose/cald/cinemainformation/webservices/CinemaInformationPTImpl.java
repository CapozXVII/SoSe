package it.univaq.disim.sose.cald.cinemainformation.webservices;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.xml.datatype.DatatypeFactory;

import it.univaq.disim.sose.cald.cinemainformation.business.CinemaInformationService;
import it.univaq.disim.sose.cald.cinemainformation.business.model.Cinema;
import it.univaq.disim.sose.cald.cinemainformation.CinemaInfoType;
import it.univaq.disim.sose.cald.cinemainformation.CinemaInformationFault_Exception;
import it.univaq.disim.sose.cald.cinemainformation.CinemaInformationPT;
import it.univaq.disim.sose.cald.cinemainformation.CinemaInformationRequest;
import it.univaq.disim.sose.cald.cinemainformation.CinemaInformationResponse;
import it.univaq.disim.sose.cald.cinemainformation.CinemaType;
import it.univaq.disim.sose.cald.cinemainformation.FilmType;
import it.univaq.disim.sose.cald.cinemainformation.HallInfoType;
import it.univaq.disim.sose.cald.cinemainformation.HallType;

@Component(value = "CinemaInformationPTImpl")
public class CinemaInformationPTImpl implements CinemaInformationPT{

	private static Logger LOGGER = LoggerFactory.getLogger(CinemaInformationPTImpl.class);
	
	@Autowired
	CinemaInformationService service;
	
	public CinemaInformationResponse cinemaInformation(CinemaInformationRequest parameters) throws CinemaInformationFault_Exception {
		
		LOGGER.info("CALLED cinemaInformation");
		try {
			List<Cinema> cinemaList = service.getCinemas(parameters.getCity());
			List<HallType> halls;
			CinemaInformationResponse response = new CinemaInformationResponse();
			GregorianCalendar gtime = new GregorianCalendar();
			XMLGregorianCalendar xmlCalendar = null;
			
			for (Cinema cinema: cinemaList) {
				halls = new ArrayList<HallType>();
				CinemaInfoType osmCinemaInfoType = new CinemaInfoType();
				CinemaType osmCinemaType = new CinemaType();
				for (int i = 0; i < cinema.getHalls().size(); i++) {
					FilmType osmFilmType = new FilmType();
					HallInfoType osmHallInfoType = new HallInfoType();
					HallType osmHallType = new HallType();
					osmFilmType.setCast(cinema.getHalls().get(i).getFilm().getCast());
					osmFilmType.setDirector(cinema.getHalls().get(i).getFilm().getDirector());
					osmFilmType.setDuration(cinema.getHalls().get(i).getFilm().getDuration());
					osmFilmType.setName(cinema.getHalls().get(i).getFilm().getName());
					osmFilmType.setPlot(cinema.getHalls().get(i).getFilm().getPlot());
					osmFilmType.setType(cinema.getHalls().get(i).getFilm().getType());
					osmHallInfoType.setFilm(osmFilmType);
					osmHallInfoType.setFreeSeatsNumber(cinema.getHalls().get(i).getFreeSeatsNumber());
					osmHallInfoType.setPrice(cinema.getHalls().get(i).getPrice());
					gtime.setTime(cinema.getHalls().get(i).getTime());
					xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gtime);
					osmHallInfoType.setTime(xmlCalendar);
					osmHallType.setHallInfo(osmHallInfoType);
					osmHallType.setNumber(cinema.getHalls().get(i).getHall().getNumber());
					osmHallType.setSeatsNumber(cinema.getHalls().get(i).getHall().getSeatsNumber());
					halls.add(osmHallType);
				}
				osmCinemaInfoType.setHall(halls);
				osmCinemaInfoType.setAddress(cinema.getAddress());
				osmCinemaInfoType.setCap(cinema.getCap());
				osmCinemaInfoType.setCity(cinema.getCity());
				osmCinemaInfoType.setName(cinema.getName());
				osmCinemaInfoType.setTelephoneNumber(cinema.getTelephoneNumber());
				osmCinemaType.setCinemaInfo(osmCinemaInfoType);
				osmCinemaType.setLat(cinema.getLatitude());
				osmCinemaType.setLon(cinema.getLongitude());
				response.getCinemas().add(osmCinemaType);
			}
			return response;
		} catch (Exception ex) {
			throw new CinemaInformationFault_Exception("Something was wrong with response");
		}
	}
}
