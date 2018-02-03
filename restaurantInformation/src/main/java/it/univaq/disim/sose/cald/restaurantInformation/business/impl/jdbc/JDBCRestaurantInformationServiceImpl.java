package it.univaq.disim.sose.cald.restaurantInformation.business.impl.jdbc;

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

import it.univaq.disim.sose.cald.restaurantInformation.business.model.Cinema;
import it.univaq.disim.sose.cald.restaurantInformation.business.BusinessException;
import it.univaq.disim.sose.cald.restaurantInformation.business.RestaurantInformationService;
import it.univaq.disim.sose.cald.restaurantInformation.business.model.Discount;
import it.univaq.disim.sose.cald.restaurantInformation.business.model.Restaurant;
import it.univaq.disim.sose.cald.restaurantInformation.business.model.Table;

@Service
public class JDBCRestaurantInformationServiceImpl implements RestaurantInformationService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(JDBCRestaurantInformationServiceImpl.class);
	
	@Autowired
	private DataSource dataSource;

	@Override
	public List<Restaurant> getRestaurants(String city) throws BusinessException {
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		List<Table> tableList = new ArrayList<Table>();
		String sql = "SELECT * FROM restaurants JOIN tables ON restaurants.restaurant_id = tables.restaurant AND restaurants.restaurant_city = '" + city + "' " + "ORDER BY restaurants.restaurant_id";
		LOGGER.info(sql);
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Restaurant restaurant = null;
			int count = 0;
			con = dataSource.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int restaurantId = rs.getInt("restaurant_id");
				if (rs.isFirst()) {
					count = restaurantId;
					restaurant = createRestaurant(rs);
				}
				if (count == restaurantId) {
					tableList.add(createTable(rs));
				} else {
					count = restaurantId;
					restaurant.setTables(tableList);
					restaurantList.add(restaurant);
					tableList = new ArrayList<Table>();
					restaurant = createRestaurant(rs);
					tableList.add(createTable(rs));
				}
				if (rs.isLast()) {
					restaurant.setTables(tableList);
					restaurantList.add(restaurant);
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
		return restaurantList;
	}
	
	public Restaurant createRestaurant(ResultSet rs) throws SQLException {
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
		restaurant.setDiscount(discount);
		return restaurant;
	}
	
	public Table createTable(ResultSet rs) throws SQLException {
		Table table = new Table();
		table.setId(rs.getLong("table_id"));
		table.setNumber(rs.getInt("number"));
		table.setSeatsNumber(rs.getInt("seatsNumber"));
		return table;
	}

}
