
package it.univaq.disim.sose.cald.enjoyreservation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteCinemaRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteCinemaRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="hallFilm_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteCinemaRequest", propOrder = {
    "hallFilmId"
})
public class DeleteCinemaRequest {

    @XmlElement(name = "hallFilm_id")
    protected Long hallFilmId;

    /**
     * Gets the value of the hallFilmId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getHallFilmId() {
        return hallFilmId;
    }

    /**
     * Sets the value of the hallFilmId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHallFilmId(Long value) {
        this.hallFilmId = value;
    }

}
