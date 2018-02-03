package it.univaq.disim.sose.cald.restaurantinformation.business.impl.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.restaurantinformation.business.model.Cinema;
import it.univaq.disim.sose.cald.restaurantinformation.RestaurantInformationFault_Exception;
import it.univaq.disim.sose.cald.restaurantinformation.business.RestaurantInformationService;
import it.univaq.disim.sose.cald.restaurantinformation.business.model.Discount;
import it.univaq.disim.sose.cald.restaurantinformation.business.model.Restaurant;

@Service
public class JDBCRestaurantInformationServiceImpl implements RestaurantInformationService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(JDBCRestaurantInformationServiceImpl.class);
	
	@Autowired
	private DataSource dataSource;

	@Override
	public List<Restaurant> getRestaurants(String city) throws RestaurantInformationFault_Exception {
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		String sql = "SELECT * FROM restaurants WHERE restaurants.restaurant_city = '" + city + "' " + "ORDER BY restaurants.restaurant_id";
		LOGGER.info(sql);
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Restaurant restaurant = null;
			con = dataSource.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				restaurant = createRestaurant(rs);
				restaurantList.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RestaurantInformationFault_Exception("Something was wrong Restaurant creation");
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
		return restaurantList;
	}
	
	public Restaurant createRestaurant(ResultSet rs) throws SQLException, RestaurantInformationFault_Exception {
		Connection con = null;
		Statement st = null;
		ResultSet rss = null;
		Long restaurantId = rs.getLong("restaurant_id");
		String sql = "SELECT * FROM discount JOIN cinema ON cinema.cinema_id = discount.cinema AND discount.restaurant =" + restaurantId;
		Restaurant restaurant = new Restaurant();
		Discount discount = new Discount();
		Cinema cinema = new Cinema();
		restaurant.setId(restaurantId);
		restaurant.setAddress(rs.getString("restaurant_address"));
		restaurant.setCap(rs.getString("restaurant_cap"));
		restaurant.setCity(rs.getString("restaurant_city"));
		restaurant.setCousine(rs.getString("cuisine"));
		restaurant.setLatitude(rs.getDouble("restaurant_lat"));
		restaurant.setLongitude(rs.getDouble("restaurant_lon"));
		restaurant.setMenu(rs.getString("menu"));
		restaurant.setName(rs.getString("restaurant_name"));
		restaurant.setStyle(rs.getString("style"));
		restaurant.setTelephoneNumber(rs.getString("restaurant_telephoneNumber"));
		restaurant.setMaxSeats(rs.getInt("max_seats"));
		
		try {
			con = dataSource.getConnection();
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);;
			rss = st.executeQuery(sql);
			rss.last();
			int numRows = rss.getRow();
			if (numRows != 0) {
				rss.first();
				discount.setPrice(rss.getFloat("price"));
				cinema.setName(rss.getString("cinema_name"));
				discount.setCinema(cinema);
			} else {
				discount = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RestaurantInformationFault_Exception("Something was wrong with Discount selection");
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
		restaurant.setDiscount(discount);
		return restaurant;
	}
}
