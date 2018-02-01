package it.univaq.disim.sose.cald.cinemaInserting.business.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.cinemaInserting.CinemaInfoType;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaInsertRequest;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaInsertResponse;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaType;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaUpdateRequest;
import it.univaq.disim.sose.cald.cinemaInserting.CinemaUpdateResponse;
import it.univaq.disim.sose.cald.cinemaInserting.HallType;
import it.univaq.disim.sose.cald.cinemaInserting.business.BusinessException;
import it.univaq.disim.sose.cald.cinemaInserting.business.CinemaInsertingService;
import it.univaq.disim.sose.cald.cinemaInserting.DiscountType;
import it.univaq.disim.sose.cald.cinemaInserting.HallInfoType;

@Service
public class JDBCCinemaInsertingServiceImpl implements CinemaInsertingService {

	private static Logger LOGGER = LoggerFactory.getLogger(JDBCCinemaInsertingServiceImpl.class);

	@Autowired
	private DataSource dataSource;

	@Override
	public CinemaInsertResponse insertCinema(CinemaInsertRequest parameters) throws BusinessException {

		LOGGER.info("Called JDBCInserting");

		CinemaType newCinema = parameters.getCinema();
		double lat = newCinema.getLat();
		double lon = newCinema.getLon();
		CinemaInfoType newCinemaInfo = newCinema.getCinemaInfo();
		String name = newCinemaInfo.getName();
		String address = newCinemaInfo.getAddress();
		int cap = newCinemaInfo.getCap();
		String city = newCinemaInfo.getCity();
		String telephoneNumber = newCinemaInfo.getTelephoneNumber();
		List<HallType> hall = newCinemaInfo.getHall();

		int id_newCinema = 0;
		int id_newHall = 0;
		int id_newFilm = 0;
		int id_newHallFilm = 0;
		String film_name = "", film_director = "";

		Connection con = null;
		PreparedStatement sql_iCinema, sql_iHalls, sql_iFilms, sql_iHallFilm;
		Statement st = null;
		ResultSet rss = null;

		try {
			con = dataSource.getConnection();
			sql_iCinema = con.prepareStatement(
					"INSERT INTO cinema (cinema_lat,cinema_lon,cinema_name,cinema_address,cinema_cap,cinema_city,cinema_telephoneNumber) VALUES (?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			/*Insert cinema*/
			
			sql_iCinema.setDouble(1, lat);
			sql_iCinema.setDouble(2, lon);
			sql_iCinema.setString(3, name);
			sql_iCinema.setString(4, address);
			sql_iCinema.setInt(5, cap);
			sql_iCinema.setString(6, city);
			sql_iCinema.setString(7, telephoneNumber);

			if (sql_iCinema.executeUpdate() == 1) {
				try (ResultSet keys = sql_iCinema.getGeneratedKeys()) {
					if (keys.next()) {
						id_newCinema = keys.getInt(1);
					}
				}
			}

			sql_iHalls = con.prepareStatement("INSERT INTO halls (number,seatsNumber,cinema) VALUES (?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			/*insert halls*/
			for (int i = 0; i < hall.size(); i++) {	/* Hall iteration */
				
				sql_iHalls.setInt(1, hall.get(i).getNumber());
				sql_iHalls.setInt(2, hall.get(i).getSeatsNumber());
				sql_iHalls.setInt(3, id_newCinema);

				if (sql_iHalls.executeUpdate() == 1) {
					try (ResultSet keys = sql_iHalls.getGeneratedKeys()) {
						if (keys.next()) {
							id_newHall = keys.getInt(1);
						}
					}
				}

				for (int j = 0; j < hall.get(i).getHallInfo().size(); j++) { /* film iteration */
					
					/* check films  presence*/
					film_name = hall.get(i).getHallInfo().get(j).getFilm().getName();
					film_director = hall.get(i).getHallInfo().get(j).getFilm().getDirector();
					
					String sql_sFilm = "SELECT film_id FROM films WHERE name='" + film_name + "' AND director='"
							+ film_director + "'";

					st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					rss = st.executeQuery(sql_sFilm);
					rss.last();
					int numRows = rss.getRow();
					
					/*if film is not in the db then insert film */

					if (numRows == 0) {
						sql_iFilms = con.prepareStatement(
								"INSERT INTO films (name,director,cast,duration,type,plot) VALUES (?,?,?,?,?,?)",
								Statement.RETURN_GENERATED_KEYS);
						
						sql_iFilms.setString(1, hall.get(i).getHallInfo().get(j).getFilm().getName());
						sql_iFilms.setString(2, hall.get(i).getHallInfo().get(j).getFilm().getDirector());
						sql_iFilms.setString(3, hall.get(i).getHallInfo().get(j).getFilm().getCast());
						sql_iFilms.setInt(4, hall.get(i).getHallInfo().get(j).getFilm().getDuration());
						sql_iFilms.setString(5,
								hall.get(i).getHallInfo().get(j).getFilm().getType());
						sql_iFilms.setString(6, hall.get(i).getHallInfo().get(j).getFilm().getPlot());

						if (sql_iFilms.executeUpdate() == 1) {
							try (ResultSet keys = sql_iFilms.getGeneratedKeys()) {
								if (keys.next()) {
									id_newFilm = keys.getInt(1); 
								}
							}
						}


					} else {
						/*if the film is in the db take its id*/
						rss.first();
						id_newFilm = rss.getInt("film_id");
						
					}
					/* insert hall film */

					sql_iHallFilm = con.prepareStatement(
							"INSERT INTO hall_film (hall,film,time,price,freeSeatsNumber) VALUES (?,?,?,?,?)",
							Statement.RETURN_GENERATED_KEYS);
					sql_iHallFilm.setInt(1, id_newHall);
					sql_iHallFilm.setInt(2, id_newFilm);
					sql_iHallFilm.setTimestamp(3,
							new Timestamp(hall.get(i).getHallInfo().get(j).getTime().getTime())); 
					sql_iHallFilm.setFloat(4, hall.get(i).getHallInfo().get(j).getPrice());
					sql_iHallFilm.setInt(5, hall.get(i).getHallInfo().get(j).getFreeSeatsNumber());

					if (sql_iHallFilm.executeUpdate() == 1) {
						try (ResultSet keys = sql_iHallFilm.getGeneratedKeys()) {
							if (keys.next()) {
								id_newHallFilm = keys.getInt(1); 
							}
						}
					}

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
				} catch (SQLException e) {
				}
			}
		}

		CinemaInsertResponse result = new CinemaInsertResponse();
		result.setAccepted(true); /* controllare se va bene */

		return result;
	}

	@Override
	public CinemaUpdateResponse updateCinema(CinemaUpdateRequest parameters) throws BusinessException {
		LOGGER.info("Called JDBCInserting");
		return null;
	}

}
