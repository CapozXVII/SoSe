package it.univaq.disim.sose.cald.cinemainserting.business;

import it.univaq.disim.sose.cald.cinemainserting.CinemaDeleteFault_Exception;
import it.univaq.disim.sose.cald.cinemainserting.CinemaDeleteRequest;
import it.univaq.disim.sose.cald.cinemainserting.CinemaDeleteResponse;
import it.univaq.disim.sose.cald.cinemainserting.CinemaInsertFault_Exception;
import it.univaq.disim.sose.cald.cinemainserting.CinemaInsertRequest;
import it.univaq.disim.sose.cald.cinemainserting.CinemaInsertResponse;
import it.univaq.disim.sose.cald.cinemainserting.CinemaUpdateFault_Exception;
import it.univaq.disim.sose.cald.cinemainserting.CinemaUpdateRequest;
import it.univaq.disim.sose.cald.cinemainserting.CinemaUpdateResponse;

public interface CinemaInsertingService {
	
	CinemaInsertResponse insertCinema(CinemaInsertRequest parameters) throws CinemaInsertFault_Exception;
	
	CinemaUpdateResponse updateCinema(CinemaUpdateRequest parameters) throws CinemaUpdateFault_Exception;
	
	CinemaDeleteResponse deleteCinema(CinemaDeleteRequest parameters) throws CinemaDeleteFault_Exception;

}
