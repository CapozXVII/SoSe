package it.univaq.disim.sose.cald.restaurantbooking.business.model;

import java.sql.Date;

public class RestaurantBooking implements java.io.Serializable {
	
	private int id;
	private int id_restaurant;
	private int id_user;
	private int seats;
	private Date schedule;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_restaurant() {
		return id_restaurant;
	}
	
	public void setId_restaurant(int id_restaurant) {
		this.id_restaurant = id_restaurant;
	}

	public int getId_user() {
		return id_user;
	}
	
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	public int getSeats() {
		return seats;
	}
	
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public Date getSchedule() {
		return schedule;
	}
	
	public void setSchedule(java.util.Date schedule) {
		this.schedule = new java.sql.Date(schedule.getTime());
		
	}
		
}
