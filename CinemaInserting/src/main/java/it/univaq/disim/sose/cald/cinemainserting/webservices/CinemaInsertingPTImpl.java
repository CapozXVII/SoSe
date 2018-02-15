package it.univaq.disim.sose.cald.cinemainserting.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.cald.cinemainserting.CinemaDeleteFault_Exception;
import it.univaq.disim.sose.cald.cinemainserting.CinemaDeleteRequest;
import it.univaq.disim.sose.cald.cinemainserting.CinemaDeleteResponse;
import it.univaq.disim.sose.cald.cinemainserting.CinemaInsertFault_Exception;
import it.univaq.disim.sose.cald.cinemainserting.CinemaInsertRequest;
import it.univaq.disim.sose.cald.cinemainserting.CinemaInsertResponse;
import it.univaq.disim.sose.cald.cinemainserting.business.CinemaInsertingService;
import it.univaq.disim.sose.cald.cinemainserting.CinemaPT;
import it.univaq.disim.sose.cald.cinemainserting.CinemaUpdateFault_Exception;
import it.univaq.disim.sose.cald.cinemainserting.CinemaUpdateRequest;
import it.univaq.disim.sose.cald.cinemainserting.CinemaUpdateResponse;


@Component(value = "CinemaInsertingPTImpl")
public class CinemaInsertingPTImpl implements CinemaPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CinemaInsertingPTImpl.class);
	
	@Autowired
	private CinemaInsertingService service;

	@Override
	public CinemaInsertResponse cinemaInsert(CinemaInsertRequest parameters) throws CinemaInsertFault_Exception {
		LOGGER.info("CALLED CinemaInserting");
		try {
			CinemaInsertResponse response = service.insertCinema(parameters);
			return response;
			
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
		
	}

	@Override
	public CinemaUpdateResponse cinemaUpdate(CinemaUpdateRequest parameters) throws CinemaUpdateFault_Exception {
		LOGGER.info("CALLED CinemaInserting");
		try {
			CinemaUpdateResponse response = service.updateCinema(parameters);
			return response;
			
		}catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

	@Override
	public CinemaDeleteResponse cinemaDelete(CinemaDeleteRequest parameters) throws CinemaDeleteFault_Exception {
		LOGGER.info("CALLED CinemaDelete");
		try {
			CinemaDeleteResponse response = service.deleteCinema(parameters);
			return response;
			
		}catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}
}
