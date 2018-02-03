
package it.univaq.disim.sose.cald.clients.cinemabooking;

import java.util.Date;

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
 *         &lt;element name="id_hall" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="id_film" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="id_utente" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="seats" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "idHall",
    "idFilm",
    "idUtente",
    "seats",
    "schedule"
})
public class CinemaBookingRequest {

    @XmlElement(name = "id_hall")
    protected int idHall;
    @XmlElement(name = "id_film")
    protected int idFilm;
    @XmlElement(name = "id_utente")
    protected int idUtente;
    protected int seats;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date schedule;

    /**
     * Gets the value of the idHall property.
     * 
     */
    public int getIdHall() {
        return idHall;
    }

    /**
     * Sets the value of the idHall property.
     * 
     */
    public void setIdHall(int value) {
        this.idHall = value;
    }

    /**
     * Gets the value of the idFilm property.
     * 
     */
    public int getIdFilm() {
        return idFilm;
    }

    /**
     * Sets the value of the idFilm property.
     * 
     */
    public void setIdFilm(int value) {
        this.idFilm = value;
    }

    /**
     * Gets the value of the idUtente property.
     * 
     */
    public int getIdUtente() {
        return idUtente;
    }

    /**
     * Sets the value of the idUtente property.
     * 
     */
    public void setIdUtente(int value) {
        this.idUtente = value;
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
