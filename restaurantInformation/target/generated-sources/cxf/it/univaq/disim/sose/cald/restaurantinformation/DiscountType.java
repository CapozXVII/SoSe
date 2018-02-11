
package it.univaq.disim.sose.cald.restaurantinformation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for discountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="discountType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="discount_id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="cinema" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "discountId",
    "cinema",
    "price"
})
public class DiscountType {

    @XmlElement(name = "discount_id")
    protected long discountId;
    protected int cinema;
    protected float price;

    /**
     * Gets the value of the discountId property.
     * 
     */
    public long getDiscountId() {
        return discountId;
    }

    /**
     * Sets the value of the discountId property.
     * 
     */
    public void setDiscountId(long value) {
        this.discountId = value;
    }

    /**
     * Gets the value of the cinema property.
     * 
     */
    public int getCinema() {
        return cinema;
    }

    /**
     * Sets the value of the cinema property.
     * 
     */
    public void setCinema(int value) {
        this.cinema = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(float value) {
        this.price = value;
    }

}
