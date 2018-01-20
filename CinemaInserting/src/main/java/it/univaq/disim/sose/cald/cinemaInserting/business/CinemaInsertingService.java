package it.univaq.disim.sose.cald.cinemaInserting.business;

import it.univaq.disim.sose.cald.cinemaInserting.CinemaInsertRequest;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaInsertResponse;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaUpdateRequest;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaUpdateResponse;

public interface CinemaInsertingService {
	
	CinemaInsertResponse insertCinema(CinemaInsertRequest parameters)throws BusinessException;
	
	CinemaUpdateResponse updateCinema(CinemaUpdateRequest parameters)throws BusinessException;

}
