package it.univaq.disim.sose.cald.cinemabooking.business.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;



import javax.sql.DataSource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.cinemabooking.CinemaBookingRequest;
import it.univaq.disim.sose.cald.cinemabooking.CinemaBookingResponse;
import it.univaq.disim.sose.cald.cinemabooking.business.*;
import it.univaq.disim.sose.cald.cinemabooking.business.impl.jdbc.JDBCCinemaBookingImpl;
import it.univaq.disim.sose.cald.cinemabooking.business.model.CinemaBooking;

@Service
public class JDBCCinemaBookingImpl implements CinemaBookingService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(JDBCCinemaBookingImpl.class);

	
	@Autowired
	private DataSource dataSource;

	@Override
	public CinemaBookingResponse insertCinemaBooking(CinemaBookingRequest parameters) throws BusinessException {
		
		int nSeats = 0;
		boolean resultUpdate = false;
		String resultBook = "Booking not inserted";
		Connection con;
		PreparedStatement sql;
		
		CinemaBooking booking = new CinemaBooking();
		
		booking.setId_film(parameters.getIdFilm());
		booking.setId_hall(parameters.getIdHall());
		booking.setId_utente(parameters.getIdUtente());
		booking.setSchedule(parameters.getSchedule());
		booking.setSeats(parameters.getSeats());

		CinemaBookingResponse resultBooking = new CinemaBookingResponse();

		con = null;
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);

			nSeats = countSeats(con, booking.getId_hall(), booking.getSchedule(), booking.getSeats());
			if (nSeats >= booking.getSeats()) {

				resultUpdate = updateSeats(con, booking.getId_hall(), booking.getSchedule(), booking.getSeats(), nSeats);
				
				if (resultUpdate) {
					
					if(insertBooking(con, booking.getId_hall(), booking.getId_film(), booking.getId_utente(), booking.getSchedule(), booking.getSeats())) {
						resultBook = "Booking inserted";
					}
					
				}
				
			}
			else {
				
				resultBook = "Not enough seats available. Booking not inserted";
				
			}
					
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (con != null) {
				try {
					con.setAutoCommit(true);
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		resultBooking.setAccepted(resultBook);
		
		return resultBooking;

	}

	public int countSeats(Connection con, int id_hall, Timestamp schedule, int seats) throws SQLException {

		int freeSeatsNumber = 0;

		try {

			String query = "SELECT freeSeatsNumber FROM hall_film WHERE hall = ? AND time = ?";
			
			PreparedStatement sql = con.prepareStatement(query);
			sql.setInt(1, id_hall);
			sql.setTimestamp(2, schedule);
			LOGGER.info(query);
			ResultSet res = sql.executeQuery();
			LOGGER.info("forse");
			res.next();
			freeSeatsNumber = res.getInt("freeSeatsNumber");
			LOGGER.info("forse2");
			return freeSeatsNumber;

		}

		catch (SQLException e1) {

			e1.printStackTrace();
			return 0;
		}

	}

	public boolean updateSeats(Connection con, int id_hall, Timestamp schedule, int seats, int freeSeatsNumber)
			throws SQLException {

		int difference;

		difference = freeSeatsNumber - seats;

		String query = "UPDATE hall_film SET freeSeatsNumber = ? WHERE hall = ? and time = ?";

		try {

			PreparedStatement sql = con.prepareStatement(query);
			sql.setInt(1, difference);
			sql.setInt(2, id_hall);
			sql.setTimestamp(3, schedule);
			LOGGER.info(sql.toString());
			if (sql.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}

		}

		catch (SQLException e1) {

			return false;

		}
		
		

	}

	public boolean insertBooking(Connection con, int id_hall, int id_film, int id_user, Timestamp schedule, int seats) {

		String query = "INSERT INTO cinemaBooking (hall, film, user, seats, schedule) VALUES (?,?,?,?,?)";

		try {

			PreparedStatement sql = con.prepareStatement(query);
			sql.setInt(1, id_hall);
			sql.setInt(2, id_film);
			sql.setInt(3, id_user);
			sql.setInt(4, seats);
			sql.setTimestamp(5, schedule);

			if (sql.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			return false;
		}

	}

}
