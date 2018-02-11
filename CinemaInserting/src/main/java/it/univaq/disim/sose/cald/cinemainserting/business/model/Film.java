package it.univaq.disim.sose.cald.cinemainserting.business.model;

import javax.xml.bind.annotation.XmlElement;

public class Film {
	
    private String name;
    private String director;
    private String cast;
    private int duration;
    private String type;
    private String plot;
    private Long id;
    
    public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director=director;
	}
	
	public String getCast() {
		return cast;
	}
	
	public void setCast(String cast) {
		this.cast=cast;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration=duration;
	}
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type=type;
	}
	public String getPlot() {
		return plot;
	}
	
	public void setPlot(String plot) {
		this.plot=plot;
	}
	
	public  Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	

}
