package it.univaq.disim.sose.cald.restaurantInserting.business.Model;

public class Table implements java.io.Serializable {
	
	private Long id;
	private int number;
	private int seatsNumber;
	private Long restaurant;
	
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
	
	public Long getRestaurant() {
		return restaurant;
	}
	
	public void setRestaurant(Long restaurant) {
		this.restaurant = restaurant;
	}

}
