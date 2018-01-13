
package it.univaq.disim.sose.cald.cinemaInserting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per discountType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="discountType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="restaurant" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "discountType", propOrder = {
    "restaurant",
    "price"
})
public class DiscountType {

    @XmlElement(required = true)
    protected String restaurant;
    protected float price;

    /**
     * Recupera il valore della proprietà restaurant.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRestaurant() {
        return restaurant;
    }

    /**
     * Imposta il valore della proprietà restaurant.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRestaurant(String value) {
        this.restaurant = value;
    }

    /**
     * Recupera il valore della proprietà price.
     * 
     */
    public float getPrice() {
        return price;
    }

    /**
     * Imposta il valore della proprietà price.
     * 
     */
    public void setPrice(float value) {
        this.price = value;
    }

}
