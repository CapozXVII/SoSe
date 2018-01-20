package it.univaq.disim.sose.cald.cinemaInformation.business;

import java.util.List;

import it.univaq.disim.sose.cald.cinemaInformation.business.model.Cinema;

public interface CinemaInformationService {
	
	List<Cinema> getCinemas(String city) throws BusinessException;
	
	
	
}
