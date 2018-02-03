
package it.univaq.disim.sose.cald.cinemaBooking;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import java.util.Date;


/**
 * <p>Classe Java per cinemaBookingRequest complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
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
     * Recupera il valore della proprietà idHall.
     * 
     */
    public int getIdHall() {
        return idHall;
    }

    /**
     * Imposta il valore della proprietà idHall.
     * 
     */
    public void setIdHall(int value) {
        this.idHall = value;
    }

    /**
     * Recupera il valore della proprietà idFilm.
     * 
     */
    public int getIdFilm() {
        return idFilm;
    }

    /**
     * Imposta il valore della proprietà idFilm.
     * 
     */
    public void setIdFilm(int value) {
        this.idFilm = value;
    }

    /**
     * Recupera il valore della proprietà idUtente.
     * 
     */
    public int getIdUtente() {
        return idUtente;
    }

    /**
     * Imposta il valore della proprietà idUtente.
     * 
     */
    public void setIdUtente(int value) {
        this.idUtente = value;
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
