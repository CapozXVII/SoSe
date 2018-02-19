package it.univaq.disim.sose.cald.cinemainformation.business.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.cinemainformation.CinemaInformationFault_Exception;
import it.univaq.disim.sose.cald.cinemainformation.business.CinemaInformationService;
import it.univaq.disim.sose.cald.cinemainformation.business.model.*;

@Service
public class JDBCCinemaInformationServiceImpl implements CinemaInformationService {
		
	@Autowired
	private DataSource dataSource;
	
	/**
     * Get information about all the cinema given a city
     * @param parameters City where the user wants to see the cinemas
     * @return response List of cinemas in the city passed in input
     */
	public List<Cinema> getCinemas(String city) throws CinemaInformationFault_Exception {
		List<Cinema> cinemaList = new ArrayList<Cinema>();
		List<HallFilm> hallFilmList = new ArrayList<HallFilm>();
		String sql = "SELECT * FROM cinemas JOIN halls ON cinemas.cinema_id = halls.cinema JOIN hall_film ON hall_film.hall = halls.hall_id JOIN films ON films.film_id = hall_film.film AND cinemas.cinema_city = ? ORDER BY cinemas.cinema_id";
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Cinema cinema = null;
			int count = 0;
			
			con = dataSource.getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, city);
			rs = st.executeQuery();
			int cinemaId = 0;
			
			while (rs.next()) {
				cinemaId = rs.getInt("cinema_id");
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
			throw new CinemaInformationFault_Exception("Something was wrong with Cinema creation");
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
		Date date = new Date(rs.getTimestamp("time").getTime());
		hallFilm.setTime(date);
		hallFilm.setHall(hall);
		hallFilm.setFilm(film);
		return hallFilm;
	}

	/**
     * Get information about a single cinema
     * @param id cinema_id we want to show out 
     * @return response Information about the cinema
     */
	@Override
	public Cinema getSingleCinema(long id) throws CinemaInformationFault_Exception {
		Cinema cinema= new Cinema();
		List<HallFilm> hallFilmList = new ArrayList<HallFilm>();
		String sql = "SELECT * FROM cinemas JOIN halls ON cinemas.cinema_id = halls.cinema JOIN hall_film ON hall_film.hall = halls.hall_id JOIN films ON films.film_id = hall_film.film AND cinemas.cinema_id = ?";

		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			st = con.prepareStatement(sql);
			st.setLong(1, id);
			rs = st.executeQuery();
			
			while(rs.next()) {
				if(rs.first()) {
					cinema = createCinema(rs);
					hallFilmList.add(createHallFilm(rs));
				}
				
				if(!rs.first() && !rs.last()) {
					hallFilmList.add(createHallFilm(rs));
				}
				
				if(rs.last()) {
					hallFilmList.add(createHallFilm(rs));
					cinema.setHalls(hallFilmList);	
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		return cinema;
	}
}
