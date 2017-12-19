package it.univaq.disim.sose.cald.cinemaInformation.business;

import java.util.List;
import it.univaq.disim.sose.cald.cinemaInformation.business.model.HallFilm;

public interface CinemaInformationService {
	
	List<HallFilm> getCinemas(String city) throws BusinessException;
}
