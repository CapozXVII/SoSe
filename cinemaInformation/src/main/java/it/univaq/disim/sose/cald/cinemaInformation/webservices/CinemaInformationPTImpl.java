package it.univaq.disim.sose.cald.cinemaInformation.webservices;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.cald.cinemaInformation.business.CinemaInformationService;
import it.univaq.disim.sose.cald.cinemaInformation.business.model.Cinema;
import it.univaq.disim.sose.cald.cinemaInformation.CinemaInfoType;
import it.univaq.disim.sose.cald.cinemaInformation.CinemaInformationPT;
import it.univaq.disim.sose.cald.cinemaInformation.CinemaInformationRequest;
import it.univaq.disim.sose.cald.cinemaInformation.CinemaInformationResponse;
import it.univaq.disim.sose.cald.cinemaInformation.CinemaType;
import it.univaq.disim.sose.cald.cinemaInformation.FilmType;
import it.univaq.disim.sose.cald.cinemaInformation.HallInfoType;
import it.univaq.disim.sose.cald.cinemaInformation.HallType;

@Component(value = "CinemaInformationPTImpl")
public class CinemaInformationPTImpl implements CinemaInformationPT{

	private static Logger LOGGER = LoggerFactory.getLogger(CinemaInformationPTImpl.class);
	
	@Autowired
	CinemaInformationService service;
	
	public CinemaInformationResponse cinemaInformation(CinemaInformationRequest parameters) {
		
		LOGGER.info("CALLED cinemaInformation");
		try {
			List<Cinema> cinemaList = service.getCinemas(parameters.getCity());
			List<HallType> halls;
			CinemaInformationResponse response = new CinemaInformationResponse();
			
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
					osmHallInfoType.setTime(cinema.getHalls().get(i).getTime());
					LOGGER.info(osmHallInfoType.getTime() + "CIAOOOO");
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
			throw new RuntimeException(ex.getMessage());
		}
	}
}
