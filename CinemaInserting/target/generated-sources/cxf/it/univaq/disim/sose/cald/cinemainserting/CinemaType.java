
package it.univaq.disim.sose.cald.cinemainserting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per cinemaType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="cinemaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lat" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="lon" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="cinemaInfo" type="{http://it.univaq.disim.sose.cald/cinemaInserting}cinemaInfoType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cinemaType", propOrder = {
    "lat",
    "lon",
    "cinemaInfo"
})
public class CinemaType {

    protected double lat;
    protected double lon;
    @XmlElement(required = true)
    protected CinemaInfoType cinemaInfo;

    /**
     * Recupera il valore della proprietà lat.
     * 
     */
    public double getLat() {
        return lat;
    }

    /**
     * Imposta il valore della proprietà lat.
     * 
     */
    public void setLat(double value) {
        this.lat = value;
    }

    /**
     * Recupera il valore della proprietà lon.
     * 
     */
    public double getLon() {
        return lon;
    }

    /**
     * Imposta il valore della proprietà lon.
     * 
     */
    public void setLon(double value) {
        this.lon = value;
    }

    /**
     * Recupera il valore della proprietà cinemaInfo.
     * 
     * @return
     *     possible object is
     *     {@link CinemaInfoType }
     *     
     */
    public CinemaInfoType getCinemaInfo() {
        return cinemaInfo;
    }

    /**
     * Imposta il valore della proprietà cinemaInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link CinemaInfoType }
     *     
     */
    public void setCinemaInfo(CinemaInfoType value) {
        this.cinemaInfo = value;
    }

}
