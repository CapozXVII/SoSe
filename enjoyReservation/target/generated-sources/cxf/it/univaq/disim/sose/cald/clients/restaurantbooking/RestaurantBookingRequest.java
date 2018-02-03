
package it.univaq.disim.sose.cald.clients.restaurantbooking;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for restaurantBookingRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="restaurantBookingRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="restaurant" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="seats" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="schedule" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "restaurantBookingRequest", propOrder = {
    "restaurant",
    "seats",
    "user",
    "schedule"
})
public class RestaurantBookingRequest {

    protected int restaurant;
    protected int seats;
    protected int user;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date schedule;

    /**
     * Gets the value of the restaurant property.
     * 
     */
    public int getRestaurant() {
        return restaurant;
    }

    /**
     * Sets the value of the restaurant property.
     * 
     */
    public void setRestaurant(int value) {
        this.restaurant = value;
    }

    /**
     * Gets the value of the seats property.
     * 
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Sets the value of the seats property.
     * 
     */
    public void setSeats(int value) {
        this.seats = value;
    }

    /**
     * Gets the value of the user property.
     * 
     */
    public int getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     */
    public void setUser(int value) {
        this.user = value;
    }

    /**
     * Gets the value of the schedule property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getSchedule() {
        return schedule;
    }

    /**
     * Sets the value of the schedule property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSchedule(Date value) {
        this.schedule = value;
    }

}
