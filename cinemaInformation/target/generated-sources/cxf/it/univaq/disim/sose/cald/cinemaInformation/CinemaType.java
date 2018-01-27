
package it.univaq.disim.sose.cald.cinemaInformation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cinemaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cinemaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lat" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="lon" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="cinemaInfo" type="{http://it.univaq.disim.sose.cald/cinemaInformation}cinemaInfoType"/&gt;
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
     * Gets the value of the lat property.
     * 
     */
    public double getLat() {
        return lat;
    }

    /**
     * Sets the value of the lat property.
     * 
     */
    public void setLat(double value) {
        this.lat = value;
    }

    /**
     * Gets the value of the lon property.
     * 
     */
    public double getLon() {
        return lon;
    }

    /**
     * Sets the value of the lon property.
     * 
     */
    public void setLon(double value) {
        this.lon = value;
    }

    /**
     * Gets the value of the cinemaInfo property.
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
     * Sets the value of the cinemaInfo property.
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
