package it.univaq.disim.sose.cald.cinemaInserting.business.impl.jdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.cinemaInserting.CinemaInsertRequest;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaInsertResponse;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaUpdateRequest;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaUpdateResponse;
import it.univaq.disim.sose.cald.cinemaInserting.business.BusinessException;
import it.univaq.disim.sose.cald.cinemaInserting.business.CinemaInsertingService;


@Service
public class JDBCCinemaInsertingServiceImpl implements CinemaInsertingService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(JDBCCinemaInsertingServiceImpl.class);
	
	@Autowired
	private DataSource dataSource;

	@Override
	public CinemaInsertResponse insertCinema(CinemaInsertRequest parameters) throws BusinessException {
		LOGGER.info("Called JDBCInserting");
		CinemaInsertResponse result = new CinemaInsertResponse(); 
		result.setAccepted(true); /* controllare se va bene*/
		
		return result;
	}

	@Override
	public CinemaUpdateResponse updateCinema(CinemaUpdateRequest parameters) throws BusinessException {
		LOGGER.info("Called JDBCInserting");
		return null;
	}

}
