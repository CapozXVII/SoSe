package it.univaq.disim.sose.cald.cinemaInserting.business.model;

public class Hall implements java.io.Serializable {
	
	private Long hall_id;
	private int number; 
	private int seatsNumber;
	private Long cinema;
	
	public Long getHall_id() {
		return hall_id;
	}
	
	public void setHall_id(Long hall_id) {
		this.hall_id=hall_id;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number=number;
	}
	
	public int getSeatsNumber() {
		return seatsNumber;
	}
	
	public void setSeatsNumber(int seatsNumber) {
		this.seatsNumber=seatsNumber;
	}
	
	public Long getCinema() {
		return cinema;
	}
	
	public void setCinema(Long cinema) {
		this.cinema=cinema;
	}
	
	

}