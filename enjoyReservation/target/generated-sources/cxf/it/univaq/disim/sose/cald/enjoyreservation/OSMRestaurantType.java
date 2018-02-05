
package it.univaq.disim.sose.cald.enjoyreservation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OSMRestaurantType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OSMRestaurantType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lat" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="lon" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="restaurantInfo" type="{http://it.univaq.disim.sose.cald/enjoyReservation}OSMRestaurantInfoType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OSMRestaurantType", propOrder = {
    "lat",
    "lon",
    "restaurantInfo"
})
public class OSMRestaurantType {

    protected Double lat;
    protected Double lon;
    @XmlElement(required = true)
    protected OSMRestaurantInfoType restaurantInfo;

    /**
     * Gets the value of the lat property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLat() {
        return lat;
    }

    /**
     * Sets the value of the lat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLat(Double value) {
        this.lat = value;
    }

    /**
     * Gets the value of the lon property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLon() {
        return lon;
    }

    /**
     * Sets the value of the lon property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLon(Double value) {
        this.lon = value;
    }

    /**
     * Gets the value of the restaurantInfo property.
     * 
     * @return
     *     possible object is
     *     {@link OSMRestaurantInfoType }
     *     
     */
    public OSMRestaurantInfoType getRestaurantInfo() {
        return restaurantInfo;
    }

    /**
     * Sets the value of the restaurantInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OSMRestaurantInfoType }
     *     
     */
    public void setRestaurantInfo(OSMRestaurantInfoType value) {
        this.restaurantInfo = value;
    }

}
