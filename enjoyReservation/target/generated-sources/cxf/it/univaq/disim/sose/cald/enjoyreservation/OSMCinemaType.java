
package it.univaq.disim.sose.cald.enjoyreservation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OSMCinemaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OSMCinemaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lat" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="lon" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="cinemaInfo" type="{http://it.univaq.disim.sose.cald/enjoyReservation}OSMCinemaInfoType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OSMCinemaType", propOrder = {
    "lat",
    "lon",
    "cinemaInfo"
})
public class OSMCinemaType {

    protected double lat;
    protected double lon;
    @XmlElement(required = true)
    protected OSMCinemaInfoType cinemaInfo;

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
     *     {@link OSMCinemaInfoType }
     *     
     */
    public OSMCinemaInfoType getCinemaInfo() {
        return cinemaInfo;
    }

    /**
     * Sets the value of the cinemaInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OSMCinemaInfoType }
     *     
     */
    public void setCinemaInfo(OSMCinemaInfoType value) {
        this.cinemaInfo = value;
    }

}
