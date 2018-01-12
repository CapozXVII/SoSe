package it.univaq.disim.sose.cald.restaurantInformation.business.model;

public class Table implements java.io.Serializable {
	
	private Long id;
	private int number;
	private int seatsNumber;
	private Restaurant restaurant;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int Number) {
		this.number = number;
	}
	
	public int getSeatsNumber() {
		return seatsNumber;
	}
	
	public void setSeatsNumber(int seatsNumber) {
		this.seatsNumber = seatsNumber;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
}
