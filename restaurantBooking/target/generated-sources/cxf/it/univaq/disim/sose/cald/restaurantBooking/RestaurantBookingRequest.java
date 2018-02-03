
package it.univaq.disim.sose.cald.restaurantBooking;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per restaurantBookingRequest complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
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
     * Recupera il valore della proprietà restaurant.
     * 
     */
    public int getRestaurant() {
        return restaurant;
    }

    /**
     * Imposta il valore della proprietà restaurant.
     * 
     */
    public void setRestaurant(int value) {
        this.restaurant = value;
    }

    /**
     * Recupera il valore della proprietà seats.
     * 
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Imposta il valore della proprietà seats.
     * 
     */
    public void setSeats(int value) {
        this.seats = value;
    }

    /**
     * Recupera il valore della proprietà user.
     * 
     */
    public int getUser() {
        return user;
    }

    /**
     * Imposta il valore della proprietà user.
     * 
     */
    public void setUser(int value) {
        this.user = value;
    }

    /**
     * Recupera il valore della proprietà schedule.
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
     * Imposta il valore della proprietà schedule.
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
