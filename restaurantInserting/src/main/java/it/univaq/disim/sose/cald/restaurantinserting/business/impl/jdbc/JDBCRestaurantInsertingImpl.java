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
					"INSERT INTO RESTAURANTS (restaurant_lat,restaurant_lon,restaurant_name,restaurant_address,restaurant_cap,restaurant_city,restaurant_telephonenumber,style,cuisine,menu,max_seats) VALUES (?,?,?,?,?,?,?,?,?,?,?)",
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

			if (sql_iRestaurant.executeUpdate() == 1) {
				try (ResultSet keys = sql_iRestaurant.getGeneratedKeys()) {
					if (keys.next()) {
						id_restaurant = keys.getInt(1);
					}
				}
			}
			
			sql_iDiscout = con.prepareStatement("INSERT INTO DISCOUNT (cinema,restaurant,price) VALUES (?,?,?)");
			sql_iDiscout.setInt(1, newDiscount.getCinema()); /*forse meglio mettere il nome?*/
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

		if (id_restaurant > 0 && insert) { /* Controllare qua se va bene >0 ma penso di si perchè funziona */
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
		result.setAccepted(true);/* controllare se va bene */
		return result;
	}
}
