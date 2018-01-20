package it.univaq.disim.sose.cald.cinemaInserting.webservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.univaq.disim.sose.cald.cinemaInserting.CinemaInsertFault_Exception;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaInsertRequest;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaInsertResponse;
import it.univaq.disim.sose.cald.cinemaInserting.business.CinemaInsertingService;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaPT;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaUpdateFault_Exception;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaUpdateRequest;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaUpdateResponse;


@Component(value = "cinemaInsertingPTImpl")
public class cinemaInsertingPTImpl implements CinemaPT {
	
	private static Logger LOGGER = LoggerFactory.getLogger(cinemaInsertingPTImpl.class);
	
	@Autowired
	private CinemaInsertingService service;

	@Override
	public CinemaInsertResponse cinemaInsert(CinemaInsertRequest parameters) throws CinemaInsertFault_Exception {
		LOGGER.info("CALLED CinemaInserting");
		try {
			CinemaInsertResponse response=service.insertCinema(parameters);
			return response;
			
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
		
	}

	@Override
	public CinemaUpdateResponse cinemaUpdate(CinemaUpdateRequest parameters) throws CinemaUpdateFault_Exception {
		LOGGER.info("CALLED CinemaInserting");
		try {
			CinemaUpdateResponse response=service.updateCinema(parameters);
			return response;
			
		}catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

}
