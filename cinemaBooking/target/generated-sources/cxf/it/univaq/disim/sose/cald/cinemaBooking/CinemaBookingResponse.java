
package it.univaq.disim.sose.cald.cinemaBooking;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per cinemaBookingResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="cinemaBookingResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accepted" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cinemaBookingResponse", propOrder = {
    "accepted"
})
public class CinemaBookingResponse {

    @XmlElement(required = true)
    protected String accepted;

    /**
     * Recupera il valore della proprietà accepted.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccepted() {
        return accepted;
    }

    /**
     * Imposta il valore della proprietà accepted.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccepted(String value) {
        this.accepted = value;
    }

}
