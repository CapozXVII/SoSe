package it.univaq.disim.sose.cald.restaurantinserting.business.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.restaurantinserting.RestaurantDeleteRequest;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantDeleteResponse;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantInsertRequest;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantInsertResponse;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantUpdateRequest;
import it.univaq.disim.sose.cald.restaurantinserting.RestaurantUpdateResponse;
import it.univaq.disim.sose.cald.restaurantinserting.business.BusinessException;
import it.univaq.disim.sose.cald.restaurantinserting.business.RestaurantInsertingService;
import it.univaq.disim.sose.cald.restaurantinserting.business.model.Discount;
import it.univaq.disim.sose.cald.restaurantinserting.business.model.Restaurant;

@Service
public class JDBCRestaurantInsertingImpl implements RestaurantInsertingService {

	private static Logger LOGGER = LoggerFactory.getLogger(JDBCRestaurantInsertingImpl.class);

	@Autowired
	private DataSource dataSource;

	@Override
	public RestaurantInsertResponse insertRestaurant(RestaurantInsertRequest parameters) throws BusinessException {

		LOGGER.info("Called JDBCInserting");
		
		Restaurant newRestaurant = new Restaurant();
		newRestaurant.setLatitude(parameters.getRestaurant().getLat());
		newRestaurant.setLongitude(parameters.getRestaurant().getLon());
		newRestaurant.setName(parameters.getRestaurant().getRestaurantInfo().getName());
		newRestaurant.setCap(parameters.getRestaurant().getRestaurantInfo().getCap());
		newRestaurant.setAddress(parameters.getRestaurant().getRestaurantInfo().getAddress());
		newRestaurant.setCity(parameters.getRestaurant().getRestaurantInfo().getCity());
		newRestaurant.setTelephoneNumber(parameters.getRestaurant().getRestaurantInfo().getTelephoneNumber());
		newRestaurant.setStyle(parameters.getRestaurant().getRestaurantInfo().getStyle());
		newRestaurant.setCousine(parameters.getRestaurant().getRestaurantInfo().getCuisine());
		newRestaurant.setMenu(parameters.getRestaurant().getRestaurantInfo().getMenu());
		newRestaurant.setMax_seats(parameters.getRestaurant().getRestaurantInfo().getMaxSeats());
		newRestaurant.setOwner(parameters.getId());
		
		Discount newDiscount = new Discount();
		newDiscount.setCinema(parameters.getRestaurant().getRestaurantInfo().getDiscount().getCinema());
		newDiscount.setPrice(parameters.getRestaurant().getRestaurantInfo().getDiscount().getPrice());

		int id_restaurant = 0;
		boolean insert = false;
		Connection con = null;
		PreparedStatement sql_iRestaurant, sql_iDiscout;
		

		try {
			con = dataSource.getConnection();
			sql_iRestaurant = con.prepareStatement(
					"INSERT INTO RESTAURANTS (restaurant_lat,restaurant_lon,restaurant_name,restaurant_address,restaurant_cap,restaurant_city,restaurant_telephonenumber,style,cuisine,menu,max_seats,owner) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			sql_iRestaurant.setDouble(1, newRestaurant.getLatitude());
			sql_iRestaurant.setDouble(2, newRestaurant.getLongitude());
			sql_iRestaurant.setString(3, newRestaurant.getName());
			sql_iRestaurant.setString(4, newRestaurant.getAddress());
			sql_iRestaurant.setString(5, newRestaurant.getCap());
			sql_iRestaurant.setString(6, newRestaurant.getCity());
			sql_iRestaurant.setString(7, newRestaurant.getTelephoneNumber());
			sql_iRestaurant.setString(8, newRestaurant.getStyle());
			sql_iRestaurant.setString(9, newRestaurant.getCousine());
			sql_iRestaurant.setString(10, newRestaurant.getMenu());
			sql_iRestaurant.setInt(11, newRestaurant.getMax_seats());
			sql_iRestaurant.setLong(12, newRestaurant.getOwner());

			if (sql_iRestaurant.executeUpdate() == 1) {
				try (ResultSet keys = sql_iRestaurant.getGeneratedKeys()) {
					if (keys.next()) {
						id_restaurant = keys.getInt(1);
					}
				}
			}
			
			sql_iDiscout = con.prepareStatement("INSERT INTO DISCOUNT (cinema,restaurant,price) VALUES (?,?,?)");
			sql_iDiscout.setInt(1, newDiscount.getCinema());
			sql_iDiscout.setInt(2, id_restaurant);
			sql_iDiscout.setDouble(3, newDiscount.getPrice());
			
			if (sql_iDiscout.executeUpdate()==1) {
				insert=true;
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}

		RestaurantInsertResponse result = new RestaurantInsertResponse();

		if (id_restaurant > 0 && insert) { 
			result.setAccepted(true);
			return result;
		} else {
			result.setAccepted(false);
			return result;
		}
	}

	@Override
	public RestaurantUpdateResponse updateRestaurant(RestaurantUpdateRequest parameters) throws BusinessException {
		
		RestaurantUpdateResponse result = new RestaurantUpdateResponse();
		LOGGER.info("Called JDBCRestaurantUpdate");
		
		Restaurant newRestaurant = new Restaurant();
		newRestaurant.setId(parameters.getRestaurant().getRestaurantInfo().getId());
		newRestaurant.setLatitude(parameters.getRestaurant().getLat());
		newRestaurant.setLongitude(parameters.getRestaurant().getLon());
		newRestaurant.setName(parameters.getRestaurant().getRestaurantInfo().getName());
		newRestaurant.setCap(parameters.getRestaurant().getRestaurantInfo().getCap());
		newRestaurant.setAddress(parameters.getRestaurant().getRestaurantInfo().getAddress());
		newRestaurant.setCity(parameters.getRestaurant().getRestaurantInfo().getCity());
		newRestaurant.setTelephoneNumber(parameters.getRestaurant().getRestaurantInfo().getTelephoneNumber());
		newRestaurant.setStyle(parameters.getRestaurant().getRestaurantInfo().getStyle());
		newRestaurant.setCousine(parameters.getRestaurant().getRestaurantInfo().getCuisine());
		newRestaurant.setMenu(parameters.getRestaurant().getRestaurantInfo().getMenu());
		newRestaurant.setMax_seats(parameters.getRestaurant().getRestaurantInfo().getMaxSeats());
				
		Discount newDiscount = new Discount();
		newDiscount.setCinema(parameters.getRestaurant().getRestaurantInfo().getDiscount().getCinema());
		newDiscount.setPrice(parameters.getRestaurant().getRestaurantInfo().getDiscount().getPrice());
		newDiscount.setId(parameters.getRestaurant().getRestaurantInfo().getDiscount().getDiscountId());
		
		boolean insertRestaurant = false, insertDiscount=false;
		Connection con = null;
		PreparedStatement sql_uRestaurant, sql_uDiscout;
		

		try {
			con = dataSource.getConnection();
			sql_uRestaurant = con.prepareStatement(
					"UPDATE RESTAURANTS SET restaurant_lat=?,restaurant_lon=?,restaurant_name=?,restaurant_address=?,restaurant_cap=?,restaurant_city=?,restaurant_telephonenumber=?,style=?,cuisine=?,menu=?,max_seats=? WHERE restaurant_id=? ");

			sql_uRestaurant.setDouble(1, newRestaurant.getLatitude());
			sql_uRestaurant.setDouble(2, newRestaurant.getLongitude());
			sql_uRestaurant.setString(3, newRestaurant.getName());
			sql_uRestaurant.setString(4, newRestaurant.getAddress());
			sql_uRestaurant.setString(5, newRestaurant.getCap());
			sql_uRestaurant.setString(6, newRestaurant.getCity());
			sql_uRestaurant.setString(7, newRestaurant.getTelephoneNumber());
			sql_uRestaurant.setString(8, newRestaurant.getStyle());
			sql_uRestaurant.setString(9, newRestaurant.getCousine());
			sql_uRestaurant.setString(10, newRestaurant.getMenu());
			sql_uRestaurant.setInt(11, newRestaurant.getMax_seats());
			sql_uRestaurant.setLong(12, newRestaurant.getId());
			
			if (sql_uRestaurant.executeUpdate() == 1) {
				insertRestaurant = true;
			}
			
			sql_uDiscout = con.prepareStatement("UPDATE DISCOUNT SET cinema=?,restaurant=?,price=? WHERE discount_id=?");
			sql_uDiscout.setInt(1, newDiscount.getCinema()); /*forse meglio mettere il nome?*/
			sql_uDiscout.setLong(2, newRestaurant.getId());
			sql_uDiscout.setDouble(3, newDiscount.getPrice());
			sql_uDiscout.setLong(4, newDiscount.getId());
			
			if (sql_uDiscout.executeUpdate()==1) {
				insertDiscount = true;
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}


		if (insertRestaurant && insertDiscount) { 
			result.setAccepted(true);
		} else {
			result.setAccepted(false);
		}
		return result;
	}

	@Override
	public RestaurantDeleteResponse deleteRestaurant(RestaurantDeleteRequest parameters) throws BusinessException {
		LOGGER.info("Called JDBCRestaurantDelete");
		
		RestaurantDeleteResponse result = new RestaurantDeleteResponse();
		long idRestaurant = parameters.getRestaurantId();
		Connection con = null;
		PreparedStatement sql_dRestaurant, sql_dDiscount, sql_dRestaurantBooking;
		boolean delete_restaurant = false, delete_discount = false, delete_restaurantBooking = false;
		
		try {
			con = dataSource.getConnection();
			
			sql_dRestaurantBooking = con.prepareStatement(
					"DELETE FROM restaurantbookings WHERE restaurant=?");
			
			sql_dRestaurantBooking.setLong(1, idRestaurant);
			if (sql_dRestaurantBooking.executeUpdate() == 1) {
				delete_restaurantBooking = true;
			}
			
			sql_dDiscount = con.prepareStatement(
					"DELETE FROM discount WHERE restaurant=?");
			
			sql_dDiscount.setLong(1, idRestaurant);
			if (sql_dDiscount.executeUpdate() == 1) {
				delete_discount=true;
			}
			
			
			sql_dRestaurant = con.prepareStatement(
					"DELETE FROM restaurants WHERE restaurant_id=?");
			
			sql_dRestaurant.setLong(1, idRestaurant);
			
			if (sql_dRestaurant.executeUpdate() == 1) {
				delete_restaurant=true;
			}
			
			if(delete_restaurant && delete_discount && delete_restaurantBooking) {
				result.setAccepted(true);
			} else {
				result.setAccepted(false);
			}

		
		}catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}

		return result;
	}
}
