
package it.univaq.disim.sose.cald.enjoyReservation;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCinemaInformationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCinemaInformationResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cinemas" type="{http://it.univaq.disim.sose.cald/enjoyReservation}cinemaType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCinemaInformationResponse", propOrder = {
    "cinemas"
})
public class GetCinemaInformationResponse {

    protected List<CinemaType> cinemas;

    /**
     * Gets the value of the cinemas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cinemas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCinemas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CinemaType }
     * 
     * 
     */
    public List<CinemaType> getCinemas() {
        if (cinemas == null) {
            cinemas = new ArrayList<CinemaType>();
        }
        return this.cinemas;
    }

}
