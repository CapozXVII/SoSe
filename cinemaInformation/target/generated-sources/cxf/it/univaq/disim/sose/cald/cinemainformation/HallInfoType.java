
package it.univaq.disim.sose.cald.cinemainformation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per hallInfoType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="hallInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="film" type="{http://it.univaq.disim.sose.cald/cinemaInformation}filmType"/&gt;
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
     * Recupera il valore della proprietà time.
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
     * Imposta il valore della proprietà time.
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
     * Recupera il valore della proprietà film.
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
     * Imposta il valore della proprietà film.
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
     * Recupera il valore della proprietà price.
     * 
     */
    public float getPrice() {
        return price;
    }

    /**
     * Imposta il valore della proprietà price.
     * 
     */
    public void setPrice(float value) {
        this.price = value;
    }

    /**
     * Recupera il valore della proprietà freeSeatsNumber.
     * 
     */
    public int getFreeSeatsNumber() {
        return freeSeatsNumber;
    }

    /**
     * Imposta il valore della proprietà freeSeatsNumber.
     * 
     */
    public void setFreeSeatsNumber(int value) {
        this.freeSeatsNumber = value;
    }

}
