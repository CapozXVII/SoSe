package it.univaq.disim.sose.cald.restaurantinformation.business.model;

public class Discount {
	
	private Long id;
	private float price;
	private Restaurant restaurant;
	//private Cinema cinema;
	private int cinema;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public int getCinema() {
		return cinema;
	}
	public void setCinema(int cinema) {
		this.cinema = cinema;
	}
}
