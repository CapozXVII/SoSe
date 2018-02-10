package it.univaq.disim.sose.cald.routingrequests.model;

public class Discount {
	
	private Long id;
	private int cinema;
	private float price;
	
	public  Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public int getCinema() {
		return cinema;
	}
	
	public void setCinema(int cinema) {
		this.cinema=cinema;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price=price;
	}

}
