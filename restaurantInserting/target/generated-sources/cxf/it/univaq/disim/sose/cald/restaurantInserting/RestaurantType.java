
package it.univaq.disim.sose.cald.restaurantInserting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per restaurantType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="restaurantType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lat" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="lon" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="restaurantInfo" type="{http://it.univaq.disim.sose.cald/restaurantInserting}restaurantInfoType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "restaurantType", propOrder = {
    "lat",
    "lon",
    "restaurantInfo"
})
public class RestaurantType {

    protected double lat;
    protected double lon;
    @XmlElement(required = true)
    protected RestaurantInfoType restaurantInfo;

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
     * Recupera il valore della proprietà restaurantInfo.
     * 
     * @return
     *     possible object is
     *     {@link RestaurantInfoType }
     *     
     */
    public RestaurantInfoType getRestaurantInfo() {
        return restaurantInfo;
    }

    /**
     * Imposta il valore della proprietà restaurantInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link RestaurantInfoType }
     *     
     */
    public void setRestaurantInfo(RestaurantInfoType value) {
        this.restaurantInfo = value;
    }

}
