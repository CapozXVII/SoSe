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

@Service
public class JDBCCinemaInsertingServiceImpl implements CinemaInsertingService {

	private static Logger LOGGER = LoggerFactory.getLogger(JDBCCinemaInsertingServiceImpl.class);

	@Autowired
	private DataSource dataSource;

	@Override
	public CinemaInsertResponse insertCinema(CinemaInsertRequest parameters) throws BusinessException {
		
		LOGGER.info("Called JDBCInserting");
		
		
		CinemaType newCinema= parameters.getCinema();
		double lat = newCinema.getLat();
		double lon = newCinema.getLon();
		CinemaInfoType newCinemaInfo=newCinema.getCinemaInfo();
		String name = newCinemaInfo.getName();
		String address = newCinemaInfo.getAddress();
		int cap = newCinemaInfo.getCap();
		String city = newCinemaInfo.getCity();
		String telephoneNumber = newCinemaInfo.getTelephoneNumber();
		List <HallType> hall=newCinemaInfo.getHall();
		
		int id_newCinema=0;
		int id_newHall=0;
		int id_newFilm=0;
		int id_newHallFilm=0;
		String film_name="",film_director="";
		
		Connection con = null;
		PreparedStatement sql, sql2, sql3, sql4;
		Statement st = null;
		ResultSet rss = null;
		
		try {
			con = dataSource.getConnection();
			sql = con.prepareStatement("INSERT INTO cinema (cinema_lat,cinema_lon,cinema_name,cinema_address,cinema_cap,cinema_city,cinema_telephoneNumber) VALUES (?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			
			
			sql.setDouble(1, lat);
			sql.setDouble(2, lon);
			sql.setString(3, name);
			sql.setString(4, address);
			sql.setInt(5, cap);
			sql.setString(6, city);
			sql.setString(7, telephoneNumber);
			
			if (sql.executeUpdate() == 1) {
				try (ResultSet keys = sql.getGeneratedKeys()) {
					if (keys.next()) {
						id_newCinema = keys.getInt(1);
					}
				}
			}
			
			sql2= con.prepareStatement("INSERT INTO halls (number,seatsNumber,cinema) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
			
			for (int i=0;i<hall.size();i++) {/*itera sulle hall*/
				sql2.setInt(1, hall.get(i).getNumber());
				sql2.setInt(2, hall.get(i).getSeatsNumber());
				sql2.setInt(3, id_newCinema);
				
				if (sql2.executeUpdate() == 1) {
					try (ResultSet keys = sql2.getGeneratedKeys()) {
						if (keys.next()) {
							id_newHall=keys.getInt(1) ; 
						}
					}
				}
				
				String sql5 = "SELECT film_id FROM films WHERE name='"+film_name+"' AND director='"+film_director+"'";	
				
				for (int j=0; j<hall.get(i).getHallInfo().size();j++) { /*itera sui film*/
					
					film_name= hall.get(i).getHallInfo().get(j).getFilm().getName();
					film_director= hall.get(i).getHallInfo().get(j).getFilm().getDirector();
					
					st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					rss = st.executeQuery(sql5);
					rss.last();
					int numRows = rss.getRow();
					if (numRows == 0) {
						sql3= con.prepareStatement("INSERT INTO films (name,director,cast,duration,rating,plot) VALUES (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
						/*se il film non c'è lo inserisco e poi lo inserisco nella hall*/
						sql3.setString(1, hall.get(i).getHallInfo().get(j).getFilm().getName());
						sql3.setString(2, hall.get(i).getHallInfo().get(j).getFilm().getDirector());
						sql3.setString(3, hall.get(i).getHallInfo().get(j).getFilm().getCast());
						sql3.setInt(4, hall.get(i).getHallInfo().get(j).getFilm().getDuration());
						sql3.setString(5, hall.get(i).getHallInfo().get(j).getFilm().getRating());/*questa è una string?*/
						sql3.setString(6, hall.get(i).getHallInfo().get(j).getFilm().getPlot());
						
						if (sql3.executeUpdate() == 1) {
							try (ResultSet keys = sql3.getGeneratedKeys()) {
								if (keys.next()) {
									id_newFilm=keys.getInt(1); /*controllare*/
								}
							}
						}
						
						/*Inserire hall_film lo faccio alla fine*/
						
					
				
					} else {
						rss.first();
						id_newFilm=rss.getInt("film_id");
						/* inserire hall_film lo faccio alla fine*/
					}
					/*inserire hall_film*/
					
					sql4= con.prepareStatement("INSERT INTO hall_film (hall,film,time,price,freeSeatsNumber) VALUES (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
					sql4.setInt(1, id_newHall);
					sql4.setInt(2, id_newFilm);
					sql4.setTimestamp(3, new Timestamp(hall.get(i).getHallInfo().get(j).getTime().getTime())); /*controllare*/
					sql4.setFloat(4, hall.get(i).getHallInfo().get(j).getPrice());
					sql4.setInt(5, hall.get(i).getHallInfo().get(j).getFreeSeatsNumber());
					
					if (sql4.executeUpdate() == 1) {
						try (ResultSet keys = sql4.getGeneratedKeys()) {
							if (keys.next()) {
								id_newHallFilm=keys.getInt(1); /*controllare*/
							}
						}
					}
				
					}
			
			}
			
			
		}catch (SQLException e) {
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
