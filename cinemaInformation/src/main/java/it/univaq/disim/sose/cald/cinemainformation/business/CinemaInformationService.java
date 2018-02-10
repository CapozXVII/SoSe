package it.univaq.disim.sose.cald.cinemainformation.business;

import java.util.List;

import it.univaq.disim.sose.cald.cinemainformation.CinemaInformationFault_Exception;
import it.univaq.disim.sose.cald.cinemainformation.business.model.Cinema;

public interface CinemaInformationService {

	List<Cinema> getCinemas(String city) throws CinemaInformationFault_Exception;
	
	Cinema getSingleCinema(long id)throws CinemaInformationFault_Exception;
}
