
package it.univaq.disim.sose.cald.restaurantInserting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per restaurantInsertRequest complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="restaurantInsertRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="restaurant" type="{http://it.univaq.disim.sose.cald/restaurantInserting}restaurantType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "restaurantInsertRequest", propOrder = {
    "restaurant"
})
public class RestaurantInsertRequest {

    @XmlElement(required = true)
    protected RestaurantType restaurant;

    /**
     * Recupera il valore della proprietà restaurant.
     * 
     * @return
     *     possible object is
     *     {@link RestaurantType }
     *     
     */
    public RestaurantType getRestaurant() {
        return restaurant;
    }

    /**
     * Imposta il valore della proprietà restaurant.
     * 
     * @param value
     *     allowed object is
     *     {@link RestaurantType }
     *     
     */
    public void setRestaurant(RestaurantType value) {
        this.restaurant = value;
    }

}
