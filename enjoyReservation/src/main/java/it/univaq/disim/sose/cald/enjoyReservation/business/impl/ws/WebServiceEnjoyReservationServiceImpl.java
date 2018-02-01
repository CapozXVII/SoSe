package it.univaq.disim.sose.cald.enjoyreservation.business.impl.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationFault_Exception;
import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationPT;
import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationRequest;
import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationResponse;
import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaInformationService;
import it.univaq.disim.sose.cald.clients.cinemainformation.CinemaType;
import it.univaq.disim.sose.cald.clients.cinemainformation.HallType;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetCinemaInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoRequest;
import it.univaq.disim.sose.cald.enjoyreservation.GetRestaurantInfoResponse;
import it.univaq.disim.sose.cald.enjoyreservation.OSMCinemaInfoType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMCinemaType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMFilmType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMHallInfoType;
import it.univaq.disim.sose.cald.enjoyreservation.OSMHallType;
import it.univaq.disim.sose.cald.enjoyreservation.business.BusinessException;
import it.univaq.disim.sose.cald.enjoyreservation.business.EnjoyReservationService;

@Service
public class WebServiceEnjoyReservationServiceImpl implements EnjoyReservationService {

	@Override
	public GetRestaurantInfoResponse getRestaurantInfo(GetRestaurantInfoRequest request) throws BusinessException {
		return null;
	}

	@Override
	public GetCinemaInfoResponse getCinemaInfo(GetCinemaInfoRequest request) throws BusinessException {
		GetCinemaInfoResponse response = new GetCinemaInfoResponse();
		List<CinemaType> cinemas = new ArrayList<CinemaType>();
		List<OSMCinemaType> cinemasResponse = new ArrayList<OSMCinemaType>();
		List<OSMHallType> hallResponse = new ArrayList<OSMHallType>();
		
		CinemaInformationService cinemaInformationService = new CinemaInformationService();
		CinemaInformationPT cinemaInformation = cinemaInformationService.getCinemaInformationPort();
		CinemaInformationRequest cinemaInformationRequest = new CinemaInformationRequest();
		cinemaInformationRequest.setCity(request.getCity());
		try {
			CinemaInformationResponse cinemaInformationResponse = cinemaInformation.cinemaInformation(cinemaInformationRequest);
			cinemas = cinemaInformationResponse.getCinemas();
			for(CinemaType cinema : cinemas) {
				OSMCinemaType newCinema = new OSMCinemaType();
				OSMCinemaInfoType newCinemaInfo = new OSMCinemaInfoType();
				
				for(HallType hall : cinema.getCinemaInfo().getHall()) {
					OSMHallType newHall = new OSMHallType();
					OSMHallInfoType newHallInfo = new OSMHallInfoType();
					OSMFilmType newFilm = new OSMFilmType();
					newFilm.setCast(hall.getHallInfo().getFilm().getCast());
					newFilm.setDirector(hall.getHallInfo().getFilm().getDirector());
					newFilm.setDuration(hall.getHallInfo().getFilm().getDuration());
					newFilm.setName(hall.getHallInfo().getFilm().getName());
					newFilm.setPlot(hall.getHallInfo().getFilm().getPlot());
					newFilm.setType(hall.getHallInfo().getFilm().getType());
					newHallInfo.setFilm(newFilm);
					newHallInfo.setFreeSeatsNumber(hall.getHallInfo().getFreeSeatsNumber());
					newHallInfo.setPrice(hall.getHallInfo().getPrice());
					newHallInfo.setTime(hall.getHallInfo().getTime());
					newHall.setHallInfo(newHallInfo);
					newHall.setNumber(hall.getNumber());
					newHall.setSeatsNumber(hall.getSeatsNumber());
					hallResponse.add(newHall);
				}
				newCinemaInfo.setAddress(cinema.getCinemaInfo().getAddress());
				newCinemaInfo.setCap(cinema.getCinemaInfo().getCap());
				newCinemaInfo.setCity(cinema.getCinemaInfo().getCity());
				newCinemaInfo.setName(cinema.getCinemaInfo().getName());
				newCinemaInfo.setTelephoneNumber(cinema.getCinemaInfo().getTelephoneNumber());
				newCinemaInfo.setHall(hallResponse);
				newCinema.setCinemaInfo(newCinemaInfo);
				newCinema.setLat(cinema.getLat());
				newCinema.setLon(cinema.getLon());
				cinemasResponse.add(newCinema);
			}
			response.setCinemas(cinemasResponse);
		} catch (CinemaInformationFault_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

}
