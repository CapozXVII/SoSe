package it.univaq.disim.sose.cald.restaurantbooking.business.impl.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.restaurantbooking.RestaurantBookingFault_Exception;
import it.univaq.disim.sose.cald.restaurantbooking.RestaurantBookingRequest;
import it.univaq.disim.sose.cald.restaurantbooking.RestaurantBookingResponse;
import it.univaq.disim.sose.cald.restaurantbooking.business.*;
import it.univaq.disim.sose.cald.restaurantbooking.business.impl.jdbc.JDBCRestaurantBookingImpl;
import it.univaq.disim.sose.cald.restaurantbooking.business.model.RestaurantBooking;

@Service
public class JDBCRestaurantBookingImpl implements RestaurantBookingService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(JDBCRestaurantBookingImpl.class);

	@Autowired
	private DataSource dataSource;

	/**
     * Insert into the database a restaurant booking request by a user 
     * @param parameters Information about booking request
     * @return response String saying if the booking was successful or not
     */
	@Override
	public RestaurantBookingResponse insertRestaurantBooking(RestaurantBookingRequest parameters) throws RestaurantBookingFault_Exception {
		
		int nSeats = 0, seatsPreviousBooking = 0;
		boolean resultSeats = false, resultBooking = false;
		String resultFinal = "Booking not inserted";
		
		Connection con = null;
		
		RestaurantBooking booking = new RestaurantBooking();
		RestaurantBookingResponse response = new RestaurantBookingResponse();
		booking.setId_restaurant(parameters.getRestaurant());
		booking.setId_user(parameters.getUser());
		booking.setSchedule(toDate(parameters.getSchedule()));
		booking.setSeats(parameters.getSeats());
		
		try {
			
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			
			seatsPreviousBooking = checkBooking(con, booking.getId_restaurant(), booking.getId_user(), booking.getSchedule());
			
			nSeats = countSeats(con, booking.getId_restaurant(),  booking.getSeats(), booking.getSchedule());
			
			nSeats+=booking.getSeats();
			
			resultSeats = checkSeats(con, booking.getId_restaurant(), nSeats);
			
			if(resultSeats) {
				
				if(seatsPreviousBooking > 0) {
					
					resultBooking = updateBooking(con, booking.getId_restaurant(), booking.getId_user(), booking.getSchedule(), booking.getSeats() + seatsPreviousBooking);
					
					if(resultBooking) {
						
						resultFinal = "Booking Updated";
					}
					
				} else {
					
					resultBooking = insertBooking(con, booking.getId_restaurant(), booking.getId_user(), booking.getSeats(), booking.getSchedule());
					
					if(resultBooking) {
						
						resultFinal = "Booking inserted";	
					}
				}
				
			} else {
				
				resultFinal = "Not enough seats available. Booking not inserted";
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			throw new RestaurantBookingFault_Exception("Something was wrong with Insert Booking Restaurant");
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
		
		response.setAccepted(resultFinal);
		
		return response;
		
	}
	
	public int checkBooking(Connection con, int id_restaurant, int id_user, Date schedule) throws SQLException {
		
		PreparedStatement sql;
		String query = "SELECT seats FROM restaurantbookings WHERE Restaurant = ? and user = ? and schedule = ?";
		
		try {
			
			sql = con.prepareStatement(query);
			
			sql.setInt(1, id_restaurant);
			sql.setInt(2, id_user);
			sql.setDate(3, schedule);
			
			ResultSet rs = sql.executeQuery();
			
			rs.next();
			
			if(rs.getRow() != 0) {
				return rs.getInt("seats");
			}
			else {
				return 0;
			}
			
		}
		
		catch (SQLException e) {
			throw new SQLException(e);
		}
	}
	
	public int countSeats(Connection con, int id_restaurant, int seats, Date schedule) throws SQLException {
		
		int seatsNumber = 0;
		PreparedStatement sql;
		
		try {
			
			String query = "SELECT SUM(Seats) as seats FROM restaurantBookings WHERE Restaurant = ? and schedule = ?";
			
			sql = con.prepareStatement(query);
			sql.setInt(1, id_restaurant);
			sql.setDate(2, schedule);
			
			ResultSet res = sql.executeQuery();
			res.next();
			
			seatsNumber = res.getInt("seats");
			
			return seatsNumber;
		}
		catch (SQLException e) {
			throw new SQLException(e);
		}
	}
	
	public boolean checkSeats(Connection con, int id_restaurant, int nSeats) throws SQLException {
		
		PreparedStatement sql;
		int maxSeats = 0;
		String query = "SELECT max_seats FROM restaurants WHERE restaurant_id = ?";
		
		try {
			
			sql = con.prepareStatement(query);
			
			sql.setInt(1, id_restaurant);
			
			ResultSet res = sql.executeQuery();
			res.next();
			
			maxSeats = res.getInt("max_seats");
			
			if(nSeats <= maxSeats) {
				return true;
			}
			
			else {
				return false;
			}	
		}
		catch (SQLException e) {
			throw new SQLException(e);
		}
	}
	
	public boolean insertBooking(Connection con, int id_restaurant, int id_user, int seats, Date schedule) throws SQLException {
		
		PreparedStatement sql;
		String query="INSERT INTO restaurantBookings (Restaurant, User, Schedule, Seats) VALUES (?,?,?,?)";
		
		try {
			
			sql = con.prepareStatement(query);
			
			sql.setInt(1, id_restaurant);
			sql.setInt(2, id_user);
			sql.setDate(3, schedule);
			sql.setInt(4, seats);
			
			if(sql.executeUpdate() == 1) {
				return true;
			}
			
			else {
				return false;
			}
			
		}
		catch(SQLException e) {
			throw new SQLException(e);
		}		
	}
	
	public boolean updateBooking(Connection con, int id_restaurant, int id_user, Date schedule, int seats) throws SQLException {
		
		PreparedStatement sql;
		String query = "UPDATE restaurantBookings SET Seats = ? WHERE restaurant = ? and user = ? and schedule = ?";
		
		try {
			
			sql = con.prepareStatement(query);
			
			sql.setInt(1, seats);
			sql.setInt(2, id_restaurant);
			sql.setInt(3, id_user);
			sql.setDate(4, schedule);
			
			if(sql.executeUpdate() == 1) {
				return true;
			}
			else {
				return false;
			}	
		}
		catch (SQLException e) {
			throw new SQLException(e);
		}
	}
	
	public static java.util.Date toDate(XMLGregorianCalendar calendar) {
        if(calendar == null) {
            return null;
        }
        java.util.Date date = calendar.toGregorianCalendar().getTime();
        date.setTime(date.getTime() - 3600 * 1000);
        return date;
    }
}
