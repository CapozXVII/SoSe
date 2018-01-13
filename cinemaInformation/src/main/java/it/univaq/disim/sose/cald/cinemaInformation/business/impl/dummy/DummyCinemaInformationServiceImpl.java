package it.univaq.disim.sose.cald.cinemaInformation.business.impl.dummy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.cinemaInformation.business.BusinessException;
import it.univaq.disim.sose.cald.cinemaInformation.business.CinemaInformationService;
import it.univaq.disim.sose.cald.cinemaInformation.business.model.HallFilm;

@Service
public class DummyCinemaInformationServiceImpl implements CinemaInformationService{
	
	
	public List<HallFilm> getCinemas(String city) throws BusinessException {
		List<HallFilm> result = new ArrayList<HallFilm>();
		return result;
	}

}