
package it.univaq.disim.sose.cald.enjoyreservation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteRestaurantRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteRestaurantRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="restaurant_id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteRestaurantRequest", propOrder = {
    "restaurantId"
})
public class DeleteRestaurantRequest {

    @XmlElement(name = "restaurant_id")
    protected long restaurantId;

    /**
     * Gets the value of the restaurantId property.
     * 
     */
    public long getRestaurantId() {
        return restaurantId;
    }

    /**
     * Sets the value of the restaurantId property.
     * 
     */
    public void setRestaurantId(long value) {
        this.restaurantId = value;
    }

}
