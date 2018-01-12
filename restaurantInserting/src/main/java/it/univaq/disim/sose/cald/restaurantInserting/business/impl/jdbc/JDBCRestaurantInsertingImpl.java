package it.univaq.disim.sose.cald.restaurantInserting.business.impl.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import it.univaq.disim.sose.cald.restaurantInserting.DiscountType;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantInfoType;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertRequest;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantInsertResponse;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantType;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantUpdateRequest;
import it.univaq.disim.sose.cald.restaurantInserting.RestaurantUpdateResponse;
import it.univaq.disim.sose.cald.restaurantInserting.TableType;
import it.univaq.disim.sose.cald.restaurantInserting.business.BusinessException;
import it.univaq.disim.sose.cald.restaurantInserting.business.RestaurantInsertingService;


public class JDBCRestaurantInsertingImpl implements RestaurantInsertingService {

private static Logger LOGGER = LoggerFactory.getLogger(JDBCRestaurantInsertingImpl.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public RestaurantInsertResponse insertRestaurant(RestaurantInsertRequest parameters) throws BusinessException {
		
		RestaurantType newRestaurant = parameters.getRestaurant();
		double lat = newRestaurant.getLat();
		double lon = newRestaurant.getLon();
		RestaurantInfoType newRestaurantInfo = newRestaurant.getRestaurantInfo();
		String name = newRestaurantInfo.getName();
		String address = newRestaurantInfo.getAddress();
		int cap = newRestaurantInfo.getCap();
		String city = newRestaurantInfo.getCity();
		String telephoneNumber = newRestaurantInfo.getTelephoneNumber();
		List<TableType> table = newRestaurantInfo.getTable();
		String style = newRestaurantInfo.getStyle();
		String cuisine = newRestaurantInfo.getCuisine();
		String menu = newRestaurantInfo.getMenu();
		DiscountType discount = newRestaurantInfo.getDiscount();
		
		int id = 0;
		int id2 = 0;
				
		/*String sql="INSERT INTO RESTAURANTS (lat,lon,name,address,cap,city,telephonenumber,style,cusine,menu)"+
					"VALUES ('"+lat+"','"+lon+"',"+name+"','"+address+"','"+cap+"','"+city+"','"+telephoneNumber+"','"+
					style+"','"+cuisine+"','"+menu+"')";
		LOGGER.info(sql);*/
		
		Connection con = null;
		PreparedStatement sql;
		
		try {
			sql = con.prepareStatement("INSERT INTO RESTAURANTS (lat,lon,name,address,cap,city,telephonenumber,style,cusine,menu) VALUES (?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = null;
			sql.setDouble(1, lat);
			sql.setDouble(2, lon);
			sql.setString(3, name);
			sql.setString(4, address);
			sql.setInt(5, cap);
			sql.setString(6, city);
			sql.setString(7, telephoneNumber);
			sql.setString(8, style);
			sql.setString(9, cuisine);
			sql.setString(10, menu);
			con = dataSource.getConnection();
			
			if (sql.executeUpdate() == 1) {
                try (ResultSet keys = sql.getGeneratedKeys()) {
                    if (keys.next()) {
                        id = keys.getInt(1);
                    }
                }
            }	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();	
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				}
			}
		}		
		int qualcosa = 0;
		
		if (id!=0) {
			for (int i = 0; i < table.size(); i++) {
				/*String sql2="INSERT INTO TABLES (number, seatsNumber, restaurant) VALUES ('"+table.get(i).getNumber()+"','"
							+table.get(i).getSeatsNumber()+"','"+qualcosa+"')";
				LOGGER.info(sql2);*/
				
				try {
					sql = con.prepareStatement("INSERT INTO TABLES (number, seatsNumber, restaurant) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
					ResultSet rs = null;
					sql.setInt(1, table.get(i).getNumber());
					sql.setInt(2, table.get(i).getSeatsNumber());/*questo non va bene errore nel wsdl*//*modificato*/
					sql.setInt(3, id);
					con = dataSource.getConnection();
					
					if (sql.executeUpdate() == 1) {
		                try (ResultSet keys = sql.getGeneratedKeys()) {
		                    if (keys.next()) {
		                        id2 = keys.getInt(1);
		                    }
		                }
		            }
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					if (con != null) {
						try {
							con.close();
						} catch (SQLException e) {}
					}
				}
			}
		}
		RestaurantInsertResponse result= new RestaurantInsertResponse(); 
		
		if (id2>0) {
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
		result.setAccepted(true);/* controllare se va bene*/
		return result;
	}
}
