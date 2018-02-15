package it.univaq.disim.sose.cald.cinemabooking.business.model;

import java.sql.Timestamp;
import java.util.Date;

public class CinemaBooking implements java.io.Serializable {
	
	private int id;
	private int id_hall; 
	private int id_film; 
	private int id_utente;
	private int seats;
	private Timestamp schedule;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_hall() {
		return id_hall;
	}
	public void setId_hall(int id_hall) {
		this.id_hall = id_hall;
	}
	public int getId_film() {
		return id_film;
	}
	public void setId_film(int id_film) {
		this.id_film = id_film;
	}
	public int getId_utente() {
		return id_utente;
	}
	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public Timestamp getSchedule() {
		return schedule;
	}
	public void setSchedule(Date schedule) {
		
		this.schedule = new Timestamp(schedule.getTime());
	}
	
}
