
package it.univaq.disim.sose.cald.enjoyReservation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for cinemaBookingRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cinemaBookingRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cinema" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="seats" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="film" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
@XmlType(name = "cinemaBookingRequest", propOrder = {
    "cinema",
    "seats",
    "film",
    "schedule"
})
public class CinemaBookingRequest {

    @XmlElement(required = true)
    protected String cinema;
    protected int seats;
    @XmlElement(required = true)
    protected String film;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar schedule;

    /**
     * Gets the value of the cinema property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCinema() {
        return cinema;
    }

    /**
     * Sets the value of the cinema property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCinema(String value) {
        this.cinema = value;
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
     * Gets the value of the film property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilm() {
        return film;
    }

    /**
     * Sets the value of the film property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilm(String value) {
        this.film = value;
    }

    /**
     * Gets the value of the schedule property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSchedule() {
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
    public void setSchedule(XMLGregorianCalendar value) {
        this.schedule = value;
    }

}
