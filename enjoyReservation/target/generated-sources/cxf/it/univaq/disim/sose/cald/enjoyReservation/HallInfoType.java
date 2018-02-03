
package it.univaq.disim.sose.cald.enjoyReservation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for hallInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hallInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="film" type="{http://it.univaq.disim.sose.cald/enjoyReservation}filmType"/&gt;
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="freeSeatsNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hallInfoType", propOrder = {
    "time",
    "film",
    "price",
    "freeSeatsNumber"
})
public class HallInfoType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar time;
    @XmlElement(required = true)
    protected FilmType film;
    protected float price;
    protected int freeSeatsNumber;

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTime(XMLGregorianCalendar value) {
        this.time = value;
    }

    /**
     * Gets the value of the film property.
     * 
     * @return
     *     possible object is
     *     {@link FilmType }
     *     
     */
    public FilmType getFilm() {
        return film;
    }

    /**
     * Sets the value of the film property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilmType }
     *     
     */
    public void setFilm(FilmType value) {
        this.film = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(float value) {
        this.price = value;
    }

    /**
     * Gets the value of the freeSeatsNumber property.
     * 
     */
    public int getFreeSeatsNumber() {
        return freeSeatsNumber;
    }

    /**
     * Sets the value of the freeSeatsNumber property.
     * 
     */
    public void setFreeSeatsNumber(int value) {
        this.freeSeatsNumber = value;
    }

}
