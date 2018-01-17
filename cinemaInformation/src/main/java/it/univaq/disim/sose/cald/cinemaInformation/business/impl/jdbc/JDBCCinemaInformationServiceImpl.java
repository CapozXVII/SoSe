package it.univaq.disim.sose.cald.cinemaInformation.business.impl.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.cinemaInformation.business.BusinessException;
import it.univaq.disim.sose.cald.cinemaInformation.business.CinemaInformationService;
import it.univaq.disim.sose.cald.cinemaInformation.business.model.*;

@Service
public class JDBCCinemaInformationServiceImpl implements CinemaInformationService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(JDBCCinemaInformationServiceImpl.class);
	
	//private Map<Cinema, Map<Hall, Map<HallFilm, Film>>> listCinema = new HashMap<Cinema, Map<Hall, Map<HallFilm, Film>>>();
	//private Map<Cinema, List<HallFilm>> listCinema = new HashMap<Cinema, List<HallFilm>>();
	@Autowired
	private DataSource dataSource;
	
	List<HallFilm> hallFilmList = new ArrayList<HallFilm>();

	public List<HallFilm> getCinemas(String city) throws BusinessException {
		String sql = "SELECT * FROM cinema JOIN halls ON cinema.cinema_id = halls.cinema JOIN hall_film ON hall_film.hall = halls.hall_id JOIN films ON films.film_id = hall_film.film AND cinema.cinema_city =" + city + " " + "ORDER BY cinema.cinema_id";
		LOGGER.info(sql);
		Long count = (long) 0;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Hall hall = new Hall();
				Film film = new Film();
				HallFilm hallFilm = new HallFilm();
				Cinema cinema = new Cinema();
				cinema.setId(rs.getLong("cinema_id"));
				cinema.setName(rs.getString("cinema_name"));
				cinema.setLatitude(rs.getDouble("cinema_ilat"));
				cinema.setLongitude(rs.getDouble("cinema_ilon"));
				cinema.setAddress(rs.getString("cinema_iaddress"));
				cinema.setCap(rs.getString("cinema_icap"));
				cinema.setCity(city);
				cinema.setTelephoneNumber(rs.getString("cinema_itelephoneNumber"));
				hall.setId(rs.getLong("hall_id"));
				hall.setNumber(rs.getInt("number"));
				hall.setSeatsNumber(rs.getInt("seatsNumber"));
				hall.setCinema(cinema);
				film.setId(rs.getLong("film_id"));
				film.setCast(rs.getString("cast"));
				film.setDirector(rs.getString("director"));
				film.setDuration(rs.getInt("duration"));
				film.setName(rs.getString("name"));
				film.setPlot(rs.getString("plot"));
				film.setRating(rs.getString("rating"));
				hallFilm.setId(rs.getLong("hall_film_id"));
				hallFilm.setFreeSeatsNumber(rs.getInt("freeSeatsNumber"));
				hallFilm.setPrice(rs.getFloat("price"));
				hallFilm.setTime(rs.getDate("time"));
				hallFilm.setHall(hall);
				hallFilm.setFilm(film);
				hallFilmList.add(hallFilm);
				/*
				if (count == rs.getLong("parking_id") && cinema != null) {
					listCinema.put(cinema, hallFilmList);
				}
				if (count != rs.getLong("parking_id")) {
					count = rs.getLong("parking_id");
					cinema = new Cinema();
					cinema.setId(rs.getLong("parking_id"));
					cinema.setLatitude(rs.getDouble("lat"));
					cinema.setLongitude(rs.getDouble("lon"));
					cinema.setAddress(rs.getString("address"));
					cinema.setCap(rs.getString("cap"));
					cinema.setCity(city);
					cinema.setTelephoneNumber(rs.getString("telephoneNumber"));
				}
				*/
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		}
		return hallFilmList;
	}
}
