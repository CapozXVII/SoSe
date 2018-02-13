package it.univaq.disim.sose.cald.cinemainserting.business;

import it.univaq.disim.sose.cald.cinemainserting.CinemaDeleteRequest;
import it.univaq.disim.sose.cald.cinemainserting.CinemaDeleteResponse;
import it.univaq.disim.sose.cald.cinemainserting.CinemaInsertRequest;
import it.univaq.disim.sose.cald.cinemainserting.CinemaInsertResponse;
import it.univaq.disim.sose.cald.cinemainserting.CinemaUpdateRequest;
import it.univaq.disim.sose.cald.cinemainserting.CinemaUpdateResponse;

public interface CinemaInsertingService {
	
	CinemaInsertResponse insertCinema(CinemaInsertRequest parameters)throws BusinessException;
	
	CinemaUpdateResponse updateCinema(CinemaUpdateRequest parameters)throws BusinessException;
	
	CinemaDeleteResponse deleteCinema(CinemaDeleteRequest parameters)throws BusinessException;

}
