package it.univaq.disim.sose.cald.cinemainserting.business.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.sql.DataSource;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.cinemainserting.CinemaInsertRequest;
import it.univaq.disim.sose.cald.cinemainserting.CinemaInsertResponse;
import it.univaq.disim.sose.cald.cinemainserting.CinemaUpdateRequest;
import it.univaq.disim.sose.cald.cinemainserting.CinemaUpdateResponse;
import it.univaq.disim.sose.cald.cinemainserting.HallType;
import it.univaq.disim.sose.cald.cinemainserting.business.BusinessException;
import it.univaq.disim.sose.cald.cinemainserting.business.CinemaInsertingService;
import it.univaq.disim.sose.cald.cinemainserting.business.model.Cinema;
import it.univaq.disim.sose.cald.cinemainserting.business.model.Film;
import it.univaq.disim.sose.cald.cinemainserting.business.model.Hall;
import it.univaq.disim.sose.cald.cinemainserting.business.model.HallInfo;
import it.univaq.disim.sose.cald.cinemainserting.HallInfoType;

@Service
public class JDBCCinemaInsertingServiceImpl implements CinemaInsertingService {

	private static Logger LOGGER = LoggerFactory.getLogger(JDBCCinemaInsertingServiceImpl.class);

	@Autowired
	private DataSource dataSource;

