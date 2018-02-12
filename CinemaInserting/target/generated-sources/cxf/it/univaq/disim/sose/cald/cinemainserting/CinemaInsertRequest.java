
package it.univaq.disim.sose.cald.cinemainserting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per cinemaInsertRequest complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="cinemaInsertRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cinema" type="{http://it.univaq.disim.sose.cald/cinemaInserting}cinemaType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cinemaInsertRequest", propOrder = {
    "cinema"
})
public class CinemaInsertRequest {

    @XmlElement(required = true)
    protected CinemaType cinema;

    /**
     * Recupera il valore della proprietà cinema.
     * 
     * @return
     *     possible object is
     *     {@link CinemaType }
     *     
     */
    public CinemaType getCinema() {
        return cinema;
    }

    /**
     * Imposta il valore della proprietà cinema.
     * 
     * @param value
     *     allowed object is
     *     {@link CinemaType }
     *     
     */
    public void setCinema(CinemaType value) {
        this.cinema = value;
    }

}
