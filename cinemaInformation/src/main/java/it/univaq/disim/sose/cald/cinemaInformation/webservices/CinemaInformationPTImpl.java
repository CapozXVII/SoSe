package it.univaq.disim.sose.cald.cinemaInformation.webservices;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.cald.cinemaInformation.business.CinemaInformationService;
import it.univaq.disim.sose.cald.cinemaInformation.business.model.HallFilm;
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
			List<HallFilm> cinema = service.getCinemas(parameters.getCity());
			CinemaInformationResponse response = new CinemaInformationResponse();
			
			for (HallFilm hallFilm: cinema) {
				FilmType osmFilmType = new FilmType();
				HallInfoType osmHallInfoType = new HallInfoType();
				HallType osmHallType = new HallType();
				CinemaInfoType osmCinemaInfoType = new CinemaInfoType();
				CinemaType osmCinemaType = new CinemaType();
				osmFilmType.setCast(hallFilm.getFilm().getCast());
				osmFilmType.setDirector(hallFilm.getFilm().getDirector());
				osmFilmType.setDuration(hallFilm.getFilm().getDuration());
				osmFilmType.setName(hallFilm.getFilm().getName());
				osmFilmType.setPlot(hallFilm.getFilm().getPlot());
				osmFilmType.setRating(hallFilm.getFilm().getRating());
				osmHallInfoType.setFilm(osmFilmType);
				osmHallInfoType.setFreeSeatsNumber(hallFilm.getFreeSeatsNumber());
				osmHallInfoType.setPrice(hallFilm.getPrice());
				osmHallInfoType.setTime(hallFilm.getTime());
				osmHallType.setHallInfo(osmHallInfoType);
				osmHallType.setNumber(hallFilm.getHall().getNumber());
				osmHallType.setSeatsNumber(hallFilm.getHall().getSeatsNumber());
				osmCinemaInfoType.setAddress(hallFilm.getHall().getCinema().getAddress());
				osmCinemaInfoType.setCap(hallFilm.getHall().getCinema().getCap());
				osmCinemaInfoType.setCity(hallFilm.getHall().getCinema().getCity());
				osmCinemaInfoType.setName(hallFilm.getHall().getCinema().getName());
				osmCinemaInfoType.setTelephoneNumber(hallFilm.getHall().getCinema().getTelephoneNumber());
				osmCinemaType.setCinemaInfo(osmCinemaInfoType);
				osmCinemaType.setLat(hallFilm.getHall().getCinema().getLatitude());
				osmCinemaType.setLon(hallFilm.getHall().getCinema().getLongitude());
				response.getCinemas().add(osmCinemaType);
			}
			return response;
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}
}
