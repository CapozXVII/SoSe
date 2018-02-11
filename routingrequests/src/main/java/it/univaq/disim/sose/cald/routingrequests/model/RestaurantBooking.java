package it.univaq.disim.sose.cald.routingrequests.model;

import java.sql.Date;

public class RestaurantBooking implements java.io.Serializable {
	
	private int id;
	private int restaurant;
	private int user;
	private int seats;
	private Date schedule;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRestaurant() {
		return restaurant;
	}
	
	public void setRestaurant(int restaurant) {
		this.restaurant = restaurant;
	}

	public int getUser() {
		return user;
	}
	
	public void setUser(int user) {
		this.user = user;
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
