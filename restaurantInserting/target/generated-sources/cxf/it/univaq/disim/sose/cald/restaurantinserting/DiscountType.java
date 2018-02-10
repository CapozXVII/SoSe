
package it.univaq.disim.sose.cald.restaurantinserting;

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
 *         &lt;element name="discount_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
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
    protected Long discountId;
    protected int cinema;
    protected float price;

    /**
     * Recupera il valore della proprietà discountId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDiscountId() {
        return discountId;
    }

    /**
     * Imposta il valore della proprietà discountId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDiscountId(Long value) {
        this.discountId = value;
    }

    /**
     * Recupera il valore della proprietà cinema.
     * 
     */
    public int getCinema() {
        return cinema;
    }

    /**
     * Imposta il valore della proprietà cinema.
     * 
     */
    public void setCinema(int value) {
        this.cinema = value;
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
