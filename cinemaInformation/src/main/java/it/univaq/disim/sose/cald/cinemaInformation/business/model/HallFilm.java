package it.univaq.disim.sose.cald.cinemaInformation.business.model;

import java.util.Date;

public class HallFilm {
	
	private Long id;
	private Hall hall;
	private Long idHall;
	private Film film;
	private Long idFilm;
	private Date time;
	private float price;
	private int freeSeatsNumber;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public Long getIdHall() {
		return idHall;
	}
	public void setIdHall(Long idHall) {
		this.idHall = idHall;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public Long getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(Long idFilm) {
		this.idFilm = idFilm;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getFreeSeatsNumber() {
		return freeSeatsNumber;
	}
	public void setFreeSeatsNumber(int freeSeatsNumber) {
		this.freeSeatsNumber = freeSeatsNumber;
	}
}
