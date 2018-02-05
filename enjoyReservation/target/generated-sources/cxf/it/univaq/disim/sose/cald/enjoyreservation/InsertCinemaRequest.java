
package it.univaq.disim.sose.cald.enjoyreservation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for insertCinemaRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="insertCinemaRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cinema" type="{http://it.univaq.disim.sose.cald/enjoyReservation}OSMCinemaType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertCinemaRequest", propOrder = {
    "cinema"
})
public class InsertCinemaRequest {

    @XmlElement(required = true)
    protected OSMCinemaType cinema;

    /**
     * Gets the value of the cinema property.
     * 
     * @return
     *     possible object is
     *     {@link OSMCinemaType }
     *     
     */
    public OSMCinemaType getCinema() {
        return cinema;
    }

    /**
     * Sets the value of the cinema property.
     * 
     * @param value
     *     allowed object is
     *     {@link OSMCinemaType }
     *     
     */
    public void setCinema(OSMCinemaType value) {
        this.cinema = value;
    }

}