	@Override
	public CinemaInsertResponse insertCinema(CinemaInsertRequest parameters) throws BusinessException {

		LOGGER.info("Called JDBCInserting");
		
		Cinema newCinema= new Cinema();
		List<Hall> hall_list = new ArrayList<Hall>();
		
		newCinema.setLatitude(parameters.getCinema().getLat());
		newCinema.setLongitude(parameters.getCinema().getLon());
		newCinema.setName(parameters.getCinema().getCinemaInfo().getName());
		newCinema.setAddress(parameters.getCinema().getCinemaInfo().getAddress());
		newCinema.setCap(parameters.getCinema().getCinemaInfo().getCap());
		newCinema.setCity(parameters.getCinema().getCinemaInfo().getCity());
		newCinema.setTelephoneNumber(parameters.getCinema().getCinemaInfo().getTelephoneNumber());
		
		
		for(HallType x : parameters.getCinema().getCinemaInfo().getHall()) {
			Hall newHall  = new Hall();

			newHall.setNumber(x.getNumber());
			newHall.setSeatsNumber(x.getSeatsNumber());
			List<HallInfo> listHallInfo = new ArrayList<HallInfo>();
			
			for(HallInfoType h : x.getHallInfo()) {
				HallInfo newHallInfo = new HallInfo();

				newHallInfo.setTime(toDate(h.getTime()));
				newHallInfo.setFreeSeatsNumber(h.getFreeSeatsNumber());
				newHallInfo.setPrice(h.getPrice());
				Film newFilm = new Film();
				newFilm.setName(h.getFilm().getName());
				newFilm.setDirector(h.getFilm().getDirector());
				newFilm.setCast(h.getFilm().getCast());
				newFilm.setDuration(h.getFilm().getDuration());
				newFilm.setType(h.getFilm().getType());
				newFilm.setPlot(h.getFilm().getPlot());
				newHallInfo.setFilm(newFilm);
				listHallInfo.add(newHallInfo);
			}
			
			newHall.setHallInfo(listHallInfo);
			hall_list.add(newHall);
			
		}
		newCinema.setHall(hall_list);
		

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
			
			sql_iCinema.setDouble(1, newCinema.getLatitude());
			sql_iCinema.setDouble(2, newCinema.getLongitude());
			sql_iCinema.setString(3, newCinema.getName());
			sql_iCinema.setString(4, newCinema.getAddress());
			sql_iCinema.setString(5, newCinema.getCap());
			sql_iCinema.setString(6, newCinema.getCity());
			sql_iCinema.setString(7, newCinema.getTelephoneNumber());

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
			for (int i = 0; i < hall_list.size(); i++) {	/* Hall iteration */
				
				sql_iHalls.setInt(1, hall_list.get(i).getNumber());
				sql_iHalls.setInt(2, hall_list.get(i).getSeatsNumber());
				sql_iHalls.setInt(3, id_newCinema);

				if (sql_iHalls.executeUpdate() == 1) {
					try (ResultSet keys = sql_iHalls.getGeneratedKeys()) {
						if (keys.next()) {
							id_newHall = keys.getInt(1);
						}
					}
				}

				for (int j = 0; j < hall_list.get(i).getHallInfo().size(); j++) { /* film iteration */
					
					/* check films  presence*/
					film_name = hall_list.get(i).getHallInfo().get(j).getFilm().getName();
					film_director = hall_list.get(i).getHallInfo().get(j).getFilm().getDirector();
					
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
						
						sql_iFilms.setString(1, hall_list.get(i).getHallInfo().get(j).getFilm().getName());
						sql_iFilms.setString(2, hall_list.get(i).getHallInfo().get(j).getFilm().getDirector());
						sql_iFilms.setString(3, hall_list.get(i).getHallInfo().get(j).getFilm().getCast());
						sql_iFilms.setInt(4, hall_list.get(i).getHallInfo().get(j).getFilm().getDuration());
						sql_iFilms.setString(5,
								hall_list.get(i).getHallInfo().get(j).getFilm().getType());
						sql_iFilms.setString(6, hall_list.get(i).getHallInfo().get(j).getFilm().getPlot());

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
							new Timestamp(hall_list.get(i).getHallInfo().get(j).getTime().getTime())); 
					sql_iHallFilm.setFloat(4, hall_list.get(i).getHallInfo().get(j).getPrice());
					sql_iHallFilm.setInt(5, hall_list.get(i).getHallInfo().get(j).getFreeSeatsNumber());

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
	
	public static Date toDate(XMLGregorianCalendar calendar){
        if(calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }


	@Override
	public CinemaUpdateResponse updateCinema(CinemaUpdateRequest parameters) throws BusinessException {
		LOGGER.info("Called JDBCCinemaUpdate");
		
		Cinema newCinema= new Cinema();
		List<Hall> hall_list = new ArrayList<Hall>();
		
		newCinema.setLatitude(parameters.getCinema().getLat());
		newCinema.setLongitude(parameters.getCinema().getLon());
		newCinema.setName(parameters.getCinema().getCinemaInfo().getName());
		newCinema.setAddress(parameters.getCinema().getCinemaInfo().getAddress());
		newCinema.setCap(parameters.getCinema().getCinemaInfo().getCap());
		newCinema.setCity(parameters.getCinema().getCinemaInfo().getCity());
		newCinema.setTelephoneNumber(parameters.getCinema().getCinemaInfo().getTelephoneNumber());
		newCinema.setId(parameters.getCinema().getCinemaInfo().getIdCinema());
		
		
		for(HallType x : parameters.getCinema().getCinemaInfo().getHall()) {
			Hall newHall  = new Hall();

			newHall.setNumber(x.getNumber());
			newHall.setSeatsNumber(x.getSeatsNumber());
			newHall.setHall_id(x.getIdHall());
			List<HallInfo> listHallInfo = new ArrayList<HallInfo>();
			
			for(HallInfoType h : x.getHallInfo()) {
				HallInfo newHallInfo = new HallInfo();

				newHallInfo.setTime(toDate(h.getTime()));
				newHallInfo.setFreeSeatsNumber(h.getFreeSeatsNumber());
				newHallInfo.setPrice(h.getPrice());
				newHallInfo.setId(h.getIdHallFilm());
				Film newFilm = new Film();
				newFilm.setName(h.getFilm().getName());
				newFilm.setDirector(h.getFilm().getDirector());
				newFilm.setCast(h.getFilm().getCast());
				newFilm.setDuration(h.getFilm().getDuration());
				newFilm.setType(h.getFilm().getType());
				newFilm.setPlot(h.getFilm().getPlot());
				newFilm.setId(h.getFilm().getIdFilm());
				newHallInfo.setFilm(newFilm);
				listHallInfo.add(newHallInfo);
			}
			
			newHall.setHallInfo(listHallInfo);
			hall_list.add(newHall);
			
		}
		newCinema.setHall(hall_list);
		
		
		int id_newCinema = 0;
		int id_newHall = 0;
		int id_newFilm = 0;
		int id_newHallFilm = 0;
		String film_name = "", film_director = "";
		boolean updateCinema=false;

		Connection con = null;
		PreparedStatement sql_iCinema, sql_iHalls, sql_iFilms, sql_iHallFilm;
		Statement st = null;
		ResultSet rss = null;
		
		
		try {
			con = dataSource.getConnection();
			sql_iCinema = con.prepareStatement(
					"UPDATE cinemas SET cinema_lat=?,cinema_lon=?,cinema_name=?,cinema_address=?,cinema_cap=?,cinema_city=?,cinema_telephoneNumber=? WHERE cinema_id=?");
			/*UpdateCinema cinema*/
			
			sql_iCinema.setDouble(1, newCinema.getLatitude());
			sql_iCinema.setDouble(2, newCinema.getLongitude());
			sql_iCinema.setString(3, newCinema.getName());
			sql_iCinema.setString(4, newCinema.getAddress());
			sql_iCinema.setString(5, newCinema.getCap());
			sql_iCinema.setString(6, newCinema.getCity());
			sql_iCinema.setString(7, newCinema.getTelephoneNumber());
			sql_iCinema.setLong(8, newCinema.getId());

			if (sql_iCinema.executeUpdate() == 1) {
				updateCinema=true;
			}

			sql_iHalls = con.prepareStatement("UPDATE halls SET number=?,seatsNumber=?,cinema=? WHERE hall_id=?");
			/*insert halls*/
			for (int i = 0; i < hall_list.size(); i++) {	/* Hall iteration */
				
				sql_iHalls.setInt(1, hall_list.get(i).getNumber());
				sql_iHalls.setInt(2, hall_list.get(i).getSeatsNumber());
				sql_iHalls.setLong(3, newCinema.getId());
				sql_iHalls.setLong(4, newCinema.getHall().get(i).getHall_id());
				
				
				if (sql_iHalls.executeUpdate() == 1) {
					
				}

				for (int j = 0; j < hall_list.get(i).getHallInfo().size(); j++) { /* film iteration */
					
					

					
						sql_iFilms = con.prepareStatement(
								"UPDATE films  SET name=?,director=?,cast=?,duration=?,type=?,plot=? WHERE film_id=?");
						
						sql_iFilms.setString(1, hall_list.get(i).getHallInfo().get(j).getFilm().getName());
						sql_iFilms.setString(2, hall_list.get(i).getHallInfo().get(j).getFilm().getDirector());
						sql_iFilms.setString(3, hall_list.get(i).getHallInfo().get(j).getFilm().getCast());
						sql_iFilms.setInt(4, hall_list.get(i).getHallInfo().get(j).getFilm().getDuration());
						sql_iFilms.setString(5,
								hall_list.get(i).getHallInfo().get(j).getFilm().getType());
						sql_iFilms.setString(6, hall_list.get(i).getHallInfo().get(j).getFilm().getPlot());
						sql_iFilms.setLong(7, hall_list.get(i).getHallInfo().get(j).getFilm().getId());

						if (sql_iFilms.executeUpdate() == 1) {
							
						}


					
					/* insert hall film */

					sql_iHallFilm = con.prepareStatement(
							"UPDATE hall_film SET hall=?,film=?,time=?,price=?,freeSeatsNumber=? WHERE hall_film_id=?");
					sql_iHallFilm.setLong(1, newCinema.getHall().get(i).getHall_id());
					sql_iHallFilm.setLong(2, newCinema.getHall().get(i).getHallInfo().get(j).getFilm().getId());
					sql_iHallFilm.setTimestamp(3,
							new Timestamp(hall_list.get(i).getHallInfo().get(j).getTime().getTime())); 
					sql_iHallFilm.setFloat(4, hall_list.get(i).getHallInfo().get(j).getPrice());
					sql_iHallFilm.setInt(5, hall_list.get(i).getHallInfo().get(j).getFreeSeatsNumber());
					sql_iHallFilm.setLong(6, hall_list.get(i).getHallInfo().get(j).getId());

					if (sql_iHallFilm.executeUpdate() == 1) {
						
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
		
		return null;
	}

}
