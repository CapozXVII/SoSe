package it.univaq.disim.sose.cald.cinemainformation.business.model;

public class Hall {
	
	private Long id;
	private int number;
	private int seatsNumber;
	private Cinema cinema;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getSeatsNumber() {
		return seatsNumber;
	}
	public void setSeatsNumber(int seatsNumber) {
		this.seatsNumber = seatsNumber;
	}
	public Cinema getCinema() {
		return this.cinema;
	}
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
}
