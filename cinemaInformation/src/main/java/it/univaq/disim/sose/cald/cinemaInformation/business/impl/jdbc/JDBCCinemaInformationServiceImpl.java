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
	
	public List<Cinema> getCinemas(String city) throws BusinessException {
		List<Cinema> cinemaList = new ArrayList<Cinema>();
		List<HallFilm> hallFilmList = new ArrayList<HallFilm>();
		String sql = "SELECT * FROM cinema JOIN halls ON cinema.cinema_id = halls.cinema JOIN hall_film ON hall_film.hall = halls.hall_id JOIN films ON films.film_id = hall_film.film AND cinema.cinema_city = '" + city + "' " + "ORDER BY cinema.cinema_id";
		LOGGER.info(sql);
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Cinema cinema = null;
			int count = 0;
			con = dataSource.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				int cinemaId = rs.getInt("cinema_id");
				if (rs.isFirst()) {
					count = cinemaId;
					cinema = createCinema(rs);
				}
				if (count == cinemaId) {
					hallFilmList.add(createHallFilm(rs));
				} else {
					count = cinemaId;
					cinema.setHalls(hallFilmList);
					cinemaList.add(cinema);
					hallFilmList = new ArrayList<HallFilm>();
					cinema = createCinema(rs);
					hallFilmList.add(createHallFilm(rs));
				}
				if (rs.isLast()) {
					cinema.setHalls(hallFilmList);
					cinemaList.add(cinema);
				}
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
		return cinemaList;
	}
	
	public Cinema createCinema(ResultSet rs) throws SQLException {
		Cinema cinema = new Cinema();
		cinema.setId(rs.getLong("cinema_id"));
		cinema.setName(rs.getString("cinema_name"));
		cinema.setLatitude(rs.getDouble("cinema_lat"));
		cinema.setLongitude(rs.getDouble("cinema_lon"));
		cinema.setAddress(rs.getString("cinema_address"));
		cinema.setCap(rs.getString("cinema_cap"));
		cinema.setCity(rs.getString("cinema_city"));
		cinema.setTelephoneNumber(rs.getString("cinema_telephoneNumber"));
		return cinema;
	}
	
	public HallFilm createHallFilm(ResultSet rs) throws SQLException {
		Hall hall = new Hall();
		Film film = new Film();
		HallFilm hallFilm = new HallFilm();
		hall.setId(rs.getLong("hall_id"));
		hall.setNumber(rs.getInt("number"));
		hall.setSeatsNumber(rs.getInt("seatsNumber"));
		film.setId(rs.getLong("film_id"));
		film.setCast(rs.getString("cast"));
		film.setDirector(rs.getString("director"));
		film.setDuration(rs.getInt("duration"));
		film.setName(rs.getString("name"));
		film.setPlot(rs.getString("plot"));
		film.setType(rs.getString("type"));
		hallFilm.setId(rs.getLong("hall_film_id"));
		hallFilm.setFreeSeatsNumber(rs.getInt("freeSeatsNumber"));
		hallFilm.setPrice(rs.getFloat("price"));
		hallFilm.setTime(rs.getTimestamp("time"));
		LOGGER.info(hallFilm.getTime() + "CIa");
		hallFilm.setHall(hall);
		hallFilm.setFilm(film);
		return hallFilm;
	}
}
