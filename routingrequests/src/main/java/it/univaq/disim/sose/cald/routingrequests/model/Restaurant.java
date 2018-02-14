package it.univaq.disim.sose.cald.routingrequests.model;

public class Restaurant implements java.io.Serializable {
	
	private Long id;
	private double lat;
	private double lon;
	private String name;
	private String cap;
	private String address;
	private String city;
	private String telephoneNumber;
	private String style;
	private String cuisine;
	private String menu;
	private int maxSeats;
	private Long owner;
	private Discount discount;
	
	public Long getOwner() {
		return owner;
	}

	public void setOwner(Long owner) {
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public double getLat() {
		return lat;
	}
	
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	public double getLon() {
		return lon;
	}
	
	public void setLon(double lon) {
		this.lon = lon;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCap() {
		return cap;
	}
	
	public void setCap(String cap) {
		this.cap = cap;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	public String getStyle() {
		return style;
	}
	
	public void setStyle(String style) {
		this.style = style;
	}
	
	public String getCuisine() {
		return cuisine;
	}
	
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	
	public String getMenu() {
		return menu;
	}
	
	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	public int getMaxSeats() {
		return maxSeats;
	}
	
	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}
	
	public Discount getDiscount() {
		return this.discount;
	}
	
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
}
